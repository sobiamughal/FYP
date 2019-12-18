package com.fyp.roubaisha.counter.mactivity;

import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.fyp.roubaisha.counter.R;

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
