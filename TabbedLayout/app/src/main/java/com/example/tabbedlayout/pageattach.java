package com.example.tabbedlayout;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class pageattach extends FragmentPagerAdapter {
    int tabcount ;
    Context context;
    public pageattach(Context con, FragmentManager fm, int behavior) {
        super(fm);
        this.context = con;
        this.tabcount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                Chats c = new Chats();
                return c;
            case 1:
                status st = new status();
                return st;
            case 2:
                calls ca = new calls();
                return ca;
            default:
                Chats ch = new Chats();
                return ch;
        }

    }

    @Override
    public int getCount() {
        return 0;
    }
}
