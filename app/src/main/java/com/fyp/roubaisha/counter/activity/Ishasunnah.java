package com.fyp.roubaisha.counter.activity;

import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.fyp.roubaisha.counter.R;

public class Ishasunnah extends AppCompatActivity {
    private ViewPager viewPagers;
    private SlideAdapterIS myadapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ishasunah);

        viewPagers = (ViewPager) findViewById(R.id.viewpager);
        myadapters= new SlideAdapterIS(this);
        viewPagers.setAdapter(myadapters);
    }
}