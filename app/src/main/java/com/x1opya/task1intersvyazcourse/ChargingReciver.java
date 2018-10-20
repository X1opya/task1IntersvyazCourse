package com.x1opya.task1intersvyazcourse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.os.PowerManager;
import android.widget.TextView;
import android.widget.Toast;

public class ChargingReciver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        if(status == BatteryManager.BATTERY_STATUS_CHARGING) {
            Toast.makeText(context, "Устройство заряжается от сети", Toast.LENGTH_SHORT).show();
        }else if(status == BatteryManager.BATTERY_STATUS_DISCHARGING) {
            Toast.makeText(context, "Устройство не заряжается", Toast.LENGTH_SHORT).show();
        }
        else{

        }

    }
}
