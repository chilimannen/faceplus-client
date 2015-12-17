package com.rduda.Model;


import com.rduda.Model.API.*;
import com.rduda.Model.API.Request.RequestMapping;
import com.rduda.Model.Exception.AccountAlreadyExistsException;
import com.rduda.Model.Exception.AuthenticationException;
import com.rduda.Model.Exception.NoSuchAccountException;
import com.rduda.Model.Exception.NoSuchImageException;

import java.util.List;

/**
 * Created by Robin on 2015-11-11.
 * <p>
 * Handles account logic.
 */
public class AccountHandler implements AccountManager {
    private StoreProviderDefault provider;
    private AccountStore accounts;
    private Account account;
    private boolean authenticated = false;

    /**
     * Uses the default StoreManager in the package.
     */
    public AccountHandler() {
        this(new StoreProviderDefault());
    }

    /**
     * If supplied the AccountManager will use that StoreManager.
     *
     * @param provider a StoreManager with mappings to entity storage.
     */
    public AccountHandler(StoreProviderDefault provider) {
        this.provider = provider;
        accounts = provider.getAccountStore();
    }

    @Override
    public Account getAccount() throws AuthenticationException {
        if (authenticated)
            return new AccountBean(accounts.findByUsername(account.getActor()));
        else
            throw new AuthenticationException();
    }

    @Override
    public List<Account> findByAny(String query) {
        return AccountBean.fromList(accounts.findByAny(query));
    }

    @Override
    public Account findByUsername(String username) throws NoSuchAccountException {
        return new AccountBean(accounts.findByUsername(username));
    }

    @Override
    public void setProfile(String firstName, String lastName, String country, Integer age) throws AuthenticationException {
        if (authenticated)
            accounts.setProfile(account, firstName, lastName, country, age);
        else
            throw new AuthenticationException();
    }

    @Override
    public void setProfileImage(String base64encoded) throws AuthenticationException {
        if (authenticated)
            accounts.setProfileImage(account, base64encoded);
        else
            throw new AuthenticationException();
    }

    @Override
    public Image getProfileImage(long accountId) throws NoSuchImageException, AuthenticationException {
        if (authenticated)
            return new com.rduda.Model.ImageMapping(accounts.getProfileImage(accountId));
        else
            throw new AuthenticationException();
    }

    @Override
    public FriendManager getFriendManager() throws AuthenticationException {
        if (authenticated)
            return new FriendHandler(provider, account);
        else
            throw new AuthenticationException();
    }

    @Override
    public MessageManager getMessageManager() throws AuthenticationException {
        if (authenticated)
            return new MessageHandler(provider, account);
        else
            throw new AuthenticationException();
    }

    @Override
    public PostManager getPostManager() throws AuthenticationException {
        if (authenticated)
            return new PostHandler(provider, account);
        else
            throw new AuthenticationException();
    }

    @Override
    public void register(String username, String password, String firstName, String lastName) throws AccountAlreadyExistsException {
        // Member-field account is not assigned if the registration fails.
        synchronized (this) {
            authenticated = false;
            account = accounts.add(provider.getAccountModel(username, password, firstName, lastName));
            provider.setRequest(account);
            accounts = provider.getAccountStore();
            authenticated = true;
        }
    }

    @Override
    public void login(String username, String password) throws AuthenticationException {
        synchronized (this) {
            authenticated = false;
            account = accounts.authenticate(username, password);
            provider.setRequest(account);
            accounts = provider.getAccountStore();
            authenticated = true;
        }
    }

    @Override
    public void unregister() throws NoSuchAccountException {
        synchronized (this) {
            if (authenticated) {
                authenticated = false;
                provider.setRequest(new RequestMapping());
                accounts = provider.getAccountStore();
            }
        }
        accounts.remove(account);
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void logout() {
        authenticated = false;
    }
}
