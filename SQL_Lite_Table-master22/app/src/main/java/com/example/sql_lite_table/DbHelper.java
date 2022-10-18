package com.example.sql_lite_table;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DbHelper extends SQLiteOpenHelper {
    String Databasename = "Registration.db";

    public DbHelper(@Nullable Context context) {
        super(context, "Registration.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Registrationdata(Id integer primary key autoincrement , Username text , Email text , Password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Registrationdata");
    }

    public boolean Insertrecord(String Username, String Email, String Password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues datainserted = new ContentValues();
        datainserted.put("Username", Username);
        datainserted.put("Email", Email);
        datainserted.put("Password", Password);
        long success = db.insert("Registrationdata", null, datainserted);
        if (success > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkemail(String useremail){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor find = db.rawQuery("select * from Registrationdata where Email  = ?",new String[]{useremail});
        if (find.getCount() > 0)
        {
            return true;
        }
        else{
            return false;
        }
    }

    public boolean loginemail (String uemail ,String upswd){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor find = db.rawQuery("select * from Registrationdata where Email  = ? and Password = ?",new String[]{uemail,upswd});
        if (find.getCount() > 0)
        {
            return true;
        }
        else{
            return false;
        }
    }

    public ArrayList<HashMap<String,String>> fetchdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor find = db.rawQuery("select Username,Email from Registrationdata",null);
        // Table
        ArrayList<HashMap<String,String>> records = new ArrayList<>();
        while(find.moveToNext()){
            // Column
            HashMap<String,String> column = new HashMap<>();
            column.put("Name",find.getString(0));
            column.put("Email",find.getString(1));
            records.add(column);
        }
        return records;
    }

    public Cursor fetchdata2()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor find = db.rawQuery("select * from Registrationdata",null);
        return find;
    }

    public boolean deletebtn(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete("Registrationdata","Id = ?",new String[]{id});
        if (result == -1)
        {
            return false;
        }
        else{
            return true;
        }
    }

    public boolean updaterecord(String id, String u, String e, String p)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues datajao = new ContentValues();
        datajao.put("Username",u);
        datajao.put("Email",e);
        datajao.put("Password",p);
        int res = db.update("Registrationdata",datajao,"Id = ?",new String[]{id});
        if (res == -1)
        {
            return false;
        }
        else{
            return true;
        }
    }
}

