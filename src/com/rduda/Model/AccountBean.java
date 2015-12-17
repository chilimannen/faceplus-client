package com.rduda.Model;

import com.rduda.Model.API.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin on 2015-11-21.
 * <p>
 * Creates an instanced copy of any object implementing Account.
 */
class AccountBean implements Account {
    private Long id;
    private String actor;
    private String firstName;
    private String lastName;
    private String country;
    private String token;
    private Integer age;

    public AccountBean(Account account) {
        this.id = account.getId();
        this.actor = account.getActor();
        this.firstName = account.getFirstName();
        this.lastName = account.getLastName();
        this.country = account.getCountry();
        this.age = account.getAge();
        this.token = account.getToken();
    }

    public static List<Account> fromList(List<Account> accounts) {
        List<Account> beans = new ArrayList<>();

        if (accounts != null) {
            for (Account account : accounts) {
                beans.add(new AccountBean(account));
            }
        }

        return beans;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getActor() {
        return actor;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public Long getProfileImage() {
        return null;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Account) {
            Account account = (Account) other;

            if (account.getId().equals(id))
                return true;
        }
        return false;
    }
}
