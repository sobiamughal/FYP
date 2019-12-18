package com.fyp.roubaisha.counter.Services;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class RestartPrayerReminderService extends BroadcastReceiver {

    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, PrayerReminderService.class));

    }

}