package com.example.liuyao.androidwithretrofit;

import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
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
    private Toolbar mToolbar;

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
        mToolbar = findViewById(R.id.toolbar);

      String login =  getIntent().getExtras().getString("login");

      final Call<Users> user = RetrofitClient.getInstance().getGitService().getUserDetail(login);
      user.enqueue(new Callback<Users>() {
          @Override
          public void onResponse(Call<Users> call, Response<Users> response) {
              if (response.isSuccessful()){
                  if (response.body() !=  null){
                    users = response.body();
                    String name = users.getName() != null ? users.getName() : "";
                    String company = users.getCompany() != null ? users.getCompany() : "";
                    String blog = users.getBlog() != null ? users.getBlog() : "";
                    tvName.setText("Name : " + name);
                    tvCompany.setText("Company : " + company);
                    tvBlog.setText("Blog : " + blog);
                    tvBio.setText(users.getBio());
                    Glide.with(UserDetailActivity.this).load(users.getAvartaUrl()).into(imgAvatar);
                  }
              }
          }

          @Override
          public void onFailure(Call<Users> call, Throwable t) {

          }
      });

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(login);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }
}
