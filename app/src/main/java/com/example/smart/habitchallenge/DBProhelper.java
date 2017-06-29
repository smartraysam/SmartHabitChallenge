package com.example.smart.habitchallenge;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SMARTTECHX on 9/14/2016.
 */
public class DBProhelper extends SQLiteOpenHelper {
        //version number to upgrade database version
        //each time if you Add, Edit table, you need to change the
        //version number.
        private static final int DATABASE_VERSION = 4;

        // Database Name
        private static final String DATABASE_NAME = "prog.db";

        public DBProhelper(Context context ) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //All necessary tables you like to create will create here

            String CREATE_TABLE_PROGRESS = "CREATE TABLE " + Progress.TABLE  + "("
                    + Progress.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + Progress.KEY_comment + " TEXT, "
                    + Progress.KEY_dayno + " INTEGER, "
                    + Progress.KEY_state + " INTEGER )";

            db.execSQL(CREATE_TABLE_PROGRESS);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Drop older table if existed, all data will be gone!!!
            db.execSQL("DROP TABLE IF EXISTS " + Progress.TABLE);

            // Create tables again
            onCreate(db);

        }

}


