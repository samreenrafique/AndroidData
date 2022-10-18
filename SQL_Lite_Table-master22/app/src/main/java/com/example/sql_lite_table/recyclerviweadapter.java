package com.example.sql_lite_table;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerviweadapter extends RecyclerView.Adapter<recyclerviweadapter.cardkadatauthao> {
    ArrayList<Registrationdata> regdata;

    public recyclerviweadapter(ArrayList<Registrationdata> regdata) {
        this.regdata = regdata;
    }

    @NonNull
    @Override
    public cardkadatauthao onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.carddemo,parent,false);
       return new cardkadatauthao(v);
    }

    @Override
    public void onBindViewHolder(@NonNull cardkadatauthao holder, int position) {
            holder.t1.setText(regdata.get(position).getId());
            holder.t2.setText(regdata.get(position).getUsername());
            holder.t3.setText(regdata.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return regdata.size();
    }

    class cardkadatauthao extends RecyclerView.ViewHolder{
        TextView t1,t2,t3;
        public cardkadatauthao(@NonNull View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.cardid);
            t2 = (TextView) itemView.findViewById(R.id.cardname);
            t3 = (TextView) itemView.findViewById(R.id.cardemail);
        }
    }
}
