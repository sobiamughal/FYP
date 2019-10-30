package com.example.roubaisha.counter;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.roubaisha.counter.Helper.DatabaseHelper;
import com.example.roubaisha.counter.Helper.PrayerAPIHelper;
import com.example.roubaisha.counter.Map.MapsActivity;
import com.example.roubaisha.counter.Names.NamesOptionActivity;
import com.example.roubaisha.counter.Qibla.QiblaActivity;
import com.example.roubaisha.counter.Services.PrayerReminderService;
import com.example.roubaisha.counter.Services.RestartPrayerReminderService;
import com.example.roubaisha.counter.Services.RestartTravelDetectionService;
import com.example.roubaisha.counter.Services.TravelDetectionService;
import com.example.roubaisha.counter.Settings.SettingsActivity;
import com.example.roubaisha.counter.activity.ScrollableTabsActivity;
import com.example.roubaisha.counter.duaen.DuaActivity;
import com.example.roubaisha.counter.mactivity.MScrollableTabsActivity;
import com.example.roubaisha.counter.prayertime.PrayerTimeActivity;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;


public class DashboardActivity extends AppCompatActivity {
    DatabaseHelper objDBHelper;
    private static final long START_TIME_IN_MILLIS = 1800000;

    private ViewFlipper viewFlipper;
    private Animation fadeIn, fadeOut;

    private RelativeLayout prayergbtn;
    private RelativeLayout tasbihbtn;
    private RelativeLayout nearestmosquebtn;
    private RelativeLayout prayertimebtn;
    private RelativeLayout pendingprayerbtn;
    private RelativeLayout namesbtn;

    ImageView Mprayergbtn;
    private SharedPreferences sharedPref;
    public Intent intent;
    Context ctx = DashboardActivity.this;
    SettingsActivity st = new SettingsActivity();
    DashboardActivity(){
    }
    DashboardActivity(Context ctx){
        this.ctx = ctx;
    }

    SpaceNavigationView spaceNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        spaceNavigationView = findViewById(R.id.space);

        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem("",R.drawable.ic_home_black_24dp));
        spaceNavigationView.addSpaceItem(new SpaceItem("",R.drawable.ic_dua_hands));
        spaceNavigationView.addSpaceItem(new SpaceItem("",R.drawable.ic_access_time_black_24dp));
        spaceNavigationView.addSpaceItem(new SpaceItem("",R.drawable.ic_qibla_compass));

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                Intent intent = new Intent(DashboardActivity.this,HijriCalendar.class);
                startActivity(intent);
                Toast.makeText(DashboardActivity.this,"Coming Soon", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                //Toast.makeText(DashboardActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
                spaceNavigationView.setCentreButtonSelectable(true);

                if (itemIndex ==0 )
                {
                    Intent intent = new Intent(DashboardActivity.this,DashboardActivity.class);
                    startActivity(intent);
                }else if (itemIndex == 1)
                {
                    Intent intent = new Intent(DashboardActivity.this, DuaActivity.class);
                    startActivity(intent);
                }else if (itemIndex == 2)
                {
                    Intent intent = new Intent(DashboardActivity.this,PrayerTimeActivity.class);
                    startActivity(intent);
                }else if (itemIndex == 3)
                {
                    Intent intent = new Intent(DashboardActivity.this, QiblaActivity.class);
                    startActivity(intent);
                }else {}


            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Toast.makeText(DashboardActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }
        });

        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        viewFlipper.setInAnimation(fadeIn);
        viewFlipper.setOutAnimation(fadeOut);

        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.startFlipping();


        Mprayergbtn= findViewById(R.id.Mprayergbtn);
        Mprayergbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMalePrayerGuidanceActivity();
            }
        });
        prayergbtn= findViewById(R.id.prayergbtn);
        prayergbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPrayerGuidanceActivity();
            }
        });
        tasbihbtn= findViewById(R.id.tasbihbtn);
        tasbihbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTasbihActivity();
            }
        });
        nearestmosquebtn= findViewById(R.id.nearestmosquebtn);
        nearestmosquebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMosqueActivity();
            }
        });
        prayertimebtn= findViewById(R.id.prayertimebtn);
        prayertimebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPrayerTimeActivity();
            }
        });
        pendingprayerbtn = findViewById(R.id.pendingprayerbtn);
        pendingprayerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openPendingPrayerActivity();
            }
        });
        namesbtn = findViewById(R.id.namesbtn);
        namesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openNamesActivity();
            }
        });


        PrayerAPIHelper.RetrievePrayerTimings(this);
        if (!isMyServiceRunning(PrayerReminderService.class)) {

            RestartPrayerReminderService objRestartPrayerReminderService = new RestartPrayerReminderService();
            this.registerReceiver(objRestartPrayerReminderService, new IntentFilter());
            Intent intent = new Intent(this, RestartPrayerReminderService.class);
            sendBroadcast(intent);
        }
        if (!isMyServiceRunning(TravelDetectionService.class)) {

            RestartTravelDetectionService objRestartTravelDetectionService = new RestartTravelDetectionService();
            this.registerReceiver(objRestartTravelDetectionService, new IntentFilter());
            Intent intent = new Intent(this, RestartTravelDetectionService.class);
            sendBroadcast(intent);
        }
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);
        mNotificationManager.cancel(2);
    }


    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.action_settings){
            Intent intent = new Intent(DashboardActivity.this,SettingsActivity.class);
            intent.putExtra("select","selected");
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void openMalePrayerGuidanceActivity() {
        Intent intent = new Intent(this, MScrollableTabsActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d("0099","OnResume Called");
        sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        boolean isMuslim= sharedPref.getBoolean("btn", true);
        Log.d("0099", String.valueOf(isMuslim));
        Log.d("0099","In resume:   "+isMuslim);
        if (isMuslim){
            Log.d("0099","when switch is on"+isMuslim);
            Mprayergbtn.setVisibility(View.VISIBLE);
            prayergbtn.setVisibility(View.INVISIBLE);
        }else {
            Log.d("0099","when switch is off"+isMuslim);
            prayergbtn.setVisibility(View.VISIBLE);
            Mprayergbtn.setVisibility(View.INVISIBLE);
        }

    }

    private void openNamesActivity() {
        Intent intent = new Intent(this, NamesOptionActivity.class);
        startActivity(intent);
    }

    private void openPendingPrayerActivity() {
        Intent intent = new Intent(this, PendingPrayerLayerActivity.class);
        startActivity(intent);
    }

    private void openPrayerTimeActivity() {
        Intent intent = new Intent(this, PrayerTimeActivity.class);
        startActivity(intent);
    }

    private void openMosqueActivity() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    private void openTasbihActivity() {
        Intent intent = new Intent(this, TasbihOption.class);
        startActivity(intent);
    }

    private void openPrayerGuidanceActivity() {
        Intent intent = new Intent(this, ScrollableTabsActivity.class);
        startActivity(intent);
    }
}
