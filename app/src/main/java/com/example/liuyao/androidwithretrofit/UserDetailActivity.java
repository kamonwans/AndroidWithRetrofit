package com.example.liuyao.androidwithretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class UserDetailActivity extends AppCompatActivity {
    private ImageView imgAvatar;
    private TextView tvName;
    private TextView tvCompany;
    private TextView tvBlog;
    private TextView tvBio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        initInstance();
    }

    private void initInstance() {
        imgAvatar = findViewById(R.id.imgAvarta);
        tvName = findViewById(R.id.tvName);
        tvCompany = findViewById(R.id.tvComapy);
        tvBlog = findViewById(R.id.tvBlog);
        tvBio = findViewById(R.id.tvBio);

      String login =  getIntent().getExtras().getString("login");

    }
}
