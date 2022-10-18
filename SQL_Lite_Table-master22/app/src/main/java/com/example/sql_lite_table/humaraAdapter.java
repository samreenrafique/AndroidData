package com.example.sql_lite_table;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class humaraAdapter extends BaseAdapter {
    Context c;
    ArrayList<Registrationdata> record;
    LayoutInflater lay;

    public humaraAdapter(Context c, ArrayList<Registrationdata> record) {
        this.c = c;
        this.record = record;
        lay = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return record.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = lay.inflate(R.layout.mytablerow,null);
        TextView id = (TextView) view.findViewById(R.id.myid);
        TextView name = (TextView) view.findViewById(R.id.myname);
        TextView email = (TextView) view.findViewById(R.id.myemail);
        TextView pswd = (TextView) view.findViewById(R.id.mypswd);

        Registrationdata reg = record.get(i);
        id.setText(reg.getId());
        name.setText(reg.getUsername());
        email.setText(reg.getEmail());
        pswd.setText(reg.getPassword());

        Button dbtn = (Button) view.findViewById(R.id.delbtn);
        dbtn.setTag(i);

        dbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper db = new DbHelper(c);
                boolean res = db.deletebtn(reg.getId());
                if (res== true)
                {
                    int irowno = (int)view.getTag();
                    record.remove(irowno);
                    notifyDataSetChanged();
                    Toast.makeText(c, "Data Deleted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(c, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });


        Button update = (Button) view.findViewById(R.id.updbtn);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(c,UpdateActivity.class);
                ii.putExtra("id",reg.getId());
                ii.putExtra("name",reg.getUsername());
                ii.putExtra("Email",reg.getEmail());
                ii.putExtra("pswfd",reg.getPassword());
                c.startActivity(ii);
            }
        });
        return view;
    }
}
