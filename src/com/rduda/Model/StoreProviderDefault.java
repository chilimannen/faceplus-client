package com.rduda.Model;

import com.rduda.Model.API.*;
import com.rduda.Model.API.Request.MessageMapping;
import com.rduda.Model.API.Request.PostMapping;
import com.rduda.Model.API.Request.RequestMapping;

import java.io.Serializable;

/**
 * Created by Robin on 2015-11-28.
 * <p>
 * Provides an anonymous store/model factory
 * for a REST implementation.
 */
class StoreProviderDefault implements Serializable, StoreProviderREST {
    private RequestMapping request = new RequestMapping();

    @Override
    public AccountStore getAccountStore() {
        return new AccountRS(request);
    }

    @Override
    public FriendStore getFriendStore() {
        return new FriendRS();
    }

    @Override
    public PostStore getPostStore() {
        return new PostRS();
    }

    @Override
    public MessageStore getMessageStore() {
        return new MessageRS();
    }

    @Override
    public Account getAccountModel(String username, String plaintextPassword, String firstName, String lastName) {
        return new RequestMapping()
                .setActor(username)
                .setPassword(plaintextPassword)
                .setFirstName(firstName)
                .setLastName(lastName);
    }

    @Override
    public Account getRequest() {
        return request;
    }

    @Override
    public void setRequest(Account request) {
        this.request
                .setActor(request.getActor())
                .setToken(request.getToken());
    }

    @Override
    public Post getPostModel(Account sender, String receiver, String content, String date) {
        return new PostMapping(new RequestMapping(request))
                .setTarget(receiver)
                .setContent(content);
    }

    @Override
    public Message getMessageModel(Account sender, String receiver, String content) {
        return new MessageMapping(new RequestMapping(request))
                .setTarget(receiver)
                .setContent(content);
    }
}
