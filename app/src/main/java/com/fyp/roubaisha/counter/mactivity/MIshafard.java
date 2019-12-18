package com.fyp.roubaisha.counter.mactivity;

import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.fyp.roubaisha.counter.R;

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
