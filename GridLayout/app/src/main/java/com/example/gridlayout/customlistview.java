package com.example.gridlayout;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class customlistview extends ArrayAdapter<String> {
    Activity c;
    String pronamearray[],prodescarray[];
    Integer imagearray[];



    public customlistview( Activity context,String[] n , String[] d, Integer[] i) {
    super(context,R.layout.layoutfile,n);

        this.c = context;
        this.prodescarray = d;
        this.pronamearray = n;
        this.imagearray = i;


    }
    public View getdata(int i, View view, ViewGroup parent){
       LayoutInflater li = c.getLayoutInflater();
       View v = li.inflate(R.layout.layoutfile,null,true);

        TextView t1 = (TextView) v.findViewById(R.id.proname);
        TextView t2 = (TextView) v.findViewById(R.id.prodesc);
        ImageView t3 = (ImageView) v.findViewById(R.id.img);

        t1.setText(pronamearray[i]);
        t2.setText(prodescarray[i]);
        t3.setImageResource(imagearray[i]);
        return v;
    }


}
