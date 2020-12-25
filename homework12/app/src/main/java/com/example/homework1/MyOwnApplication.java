package com.example.homework1;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import org.litepal.LitePal;

public class MyOwnApplication extends Application {
    SQLiteDatabase db =  LitePal .getDatabase();
    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
    }

}
