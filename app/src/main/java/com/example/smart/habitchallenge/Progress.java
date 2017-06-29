package com.example.smart.habitchallenge;

/**
 * Created by SMARTTECHX on 9/14/2016.
 */
public class Progress {
    public static final String TABLE = "Progress";

    // Labels Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_comment = "comment";
    public static final String KEY_dayno = "dayno";
    public static final String KEY_state = "state";

    // property help us to keep data
    public int progress_ID;
    public String comment;
    public int dayno;
    public int state;
}
