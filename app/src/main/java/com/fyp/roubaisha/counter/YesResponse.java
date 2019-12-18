package com.fyp.roubaisha.counter;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.widget.Toast;

import com.fyp.roubaisha.counter.Helper.DatabaseHelper;

public class YesResponse extends Activity {

    DatabaseHelper db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabaseHelper(this);

        int ResponseTypeId = getIntent().getIntExtra("ResponseTypeId",-1);
        int PendingPrayerId = getIntent().getIntExtra("PendingPrayerId",-1);

        if(ResponseTypeId == 0)
        {
        }
        else if(ResponseTypeId == 1)
        {
            if(PendingPrayerId != -1)
            {
                db.PerformPendingPrayer(PendingPrayerId);
                Toast.makeText(this,"Amazing! May Allah bless you.", Toast.LENGTH_LONG).show();
            }
        }

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.cancel(1);

        Intent intent = new Intent(YesResponse.this, DashboardActivity.class);
        intent.putExtra("Response", 1);
        startActivity(intent);
    }
}
