package com.example.fengjian.myfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.List;

/**
 * Created by fengjian on 11/14/17.
 */

public class MyFragPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    public MyFragPagerAdapter(FragmentManager fm,List<Fragment> fragments){
        super(fm);
        mFragments=fragments;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
