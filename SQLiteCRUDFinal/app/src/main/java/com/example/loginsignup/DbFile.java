package com.example.loginsignup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbFile extends SQLiteOpenHelper {
    public DbFile(@Nullable Context context) {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table register(id integer primary key autoincrement, name text , email text, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

//    To Save Data in table

    public boolean Registeration(String n, String e, String p){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues datajao = new ContentValues();
        datajao.put("name",n);
        datajao.put("email",e);
        datajao.put("password",p);
        long result = db.insert("register",null,datajao);
        if (result == 0){
            return  false;
        }
        else{
            return true;
        }
    }


    public boolean Login(String e , String p){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from register where email = ? and password = ?",new String[]{e,p});
        if (result.getCount() == 0){
            return false;
        }
        else{
            return true;
        }

    }


    // Fetch Data 2


    public Cursor FetchData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("select * from register",null);
        return data;

    }
    public boolean Update(String n, String e, int i){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues datajao = new ContentValues();
        datajao.put("name",n);
        datajao.put("email",e);
        long result = db.update("register",datajao,"Id = ?",new String[]{String.valueOf(i)});
        if (result == 0){
            return  false;
        }
        else{
            return true;
        }
    }


    public boolean deleteRecord(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        long a =  db.delete("register","Id = ?",new String[]{String.valueOf(id)});
        if (a > 0){
            return true;
        }
        else{
            return false;
        }
    }
    public Cursor FetchUsername(String e , String p){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from register where email = ? and password = ?",new String[]{e,p});
        return result;

    }
}
