package com.example.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        ed1 = findViewById(R.id.ued1);
        ed2 = findViewById(R.id.ued2);

        b = findViewById(R.id.ubt1);
        Intent ii = getIntent();

        ed1.setText(ii.getStringExtra("UserNAme").toString());
        ed2.setText(ii.getStringExtra("UserEmail").toString());
        int id = Integer.parseInt(ii.getStringExtra("UserID").toString());

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ed1.getText().toString();
                String email = ed2.getText().toString();

                DbFile db = new DbFile(UpdateActivity.this);
                boolean res = db.Update(name,email,id);
                if (res == true){
                    Toast.makeText(UpdateActivity.this, "Record Updated", Toast.LENGTH_SHORT).show();
                    Intent iii = new Intent(UpdateActivity.this,ShowUserActivity.class);
                    startActivity(iii);
                    finish();
                }
                else{
                    Toast.makeText(UpdateActivity.this, "Record Not Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}