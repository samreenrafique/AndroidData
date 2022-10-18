package com.example.listviewinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView l1;
    String[] humarifruitskiarray = {"Apple","Mango","Banana","Orange"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l1 = (ListView) findViewById(R.id.humaralistview);
      //  humarifruitskiarray = getResources().getStringArray(R.array.fruits);
        ArrayAdapter<String> plug = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,humarifruitskiarray);
        l1.setAdapter(plug);
        l1.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String itemclicked = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getApplicationContext() ,"Fruits: " + itemclicked, Toast.LENGTH_SHORT).show();

    }
}