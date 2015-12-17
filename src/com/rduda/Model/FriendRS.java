package com.rduda.Model;

import com.rduda.Model.API.Account;
import com.rduda.Model.API.FriendStore;
import com.rduda.Model.API.REST;
import com.rduda.Model.API.Request.AccountList;
import com.rduda.Model.API.Request.RequestMapping;
import com.rduda.Model.Exception.FriendException;
import com.rduda.Model.Exception.NoSuchFriendException;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin on 2015-11-28.
 * <p>
 * Implementation of a Friend-Store with REST.
 */
class FriendRS implements FriendStore {

    @Override
    public void friendRequest(Account context, Account target) throws FriendException {
        RequestMapping request = new RequestMapping(context)
                .setTarget(target.getActor());
        try {
            REST.getClient()
                    .path(REST.Friend.REQUEST)
                    .request(REST.TYPE)
                    .post(Entity.entity(request, REST.TYPE), RequestMapping.class);
        } catch (NotFoundException e) {
            throw new NoSuchFriendException();
        }
    }

    @Override
    public void acceptRequest(Account context, Account target) throws FriendException {
        try {
            RequestMapping accept = new RequestMapping(context)
                    .setTarget(target.getActor());

            REST.getClient()
                    .path(REST.Friend.ACCEPT)
                    .request(REST.TYPE)
                    .post(Entity.entity(accept, REST.TYPE), RequestMapping.class);
        } catch (NotFoundException e) {
            throw new NoSuchFriendException();
        }
    }

    @Override
    public void declineRequest(Account context, Account target) {
        RequestMapping termination = new RequestMapping(context)
                .setTarget(target.getActor());

        REST.getClient()
                .path(REST.Friend.DECLINE)
                .request(REST.TYPE)
                .post(Entity.entity(termination, REST.TYPE), RequestMapping.class);
    }

    @Override
    public void terminateFriendship(Account context, Account target) throws FriendException {
        RequestMapping terminate = new RequestMapping(context)
                .setTarget(target.getActor());

        REST.getClient()
                .path(REST.Friend.TERMINATE)
                .request(REST.TYPE)
                .post(Entity.entity(terminate, REST.TYPE), RequestMapping.class);
    }

    @Override
    public List<Account> getFriendList(Account context) throws FriendException {
        AccountList result = REST.getClient()
                .path(REST.Friend.LIST)
                .queryParam("actor", context.getActor())
                .queryParam("token", context.getToken())
                .request(REST.TYPE)
                .get(AccountList.class);

        return new ArrayList<>(result.getList());
    }

    @Override
    public List<Account> getFriendRequests(Account context) throws FriendException {
        AccountList result = REST.getClient()
                .path(REST.Friend.REQUESTS)
                .queryParam("actor", context.getActor())
                .queryParam("token", context.getToken())
                .request(REST.TYPE)
                .get(AccountList.class);

        return new ArrayList<>(result.getList());
    }

    @Override
    public boolean isFriendsWith(Account context, Account target) throws FriendException {
        Boolean result = false;
        try {
            result = REST.getClient()
                    .path(REST.Friend.IS_FRIENDS)
                    .queryParam("actor", context.getActor())
                    .queryParam("token", context.getToken())
                    .queryParam("target", target.getActor())
                    .request(REST.TYPE)
                    .get(RequestMapping.class).getResult();
        } catch (NotFoundException | NotAuthorizedException ignored) {
        }

        return result;
    }

    @Override
    public boolean isFriendRequested(Account context, Account target) throws FriendException {
        Boolean result = false;
        try {
            result = REST.getClient()
                    .path(REST.Friend.IS_REQUESTED)
                    .queryParam("actor", context.getActor())
                    .queryParam("token", context.getToken())
                    .queryParam("target", target.getActor())
                    .request(REST.TYPE)
                    .get(RequestMapping.class).getResult();
        } catch (NotFoundException | NotAuthorizedException ignored) {
        }
        return result;
    }
}
