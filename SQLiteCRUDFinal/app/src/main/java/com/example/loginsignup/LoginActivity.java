package com.example.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText ed1,ed2;
    Button b;

    String namee,emmail,paswd;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences sp = getSharedPreferences("adminfile",MODE_PRIVATE);
        SharedPreferences usp = getSharedPreferences("userfile",MODE_PRIVATE);

        if (sp.contains("name"))
        {
            Intent us = new Intent(LoginActivity.this,ShowUserActivity.class);
            startActivity(us);
            finish();
        }
        if (usp.contains("uname")){
            Intent us = new Intent(LoginActivity.this,UserActivity.class);
            startActivity(us);
            finish();
        }

        ed1 = findViewById(R.id.led1);
        ed2 = findViewById(R.id.leed2);
        b = findViewById(R.id.bt2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = ed1.getText().toString();
                String pswd = ed2.getText().toString();
                DbFile db = new DbFile(LoginActivity.this);
                Boolean check = db.Login(email,pswd);
                if (check == true){
                    Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    Intent us = new Intent(LoginActivity.this,UserActivity.class);


                    Cursor c = db.FetchUsername(email,pswd);
                    while(c.moveToNext()){
                        namee = c.getString(1);
                        id = c.getInt(0);
                        emmail = c.getString(2);
                        paswd = c.getString(3);
                    }

                    SharedPreferences usp = getSharedPreferences("userfile",MODE_PRIVATE);
                    SharedPreferences.Editor ed = usp.edit();
                    ed.putString("uname",namee);
                    ed.putString("uemail",emmail);
                    ed.putString("uid","" + id);
                    ed.putString("upswd","" + paswd);
                    ed.commit();
                    ed.apply();

                    startActivity(us);
                    finish();

                }
                else if (email.equalsIgnoreCase("admin@gmail.com") && pswd.equals("123")){
                    Intent us = new Intent(LoginActivity.this,ShowUserActivity.class);

                    SharedPreferences sp = getSharedPreferences("adminfile",MODE_PRIVATE);
                    SharedPreferences.Editor ed = sp.edit();
                    ed.putString("name" , "Admin");
                    ed.commit();
                    ed.apply();

                    startActivity(us);
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Login Not Successfully", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}