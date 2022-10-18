package com.example.firstclass;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

public class customlist extends ArrayAdapter<String> {
    Activity context;
    String[] uname;
    Integer[] img;
     public customlist(Activity context,String[] uname,Integer[] img) {
        super(context, R.layout.individualdesign,uname);

        this.context = context;
        this.uname= uname;
        this.img = img;
    }
    public View getinfo(int position , View view, ViewGroup parent){
        LayoutInflater infl = context.getLayoutInflater();
        View row = infl.inflate(R.layout.individualdesign,null,true);

        TextView txt = (TextView) row.findViewById(R.id.username);
        ImageView image = (ImageView)row.findViewById(R.id.myimg);

        txt.setText(uname[position]);
        image.setImageResource(img[position]);
        return row;
    }
}
