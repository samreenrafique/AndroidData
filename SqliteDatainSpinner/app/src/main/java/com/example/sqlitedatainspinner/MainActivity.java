package com.example.sqlitedatainspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed = (EditText) findViewById(R.id.catname);
        btn = (Button) findViewById(R.id.catbtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String catname = ed.getText().toString();
                Dbclass db = new Dbclass(MainActivity.this);
                db.categoryinsert(catname);
                Toast.makeText(MainActivity.this, "Category Added", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
                finish();
            }
        });
    }
}