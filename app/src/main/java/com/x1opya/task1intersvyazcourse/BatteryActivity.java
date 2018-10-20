package com.x1opya.task1intersvyazcourse;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BatteryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);
        TextView tvBatInfo = findViewById(R.id.tv_battery_info);
        Intent intent = this.registerReceiver(null,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        tvBatInfo.setText(intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1)+"%");
    }
}
