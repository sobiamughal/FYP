package com.fyp.roubaisha.counter.activity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.fyp.roubaisha.counter.R;

public class Fajrsunnah extends AppCompatActivity {
    private ViewPager viewPager;
    private SlideAdapter myadapter;

    private Toolbar mTopToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fajarsunnah);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        myadapter= new SlideAdapter(this);
        viewPager.setAdapter(myadapter);

    }
}