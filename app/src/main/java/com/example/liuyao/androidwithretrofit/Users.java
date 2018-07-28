package com.example.liuyao.androidwithretrofit;

import com.google.gson.annotations.SerializedName;

class Users {
    private String login;
    private String avartaUrl;
    private String type;
    private String name;
    private String company;
    private String blog;
    private String email;

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getBlog() {
        return blog;
    }

    public String getEmail() {
        return email;
    }

    public String getBio() {
        return bio;
    }

    private String bio;

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
