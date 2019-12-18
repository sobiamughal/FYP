package com.fyp.roubaisha.counter;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;

import com.fyp.roubaisha.counter.Services.SoundService;

public class StopSound extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, SoundService.class);
        stopService(intent);
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.cancel(3);


        Intent _intent = new Intent(StopSound.this, DashboardActivity.class);
        _intent.putExtra("Response", 1);
        startActivity(_intent);

    }
}
