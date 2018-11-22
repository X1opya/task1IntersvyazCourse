package com.x1opya.task1intersvyazcourse.Auth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.x1opya.task1intersvyazcourse.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    public static final String AUTH = "outh";
    public static final String TOKEN = "token";
    public static final String CODE = "code";
    public static final String TOKEN_REFRESH = "token";
    private Editor mEditor;
    SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mSettings = getSharedPreferences(AUTH,MODE_PRIVATE);

        mEditor = mSettings.edit();
        Intent authIntent = new Intent(Intent.ACTION_VIEW,Uri.parse(StaticFields.URI_AUTH+
                    "?client_id="+StaticFields.CLIENT_ID+
                    "&scope=email&response_type=code&" +
                    "state=15773059ghq9183habn&"+
                    "redirect_uri="+StaticFields.REDIRECT_URI));
        startActivity(authIntent);

    }

    @Override
    protected void onResume() {
        super.onResume();
            Uri uri = getIntent().getData();
            if(uri!=null && uri.toString().startsWith(StaticFields.REDIRECT_URI)){
                mEditor.putString(CODE,uri.getQueryParameter("code"));
                mEditor.apply();
                String code = uri.getQueryParameter("code");
                String state = uri.getQueryParameter("state");
                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://discordapp.com/api/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                DiscordApi api = retrofit.create(DiscordApi.class);
                api.getAuthToken(StaticFields.CLIENT_ID,
                        StaticFields.SECRET,
                        code,
                        "authorization_code",
                        "email",state).enqueue(new Callback<TokenResponseModel>() {
                    @Override
                    public void onResponse(Call<TokenResponseModel> call, Response<TokenResponseModel> response) {
                        TokenResponseModel token = response.body();
                    }

                    @Override
                    public void onFailure(Call<TokenResponseModel> call, Throwable t) {

                    }
                });

            }
    }
}

