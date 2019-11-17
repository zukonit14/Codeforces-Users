package com.example.retrofitpractice;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserList {

    @SerializedName("result")
    private List<User> users;

    public UserList(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }
}
