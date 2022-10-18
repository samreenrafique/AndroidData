package com.example.radiobuttonvalue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Condition extends AppCompatActivity {

    EditText username, password;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condition);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btn1 = (Button) findViewById(R.id.btn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString();
                String pass = password.getText().toString();
                if (uname.equals("Admin") && pass.equals("123"))
                {
                    Toast.makeText(Condition.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Condition.this,Welcome.class);
                    i.putExtra("passdata",uname);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(Condition.this, "Login Not Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
