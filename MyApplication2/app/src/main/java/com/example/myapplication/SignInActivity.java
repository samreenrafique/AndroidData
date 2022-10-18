package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
    TextInputLayout ed1,ed2;
    Button btn;
    TextView txt;
    ProgressBar prog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        ed1 = (TextInputLayout) findViewById(R.id.logemailtxt);
        ed2 = (TextInputLayout) findViewById(R.id.logpswdtxt);
        btn = (Button) findViewById(R.id.signinbtn);
        txt = (TextView) findViewById(R.id.textview2);
        prog = (ProgressBar) findViewById(R.id.prog2);

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignInActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = ed1.getEditText().getText().toString();
                String pswd = ed2.getEditText().getText().toString();
                prog.setVisibility(View.VISIBLE);

                FirebaseAuth authenticate = FirebaseAuth.getInstance();
                authenticate.signInWithEmailAndPassword(email,pswd).
                        addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            prog.setVisibility(View.INVISIBLE);
                            Toast.makeText(SignInActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(SignInActivity.this,WelcomeActivity.class);
                            i.putExtra("Useremail",authenticate.getCurrentUser().getEmail());
                            startActivity(i);
                        }
                        else{
                            prog.setVisibility(View.INVISIBLE);
                            Toast.makeText(SignInActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                            ed1.getEditText().setText("");
                            ed2.getEditText().setText("");
                        }
                    }
                });

            }
        });
    }
}