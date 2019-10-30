package com.example.roubaisha.counter.mactivity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.roubaisha.counter.R;

public class MFajrsunnah extends AppCompatActivity {
    private ViewPager viewPager;
    private MSlideAdapter myadapter;

    private Toolbar mTopToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fajarsunnah);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        myadapter= new MSlideAdapter(this);
        viewPager.setAdapter(myadapter);

    }
}
