package com.example.androidusingmysqlusingvolleylibrary;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3;
    RadioGroup rdgroup;
    RadioButton rdbtn;
    Button btn;
    public final String url = "http://10.0.2.2/AndroidMysQ/logic.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText) findViewById(R.id.name);
        ed2 = (EditText) findViewById(R.id.email);
        ed3 = (EditText) findViewById(R.id.password);
        rdgroup = (RadioGroup) findViewById(R.id.radioGroup);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = ed1.getText().toString();
                String e = ed2.getText().toString();
                String p = ed3.getText().toString();
                int check = rdgroup.getCheckedRadioButtonId();
                rdbtn = findViewById(check);
                String gender = rdbtn.getText().toString();
                StringRequest strreq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ed1.setText("");
                        ed2.setText("");
                        ed3.setText("");
                        Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ed1.setText("");
                        ed2.setText("");
                        ed3.setText("");
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams()  {
                        Map<String,String> params = new HashMap<>() ;
                        params.put("uname",n);
                        params.put("uemail",e);
                        params.put("upswd",p);

                        return params;
                    }
                };
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(strreq);
            }
        });
    }
}