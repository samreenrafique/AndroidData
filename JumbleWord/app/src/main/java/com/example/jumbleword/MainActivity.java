package com.example.jumbleword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView q,c,r,t,h;
    EditText et;
    Button b,rs;

    int no=1;
    int ind=0;
    int ind1=0;
    int mark=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<String>state= new ArrayList<String>(5);
        state.add("DELHI");
        state.add("PATNA");
        state.add("MUMBAI");
        state.add("KOLKATA");
        state.add("LUCKNOW");

        q=(TextView) findViewById(R.id.textView15);
        c=(TextView) findViewById(R.id.textView16);
        r=(TextView) findViewById(R.id.textView18);
        t=(TextView) findViewById(R.id.textView19);
        h=(TextView) findViewById(R.id.textView17);
        et=(EditText) findViewById(R.id.editText7);
        et.setFilters(new InputFilter[]{new InputFilter.AllCaps()
        });
        b=(Button) findViewById(R.id.button5);
        rs=(Button) findViewById(R.id.button6);

        String input=state.get(ind);
        random_qrs(input);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ind<4){
                    ind++;
                }

                String input=state.get(ind);
                random_qrs(input);

                String input1=state.get(ind1);
                String answer= et.getText().toString();

                if (answer.equals(input1)){

                    Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                    mark ++;
                    et.setText("");
                }
                else{
                    Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    et.setText("");
                }

                if (ind<5){
                    ind1++;
                }
                switch (v.getId()){


                    case R.id.button5:


                        if (no<=5) {
                            no++;

                        }
                        else {

                        }

                        if (no==5){
                            b.setText("SUBMIT");
                        }
                        if (no==6){
                            b.setText("RESULT");
                        }
                        c.setText(no+"/5");
                        if (b.getText().toString().equals("RESULT")){

                            q.setVisibility(View.INVISIBLE);
                            et.setVisibility(View.INVISIBLE);
                            b.setVisibility(View.INVISIBLE);
                            h.setVisibility(View.INVISIBLE);
                            c.setVisibility(View.INVISIBLE);
                            r.setVisibility(View.VISIBLE);
                            t.setVisibility(View.VISIBLE);
                            rs.setVisibility(View.VISIBLE);
                            r.setText("Your Marks is "+mark);
                            rs.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent= new Intent(MainActivity.this,MainActivity.class);
                                    startActivity(intent);
                                }
                            });

                        }
                        break;

                }

            }
        });

    }
    public void random_qrs(String input)
    {
        List<Character> characters= new ArrayList<Character>();
        for (char c:input.toCharArray())
        {
            characters.add(c);
        }
        StringBuilder output=new StringBuilder(input.length());
        while (characters.size()!=0)
        {
            int randPicker=(int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
        String ques=output.toString();
        q.setText(""+ques);
    }
}