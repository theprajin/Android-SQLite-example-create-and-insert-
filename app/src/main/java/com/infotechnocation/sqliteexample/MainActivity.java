package com.infotechnocation.sqliteexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.infotechnocation.sqliteexample.dbSet.DBManager;

public class MainActivity extends AppCompatActivity {



    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbManager=DBManager.newInstance(this);

        dbManager.insertContact("ram","ktm","male");
        dbManager.fetchContact();
    }
}
