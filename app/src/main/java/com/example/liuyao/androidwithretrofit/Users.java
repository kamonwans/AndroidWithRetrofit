package com.example.liuyao.androidwithretrofit;

import com.google.gson.annotations.SerializedName;

class Users {
    private String login;

    @SerializedName("avatar_url")
    private String avartaUrl;
    private String type;

    public String getLogin() {
        return login;
    }

    public String getAvartaUrl() {
        return avartaUrl;
    }

    public String getType() {
        return type;
    }
}
