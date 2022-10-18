package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText txt1, txt2;
    dbclass db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        txt1 = (EditText) findViewById(R.id.updname);
        txt2 = (EditText) findViewById(R.id.updid);
        Intent i = getIntent();
        String id = i.getStringExtra("Id");
        String name = i.getStringExtra("Name");

        txt2.setText(id);
        txt1.setText(name);
        db = new dbclass(this);

    }

    public void update(View vi){
        boolean res = db.update(txt2.getText().toString(),txt1.getText().toString());
        if (res == true)
        {
            Toast.makeText(this, "Record Updated", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this,MainActivity2.class);
            startActivity(i);
            finish();
        }
        else{
            Toast.makeText(this, "Something Went Updated", Toast.LENGTH_SHORT).show();

        }
    }
}