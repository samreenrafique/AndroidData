package com.example.tabbed;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class adpaterclass extends FragmentPagerAdapter {
    Context con;
    int tabcount;
    public adpaterclass(Context c,FragmentManager fm, int behavior) {
        super(fm);
        this.con = c;
        this.tabcount = behavior;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                HomeFragment home = new HomeFragment();
                return home;
            case 1:
                StatusFragment sta = new StatusFragment();
                return sta;
            case 2:
                HomeFragment home2 = new HomeFragment();
                return home2;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 0;
    }
}
