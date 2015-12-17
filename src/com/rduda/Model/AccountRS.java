package com.rduda.Model;

import com.rduda.Model.API.Account;
import com.rduda.Model.API.AccountStore;
import com.rduda.Model.API.Image;
import com.rduda.Model.API.REST;
import com.rduda.Model.API.Request.AccountList;
import com.rduda.Model.API.Request.RequestMapping;
import com.rduda.Model.Exception.AccountAlreadyExistsException;
import com.rduda.Model.Exception.AuthenticationException;
import com.rduda.Model.Exception.NoSuchAccountException;
import com.rduda.Model.Exception.NoSuchImageException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin on 2015-11-28.
 * <p>
 * Rest implementation of AccountStore.
 */
class AccountRS implements AccountStore {
    private RequestMapping context = new RequestMapping();

    public AccountRS(RequestMapping context) {
        this.context = context;
    }

    @Override
    public Account add(Account account) throws AccountAlreadyExistsException {
        RequestMapping request = new RequestMapping(context)
                .setActor(account.getActor())
                .setPassword(((RequestMapping) account).getPassword())
                .setFirstName(account.getFirstName())
                .setLastName(account.getLastName());
        try {
            RequestMapping response = RestHelper.getClient()
                    .path(REST.Account.REGISTER)
                    .request(REST.TYPE)
                    .post(Entity.entity(request, REST.TYPE), RequestMapping.class);

            return new AccountBean(response);
        } catch (NotAuthorizedException | NotFoundException e) {
            throw new AccountAlreadyExistsException();
        }
    }

    @Override
    public Account findByUsername(String username) throws NoSuchAccountException {
        RequestMapping request = new RequestMapping(context)
                .setTarget(username);
        try {
            return REST.getClient()
                    .path(REST.Account.LOAD)
                    .queryParam("actor", request.getActor())
                    .queryParam("token", request.getToken())
                    .queryParam("target", username)
                    .request(REST.TYPE)
                    .get(RequestMapping.class);
        } catch (NotFoundException | NotAuthorizedException e) {
            throw new NoSuchAccountException();
        }
    }

    @Override
    public void remove(Account account) throws NoSuchAccountException {
        try {
            REST.getClient()
                    .path(REST.Account.UNREGISTER)
                    .queryParam("actor", account.getActor())
                    .queryParam("token", account.getToken())
                    .request(REST.TYPE)
                    .delete(RequestMapping.class);
        } catch (NotFoundException | NotAuthorizedException e) {
            throw new NoSuchAccountException();
        }
    }

    @Override
    public List<Account> findByAny(String query) {
        AccountList result = REST.getClient()
                .path(REST.Account.SEARCH)
                .queryParam("actor", context.getActor())
                .queryParam("token", context.getToken())
                .queryParam("search", query)
                .request(REST.TYPE)
                .get(AccountList.class);

        return new ArrayList<>(result.getList());
    }

    @Override
    public Account authenticate(String username, String password) throws AuthenticationException {
        RequestMapping request = new RequestMapping()
                .setActor(username)
                .setPassword(password);
        try {
            this.context = REST.getClient()
                    .path(REST.Account.LOGIN)
                    .request(REST.TYPE)
                    .post(Entity.entity(request, REST.TYPE), RequestMapping.class);
        } catch (NotAuthorizedException e) {
            throw new AuthenticationException();
        }
        return this.context;
    }

    @Override
    public void setProfile(Account account, String firstName, String lastName, String country, Integer age) {
        RequestMapping request = new RequestMapping(context)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setCountry(country)
                .setAge(age);

        REST.getClient()
                .path(REST.Account.UPDATE)
                .request(REST.TYPE)
                .post(Entity.entity(request, REST.TYPE), RequestMapping.class);
    }

    @Override
    public void setProfileImage(Account account, String base64encoded) {
        RequestMapping request = new RequestMapping(context)
                .setProfileImageData(base64encoded);

        REST.getClient()
                .path(REST.Account.IMAGE)
                .request(REST.TYPE)
                .put(Entity.entity(request, REST.TYPE));
    }

    @Override
    public Image getProfileImage(long id) throws NoSuchImageException {
        try {
            RequestMapping response = REST.getClient()
                    .path(REST.Account.IMAGE)
                    .queryParam("actor", context.getActor())
                    .queryParam("token", context.getToken())
                    .queryParam("id", id)
                    .request(REST.TYPE)
                    .get(RequestMapping.class);

            return new ImageMapping()
                    .setBase64(response.getProfileImageData())
                    .setId(response.getProfileImage());

        } catch (NotFoundException | NotAuthorizedException e) {
            throw new NoSuchImageException();
        }
    }

    @Override
    public Account findById(long id) {
        throw new NotImplementedException();
    }
}
