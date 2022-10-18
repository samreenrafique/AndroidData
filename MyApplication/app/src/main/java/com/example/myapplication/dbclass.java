package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbclass extends SQLiteOpenHelper {
    public String dbname = "MyDb.db";

    public dbclass(@Nullable Context context) {
        super(context, "mydb.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user (id integer primary key autoincrement , name text, email text, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }
    public boolean insertdata(String n, String e, String p){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("name",n);
        c.put("email",e);
        c.put("password",p);
        long res = db.insert("user",null,c);
        if (res > 0)
        {
            return true;
        }
        else{
            return false;
        }
    }

    public Cursor fetchdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select id,name from user",null);
        return c;
    }

    public boolean delete(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        long res = db.delete("user","Id = ?",new String[]{String.valueOf(id)});
        if (res == -1 ){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean update(String id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("name",name);
        long upd = db.update("user",c,"Id = ?",new String[]{id});
        if(upd==-1)
        {
            return false;
        }else
        {
            return true;
        }
    }
}
