package com.example.sharedpreferencess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    TextView t;
    Button bt1,bt2;
    dbclass db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText) findViewById(R.id.editTextTextPersonName);
        ed2 = (EditText) findViewById(R.id.editTextTextPersonName2);
        ed3 = (EditText) findViewById(R.id.editTextTextPersonName3);
        t = (TextView) findViewById(R.id.textView);
        bt1 = (Button) findViewById(R.id.button);
        bt2 = (Button) findViewById(R.id.button2);
        db = new dbclass(this);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(db.insertdata(ed1.getText().toString() , ed2.getText().toString(),ed3.getText().toString()))
               {
                   SharedPreferences s = getSharedPreferences("Credentials",MODE_PRIVATE);
                   SharedPreferences.Editor e = s.edit();
                   e.putString("uname",ed1.getText().toString());
                   e.apply();
                   Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                   Intent i = new Intent(MainActivity.this,Login.class);
                   startActivity(i);
                   finish();
               }
               else{
                    Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("Credentials",MODE_PRIVATE);
                SharedPreferences.Editor  ed= sp.edit();
                ed.clear();
                ed.apply();

                Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }


}