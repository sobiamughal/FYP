package com.example.roubaisha.counter.mactivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.roubaisha.counter.R;
import com.example.roubaisha.counter.mfragments.MFiveFragment;
import com.example.roubaisha.counter.mfragments.MFourFragment;
import com.example.roubaisha.counter.mfragments.MOneFragment;
import com.example.roubaisha.counter.mfragments.MThreeFragment;
import com.example.roubaisha.counter.mfragments.MTwoFragment;

import java.util.ArrayList;
import java.util.List;

public class MScrollableTabsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollable_tabs);

        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        com.example.roubaisha.counter.mactivity.MScrollableTabsActivity.ViewPagerAdapter adapter = new com.example.roubaisha.counter.mactivity.MScrollableTabsActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new MOneFragment(), "FAJR");
        adapter.addFrag(new MTwoFragment(), "DUHR");
        adapter.addFrag(new MThreeFragment(), "ASR");
        adapter.addFrag(new MFourFragment(), "MAGHRIB");
        adapter.addFrag(new MFiveFragment(), "ISHA");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
