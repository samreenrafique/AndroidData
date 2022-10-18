package com.example.signuploginwithsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText ed2,ed3;
    Button btn;
    DbFile db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed2 = (EditText) findViewById(R.id.useremail);
        ed3 = (EditText) findViewById(R.id.userpswd);
        btn = (Button) findViewById(R.id.button);
        db = new DbFile(this);
        Intent i = getIntent();
        final String uname = i.getStringExtra("username");
        
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ed2.getText().toString();
                String pswd = ed3.getText().toString();

                if (email.length() != 0 && pswd.length() !=0) {
                    boolean result = db.LoginLogic(email,pswd);
                    if (result == true)
                    {
                        Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent i =new Intent(Login.this,WelcomePAge.class);
                        i.putExtra("username",uname);
                        startActivity(i);
                        finish();
                    }
                }
                else if (email.length() == 0)
                {
                    ed2.requestFocus();
                    ed2.setError("Required",null);
                }
                else if(pswd.length() == 0){
                    ed3.requestFocus();
                    ed3.setError("Required");
                }
                }


        });
    }
    public void login2 (View view)
    {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
