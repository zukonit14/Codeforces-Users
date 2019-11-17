package com.example.retrofitpractice;

import android.content.Intent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface Api {

    String BASE_URL="https://codeforces.com/api/";
    @GET
    Call <UserList> getUsers(@Url String url);
}
