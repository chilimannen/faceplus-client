package com.rduda.Controller;

import com.rduda.Model.API.AccountManager;
import com.rduda.Model.Exception.AuthenticationException;
import com.rduda.Model.API.Post;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.xml.ws.http.HTTPException;
import java.util.List;

/**
 * Created by Robin on 2015-11-24.
 *
 * ManagedBean for the stream where all friends posts show up.
 */
@ManagedBean(name = "stream")
@RequestScoped
public class StreamBean {
    @ManagedProperty(value = "#{account}")
    private AccountManagerHolder holder;
    private AccountManager account;

    public void setHolder(AccountManagerHolder holder) throws AuthenticationException {
        this.holder = holder;
        this.account = holder.getManager();
    }

    public String load() {
        return "stream.xhtml?faces-redirect=true";
    }

    public List<Post> getPosts() {
        try {
            return account.getPostManager().getStreamPosts();
        } catch (AuthenticationException e) {
            throw new HTTPException(401);
        }
    }
}
