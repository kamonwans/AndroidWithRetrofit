package com.example.liuyao.androidwithretrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements GitUsersViewHolder.OnClickUserListener{

    private GitService gitService;
    private List<Users> usersList;
    private RecyclerView recyclerView;
    private GitUsersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstance();

        Call<List<Users>> users = RetrofitClient.getInstance().getGitService().getListUsers();
        users.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        usersList = response.body();
                        adapter.setUsersList(usersList);

                        Log.d("respone", ": body : " + usersList.get(0).getLogin());
                    } else {
                        Log.d("respone", ": body is null");
                    }
                } else {
                    Log.d("respone", "isSuccessful not: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {

            }
        });

    }

    private void initInstance() {
        adapter = new GitUsersAdapter(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onClickItem(Users user) {
        Intent intent =new Intent(this,UserDetailActivity.class);
        startActivity(intent);
    }
}
