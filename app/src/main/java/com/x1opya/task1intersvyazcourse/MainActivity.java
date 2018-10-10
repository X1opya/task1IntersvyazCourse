package com.x1opya.task1intersvyazcourse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String TAG = "Life Ciycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"16 минут уже прошло",Toast.LENGTH_LONG).show();
        Log.println(Log.ASSERT, TAG,"onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.println(Log.ASSERT,TAG,"onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.println(Log.ASSERT,TAG,"onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.println(Log.ASSERT,TAG,"onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.println(Log.ASSERT,TAG,"onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.println(Log.ASSERT,TAG,"onResum");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.println(Log.ASSERT,TAG,"onPause");
    }
}
