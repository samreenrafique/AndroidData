package com.example.customlistview;

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

public class cutsomclass extends BaseAdapter {
    Context con;
    Integer[] img;
    String[] names;
    LayoutInflater ii;

    public cutsomclass(Context context, String[] n, Integer[] i) {
      //  super(context, R.layout.customelayout, n);

        this.con = context;
        this.img = i;
        this.names = n;
        ii = LayoutInflater.from(context);

    }

    public View getdata(int position, View view, ViewGroup v) {
        View r = ii.inflate(R.layout.customelayout, null, true);
        TextView TextName = (TextView) r.findViewById(R.id.mytxt);
        ImageView image = (ImageView) r.findViewById(R.id.myimg);

        TextName.setText(names[position]);
        image.setImageResource(img[position]);
        return r;
    }

    @Override
    public int getCount() {
        return 0;
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
        return null;
    }
}


