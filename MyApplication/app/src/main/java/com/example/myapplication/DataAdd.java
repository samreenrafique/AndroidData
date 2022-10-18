package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataAdd extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_add);
        ed1 = (EditText) findViewById(R.id.username);
        ed2 = (EditText) findViewById(R.id.userpswd);
        ed3 = (EditText) findViewById(R.id.useremail);
        ed4 = (EditText) findViewById(R.id.usercountry);
        Button btn = (Button) findViewById(R.id.button);

        FirebaseApp.initializeApp(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ed1.getText().toString();
                String pswd = ed2.getText().toString();
                String email = ed3.getText().toString();
                String country = ed4.getText().toString();

                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference ref = db.getReference("User");

                UserInfo user = new UserInfo(name,email,pswd,country);
                ref.child(country).push().setValue(user);
                Intent i = new Intent(DataAdd.this,DataShowRecyclerView.class);
                startActivity(i);
            }
        });
    }
}