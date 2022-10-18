package com.example.dependentdropdown;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   Spinner sp_province,sp_city;
   TextView txtProvince,txtCity;
   String SelectedProvince,SelectedCity;
    ArrayAdapter<CharSequence> city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp_province = (Spinner) findViewById(R.id.provincespinner);
        sp_city = (Spinner) findViewById(R.id.cityspinner);
        txtProvince = (TextView) findViewById(R.id.txtProvince);
        txtCity = (TextView) findViewById(R.id.txtCity);

        ArrayAdapter<CharSequence> province = ArrayAdapter.createFromResource(this,R.array.province,R.layout.support_simple_spinner_dropdown_item);
        province.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp_province.setAdapter(province);
        sp_province.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SelectedProvince = sp_province.getSelectedItem().toString();
                int parentid = parent.getId();

                if (parentid == R.id.provincespinner)
                {
                    switch (SelectedProvince)
                    {
                        case "Select City":
                            city  = ArrayAdapter.createFromResource(MainActivity.this,R.array.default_city,R.layout.support_simple_spinner_dropdown_item);
                           break;

                        case "Sindh":
                            city  = ArrayAdapter.createFromResource(MainActivity.this,R.array.sindh_city,R.layout.support_simple_spinner_dropdown_item);
                            break;
                        case "Punjab":
                            city  = ArrayAdapter.createFromResource(MainActivity.this,R.array.punjab_city,R.layout.support_simple_spinner_dropdown_item);
                            break;
                    }
                    city.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                    sp_city.setAdapter(city);


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}