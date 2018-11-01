package com.x1opya.task1intersvyazcourse.Api;

import com.x1opya.task1intersvyazcourse.Api.Models.Respons;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitHubApi {
    @GET("search/users")
    Call<Respons> searchOwners(@Query("q") String q);
}
