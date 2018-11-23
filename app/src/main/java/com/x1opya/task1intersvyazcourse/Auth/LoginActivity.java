package com.x1opya.task1intersvyazcourse.Auth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.x1opya.task1intersvyazcourse.R;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    public static final String AUTH = "outh";
    public static final String TOKEN = "token";
    public static final String DATE_REFRESH = "date";
    private Editor mEditor;
    SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mSettings = getSharedPreferences(AUTH,MODE_PRIVATE);

        mEditor = mSettings.edit();
        getEmail(mSettings.getString(TOKEN,"invalid"));
    }

    private  void getToken(){
        Intent authIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(StaticFields.URI_AUTH +
                "?client_id=" + StaticFields.CLIENT_ID +
                "&scope=basic&response_type=token&" +
                "redirect_uri=" + StaticFields.REDIRECT_URI));
        startActivity(authIntent);
    }

    @Override
    protected void onResume() {
        super.onResume();
            Uri uri = getIntent().getData();
            if(uri!=null && uri.toString().startsWith(StaticFields.REDIRECT_URI)){

                String s = uri.toString().replace("#","?");//иначе получается битая ссылка
                String token = Uri.parse(s).getQueryParameter("access_token");
                //int expiresIn = Integer.parseInt(Uri.parse(s).getQueryParameter("expires_in"));
                //Calendar end = Calendar.getInstance();
                //end.add(Calendar.SECOND,expiresIn);
                //Gson gson = new Gson();
                //String gsonDate = gson.toJson(end);
                mEditor.putString(TOKEN,token);
                //mEditor.putString(DATE_REFRESH,gsonDate);
                mEditor.apply();
                getEmail(token);
            }
    }



    private void getEmail(String token){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.instagram.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DiscordApi api = retrofit.create(DiscordApi.class);
        api.getInfo(token).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful())
                Toast.makeText(getBaseContext(),response.body().data.fullName,Toast.LENGTH_LONG).show();
                else getToken();
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                getToken();
            }
        });
    }
}

