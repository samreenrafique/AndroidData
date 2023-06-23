package com.example.loginsignup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowUserActivity extends AppCompatActivity {
    RecyclerView rec;
    Button b,b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user);
        rec= findViewById(R.id.recyck);
        b= findViewById(R.id.go);
        b1= findViewById(R.id.logout);

        SharedPreferences sp = getSharedPreferences("adminfile",MODE_PRIVATE);
        if (!sp.contains("name"))
        {
            Intent us = new Intent(ShowUserActivity.this,LoginActivity.class);
            startActivity(us);
            finish();
        }



        rec.setLayoutManager(new LinearLayoutManager(ShowUserActivity.this));
        // 3
        DbFile db = new DbFile(ShowUserActivity.this);
        ArrayList<Register> userinfo = new ArrayList<>();
        Cursor dataaya =   db.FetchData();

        if(dataaya.getCount() == 0){
            Toast.makeText(this, "No Result found", Toast.LENGTH_SHORT).show();
        }
        else{
            while(dataaya.moveToNext()){
                int db_id = dataaya.getInt(0);
                String db_name = dataaya.getString(1);
                String db_email = dataaya.getString(2);
                userinfo.add(new Register(db_id,db_name,db_email));
            }
            RecyclerViewAdapter adpt = new RecyclerViewAdapter(userinfo);
            rec.setAdapter(adpt);
        }


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(ShowUserActivity.this, MainActivity.class);
                startActivity(ii);
                finish();
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor ed = sp.edit();
                ed.clear();
                ed.commit();
                ed.apply();

                Intent ii = new Intent(ShowUserActivity.this, LoginActivity.class);
                startActivity(ii);
                finish();
            }
        });
    }
}