package com.example.smart.habitchallenge;

/**
 * Created by SMARTTECHX on 9/14/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
public class ProgressRep {
    private DBProhelper dbProhelper;

    public ProgressRep(Context context) {
        dbProhelper = new DBProhelper(context);
    }

    public int insert(Progress progress) {

        //Open connection to write data
        SQLiteDatabase db = dbProhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Progress.KEY_state, progress.state);
        values.put(Progress.KEY_dayno,progress.dayno);
        values.put(Progress.KEY_comment, progress.comment);


        // Inserting Row
        long progress_Id = db.insert(Progress.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) progress_Id;
    }

    public void delete(int progress_Id) {

        SQLiteDatabase db = dbProhelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(Progress.TABLE, Progress.KEY_ID + "= ?", new String[] { String.valueOf(progress_Id) });
        db.close(); // Closing database connection
    }

    public void update(Progress progress) {

        SQLiteDatabase db = dbProhelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Progress.KEY_state, progress.state);
        values.put(Progress.KEY_dayno,progress.dayno);
        values.put(Progress.KEY_comment, progress.comment);

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(Progress.TABLE, values, Progress.KEY_ID + "= ?", new String[] { String.valueOf(progress.progress_ID) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>>  getStudentList() {
        //Open connection to read only
        SQLiteDatabase db = dbProhelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Progress.KEY_ID + "," +
                Progress.KEY_comment + "," +
                Progress.KEY_state   + "," +
                Progress.KEY_dayno +
                " FROM " + Progress.TABLE;

        //Progress progress = new Progress();
        ArrayList<HashMap<String, String>> studentList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> progress = new HashMap<String, String>();
                progress.put("dayno", cursor.getString(cursor.getColumnIndex(Progress.KEY_dayno)));
                progress.put("comment", cursor.getString(cursor.getColumnIndex(Progress.KEY_comment)));
                studentList.add(progress);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return studentList;

    }

    public Progress getStudentById(int Id){
        SQLiteDatabase db = dbProhelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Progress.KEY_ID + "," +
                Progress.KEY_comment + "," +
                Progress.KEY_state   + "," +
                Progress.KEY_dayno +
                " FROM " + Progress.TABLE
                + " WHERE " +
                Progress.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        Progress progress = new Progress();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                progress.progress_ID =cursor.getInt(cursor.getColumnIndex(Progress.KEY_ID));
                progress.comment =cursor.getString(cursor.getColumnIndex(Progress.KEY_comment));
                progress.dayno  =cursor.getInt(cursor.getColumnIndex(Progress.KEY_dayno));
                progress.state =cursor.getInt(cursor.getColumnIndex(Progress.KEY_state));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return progress;
    }
}
