package com.x1opya.task1intersvyazcourse.Auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenResponseModel {
    @SerializedName("access_token")
    @Expose
    public String accessToken;
    @SerializedName("token_type")
    @Expose
    public String tokenType;
    @SerializedName("expires_in")
    @Expose
    public int expiresIn;
    @SerializedName("refresh_token")
    @Expose
    public String refreshToken;
    @SerializedName("scope")
    @Expose
    public String scope;
}
