package com.example.roubaisha.counter.mactivity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.roubaisha.counter.R;
import com.example.roubaisha.counter.activity.SlideAdapterZSS;

public class MZuhar_sunnah extends AppCompatActivity {
    private ViewPager viewPagers;
    private MSlideAdapterZSS myadapters;
    private Toolbar mTopToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zuhar_sunnah);
        viewPagers = (ViewPager) findViewById(R.id.viewpager);
        myadapters= new MSlideAdapterZSS(this);
        viewPagers.setAdapter(myadapters);
    }
}

