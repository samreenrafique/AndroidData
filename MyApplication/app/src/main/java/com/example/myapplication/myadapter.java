package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myview>{

    ArrayList<user> userdata;

    public myadapter(ArrayList<user> userdata) {
        this.userdata = userdata;
    }

    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout,parent,false);
        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myview holder, int position) {
        holder.uid.setText(userdata.get(position).getId());
        holder.uname.setText(userdata.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return userdata.size();
    }

    class myview extends RecyclerView.ViewHolder{
        TextView uid,uname;
        public myview(@NonNull View itemView) {
            super(itemView);
            uid = (TextView) itemView.findViewById(R.id.userid);
            uname = (TextView) itemView.findViewById(R.id.username);
        }



    }
}
