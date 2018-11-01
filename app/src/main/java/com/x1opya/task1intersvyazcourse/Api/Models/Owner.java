package com.x1opya.task1intersvyazcourse.Api.Models;

import com.google.gson.annotations.SerializedName;

public class Owner {
    @SerializedName("login")
    protected String login;
    @SerializedName("avatar_url")
    protected String avatarUrl;

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
