package com.example.loginsignup;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.underwaliclass>{
    ArrayList<Register> reg;

    public RecyclerViewAdapter(ArrayList<Register> reg) {
        this.reg = reg;
    }

    @NonNull
    @Override
    public underwaliclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  v= LayoutInflater.from(parent.getContext()).inflate(R.layout.prototype,parent,false);
        return new underwaliclass(v);
    }

    @Override
    public void onBindViewHolder(@NonNull underwaliclass holder, int position) {
        holder.t1.setText("" + reg.get(position).getId());
        holder.t2.setText(reg.get(position).getUname());
        holder.t3.setText(reg.get(position).getUEmail());

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(view.getContext(),UpdateActivity.class);
                ii.putExtra("UserID" ,"" + reg.get(position).getId());
                ii.putExtra("UserNAme" ,"" + reg.get(position).getUname());
                ii.putExtra("UserEmail" ,"" + reg.get(position).getUEmail());
                view.getContext().startActivity(ii);
//                ((Activity)view.getContext()).finish();
            }
        });


        holder.delete.setTag(position);
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
                alert.setTitle("Confirmation");
                alert.setMessage("Are you sure you want to Delete this Record?");
                alert.setIcon(R.drawable.ic_baseline_question_mark_24);

                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DbFile db = new DbFile(view.getContext());
                        boolean res =  db.deleteRecord(reg.get(position).getId());
                        if (res == true){
                            reg.remove((int)view.getTag());
                            notifyDataSetChanged();
                            Toast.makeText(view.getContext(), "Record Deleted", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(view.getContext(), "Record Not Deleted", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                alert.setCancelable(false);
                alert.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return reg.size();
    }

    public class underwaliclass extends RecyclerView.ViewHolder{
        TextView t1,t2,t3;
        ImageView update,delete;
        public underwaliclass(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.uid);
            t2 = itemView.findViewById(R.id.uname);
            t3 = itemView.findViewById(R.id.uemail);
            update = itemView.findViewById(R.id.updatebtn);
            delete = itemView.findViewById(R.id.deletebtn);
        }
    }
}
