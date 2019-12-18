package com.fyp.roubaisha.counter.mactivity;

import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.fyp.roubaisha.counter.R;

public class MIshawitr extends AppCompatActivity {
    private ViewPager viewPagers;
    private MSlideAdapterIW myadapters;
    private Toolbar mTopToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ishawitr);
        viewPagers = (ViewPager) findViewById(R.id.viewpager);
        myadapters= new MSlideAdapterIW(this);
        viewPagers.setAdapter(myadapters);
    }
}
