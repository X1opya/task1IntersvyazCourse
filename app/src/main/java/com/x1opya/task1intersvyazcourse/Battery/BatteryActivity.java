package com.x1opya.task1intersvyazcourse.Battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.x1opya.task1intersvyazcourse.R;

public class BatteryActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);
        TextView tvBatInfo = findViewById(R.id.tv_battery_info);
        Intent intent = this.registerReceiver(null,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        int value = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
        tvBatInfo.setText(value+"%");
        ProgressBar p = findViewById(R.id.progressBar);
        p.setProgress(value);
    }
}
