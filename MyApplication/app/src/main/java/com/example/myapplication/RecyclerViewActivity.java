package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView rv;
    ArrayList<user> arralist;
    dbclass db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        rv = (RecyclerView) findViewById(R.id.myrecycle);
        rv.setLayoutManager(new LinearLayoutManager(this));
        db = new dbclass(this);
        Cursor c = db.fetchdata();
        arralist = new ArrayList<>();
        while(c.moveToNext())
        {
            String id = c.getString(0);
            String name = c.getString(1);
            Log.d("Id",id);
            arralist.add(new user(id,name));

        }
        myadapter adpt = new myadapter(arralist);
        rv.setAdapter(adpt);
    }
}