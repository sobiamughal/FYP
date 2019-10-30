package com.example.roubaisha.counter.mactivity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.roubaisha.counter.R;
import com.example.roubaisha.counter.activity.SlideAdapterIN;

public class MIshanafil extends AppCompatActivity {
    private ViewPager viewPagers;
    private MSlideAdapterIN myadapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ishanafil);
        viewPagers = (ViewPager) findViewById(R.id.viewpager);
        myadapters= new MSlideAdapterIN(this);
        viewPagers.setAdapter(myadapters);
    }
}
