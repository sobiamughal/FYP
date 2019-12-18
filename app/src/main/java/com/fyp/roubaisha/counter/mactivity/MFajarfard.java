package com.fyp.roubaisha.counter.mactivity;

import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.fyp.roubaisha.counter.R;

public class MFajarfard extends AppCompatActivity {
    private ViewPager viewPagers;
    private MSlideAdapterFF myadapters;
    private Toolbar mTopToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fajarfard);
        viewPagers = (ViewPager) findViewById(R.id.viewpager);
        myadapters= new MSlideAdapterFF(this);
        viewPagers.setAdapter(myadapters);
    }
}
