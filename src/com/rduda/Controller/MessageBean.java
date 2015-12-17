package com.rduda.Controller;

import com.rduda.Model.API.AccountManager;
import com.rduda.Model.Exception.AuthenticationException;
import com.rduda.Model.Exception.NoSuchFriendException;
import com.rduda.Model.API.Message;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Robin on 2015-11-25.
 * <p>
 * MessageBean for the chat.
 */
@ManagedBean(name = "messaging")
@SessionScoped
public class MessageBean implements Serializable {
    @ManagedProperty(value = "#{account}")
    private AccountManagerHolder holder;
    private AccountManager account;
    private String thread;
    private String content;

    public void setHolder(AccountManagerHolder holder) throws AuthenticationException {
        this.holder = holder;
        this.account = holder.getManager();
    }

    public String load() throws IOException {
        return "message.xhtml?faces-redirect=true";
    }

    public String open(String target) {
        this.thread = target;
        return "message.xhtml?faces-redirect=true";
    }

    public List<Message> getThreads() {
        try {
            return account.getMessageManager().getLatestMessages();
        } catch (AuthenticationException e) {
            throw new HTTPException(401);
        }
    }

    public List<Message> getMessages() {
        if (thread != null) {
            try {
                List<Message> messages = account.getMessageManager().getMessagesFrom(thread, Long.MAX_VALUE);
                Collections.reverse(messages);
                return messages;
            } catch (NoSuchFriendException | AuthenticationException e) {
                throw new HTTPException(401);
            }
        }
        return new ArrayList<>();
    }

    public void openThread(String thread) {
        this.thread = thread;
    }

    public void sendMessage() throws IOException {
        try {
            account.getMessageManager().sendMessageTo(thread, content);
            content = "";
        } catch (NoSuchFriendException | AuthenticationException e) {
            e.printStackTrace();
            throw new HTTPException(401);
        }
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setThread(String thread) {
        this.thread = thread;
    }

    public String getThread() {
        return thread;
    }
}