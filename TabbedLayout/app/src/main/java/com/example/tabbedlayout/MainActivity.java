package com.example.tabbedlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayouts;
    TabItem tab1,tab2,tab3;
    ViewPager vwpager;
    pageattach padadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayouts = (TabLayout) findViewById(R.id.tablayout);
        tab1 = (TabItem) findViewById(R.id.chats);
        tab2 = (TabItem) findViewById(R.id.status);
        tab3 = (TabItem) findViewById(R.id.calls);
        vwpager = (ViewPager) findViewById(R.id.placeholder);
        tabLayouts.setTabGravity(TabLayout.GRAVITY_FILL);
        padadapter = new pageattach(this,getSupportFragmentManager(),tabLayouts.getTabCount());
        vwpager.setAdapter(padadapter);
        tabLayouts.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vwpager.setCurrentItem(tab.getPosition());
//                vwpager.setCurrentItem(tab.getPosition());
//                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2)
//                    padadapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

       // vwpager.addOnAdapterChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayouts));
    }
}