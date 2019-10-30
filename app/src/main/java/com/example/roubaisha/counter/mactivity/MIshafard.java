package com.example.roubaisha.counter.mactivity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.roubaisha.counter.R;
import com.example.roubaisha.counter.activity.SlideAdapterIF;

public class MIshafard extends AppCompatActivity {
    private ViewPager viewPagers;
    private MSlideAdapterIF myadapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ishafard);
        viewPagers = (ViewPager) findViewById(R.id.viewpager);
        myadapters= new MSlideAdapterIF(this);
        viewPagers.setAdapter(myadapters);
    }
}
