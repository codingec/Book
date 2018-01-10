package com.book.andrews.mybook;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        final Context context = this;
        Button button;
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, Another.class);
                startActivity(intent);

            }

        });
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int pos) {
            switch (pos) {
                case 0:
                    return FragmentViewPager.newInstance(getString(R.string.title_section1), R.drawable.apple);
                case 1:
                    return FragmentViewPager.newInstance(getString(R.string.title_section2), R.drawable.orange);
                case 2:
                    return FragmentViewPager.newInstance(getString(R.string.title_section3), R.drawable.grapes);
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



