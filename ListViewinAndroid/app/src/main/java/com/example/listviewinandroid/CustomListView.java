package com.example.listviewinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CustomListView extends AppCompatActivity {
    ListView myls;
    String[] name = {"Yousuf","Islah","Usman","Yousuf","Hamza","Hassan","Rohan"};
    String[] msg = {"lalalalala","lalalalalaLALALALALAL","lalalalala","lalalalala","lalalalala","lalalalala","lalalalala"};
    Integer[] userimage = {R.drawable.cat,R.drawable.fgf,R.drawable.fgg,R.drawable.test,R.drawable.daffy,R.drawable.tweety,R.drawable.yosemite};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        myls = (ListView) findViewById(R.id.mylist);


    }
}