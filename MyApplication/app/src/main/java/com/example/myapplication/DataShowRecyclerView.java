package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataShowRecyclerView extends AppCompatActivity {
    RecyclerView cycle;
    HumaraAdapter adpt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_show_recycler_view);

        cycle = (RecyclerView) findViewById(R.id.recycle);
        cycle.setLayoutManager(new LinearLayoutManager(this));

        try {
            FirebaseApp.initializeApp(this);
            FirebaseDatabase db = FirebaseDatabase.getInstance();
            DatabaseReference ref = db.getReference().child("User").child("Iran");

            FirebaseRecyclerOptions<UserInfo> obj = new FirebaseRecyclerOptions.Builder<UserInfo>().setQuery(ref,UserInfo.class).build();
            adpt = new HumaraAdapter(obj);
            cycle.setAdapter(adpt);
        }
        catch(Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        adpt.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adpt.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchbox,menu);
        MenuItem icon = menu.findItem(R.id.searchbox);
        SearchView sea = (SearchView) icon.getActionView();

        sea.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference ref = db.getReference().child("User").child("Iran");

                FirebaseRecyclerOptions<UserInfo> obj = new FirebaseRecyclerOptions.Builder<UserInfo>().setQuery(ref,UserInfo.class).build();
                adpt = new HumaraAdapter(obj);
                adpt.startListening();
                cycle.setAdapter(adpt);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference ref = db.getReference().child("User").child("Iran");

                FirebaseRecyclerOptions<UserInfo> obj = new FirebaseRecyclerOptions.Builder<UserInfo>().setQuery(ref,UserInfo.class).build();
                adpt = new HumaraAdapter(obj);
                adpt.startListening();
                cycle.setAdapter(adpt);
                return true;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }
}