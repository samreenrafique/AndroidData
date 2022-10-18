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

public class MainActivity extends AppCompatActivity {
    TextInputLayout ed1,ed2;
    Button btn;
    ProgressBar pro;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (TextInputLayout) findViewById(R.id.emailtxt);
        ed2 = (TextInputLayout) findViewById(R.id.pswdtxt);
        btn = (Button) findViewById(R.id.signupbtn);
        pro = (ProgressBar) findViewById(R.id.prog);
        txt = (TextView) findViewById(R.id.textview);

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SignInActivity.class);
                startActivity(i);
                finish();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = ed1.getEditText().getText().toString();
                String pswd = ed2.getEditText().getText().toString();
                pro.setVisibility(View.VISIBLE);

                FirebaseAuth obj = FirebaseAuth.getInstance();
                obj.createUserWithEmailAndPassword(email,pswd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            pro.setVisibility(View.INVISIBLE);
                            Toast.makeText(MainActivity.this, "Register Successfully", Toast.LENGTH_SHORT).show();

                            ed1.getEditText().setText("");
                            ed2.getEditText().setText("");
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