package com.example.radiobuttonvalue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Welcome extends AppCompatActivity {

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        txt = (TextView) findViewById(R.id.getstring);
        Intent im = getIntent();
        String getdata = im.getStringExtra("passdata");

        if(getdata.equals((txt)))
        {
            Toast.makeText(this, "a", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "b", Toast.LENGTH_SHORT).show();
        }

    }
}
