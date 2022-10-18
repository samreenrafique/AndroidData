package com.example.dbconnectionusingmysql;

import android.content.Context;
import android.os.AsyncTask;

import androidx.loader.content.AsyncTaskLoader;

import java.net.MalformedURLException;
import java.net.URL;

public class DbFile extends AsyncTask<String,String,String> {
    Context c;

    DbFile(Context ctx)
    {
        this.c = ctx;
    }
    @Override
    protected String doInBackground(String... strings) {
        String type = strings[0] ;
        String name = strings[1] ;
        String password = strings[2] ;
        String email = strings[3] ;
        String regUrl = "10.0.2.2/AndroidMysQ/Login.php";

        if (type.equals(("reg")))
        {
            try {
                URL url = new URL(regUrl);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
