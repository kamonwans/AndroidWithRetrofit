package com.example.liuyao.androidwithretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    GitService gitService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      Call<List<Users>> users = RetrofitClient.getInstance().getGitService().getListUsers();

      if (users != null){
          Log.d("not null","not null");
      }else {
          Log.d("null","null");
      }
    }
}
