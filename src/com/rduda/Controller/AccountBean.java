package com.rduda.Controller;

import com.rduda.Model.AccountHandler;
import com.rduda.Model.API.AccountManager;
import com.rduda.Model.Exception.AuthenticationException;
import com.rduda.Model.Exception.NoSuchImageException;
import org.primefaces.model.DefaultStreamedContent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.xml.ws.http.HTTPException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Base64;

/**
 * Created by Robin on 2015-11-10.
 * <p>
 * Managed bean controlling account operations.
 */
@ManagedBean(name = "account")
@SessionScoped
public class AccountBean implements Serializable, AccountManagerHolder {
    private AccountManager manager = new AccountHandler();
    private boolean loginError = false;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public String register() throws IOException {
        try {
            manager.register(username, password, firstName, lastName);
            return "home.xhtml?faces-redirect=true";
        } catch (AuthenticationException ignored) {
            return "error.xhtml?faces-redirect=true";
        }
    }

    public String login() throws IOException {
        try {
            manager.login(username, password);
            loginError = false;
            return "home.xhtml?faces-redirect=true";
        } catch (AuthenticationException ignored) {
            loginError = true;
            return "index.xhtml?faces-redirect=true";
        }
    }

    public String logout() throws IOException {
        manager.logout();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml?faces-redirect=true";
    }


    @Override
    public DefaultStreamedContent getProfileImage(long accountId) {
        try {
            return new DefaultStreamedContent(
                    new ByteArrayInputStream(Base64.getDecoder().decode(manager.getProfileImage(accountId).getBase64())),
                    "image/png");
        } catch (NoSuchImageException e) {
            return new DefaultStreamedContent(
                    new ByteArrayInputStream(Base64.getDecoder().decode(ImageStore.getPlaceholder())), "image/png");
        } catch (AuthenticationException e) {
            throw new HTTPException(401);
        }
    }

    public boolean isLoginError() {
        return loginError;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public AccountManager getManager() {
        return manager;
    }
}
