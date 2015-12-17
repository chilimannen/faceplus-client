package com.rduda.Controller;

import com.rduda.Model.API.Account;
import com.rduda.Model.API.AccountManager;
import com.rduda.Model.Exception.AuthenticationException;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Base64;

/**
 * Created by Robin on 2015-11-11.
 * <p>
 * Manages the home page.
 */
@ManagedBean(name = "settings")
@SessionScoped
public class SettingBean implements Serializable {
    @ManagedProperty(value = "#{account}")
    private AccountManagerHolder holder;
    private AccountManager manager;
    private String firstName;
    private String lastName;
    private String country;
    private Part image;
    private Integer age;
    private boolean saved = false;

    public void setHolder(AccountManagerHolder holder) throws AuthenticationException {
        this.holder = holder;
        this.manager = holder.getManager();
    }

    public String load() throws IOException {
        try {
            Account account = manager.getAccount();
            firstName = account.getFirstName();
            lastName = account.getLastName();
            country = account.getCountry();
            age = account.getAge();
            saved = false;
            image = null;
        } catch (AuthenticationException e) {
            return "index.xhtml?faces-redirect=true";
        }
        return "settings.xhtml?faces-redirect=true";
    }

    public void uploadImage(FileUploadEvent event) throws AuthenticationException {
        UploadedFile file = event.getFile();
        String encoded = Base64.getEncoder().encodeToString(file.getContents());
        System.err.println("got b64 file = " + encoded);
        manager.setProfileImage(encoded);
    }

    public void setProfile() throws IOException {
        try {
            saved = true;
            manager.setProfile(firstName, lastName, country, age);
        } catch (AuthenticationException e) {
            throw new HTTPException(401);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public Part getImage() {
        return image;
    }

    public void setImage(Part image) {
        this.image = image;
    }
}
