package com.x1opya.task1intersvyazcourse.Auth;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DiscordApi {
    @Headers({"Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded",
            "Authorization: Bearer"
    })

    @POST("oauth/access_token")
    @FormUrlEncoded
    Call<String> getAuthToken(@Field("client_id")String clientId,
                                          @Field("client_secret")String secret,
                                          @Field("code") String code,
                                          @Field("grant_type") String type,
                                          @Field("redirect_uri") String redirUri);

    @GET("users/self/")
    Call<UserResponse> getInfo(@Query("access_token") String token);
}
