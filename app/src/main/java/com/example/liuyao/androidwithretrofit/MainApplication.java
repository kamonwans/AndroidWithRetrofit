package com.example.liuyao.androidwithretrofit;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.nytimes.com/svc/books")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
