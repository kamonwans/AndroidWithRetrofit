package com.example.liuyao.androidwithretrofit;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

class Users implements Parcelable{
    private String login;
    private String avartaUrl;
    private String type;
    private String name;
    private String company;
    private String blog;
    private String email;

    protected Users(Parcel in) {
        login = in.readString();
        avartaUrl = in.readString();
        type = in.readString();
        name = in.readString();
        company = in.readString();
        blog = in.readString();
        email = in.readString();
        bio = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(login);
        dest.writeString(avartaUrl);
        dest.writeString(type);
        dest.writeString(name);
        dest.writeString(company);
        dest.writeString(blog);
        dest.writeString(email);
        dest.writeString(bio);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Users> CREATOR = new Creator<Users>() {
        @Override
        public Users createFromParcel(Parcel in) {
            return new Users(in);
        }

        @Override
        public Users[] newArray(int size) {
            return new Users[size];
        }
    };

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
