package com.infotechnocation.sqliteexample.dbSet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


/**
 * Created by Prajin Bajracharya on 12/15/2016.
 */

public class DBManager {
    private static DBManager DB_MANAGER;
    private Context context;
    private SQLiteDatabase mSqLiteDatabase;


    private DBManager(Context context) {
        DatabaseHelper mDatabaseHelper=new DatabaseHelper(context);
        this.context=context;
        mSqLiteDatabase=mDatabaseHelper.getWritableDatabase();
    }

    public static DBManager newInstance(Context context){
        if(DB_MANAGER==null){
            DB_MANAGER=new DBManager(context);
        }

        return DB_MANAGER;
    }

    public void insertContact(String name,String address,String gender){
        ContentValues cv = new ContentValues();
        cv.put("contact_name",name);
        cv.put("contact_address",address);
        cv.put("gender",gender);
        mSqLiteDatabase.insert("tbl_contact",null,cv);

        /**
        String query="insert into tbl_contact ( contact_name , contact_address , gender ) values ("+ name +" , "+ address +" , "+ gender +" )";
        mSqLiteDatabase.rawQuery(query,null);*/

    }

    public void fetchContact(){
        String query="SELECT * FROM tbl_contact";
        Cursor mCursor = mSqLiteDatabase.rawQuery(query,null);

        while(mCursor.moveToNext()){
            String name = mCursor.getString(mCursor.getColumnIndex("contact_name"));
            String address = mCursor.getString(mCursor.getColumnIndex("contact_address"));
            String gender = mCursor.getString(mCursor.getColumnIndex("gender"));

            Log.e("contact","name= "+name);
            Log.e("contact","address ="+address);
            Log.e("contact","gender"+gender);

        }
    }


}
