package com.rduda.Controller;

import com.rduda.Model.API.Account;
import com.rduda.Model.API.AccountManager;
import com.rduda.Model.Exception.AuthenticationException;
import com.rduda.Model.Exception.FriendException;
import org.primefaces.model.DefaultStreamedContent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin on 2015-11-11.
 * <p>
 * Manages the home page.
 */
@ManagedBean(name = "friends")
@SessionScoped
public class FriendsBean implements Serializable {
    @ManagedProperty(value = "#{account}")
    private AccountManagerHolder holder;
    private AccountManager manager;
    private String search;

    public void setHolder(AccountManagerHolder holder) throws AuthenticationException {
        this.holder = holder;
        this.manager = holder.getManager();
    }

    public String load() throws IOException {
        return "friends.xhtml?faces-redirect=true";
    }

    public DefaultStreamedContent getProfileImage() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        String accountId = request.getParameter("account");

        if (accountId == null) {
            return new DefaultStreamedContent();
        } else {
            return holder.getProfileImage(Long.parseLong(accountId));
        }
    }

    public List<Account> getRequests() {
        try {
            return manager.getFriendManager().getFriendRequests();
        } catch (FriendException | AuthenticationException e) {
            throw new HTTPException(401);
        }
    }

    public List<Account> getFriendList() {
        try {
            return manager.getFriendManager().getFriendList();
        } catch (FriendException | AuthenticationException e) {
            throw new HTTPException(401);
        }
    }

    public void accept(String username) throws IOException {
        try {
            manager.getFriendManager().accept(username);
        } catch (FriendException | AuthenticationException e) {
            throw new HTTPException(404);
        }
    }

    public void decline(String username) throws IOException {
        try {
            manager.getFriendManager().decline(username);
        } catch (FriendException | AuthenticationException e) {
            throw new HTTPException(401);
        }
    }

    public void terminate(String username) throws IOException, FriendException {
        try {
            manager.getFriendManager().terminate(username);
        } catch (FriendException | AuthenticationException e) {
            throw new FriendException();
        }
    }

    public void setSearch(String search) {
        this.search = search;
        System.out.println("search result = " + manager.findByAny(search));
    }

    public String getSearch() {
        return search;
    }

    public List<Account> getSearchResult() {
        if (search != null && search.length() != 0) {
            return manager.findByAny(search);
        } else
            return new ArrayList<>();
    }
}
