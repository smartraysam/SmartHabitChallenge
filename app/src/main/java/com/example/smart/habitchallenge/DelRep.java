package com.example.smart.habitchallenge;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by SMARTTECHX on 9/12/2016.
 */
public class DelRep {
    private DelHabithelper dbHelperhabit;

    public DelRep(Context context) {dbHelperhabit = new DelHabithelper(context);}

    public int insert(Habit habit) {

        //Open connection to write data
        SQLiteDatabase db =dbHelperhabit .getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(Habit.KEY_delname, habit.delname);

        // Inserting Row
        long habit_Id = db.insert(Habit.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) habit_Id;
    }

    public void delete(int habit_Id) {

        SQLiteDatabase db = dbHelperhabit.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(Habit.TABLE, Habit.KEY_ID + "= ?", new String[] { String.valueOf(habit_Id) });
        db.close(); // Closing database connection
    }

    public void update(Habit habit) {

        SQLiteDatabase db = dbHelperhabit.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Habit.KEY_delname, habit.delname);

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(Habit.TABLE, values, Habit.KEY_ID + "= ?", new String[] { String.valueOf(habit.habit_ID) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>> getHabitList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelperhabit.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Habit.KEY_ID + "," +
                Habit.KEY_delname +
                " FROM " + Habit.TABLE;

        //Habit habit = new Habit();
        ArrayList<HashMap<String, String>> habitList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> habit = new HashMap<String, String>();
                habit.put("id", cursor.getString(cursor.getColumnIndex(Habit.KEY_ID)));
                habit.put("delname", cursor.getString(cursor.getColumnIndex(Habit.KEY_delname)));
                habitList.add(habit);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return habitList;

    }

    public Habit getHabitById(int Id){
        SQLiteDatabase db = dbHelperhabit.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Habit.KEY_ID + "," +
                Habit.KEY_delname +
                " FROM " + Habit.TABLE
                + " WHERE " +
                Habit.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        Habit habit = new Habit();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                habit.habit_ID =cursor.getInt(cursor.getColumnIndex(Habit.KEY_ID));
                habit.delname =cursor.getString(cursor.getColumnIndex(Habit.KEY_delname));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return habit;
    }
}
