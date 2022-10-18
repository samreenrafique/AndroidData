package com.example.sharedpreferencess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText ed1,ed2;
    Button bt ,bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        bt = (Button) findViewById(R.id.button3);
        bt2 = (Button) findViewById(R.id.button4);
        dbclass db = new dbclass(this);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(db.loginlogic(ed1.getText().toString(),ed2.getText().toString()))
                {
                    SharedPreferences s = getSharedPreferences("Credentials",MODE_PRIVATE);
                    SharedPreferences.Editor e = s.edit();
                    e.putString("uname",ed1.getText().toString());
                    e.apply();
                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent i =new Intent(Login.this,WelcomeScreen.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(Login.this, "Login Not Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this , MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }


}