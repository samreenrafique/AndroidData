package com.example.firstclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void  fbclick (View view){
        Toast.makeText(this, "Facebook Clicked", Toast.LENGTH_LONG).show();
    }
    public void  gmailclick (View view){
        Toast.makeText(this, "Gmail Clicked", Toast.LENGTH_SHORT).show();
    }
}
