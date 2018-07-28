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
    interface OnClickUserListener{
        void onClickItem(Users user);
    }

    private ImageView imgAvarta;
    private TextView tvName;
    private TextView tvType;
    private Context context;

    public GitUsersViewHolder(@NonNull View itemView, Context context, final OnClickUserListener onClickUserListener) {
        super(itemView);

        imgAvarta = itemView.findViewById(R.id.imgAvarta);
        tvName = itemView.findViewById(R.id.tvName);
        tvType = itemView.findViewById(R.id.tvType);
        this.context = context;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickUserListener.onClickItem(new Users());
            }
        });
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
