package com.fyp.roubaisha.counter.activity;

import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.fyp.roubaisha.counter.R;

public class Zuharsunnah extends AppCompatActivity {
    private ViewPager viewPagers;
    private SlideAdapterZS myadapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zuharsunnah);
        viewPagers = (ViewPager) findViewById(R.id.viewpager);
        myadapters= new SlideAdapterZS(this);
        viewPagers.setAdapter(myadapters);
    }
}

