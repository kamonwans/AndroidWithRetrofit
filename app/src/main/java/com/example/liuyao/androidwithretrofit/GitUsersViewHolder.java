package com.example.liuyao.androidwithretrofit;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GitUsersViewHolder extends RecyclerView.ViewHolder {
    private ImageView imgAvarta;
    private TextView tvName;
    private TextView tvType;
    private Context context;

    public GitUsersViewHolder(@NonNull View itemView, Context context) {
        super(itemView);

        imgAvarta = itemView.findViewById(R.id.imgAvarta);
        tvName = itemView.findViewById(R.id.tvName);
        tvType = itemView.findViewById(R.id.tvType);
        this.context = context;

    }

    public void setImgAvarta(String url) {
        Glide.with(context).load(url).into(imgAvarta);

    }

    public void setTvName(String name) {
        tvName.setText(name);
    }

    public void setTvType(String type) {
        tvType.setText(type);
    }
}
