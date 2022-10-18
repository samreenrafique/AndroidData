package com.example.sql_lite_table;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView listview;
    ArrayList<Registrationdata> datastore = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listview = (ListView) findViewById(R.id.mylist);
        DbHelper db = new DbHelper(this);
        Cursor data =   db.fetchdata2();
        if (data.getCount() == 0)
        {
            Toast.makeText(this, "No Record Found", Toast.LENGTH_SHORT).show();
        }
        else{
            while(data.moveToNext())
            {
                String fetchid = data.getString(0);
                String fetchname = data.getString(1);
                String fetchemail = data.getString(2);
                String fetchpassword = data.getString(3);
                datastore.add(new Registrationdata(fetchid,fetchname,fetchemail,fetchpassword));

            }
            humaraAdapter bakwasadapter = new humaraAdapter(this,datastore);
            listview.setAdapter(bakwasadapter);
        }
    }
}