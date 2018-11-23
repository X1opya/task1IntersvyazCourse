package com.x1opya.task1intersvyazcourse.Auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserResponse {
    @SerializedName("data")
    @Expose
    public User data;
}
class User{
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("username")
    @Expose
    public String username;
    @SerializedName("full_name")
    @Expose
    public String fullName;
    @SerializedName("profile_picture")
    @Expose
    public String profilePicture;
    @SerializedName("bio")
    @Expose
    public String bio;
    @SerializedName("website")
    @Expose
    public String website;
    @SerializedName("is_business")
    @Expose
    public boolean isBusiness;
}
