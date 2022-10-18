package com.example.showdataindropdown;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Db extends SQLiteOpenHelper {

    String db = "Register.db";
    public Db(@Nullable Context context) {
        super(context, "Register.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table category (id integer primary key autoincrement, catname text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS category");
    }

    public void insertlogic(String label)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("catname",label);
        db.insert("category",null,c);
    }

    public List<String> getAllLabel()
    {
        List<String> labels = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from category",null);
        while(c.moveToNext())
        {
            labels.add(c.getString(1));
        }
        return labels;
    }
}
