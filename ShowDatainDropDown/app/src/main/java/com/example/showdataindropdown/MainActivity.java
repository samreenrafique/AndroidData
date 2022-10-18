package com.example.showdataindropdown;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText ed;
    Spinner sp;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed = (EditText) findViewById(R.id.editTextTextPersonName);
        sp = (Spinner) findViewById(R.id.spinner);
        bt = (Button) findViewById(R.id.button);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cat = ed.getText().toString();
                Db db = new Db(MainActivity.this);
                db.insertlogic(cat);
                ed.setText("");
                Toast.makeText(MainActivity.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                loadspinner();
            }
        });
    }
    public void loadspinner(){
        Db db = new Db(MainActivity.this);
        List<String> data = db.getAllLabel();
        Log.d("Data", data.toString());
        ArrayAdapter<String> adpt = new ArrayAdapter<>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,data);
        adpt.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp.setAdapter(adpt);
    }
}