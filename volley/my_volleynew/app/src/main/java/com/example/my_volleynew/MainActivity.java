package com.example.my_volleynew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText txtemail,txtpass;
    Button btn;
    private RequestQueue rq;
    private StringRequest request;
    static  final  String url="http://10.0.2.2/user_control.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtemail = (EditText)findViewById(R.id.txtemail);
        txtpass = (EditText) findViewById(R.id.txtpass);
        btn = (Button) findViewById(R.id.button);

        rq= Volley.newRequestQueue(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try
                        {
                            JSONObject jsonObject=new JSONObject(response);
                            if(jsonObject.names().get(0).equals("success"))
                            {
//                                SharedPreferences sharedPreferences=getSharedPreferences("Mydata", Context.MODE_PRIVATE);
//                                SharedPreferences.Editor editor=sharedPreferences.edit();
//                                editor.putString("name",txtemail.getText().toString());
//
//                                editor.commit();

                                Toast.makeText(getApplicationContext(),"SUCCESS"+jsonObject.getString("success"),Toast.LENGTH_LONG);

                                startActivity(new Intent(getApplicationContext(),donner_dashboard.class));


                            }
                            else
                            {

                                Toast.makeText(getApplicationContext(),"ERROR"+jsonObject.getString("error"),Toast.LENGTH_LONG);
                            }   }

                        catch (JSONException ex)
                        {
                            ex.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String,String> hashmap=new HashMap<String, String>();
                        hashmap.put("email",txtemail.getText().toString());
                        hashmap.put("password",txtpass.getText().toString());
                        return hashmap;
                    }
                };
                rq.add(request);

            }
        });

    }
}

