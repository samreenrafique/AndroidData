package com.example.myapplication;

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

public class prototype extends BaseAdapter {
    Context c;
    ArrayList<user> userlist;
    LayoutInflater lay;

    public prototype(Context c, ArrayList<user> arr) {
        this.c = c;
        this.userlist = arr;
        lay = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return userlist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = lay.inflate(R.layout.tablelayout,null,true);
        TextView id = (TextView) convertView.findViewById(R.id.tb_id);
        TextView name = (TextView) convertView.findViewById(R.id.tb_name);

        user u = userlist.get(position);
        id.setText(u.getId());
        name.setText(u.getName());

        Button del = convertView.findViewById(R.id.delbtn);
        del.setTag(position);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dbclass db = new dbclass(c);
               boolean res = db.delete(u.getId());
               if (res == true)
               {
                   int i = (int) v.getTag();
                   userlist.remove(i);
                   notifyDataSetChanged();
                   Toast.makeText(c, "Data Deleted", Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(c, "Something Went Wrong", Toast.LENGTH_SHORT).show();
               }
            }
        });
        Button update = (Button) convertView.findViewById(R.id.updbtn);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(c,UpdateActivity.class);
                i.putExtra("Id",u.getId());
                i.putExtra("Name",u.getName());
                c.startActivity(i);

            }
        });
        return convertView;
    }
}
