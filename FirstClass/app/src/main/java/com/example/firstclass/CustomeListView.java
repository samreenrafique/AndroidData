package com.example.firstclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class CustomeListView extends AppCompatActivity {
    ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custome_list_view);
        ls =(ListView)findViewById(R.id.mylist);
        String[] name = {"facebook","Twitter","Snapchat","instagram"};
        Integer[] img = {R.drawable.fb,R.drawable.twitter,R.drawable.snapchat,R.drawable.insta};
        customlist list = new customlist(this,name,img);
        ls.setAdapter(list);
    }
}
