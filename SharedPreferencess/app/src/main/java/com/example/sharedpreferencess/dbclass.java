package com.example.sharedpreferencess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbclass extends SQLiteOpenHelper {

    String dbname = "Registration.db";

    public dbclass(@Nullable Context context) {
        super(context, "Registration.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user (Userid integer primary key autoincrement,username text, useremail text, userpswd text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists user");
    }

    public boolean insertdata(String n, String e ,String p)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues con = new ContentValues();
        con.put("username",n);
        con.put("useremail",e);
        con.put("userpswd",p);

        long res = db.insert("user",null,con);
        if (res == -1)
        {
            return false;
        }
        else{
            return true;
        }
    }

    public boolean loginlogic(String n, String e)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from user where useremail= ? and userpswd = ?", new String[]{n,e});
        if (c.getCount() < 0)
        {
            return false;
        }
        else {
            return true;
        }
    }
}
