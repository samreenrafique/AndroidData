package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

public class HumaraAdapter extends FirebaseRecyclerAdapter<UserInfo,HumaraAdapter.myviewholder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public HumaraAdapter(@NonNull FirebaseRecyclerOptions<UserInfo> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull UserInfo model) {
       holder.t1.setText(model.getName());
       holder.t2.setText(model.getEmail());
       holder.delbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               AlertDialog.Builder alertbox = new AlertDialog.Builder(view.getContext());
               alertbox.setTitle("Delete");
               alertbox.setMessage("Are you sure you want to delete record?");
               alertbox.setIcon(R.drawable.ic_baseline_restore_from_trash_24);
               alertbox.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       FirebaseDatabase db = FirebaseDatabase.getInstance();
                       DatabaseReference table = db.getReference().child("User").child("Iran");

                       table.child(getRef(position).getKey()).removeValue();
                       Toast.makeText(view.getContext(), "Record Deleted Successfully", Toast.LENGTH_SHORT).show();
                   }
               });

               alertbox.setNegativeButton("No", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {

                   }
               });

               alertbox.show();
           }
       });
       holder.updetbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               DialogPlus humaradialog = DialogPlus.newDialog(view.getContext()).
                       setContentHolder(new ViewHolder(R.layout.updatewindow)).
                       setExpanded(true,1200).create();

               View humaraview = humaradialog.getHolderView();
               EditText usernametx = (EditText) humaraview.findViewById(R.id.updusername);
               EditText useremailtx = (EditText) humaraview.findViewById(R.id.upduseremail);
               EditText userpswdtx = (EditText) humaraview.findViewById(R.id.upduserpswd);
               Button updatebtb = (Button) humaraview.findViewById(R.id.updbutton);
                // Show value in textbox
               usernametx.setText(model.getName());
               useremailtx.setText(model.getEmail());
               userpswdtx.setText(model.getPassword());
                // click on update btn
               updatebtb.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       Map<String,Object> datajao = new HashMap<>();
                       datajao.put("name",usernametx.getText().toString());
                       datajao.put("email",useremailtx.getText().toString());
                       datajao.put("password",userpswdtx.getText().toString());

                       FirebaseDatabase db = FirebaseDatabase.getInstance();
                       DatabaseReference table = db.getReference().child("User").child("Iran");
                       table.child(getRef(position).getKey()).updateChildren(datajao).
                               addOnSuccessListener(new OnSuccessListener<Void>() {
                                   @Override
                                   public void onSuccess(Void unused) {
                                     humaradialog.dismiss();
                                   }
                               });

                   }
               });

               humaradialog.show();
           }
       });

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.showprototype,parent,false);
        return new myviewholder(v);
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView t1,t2;
        ImageView delbtn,updetbtn;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.username);
            t2 = itemView.findViewById(R.id.useremail);
            delbtn = (ImageView) itemView.findViewById(R.id.delete);
            updetbtn = (ImageView) itemView.findViewById(R.id.update);
        }
    }
}
