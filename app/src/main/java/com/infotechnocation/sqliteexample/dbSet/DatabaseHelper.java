package com.infotechnocation.sqliteexample.dbSet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Prajin Bajracharya on 12/15/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String DB_CONTACT = "db_contact";
    private static int version=1;
    private static final String CREATE_TABLE="CREATE TABLE IF NOT EXISTS tbl_contact" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "contact_name TEXT," +
            "contact_address TEXT," +
            "gender TEXT)";
    public DatabaseHelper(Context context) {
        super(context, DB_CONTACT, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.rawQuery(CREATE_TABLE,null);
        db.execSQL(CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
