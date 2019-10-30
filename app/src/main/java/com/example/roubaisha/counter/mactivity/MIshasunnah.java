package com.example.roubaisha.counter.mactivity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.roubaisha.counter.R;
import com.example.roubaisha.counter.activity.SlideAdapterIS;

public class MIshasunnah extends AppCompatActivity {
    private ViewPager viewPagers;
    private MSlideAdapterIS myadapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ishasunah);

        viewPagers = (ViewPager) findViewById(R.id.viewpager);
        myadapters= new MSlideAdapterIS(this);
        viewPagers.setAdapter(myadapters);
    }
}
