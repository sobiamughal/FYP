package com.fyp.roubaisha.counter.activity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.fyp.roubaisha.counter.R;

public class Asrsunnah extends AppCompatActivity {
    private ViewPager viewPagers;
    private SlideAdapterAS myadapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asrsunnah);
        viewPagers = (ViewPager) findViewById(R.id.viewpager);
        myadapters= new SlideAdapterAS(this);
        viewPagers.setAdapter(myadapters);
    }
}