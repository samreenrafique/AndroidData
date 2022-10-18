package com.example.navbarplustablayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    NavigationView nav;
    DrawerLayout draw;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        nav = (NavigationView) findViewById(R.id.navbar);
        draw = (DrawerLayout) findViewById(R.id.drawer);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle icon = new ActionBarDrawerToggle(this,draw,toolbar,R.string.open,R.string.close);
        draw.addDrawerListener(icon);
        icon.syncState();
        toolbar.setNavigationIcon(R.drawable.ic_baseline_home_24);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.one:
                        Toast.makeText(MainActivity.this, "Option One", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.two:
                        Toast.makeText(MainActivity.this, "Option Two", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.three:
                        Toast.makeText(MainActivity.this, "Option Three", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.four:
                        Toast.makeText(MainActivity.this, "Option Four", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.five:
                        Toast.makeText(MainActivity.this, "Option Five", Toast.LENGTH_SHORT).show();
                        break;
                }
                draw.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}