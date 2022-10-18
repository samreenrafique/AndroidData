package com.example.labelhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ed;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed = (EditText) findViewById(R.id.editText);
        txt = (TextView) findViewById(R.id.textView);

    }
    public void text(View view){
        txt.setText(ed.getText());
    }
    public void increase(View view){
        float recentsize = txt.getTextSize();
        txt.setTextSize(TypedValue.COMPLEX_UNIT_SP,recentsize + 2);
    }
    public void decrease(View view){
        float recentsize = txt.getTextSize();
        txt.setTextSize(TypedValue.COMPLEX_UNIT_SP,recentsize - 2f);
    }
    public void change(View view){
        float recentsize = Float.parseFloat(ed.getText().toString());
        txt.setTextSize(recentsize);
    }
    public void color(View view){
        String recentsize = ed.getText().toString();
        txt.setTextColor(Color.parseColor(recentsize));
    }
    public void backcolor(View view){
        String recentsize = ed.getText().toString();
        txt.setBackgroundColor(Color.parseColor(recentsize));
    }

}
