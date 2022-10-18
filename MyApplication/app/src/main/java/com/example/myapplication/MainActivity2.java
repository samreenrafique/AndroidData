package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {
        EditText ed1,ed2,ed3;
        Spinner sp;
        Button btn;
        String[] country = {"Pakistan","China","Iran","Iraq"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        ed3 = (EditText) findViewById(R.id.ed3);
        sp = (Spinner) findViewById(R.id.spinner);
        btn = (Button) findViewById(R.id.btn1);

        ArrayAdapter<String> adpt = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,country);
        adpt.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        FirebaseApp.initializeApp(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = ed1.getText().toString();
                String uemail = ed2.getText().toString();
                String upswd = ed3.getText().toString();
                String ucountry = sp.getSelectedItem().toString();
                try {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference table = database.getReference("User");
                    UserInfo user = new UserInfo(uname,uemail,upswd,ucountry);
                    table.child(ucountry).push().setValue(user);
                    Toast.makeText(MainActivity2.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity2.this,DataShowRecyclerView.class);
                    startActivity(i);
                }
                catch(Exception e)
                {
                    Toast.makeText(MainActivity2.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}