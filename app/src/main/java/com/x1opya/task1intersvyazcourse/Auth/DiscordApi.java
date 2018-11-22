package com.x1opya.task1intersvyazcourse.Auth;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface DiscordApi {
    @Headers({"Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded",
            "Authorization: Bearer"
    })
    @POST("oauth2/token")
    @FormUrlEncoded
    Call<TokenResponseModel> getAuthToken(@Field("client_id")String clientId,
                                          @Field("client_secret")String secret,
                                          @Field("code") String code,
                                          @Field("grant_type") String type,
                                          @Field("scope") String scope,
                                          @Field("state") String state);
}
