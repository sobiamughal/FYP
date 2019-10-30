package com.example.roubaisha.counter.mactivity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.roubaisha.counter.R;
import com.example.roubaisha.counter.activity.SlideAdapterAS;

public class MAsrsunnah extends AppCompatActivity {
    private ViewPager viewPagers;
    private MSlideAdapterAS myadapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asrsunnah);
        viewPagers = (ViewPager) findViewById(R.id.viewpager);
        myadapters= new MSlideAdapterAS(this);
        viewPagers.setAdapter(myadapters);
    }
}
