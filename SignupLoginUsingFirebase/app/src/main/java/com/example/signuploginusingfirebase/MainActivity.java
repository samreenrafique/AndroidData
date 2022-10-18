package com.example.signuploginusingfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class MainActivity extends AppCompatActivity {
    TextInputLayout ed1,ed2,ed3;
    Button btn,bt;
    FirebaseAuth auth;
    ProgressBar prog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed2 = (TextInputLayout) findViewById(R.id.ed2);
        ed3 = (TextInputLayout) findViewById(R.id.ed3);
        btn = (Button) findViewById(R.id.btn);
        bt = (Button) findViewById(R.id.logbtn);
        prog = (ProgressBar) findViewById(R.id.progress);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = ed2.getEditText().getText().toString().trim();
                String pswd = ed3.getEditText().getText().toString();
                prog.setVisibility(View.VISIBLE);
                auth = FirebaseAuth.getInstance();
                auth.createUserWithEmailAndPassword(email,pswd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                             if (task.isSuccessful()){
                                 prog.setVisibility(View.INVISIBLE);
                                 Toast.makeText(MainActivity.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                             }
                             else{
                                 prog.setVisibility(View.INVISIBLE);
                                 Log.d("Error Msg",task.getException().toString());
                                 Toast.makeText(MainActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                             }
                    }
                });
            }
        });
    }
}