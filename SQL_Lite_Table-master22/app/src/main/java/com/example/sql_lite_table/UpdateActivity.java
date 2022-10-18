package com.example.sql_lite_table;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        ed1 = (EditText) findViewById(R.id.username2);
        ed2 = (EditText) findViewById(R.id.email2);
        ed3 = (EditText) findViewById(R.id.pswd2);
        ed4 = (EditText) findViewById(R.id.cid);

        Intent rcv = getIntent();
        String uid = rcv.getStringExtra("id");
        String uname = rcv.getStringExtra("name");
        String uemail = rcv.getStringExtra("Email");
        String upswd = rcv.getStringExtra("pswfd");

        ed1.setText(uname);
        ed2.setText(uemail);
        ed3.setText(upswd);
        ed4.setText(uid);

        db = new DbHelper(this);
    }

    public void updatelogic(View v){
        String i = ed4.getText().toString();
        String n = ed1.getText().toString();
        String e = ed2.getText().toString();
        String p = ed3.getText().toString();

        boolean result =   db.updaterecord(i,n,e,p);
        if (result == true)
        {
            Toast.makeText(this, "Record Updated", Toast.LENGTH_SHORT).show();
            Intent iii = new Intent(this, MainActivity2.class);
            startActivity(iii);
            finish();
        }
        else{
            Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
        }
    }
}