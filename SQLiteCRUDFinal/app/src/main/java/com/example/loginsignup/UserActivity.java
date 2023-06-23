package com.example.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {
    TextView t,t1,t2,t3,t4;
    Button b;
    ImageView up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
         t= findViewById(R.id.txtx);
         t1= findViewById(R.id.uid1);
         t2= findViewById(R.id.uname1);
         t3 = findViewById(R.id.uemail1);
         t4= findViewById(R.id.upswd11);
         b= findViewById(R.id.btnnnn);
         up= findViewById(R.id.updatebtn111);



        SharedPreferences usp = getSharedPreferences("userfile",MODE_PRIVATE);
        if (!usp.contains("uname")){
            Intent us = new Intent(UserActivity.this,LoginActivity.class);
            startActivity(us);
            finish();
        }

         t.setText(usp.getString("uname",""));
         t1.setText(usp.getString("uid",""));
         t2.setText(usp.getString("uname",""));
         t3.setText(usp.getString("uemail",""));
         t4.setText(usp.getString("upswd",""));


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor ed= usp.edit();
                ed.clear();
                ed.commit();
                ed.apply();

                Intent us = new Intent(UserActivity.this,LoginActivity.class);
                startActivity(us);
                finish();
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(UserActivity.this,UpdateActivity.class);
                ii.putExtra("UserID" ,"" + t1.getText().toString());
                ii.putExtra("UserNAme" ,"" + t2.getText().toString());
                ii.putExtra("UserEmail" ,"" + t3.getText().toString());

                startActivity(ii);
                finish();
            }
        });
    }
}