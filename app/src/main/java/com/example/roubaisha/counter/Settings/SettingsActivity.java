package com.example.roubaisha.counter.Settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.SwitchPreference;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.roubaisha.counter.R;

public class SettingsActivity extends AppCompatPreferenceActivity {
    public static final String MY_PREFS_NAME = "MyPrefs" ;
    public static final String TAG = SettingsActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_main);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Button femalebtn = (Button)findViewById(R.id.prayergbtn);
        final ImageView malebtn = (ImageView) findViewById(R.id.Mprayergbtn);

        // Get the custom preference
        SwitchPreference switchPreference = (SwitchPreference) findPreference("switch");
        switchPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object  newValue) {

                boolean isOn = (boolean) newValue;
                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                if (isOn) {
                    editor.putBoolean("btn",isOn);
                    editor.apply();
                    Toast.makeText(SettingsActivity.this, "Switch is ON", Toast.LENGTH_SHORT).show();

                } else {
                    editor.putBoolean("btn",isOn);
                    editor.apply();
                    Log.d("0099","btn " + editor.toString() + " " + isOn);
                    Toast.makeText(SettingsActivity.this, "Switch is OFF", Toast.LENGTH_SHORT).show();

                }
                return true;
            }
        });

    }

}
