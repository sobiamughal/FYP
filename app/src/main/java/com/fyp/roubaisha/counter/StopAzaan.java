package com.fyp.roubaisha.counter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;

import com.fyp.roubaisha.counter.Services.SoundService;

public class StopAzaan extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent1 = new Intent(this, SoundService.class);
        stopService(intent1);
        Intent intent = new Intent(StopAzaan.this, DashboardActivity.class);
        startActivity(intent);
    }
}
