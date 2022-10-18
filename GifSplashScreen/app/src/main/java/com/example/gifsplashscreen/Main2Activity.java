package com.example.gifsplashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ed1 = (EditText) findViewById(R.id.txt1);
        ed2 = (EditText) findViewById(R.id.txt2);
        ed3 = (EditText) findViewById(R.id.txt3);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String red = ed1.getText().toString();
                String green = ed2.getText().toString();
                String blue = ed3.getText().toString();

                btn.setBackgroundColor(Color.parseColor("#" + red+green+blue));
            }
        });
    }
}
