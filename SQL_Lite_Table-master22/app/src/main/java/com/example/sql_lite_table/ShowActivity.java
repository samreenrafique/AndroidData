package com.example.sql_lite_table;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowActivity extends AppCompatActivity {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        list = (ListView) findViewById(R.id.mylist);
        DbHelper db = new DbHelper(this);
        ArrayList<HashMap<String,String>> datarecvd =  db.fetchdata();
        ListAdapter adapter = new SimpleAdapter(this,datarecvd,R.layout.customlayout,new String[]{"Name","Email"},new int[]{R.id.uname,R.id.uemail});
        list.setAdapter(adapter);
    }
}