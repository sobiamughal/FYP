package com.fyp.roubaisha.counter.activity;

import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.fyp.roubaisha.counter.R;

public class Ishawitr extends AppCompatActivity {
    private ViewPager viewPagers;
    private SlideAdapterIW myadapters;
    private Toolbar mTopToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ishawitr);
        viewPagers = (ViewPager) findViewById(R.id.viewpager);
        myadapters= new SlideAdapterIW(this);
        viewPagers.setAdapter(myadapters);
    }
}