package com.library.repository.models.view;

import com.library.repository.models.User;

/**
 * Created by nehaojha on 25/10/16.
 */
public class UserViewModel {

    private String email;

    private Integer userId;

    private String address;

    private String name;

    public UserViewModel(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.address = user.getAddress();
        this.email = user.getEmail();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
