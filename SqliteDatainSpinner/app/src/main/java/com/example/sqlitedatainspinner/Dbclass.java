package com.example.sqlitedatainspinner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Dbclass extends SQLiteOpenHelper {
    String dbname = "shopping.db";

    public Dbclass(@Nullable Context context) {
        super(context, "shopping.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table category (id integer primary key, catname text)");
        db.execSQL("create table product (id integer primary key, proname text, proprice text, procategory integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists category");
        db.execSQL("drop table if exists product");
    }

    public void categoryinsert(String catname)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("catname",catname);
        db.insert("category",null,c);
    }

    public void productinsert(String proname, String proprice, int catname)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("proprice",catname);
        c.put("proname",proname);
        c.put("procategory",proprice);
        db.insert("product",null,c);
    }

    public List<String> getcategory(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from category",null);
        List<String> record = new ArrayList<>();
        while(c.moveToNext())
        {
            record.add(c.getString(1));
        }
        return record;
    }
}
