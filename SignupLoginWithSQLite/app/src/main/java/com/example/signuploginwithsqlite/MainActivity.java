package com.example.signuploginwithsqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3;
    Button btn,btn2;
    DbFile db;
    AlertDialog.Builder build;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText) findViewById(R.id.username);
        ed2 = (EditText) findViewById(R.id.useremail);
        ed3 = (EditText) findViewById(R.id.userpswd);
        btn = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button3);
        db = new DbFile(this);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String btntxt= btn2.getText().toString();
                String pswd = ed3.getText().toString();
                if (btntxt.equals("Show"))
                {
                    pswd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

        build = new AlertDialog.Builder(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                build.setMessage("Are you Sure you want to add message?").setTitle("Confirmation");
                build.setIcon(R.drawable.ic_add_alert_black_24dp);
                build.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = ed1.getText().toString();
                        String email = ed2.getText().toString();
                        String pswd = ed3.getText().toString();
                        if (name.length() == 0) {
                            ed1.requestFocus();
                            ed1.setError("Name Required");

                        } else if (email.length() == 0) {
                            ed2.requestFocus();
                            ed2.setError("Email Required");
                        } else if (pswd.length() == 0) {
                            ed3.requestFocus();
                            ed3.setError("Password Required");
                        } else if (!name.matches("[a-zA-Z]+")) {
                            ed1.requestFocus();
                            ed1.setError("Alphabets are Allowed");
                        } else {
                            boolean result = db.checkEmail(email);
                            if (result == true) {
                                Toast.makeText(MainActivity.this, "Email Already Exists", Toast.LENGTH_SHORT).show();
                            } else {
                                boolean res = db.InsertData(name, email, pswd);
                                if (res == true) {
                                    Intent i = new Intent(MainActivity.this, Login.class);
                                    i.putExtra("username", name);
                                    startActivity(i);
                                    finish();
                                } else {
                                    Toast.makeText(MainActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }

                });
                build.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog a = build.create();
                a.show();
            }
        });
    }
    public void login (View view)
    {
        Intent i = new Intent(this, Login.class);
        startActivity(i);
        finish();
    }

}
