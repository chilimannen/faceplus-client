package com.rduda.Controller;

import com.rduda.Model.API.Account;
import com.rduda.Model.API.AccountManager;
import com.rduda.Model.Exception.AuthenticationException;
import com.rduda.Model.Exception.FriendException;
import com.rduda.Model.Exception.PostInvalidArgumentsException;
import com.rduda.Model.API.Post;
import org.primefaces.model.DefaultStreamedContent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Robin on 2015-11-11.
 * <p>
 * Manages the home page.
 */
@ManagedBean(name = "home")
@SessionScoped
public class HomeBean implements Serializable {
    @ManagedProperty(value = "#{account}")
    private AccountManagerHolder holder;
    private AccountManager manager;
    private String content;
    private Account account;

    public void setHolder(AccountManagerHolder holder) throws AuthenticationException {
        this.holder = holder;
        this.manager = holder.getManager();
        this.account = manager.getAccount();
    }

    public DefaultStreamedContent getProfileImage() {
        return holder.getProfileImage(account.getId());
    }

    public String load() throws IOException {
        try {
            account = manager.getAccount();
        } catch (AuthenticationException e) {
            return "index.xhtml?faces-redirect=true";
        }
        return "home.xhtml?faces-redirect=true";
    }

    public String getAge() {
        return (account.getAge() != null ? "Age " + account.getAge() : "");
    }

    public String getCountry() {
        return (account.getCountry() != null ? account.getCountry() : "");
    }

    public String getUsername() {
        return account.getActor();
    }

    public String getFirstName() {
        return account.getFirstName();
    }

    public String getLastName() {
        return account.getLastName();
    }

    public List<Post> getPosts() {
        try {
            return manager.getPostManager().getHomePosts();
        } catch (AuthenticationException e) {
            throw new HTTPException(401);
        }
    }

    public List<Account> getFriendList() {
        try {
            return manager.getFriendManager().getFriendList();
        } catch (AuthenticationException | FriendException e) {
            throw new HTTPException(401);
        }
    }

    public void removePost(long id) {
        try {
            manager.getPostManager().removePost(id);
        } catch (AuthenticationException e) {
            throw new HTTPException(401);
        }
    }

    public void post() throws IOException {
        try {
            manager.getPostManager().postHome(content);
            content = "";
        } catch (PostInvalidArgumentsException | AuthenticationException e) {
            throw new HTTPException(401);
        } catch (FriendException e) {
            throw new HTTPException(404);
        }
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
