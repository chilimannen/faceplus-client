package com.rduda.Controller;

import com.rduda.Model.API.Account;
import com.rduda.Model.API.AccountManager;
import com.rduda.Model.Exception.*;
import com.rduda.Model.API.Post;
import org.primefaces.model.DefaultStreamedContent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin on 2015-11-11.
 * <p>
 * Manages profile pages.
 * This bean should ideally be ViewScoped but parameters
 * passed are evaluated before the action method is called,
 * the action method returns a view page that is different from the
 * previous view, thus clearing the profile manager AFTER it was set.
 */
@ManagedBean(name = "profile")
@SessionScoped
public class ProfileBean implements Serializable {
    @ManagedProperty(value = "#{account}")
    private AccountManagerHolder holder;
    private AccountManager manager;
    private Account profile;
    private String content;

    public void setHolder(AccountManagerHolder holder) throws AuthenticationException {
        this.holder = holder;
        this.manager = holder.getManager();
    }

    public void setUsername(String username) throws NoSuchAccountException {
        profile = manager.findByUsername(username);
    }

    public DefaultStreamedContent getProfileImage() {
        return holder.getProfileImage(profile.getId());
    }

    public void requestFriend() throws IOException {
        try {
            manager.getFriendManager().request(profile.getActor());
        } catch (FriendException | AuthenticationException e) {
            throw new HTTPException(401);
        }
    }

    public boolean isFriends() {
        try {
            return manager.getFriendManager().isFriendsWith(profile.getActor());
        } catch (AuthenticationException | FriendException e) {
            throw new HTTPException(401);
        }
    }

    public boolean isRequested() {
        try {
            return manager.getFriendManager().isFriendRequested(profile.getActor());
        } catch (FriendException | AuthenticationException e) {
            throw new HTTPException(401);
        }
    }

    public void post() {
        try {
            manager.getPostManager().postFriend(profile.getActor(), content);
            content = "";
        } catch (FriendException | AuthenticationException e) {
            throw new HTTPException(401);
        }
    }

    public List<Post> getPosts() {
        try {
            return manager.getPostManager().getFriendPosts(profile.getActor());
        } catch (NoSuchFriendException | AuthenticationException ignored) {
        }
        return new ArrayList<>();
    }

    public void removePost(long id) {
        try {
            manager.getPostManager().removePost(id);
        } catch (AuthenticationException e) {
            throw new HTTPException(401);
        }
    }

    public String getAge() {
        return (profile.getAge() != null ? "Age " + profile.getAge() : "");
    }

    public String getCountry() {
        return (profile.getCountry() != null ? profile.getCountry() : "");
    }

    public String getUsername() {
        return profile.getActor();
    }

    public String getFirstName() {
        return profile.getFirstName();
    }

    public String getLastName() {
        return profile.getLastName();
    }

    public long getId() {
        return profile.getId();
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
