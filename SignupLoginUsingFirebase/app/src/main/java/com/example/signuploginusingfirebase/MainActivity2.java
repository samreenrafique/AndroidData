package com.example.signuploginusingfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {
    TextInputLayout ed1,ed2,ed3;
    Button btn,btn2;
    FirebaseAuth auth;
    ProgressBar prog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ed2 = (TextInputLayout) findViewById(R.id.logemail);
        ed3 = (TextInputLayout) findViewById(R.id.logpswd);
        btn = (Button) findViewById(R.id.logintbn);
        btn2 = (Button) findViewById(R.id.regbtn);
        prog = (ProgressBar) findViewById(R.id.progress);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this,MainActivity.class);
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
                auth.signInWithEmailAndPassword(email,pswd).addOnCompleteListener(MainActivity2.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            prog.setVisibility(View.INVISIBLE);
                            Intent i = new Intent(MainActivity2.this,Dashboard.class);
                            i.putExtra("Email",auth.getCurrentUser().getEmail());
                            i.putExtra("Id",auth.getCurrentUser().getUid());
                            startActivity(i);
                        }
                        else{
                            prog.setVisibility(View.INVISIBLE);
                            ed1.getEditText().setText("");
                            ed2.getEditText().setText("");
                            Toast.makeText(MainActivity2.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}