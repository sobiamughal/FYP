package com.fyp.roubaisha.counter.activity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.fyp.roubaisha.counter.R;


public class Asrfard extends AppCompatActivity {
    private ViewPager viewPagers;
    private SlideAdapterAF myadapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asrfard);
        viewPagers = (ViewPager) findViewById(R.id.viewpager);
        myadapters= new SlideAdapterAF(this);
        viewPagers.setAdapter(myadapters);
    }
}