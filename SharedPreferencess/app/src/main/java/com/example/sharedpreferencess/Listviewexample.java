package com.example.sharedpreferencess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Listviewexample extends AppCompatActivity {

    ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewexample);
        ls = (ListView) findViewById(R.id.mylist);
        ArrayAdapter<CharSequence> adpt = ArrayAdapter.createFromResource(this,R.array.color,R.layout.support_simple_spinner_dropdown_item);
        ls.setAdapter(adpt);
    }
}