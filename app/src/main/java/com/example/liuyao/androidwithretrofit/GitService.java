package com.example.liuyao.androidwithretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface GitService {
    @GET("users")
    Call<List<Users>> getListUsers();

    @GET("users/{login}")
    Call<Users> getUserDetail(@Path("login") String login);

}
