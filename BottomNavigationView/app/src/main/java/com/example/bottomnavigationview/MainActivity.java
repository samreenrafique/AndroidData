package com.example.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ActionBar tollbar;
    TabLayout tab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tollbar = getSupportActionBar();
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        tab = (TabLayout) findViewById(R.id.tabLayout);
        HomeFragment home = new HomeFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.placeholder, home).commit();
    //    bottomNavigationView.setOnNavigationItemSelectedListener(this);

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        tollbar.setTitle("Home");
                        HomeFragment home = new HomeFragment();
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.placeholder, home).commit();
                        break;
                    case 1:
                        tollbar.setTitle("Search");
                        StatusFragment staus = new StatusFragment();
                        FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                        ft2.replace(R.id.placeholder, staus).commit();
                        break;
                    case 2:
                        tollbar.setTitle("Plus");
                        ProfileFragment profile = new ProfileFragment();
                        FragmentTransaction ft3 = getSupportFragmentManager().beginTransaction();
                        ft3.replace(R.id.placeholder, profile).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.one:
                        tollbar.setTitle("Home");
                        HomeFragment home = new HomeFragment();
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.placeholder, home).commit();
                        break;
                    case R.id.two:
                        tollbar.setTitle("Search");
                        SerachFragment search = new SerachFragment();
                        FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                        ft2.replace(R.id.placeholder, search).commit();
                        break;
                    case R.id.three:
                        tollbar.setTitle("Plus");
                        ProfileFragment profile = new ProfileFragment();
                        FragmentTransaction ft3 = getSupportFragmentManager().beginTransaction();
                        ft3.replace(R.id.placeholder, profile).commit();
                        break;
                    case R.id.four:
                        tollbar.setTitle("Heart");
                        HomeFragment home2 = new HomeFragment();
                        FragmentTransaction ft4 = getSupportFragmentManager().beginTransaction();
                        ft4.replace(R.id.placeholder, home2).commit();
                        break;
                    case R.id.five:
                        tollbar.setTitle("Profile");
                        SerachFragment search2 = new SerachFragment();
                        FragmentTransaction ft21 = getSupportFragmentManager().beginTransaction();
                        ft21.replace(R.id.placeholder, search2).commit();
                }
                return true;
            }
        });
    }


//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.one:
//                getSupportFragmentManager().beginTransaction().replace(R.id.placeholder, new HomeFragment()).commit();
////                HomeFragment home = new HomeFragment();
////                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
////                ft.replace(R.id.placeholder, home).commit();
//                return true;
//            case R.id.two:
//                getSupportFragmentManager().beginTransaction().replace(R.id.placeholder, new SerachFragment()).commit();
////                SerachFragment search = new SerachFragment();
////                FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
////                ft2.replace(R.id.placeholder, search).commit();
//                return true;
//            case R.id.three:
//                getSupportFragmentManager().beginTransaction().replace(R.id.placeholder, new ProfileFragment()).commit();
////                ProfileFragment profile = new ProfileFragment();
////                FragmentTransaction ft3 = getSupportFragmentManager().beginTransaction();
////                ft3.replace(R.id.placeholder, profile).commit();
////                return true;
//            case R.id.four:
//                HomeFragment home2 = new HomeFragment();
//                FragmentTransaction ft4 = getSupportFragmentManager().beginTransaction();
//                ft4.replace(R.id.placeholder, home2).commit();
//                return true;
//            case R.id.five:
//                SerachFragment search2 = new SerachFragment();
//                FragmentTransaction ft21 = getSupportFragmentManager().beginTransaction();
//                ft21.replace(R.id.placeholder, search2).commit();
//        }
//        return false;
//    }
}