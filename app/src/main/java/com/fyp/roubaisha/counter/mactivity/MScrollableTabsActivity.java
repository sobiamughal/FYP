package com.fyp.roubaisha.counter.mactivity;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.fyp.roubaisha.counter.R;
import com.fyp.roubaisha.counter.mfragments.MFiveFragment;
import com.fyp.roubaisha.counter.mfragments.MFourFragment;
import com.fyp.roubaisha.counter.mfragments.MOneFragment;
import com.fyp.roubaisha.counter.mfragments.MThreeFragment;
import com.fyp.roubaisha.counter.mfragments.MTwoFragment;

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
        com.fyp.roubaisha.counter.mactivity.MScrollableTabsActivity.ViewPagerAdapter adapter = new com.fyp.roubaisha.counter.mactivity.MScrollableTabsActivity.ViewPagerAdapter(getSupportFragmentManager());
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
