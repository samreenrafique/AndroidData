package com.example.gridlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Main3Activity extends AppCompatActivity {

    ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ls = (ListView) findViewById(R.id.mylist);
        String[] name = {"Product One","Product Two","Product Three","Product Four","Product Five"};
        String[] desc = {"Product One Description","Product Two Description","Product Three Description","Product Four Description","Product Five Description"};
        Integer[] imagename = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.f};
        customlistview c = new customlistview(Main3Activity.this,name,desc,imagename);
        ls.setAdapter(c);
    }
}
