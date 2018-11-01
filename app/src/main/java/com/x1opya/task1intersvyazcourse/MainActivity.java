package com.x1opya.task1intersvyazcourse;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.x1opya.task1intersvyazcourse.Api.ApiActivity;
import com.x1opya.task1intersvyazcourse.Battery.BatteryActivity;
import com.x1opya.task1intersvyazcourse.Battery.ChargingReciver;

public class MainActivity extends AppCompatActivity {
    private String TAG = "Life Ciycle";
    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(new ChargingReciver(),filter);
        //Toast.makeText(this,"16 минут уже прошло",Toast.LENGTH_LONG).show();
        Log.println(Log.ASSERT, TAG,"onCreate");
        initConstraint();
    }

    protected void initConstraint(){
        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        ConstraintSet set = new ConstraintSet();
        ConstraintLayout layout = findViewById(R.id.con);
        set.clone(layout);
        set.connect(tv1.getId(),ConstraintSet.BOTTOM,R.id.button,ConstraintSet.TOP);
        set.connect(tv1.getId(),ConstraintSet.LEFT,R.id.button,ConstraintSet.LEFT);
        set.connect(tv1.getId(),ConstraintSet.RIGHT,R.id.button,ConstraintSet.RIGHT);
        set.connect(tv2.getId(),ConstraintSet.BOTTOM,R.id.button2,ConstraintSet.TOP);
        set.connect(tv2.getId(),ConstraintSet.LEFT,R.id.button2,ConstraintSet.LEFT);
        set.connect(tv2.getId(),ConstraintSet.RIGHT,R.id.button2,ConstraintSet.RIGHT);
        set.applyTo(layout);
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

    public void onClickShowApi(View view) {
        Intent intent = new Intent(this, ApiActivity.class);
        startActivity(intent);
    }
}
