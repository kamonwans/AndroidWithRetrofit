package com.example.liuyao.androidwithretrofit;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class GitUsersAdapter extends RecyclerView.Adapter<GitUsersViewHolder> {

    private List<Users> usersList;

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
        notifyDataSetChanged();
        ;
    }

    @NonNull
    @Override
    public GitUsersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_git_user, viewGroup, false);
        return new GitUsersViewHolder(view, viewGroup.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull GitUsersViewHolder gitUsersViewHolder, int i) {
        gitUsersViewHolder.setTvName(usersList.get(i).getLogin());
        gitUsersViewHolder.setTvType(usersList.get(i).getType());
        gitUsersViewHolder.setImgAvarta(usersList.get(i).getAvartaUrl());
    }

    @Override
    public int getItemCount() {
        return usersList != null ? usersList.size() : 0;
    }


}
