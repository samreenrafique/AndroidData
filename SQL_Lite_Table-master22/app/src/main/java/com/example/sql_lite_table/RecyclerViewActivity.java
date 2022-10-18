package com.example.sql_lite_table;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    RecyclerView rec;
    DbHelper db;
    ArrayList<Registrationdata> tablekadata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        rec = (RecyclerView) findViewById(R.id.myrecycle);
        rec.setLayoutManager(new LinearLayoutManager(this));
        db = new DbHelper(this);

        Cursor data = db.fetchdata2();
        tablekadata = new ArrayList<>();

        if (data.getCount() == 0)
        {
            Toast.makeText(this, "No Recound Found", Toast.LENGTH_SHORT).show();
        }
        else{
            while(data.moveToNext())
            {
                String id = data.getString(0);
                String name = data.getString(1);
                String email = data.getString(2);
                tablekadata.add(new Registrationdata(id,name,email));
                Log.d("Name",name);
            }
            recyclerviweadapter adpt = new recyclerviweadapter(tablekadata);
            rec.setAdapter(adpt);

        }
    }
}