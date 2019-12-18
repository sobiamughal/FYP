package com.fyp.roubaisha.counter.mactivity;

import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.fyp.roubaisha.counter.R;

public class MZuhar_sunnah extends AppCompatActivity {
    private ViewPager viewPagers;
    private MSlideAdapterZSS myadapters;
    private Toolbar mTopToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zuhar_sunnah);
        viewPagers = (ViewPager) findViewById(R.id.viewpager);
        myadapters= new MSlideAdapterZSS(this);
        viewPagers.setAdapter(myadapters);
    }
}

