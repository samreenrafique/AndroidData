package com.example.signuploginwithsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbFile extends SQLiteOpenHelper {

    public static final String dbname = "register.db";

    public DbFile(Context context) {
        super(context, "register.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(UserId integer PRIMARY KEY AUTOINCREMENT, Username TEXT, Useremail TEXT, Userpswd TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }

    public Boolean InsertData(String uname,String uemail, String upswd)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Username",uname);
        cv.put("Useremail",uemail);
        cv.put("Userpswd",upswd);
        long result = db.insert("user",null,cv);
        if (result == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public Boolean checkEmail(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from user where Useremail = ?", new String[]{email});
        if (c.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
        public Boolean LoginLogic(String email,String pswd)
        {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor c = db.rawQuery("select * from user where Useremail = ? and Userpswd = ?",new String[] {email,pswd});
            if (c.getCount()>0)
            {
                return true;
            }
            else {
                return false;
            }
    }
}
