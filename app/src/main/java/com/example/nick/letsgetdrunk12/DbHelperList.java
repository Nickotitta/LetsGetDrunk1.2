package com.example.nick.letsgetdrunk12;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelperList extends SQLiteOpenHelper{

    private static final String DB_NAME="EDMTDev";
    private static final int DB_VER = 1;
    public static final String DB_TABLE="Task";
    public static final String DB_COLUM = "TaskName";

    public DbHelperList(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = String.format("CREATE TABLE %s (ID INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL", DB_TABLE, DB_COLUM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
