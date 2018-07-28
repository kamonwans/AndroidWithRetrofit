package com.example.liuyao.androidwithretrofit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GitUsersViewHolder extends RecyclerView.ViewHolder{
    private ImageView imgAvarta;
    private TextView tvName;
    private TextView tvType;
    public GitUsersViewHolder(@NonNull View itemView) {
        super(itemView);

        imgAvarta = itemView.findViewById(R.id.imgAvarta);
        tvName = itemView.findViewById(R.id.tvName);
        tvType = itemView.findViewById(R.id.tvType);

    }

    public void setImgAvarta(String url){
//        imgAvarta.setBac("");

    }

    public void setTvName(String name){
        tvName.setText(name);
    }

    public void setTvType(String type){
        tvType.setText(type);
    }
}
