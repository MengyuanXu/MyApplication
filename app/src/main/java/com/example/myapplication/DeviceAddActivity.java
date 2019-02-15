package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


/**
 * Created by Administrator on 2016-04-20.
 */
public class DeviceAddActivity extends AppCompatActivity implements Button.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_device_add);
        setTitle("");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.device_light_button).setOnClickListener(this);
        findViewById(R.id.device_monitor_button).setOnClickListener(this);
        findViewById(R.id.device_lock_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(DeviceAddActivity.this, DeviceIdentifyActivity.class);
        switch(view.getId()){
            case R.id.device_light_button:
                intent.putExtra("devicetype", Device.DEVICE_TYPE_LIGHT);
                break;
            case R.id.device_monitor_button:
                intent.putExtra("devicetype", Device.DEVICE_TYPE_MONITOR);
                break;
            case R.id.device_lock_button:
                intent.putExtra("devicetype", Device.DEVICE_TYPE_LOCK);
                break;
        }
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return true;
    }

}