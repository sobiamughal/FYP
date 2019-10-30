package com.example.roubaisha.counter.mactivity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.roubaisha.counter.R;
import com.example.roubaisha.counter.activity.SlideAdapterMS;

public class MMaghribsunnah extends AppCompatActivity {
    private ViewPager viewPagers;
    private MSlideAdapterMS myadapters;
    private Toolbar mTopToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maghribsunnah);
        viewPagers = (ViewPager) findViewById(R.id.viewpager);
        myadapters= new MSlideAdapterMS(this);
        viewPagers.setAdapter(myadapters);
    }
}
