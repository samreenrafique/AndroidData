package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText one,two,three;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = (EditText)findViewById(R.id.txtone);
        two = (EditText)findViewById(R.id.txttwo);
        three = (EditText)findViewById(R.id.answer);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(one.getText().toString());
                int b = Integer.parseInt(two.getText().toString());
                int sum = a + b;
                three.setText(sum);
            }
        });

    }

}
