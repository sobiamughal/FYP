package com.fyp.roubaisha.counter.activity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.fyp.roubaisha.counter.R;

public class Maghribsunnah extends AppCompatActivity {
    private ViewPager viewPagers;
    private SlideAdapterMS myadapters;
    private Toolbar mTopToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maghribsunnah);
        viewPagers = (ViewPager) findViewById(R.id.viewpager);
        myadapters= new SlideAdapterMS(this);
        viewPagers.setAdapter(myadapters);
    }
}