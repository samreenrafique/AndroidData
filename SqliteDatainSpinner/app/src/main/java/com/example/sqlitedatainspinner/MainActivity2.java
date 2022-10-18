package com.example.sqlitedatainspinner;

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

public class MainActivity2 extends AppCompatActivity {
    EditText ed1,ed2;
    Button btn;
    Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ed1 = (EditText) findViewById(R.id.proname);
        ed2 = (EditText) findViewById(R.id.proprice);
        sp = (Spinner) findViewById(R.id.procategory);
        btn = (Button) findViewById(R.id.probtn);

        Dbclass db = new Dbclass(MainActivity2.this);
        List<String> rec = db.getcategory();
        ArrayAdapter<String> adpt = new ArrayAdapter<>(MainActivity2.this,R.layout.support_simple_spinner_dropdown_item,rec);
        adpt.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        Log.d("Data",rec.toString());
        sp.setAdapter(adpt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String proname = ed1.getText().toString();
                String proprice = ed2.getText().toString();
                int cat = sp.getSelectedItemPosition();
                db.productinsert(proname,proprice,cat);
                Toast.makeText(MainActivity2.this, "Product Added", Toast.LENGTH_SHORT).show();
            }
        });
    }

}