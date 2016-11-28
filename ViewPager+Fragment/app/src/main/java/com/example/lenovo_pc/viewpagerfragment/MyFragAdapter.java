package com.example.lenovo_pc.viewpagerfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.List;

/**
 * Created by lenovo-pc on 2016/11/11.
 */
public class MyFragAdapter extends FragmentPagerAdapter {

    List<Fragment> list;

    public MyFragAdapter(FragmentManager fm,
                         List<Fragment> list) {
        super(fm);
        this.list=list;
    }

    @Override
    public Fragment getItem(int arg0) {

        return list.get(arg0);
    }

    @Override
    public int getCount() {

        return list.size();
    }
}
