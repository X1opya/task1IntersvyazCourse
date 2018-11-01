package com.x1opya.task1intersvyazcourse.Api;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.x1opya.task1intersvyazcourse.Api.Models.Respons;
import com.x1opya.task1intersvyazcourse.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiActivity extends AppCompatActivity implements TextWatcher {
    Retrofit retrofit;
    GitHubApi api;
    UserAdapter adapter;
    RecyclerView rv;
    EditText searcher;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        rv = findViewById(R.id.rv);
        adapter = new UserAdapter(this);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(GitHubApi.class);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
        searcher = findViewById(R.id.editText);
        searcher.addTextChangedListener(this);
        pb = findViewById(R.id.pb_serching);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if(i2>2) {

        }
    }

    @Override
    public void onTextChanged(CharSequence text, int i, int i1, int i2) {



        if(i2>2){

            pb.setVisibility(View.VISIBLE);
            api.searchOwners(text.toString()).enqueue(new Callback<Respons>() {
                @Override
                public void onResponse(Call<Respons> call, Response<Respons> response) {
                    if(response.isSuccessful()) adapter.updateOwners(response.body().items);
                    pb.setVisibility(View.GONE);
                }

                @Override
                public void onFailure(Call<Respons> call, Throwable t) {

                }
            });
            pb.setVisibility(View.GONE);
            rv.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
