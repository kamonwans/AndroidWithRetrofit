package com.example.liuyao.androidwithretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GitService {
    @GET("/users")
    Call<List<Users>> getListUsers();

}
