package com.example.registrationwithfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity {
    TextInputLayout ed1,ed2;
    Button btn;
    ProgressBar pro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (TextInputLayout) findViewById(R.id.ed1);
        ed2 = (TextInputLayout) findViewById(R.id.ed2);
        btn = (Button) findViewById(R.id.btn);
        pro = (ProgressBar) findViewById(R.id.prog);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pro.setVisibility(View.VISIBLE);
                String email = ed1.getEditText().getText().toString().trim();
                String password = ed2.getEditText().getText().toString();
                FirebaseAuth dbauth = FirebaseAuth.getInstance();

                dbauth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        pro.setVisibility(View.INVISIBLE);
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                pro.setVisibility(View.INVISIBLE);
                                Toast.makeText(MainActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                            }
                    }
                });

            }
        });

    }
}