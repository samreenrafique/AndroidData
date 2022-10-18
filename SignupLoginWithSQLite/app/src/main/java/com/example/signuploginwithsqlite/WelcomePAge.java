package com.example.signuploginwithsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomePAge extends AppCompatActivity {

    TextView xtx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        Intent i = getIntent();
        final String uname = i.getStringExtra("username");
        xtx = (TextView)findViewById(R.id.textView);
        xtx.setText(uname);
    }
}
