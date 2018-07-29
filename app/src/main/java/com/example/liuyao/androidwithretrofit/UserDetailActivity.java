package com.example.liuyao.androidwithretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetailActivity extends AppCompatActivity {
    private ImageView imgAvatar;
    private TextView tvName;
    private TextView tvCompany;
    private TextView tvBlog;
    private TextView tvBio;
    private Users users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        initInstance();
    }

    private void initInstance() {
        imgAvatar = findViewById(R.id.imgAvatar);
        tvName = findViewById(R.id.tvName);
        tvCompany = findViewById(R.id.tvComapy);
        tvBlog = findViewById(R.id.tvBlog);
        tvBio = findViewById(R.id.tvBio);

      String login =  getIntent().getExtras().getString("login");

      final Call<Users> user = RetrofitClient.getInstance().getGitService().getUserDetail(login);
      user.enqueue(new Callback<Users>() {
          @Override
          public void onResponse(Call<Users> call, Response<Users> response) {
              if (response.isSuccessful()){
                  if (response.body() !=  null){
                    users = response.body();
                    tvName.setText(users.getName());
                    tvCompany.setText(users.getCompany());
                    tvBlog.setText(users.getBlog());
                    tvBio.setText(users.getBio());
                    Glide.with(UserDetailActivity.this).load(users.getAvartaUrl()).into(imgAvatar);
                  }
              }
          }

          @Override
          public void onFailure(Call<Users> call, Throwable t) {

          }
      });
    }
}
