package com.example.roubaisha.counter.mactivity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.roubaisha.counter.R;

public class MAsrfard extends AppCompatActivity {
    private ViewPager viewPagers;
    private MSlideAdapterAF myadapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asrfard);
        viewPagers = (ViewPager) findViewById(R.id.viewpager);
        myadapters= new MSlideAdapterAF(this);
        viewPagers.setAdapter(myadapters);
    }
}