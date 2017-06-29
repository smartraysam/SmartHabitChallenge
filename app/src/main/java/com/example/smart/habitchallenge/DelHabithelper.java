package com.example.smart.habitchallenge;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SMARTTECHX on 9/12/2016.
 */
public class DelHabithelper extends SQLiteOpenHelper {
        //version number to upgrade database version
        //each time if you Add, Edit table, you need to change the
        //version number.
        private static final int DATABASE_VERSION = 4;

        // Database Name
        private static final String DATABASE_NAME = "crudel.db";

        public DelHabithelper (Context context ) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //All necessary tables you like to create will create here

            String CREATE_TABLE_HABIT = "CREATE TABLE " + Habit.TABLE  + "("
                    + Habit.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + Habit.KEY_delname + " TEXT)";

            db.execSQL(CREATE_TABLE_HABIT);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Drop older table if existed, all data will be gone!!!
            db.execSQL("DROP TABLE IF EXISTS " + Habit.TABLE);

            // Create tables again
            onCreate(db);

        }
}
