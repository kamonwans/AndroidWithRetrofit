package com.example.liuyao.androidwithretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;

public interface GitService {
    @GET("users")
    Call<List<Users>> getListUsers();

    @GET("users/{login}")
    Call<Users> getUserDetail(@Part("login") String login);

}
