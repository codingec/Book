package com.book.andrews.mybook;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class Another extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int pos) {
            switch (pos) {
                case 0:
                    return FragmentViewPager.newInstance(getString(R.string.title_section4), R.drawable.m16);
                case 1:
                    return FragmentViewPager.newInstance(getString(R.string.title_section5), R.drawable.car);
                case 2:
                    return FragmentViewPager.newInstance(getString(R.string.title_section6), R.drawable.bridge);
                default:
                    return FragmentViewPager.newInstance(getString(R.string.title_section1), R.drawable.apple);
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}