package com.example.sharedpreferencess;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity {

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        txt = findViewById(R.id.textView3);
        check();
    }

    public void check()
    {
        SharedPreferences s = getSharedPreferences("Credentials",MODE_PRIVATE);
        if (!s.contains("uname"))
        {
            Intent i = new Intent(WelcomeScreen.this , Login.class);
            startActivity(i);
            finish();
        }
        else{
            txt.setText(s.getString("uname",""));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.my_menu,menu);
       return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.logout)
        {
            SharedPreferences sp = getSharedPreferences("Credentials",MODE_PRIVATE);
            sp.edit().clear().apply();
            Intent i = new Intent(WelcomeScreen.this , Login.class);
            startActivity(i);
            finish();
        }
        return true;
    }
}