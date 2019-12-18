package com.fyp.roubaisha.counter.mactivity;

import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.fyp.roubaisha.counter.R;

public class MIshasunnah extends AppCompatActivity {
    private ViewPager viewPagers;
    private MSlideAdapterIS myadapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ishasunah);

        viewPagers = (ViewPager) findViewById(R.id.viewpager);
        myadapters= new MSlideAdapterIS(this);
        viewPagers.setAdapter(myadapters);
    }
}
