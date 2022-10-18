package com.example.radiobuttonvalue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner drpdown;
    RadioGroup rd;
    RadioButton rdbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drpdown = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adpt = ArrayAdapter.createFromResource(this,R.array.listitems,android.R.layout.simple_spinner_item);
        adpt.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        drpdown.setAdapter(adpt);
        drpdown.setOnItemSelectedListener(this);

        rd = (RadioGroup) findViewById(R.id.rdgrp);

    }

    public void getRdbtn(View view) {
        int choice = rd.getCheckedRadioButtonId();
        rdbtn = (RadioButton)findViewById(choice);
        Toast.makeText(this, rdbtn.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String val = parent.getItemAtPosition(position).toString();
        Toast.makeText(getApplicationContext(), val, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
