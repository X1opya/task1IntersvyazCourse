package com.x1opya.task1intersvyazcourse;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String TAG = "Life Ciycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(new ChargingReciver(),filter);
        //Toast.makeText(this,"16 минут уже прошло",Toast.LENGTH_LONG).show();
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

    public void onClickShowBatteryInfo(View view) {
        startActivity(new Intent(this,BatteryActivity.class));
    }

    public void onClickShowGeoInfo(View view) {
        startActivity(new Intent(this,GeoActivity.class));
    }
}
