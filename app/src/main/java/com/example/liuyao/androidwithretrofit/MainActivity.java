package com.example.liuyao.androidwithretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    GitService gitService;
    List<Users> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      Call<List<Users>> users = RetrofitClient.getInstance().getGitService().getListUsers();
      users.enqueue(new Callback<List<Users>>() {
          @Override
          public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
              if (response.isSuccessful()){
                  if (response.body() != null){
                      usersList = response.body();
                      Log.d("respone",": body : " + usersList.get(0).getLogin());
                  }else {
                      Log.d("respone",": body is null");
                  }
              }else {
                  Log.d("respone","isSuccessful not: " +response.message());
              }
          }

          @Override
          public void onFailure(Call<List<Users>> call, Throwable t) {

          }
      });

      if (users != null){
          Log.d("not null","not null");
      }else {
          Log.d("null","null");
      }
    }
}
