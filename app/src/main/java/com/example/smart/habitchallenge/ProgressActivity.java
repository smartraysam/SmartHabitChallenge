package com.example.smart.habitchallenge;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.StringReader;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class ProgressActivity extends AppCompatActivity implements android.view.View.OnClickListener {

    final Handler handler = new Handler();
    final MediaPlayer mp = new MediaPlayer();
    public String Name = "";
    TextView habitHeading, mStartDate, mEndDate;
    TextView BkClick;
    int _Student_Id = 0, _Habit_Id = 0;
    int RDcount = 1;
    int countcheck;
    RadioButton RD1, RD2, RD3, RD4, RD5, RD6, RD7, RD8, RD9, RD10, RD11, RD12, RD13, RD14, RD15, RD16, RD17, RD18, RD19, RD20, RD21;
    Timer timer;
    TimerTask timerTask;
    int day_counter;
    String day_no = "Day";
    int day_counterNew;
    Button mHabitDelet;
    String com;
    int actCheck;
    int clickCheck;
    String startDate, endDate;
    int day, month, year, min, hour;
    Calendar noDaygt = Calendar.getInstance();
    StudentRepo repo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        if (getIntent().getBooleanExtra("Exit me", false)) {
            finish();
            return; // add this to prevent from doing unnecessary stuffs
        }
        habitHeading = (TextView) findViewById(R.id.habit_delname);
        BkClick = (TextView) findViewById(R.id.Back);
        day_counterNew = noDaygt.get(Calendar.DAY_OF_MONTH);
        mHabitDelet = (Button) findViewById(R.id.delHabitBut);
        mHabitDelet.setOnClickListener(ProgressActivity.this);
        // Toast.makeText(ProgressActivity.this, "first day " + String.valueOf(day_counterNew), Toast.LENGTH_LONG).show();
        mStartDate = (TextView) findViewById(R.id.startDate);
        // mPro_but = (RadioButton) findViewById(R.id.radioButton);
        day = noDaygt.get(Calendar.DAY_OF_MONTH);
        month = noDaygt.get(Calendar.MONTH) + 1;
        year = noDaygt.get(Calendar.YEAR);
        min = noDaygt.get(Calendar.MINUTE);
        hour = noDaygt.get(Calendar.HOUR_OF_DAY);
        startDate = "Date:" + " " + String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year) + "   " + "Time:" + String.valueOf(hour) + ":" + String.valueOf(min);
        mStartDate.setText(startDate);
        Intent intent = getIntent();
        _Student_Id = intent.getIntExtra("student_Id", 0);
        repo = new StudentRepo(this);
        Student student = new Student();
        student = repo.getStudentById(_Student_Id);


        habitHeading.setText(student.name);
        day_counter = student.age;
        //  Toast.makeText(ProgressActivity.this,"day Extract" + String.valueOf(day_counter), Toast.LENGTH_LONG).show();


        actCheck = _Student_Id;


        RD1 = (RadioButton) findViewById(R.id.radioButton22);
        RD2 = (RadioButton) findViewById(R.id.radioButton23);
        RD3 = (RadioButton) findViewById(R.id.radioButton24);
        RD4 = (RadioButton) findViewById(R.id.radioButton25);
        RD5 = (RadioButton) findViewById(R.id.radioButton26);
        RD6 = (RadioButton) findViewById(R.id.radioButton27);
        RD7 = (RadioButton) findViewById(R.id.radioButton28);
        RD8 = (RadioButton) findViewById(R.id.radioButton29);
        RD9 = (RadioButton) findViewById(R.id.radioButton30);
        RD10 = (RadioButton) findViewById(R.id.radioButton31);
        RD11 = (RadioButton) findViewById(R.id.radioButton32);
        RD12 = (RadioButton) findViewById(R.id.radioButton33);
        RD13 = (RadioButton) findViewById(R.id.radioButton34);
        RD14 = (RadioButton) findViewById(R.id.radioButton35);
        RD15 = (RadioButton) findViewById(R.id.radioButton36);
        RD16 = (RadioButton) findViewById(R.id.radioButton37);
        RD17 = (RadioButton) findViewById(R.id.radioButton38);
        RD18 = (RadioButton) findViewById(R.id.radioButton39);
        RD19 = (RadioButton) findViewById(R.id.radioButton40);
        RD20 = (RadioButton) findViewById(R.id.radioButton41);
        RD21 = (RadioButton) findViewById(R.id.radioButton42);

        BkClick.setOnClickListener(this);
        RD1.setOnClickListener(this);
        RD2.setOnClickListener(this);
        RD3.setOnClickListener(this);
        RD4.setOnClickListener(this);
        RD5.setOnClickListener(this);
        RD6.setOnClickListener(this);
        RD7.setOnClickListener(this);
        RD8.setOnClickListener(this);
        RD9.setOnClickListener(this);
        RD10.setOnClickListener(this);
        RD11.setOnClickListener(this);
        RD12.setOnClickListener(this);
        RD13.setOnClickListener(this);
        RD14.setOnClickListener(this);
        RD15.setOnClickListener(this);
        RD16.setOnClickListener(this);
        RD17.setOnClickListener(this);
        RD18.setOnClickListener(this);
        RD19.setOnClickListener(this);
        RD20.setOnClickListener(this);
        RD21.setOnClickListener(this);


        SharedPreferences Gp = getSharedPreferences("setting", MODE_PRIVATE);
        // SharedPreferences Gptxt = getSharedPreferences("setting", MODE_PRIVATE);
        if (actCheck == _Student_Id) {
            RD1.setChecked(Gp.getBoolean(String.valueOf(habitHeading.getText().toString() + "RD1"), false));
            if (RD1.isChecked()) {
                RD1.setText("Welcome!!");
                clickCheck = 1;

            }
            RD2.setChecked(Gp.getBoolean(String.valueOf(habitHeading.getText().toString() + "RD2"), false));
            if (RD2.isChecked()) {
                RD2.setText("Moving On!!");
                clickCheck = 2;
            }
            RD3.setChecked(Gp.getBoolean(String.valueOf(habitHeading.getText().toString() + "RD3"), false));
            if (RD3.isChecked()) {
                RD3.setText("Don't Give Up!!");
                clickCheck = 3;
            }

            RD4.setChecked(Gp.getBoolean(String.valueOf(habitHeading.getText().toString() + "RD4"), false));
            if (RD4.isChecked()) {
                RD4.setText("Getting Better!!");
                clickCheck = 4;
            }
            RD5.setChecked(Gp.getBoolean(String.valueOf(habitHeading.getText().toString() + "RD5"), false));
            if (RD5.isChecked()) {
                RD5.setText("Fight It!!");
                clickCheck = 5;
            }
            RD6.setChecked(Gp.getBoolean(String.valueOf(habitHeading.getText().toString() + "RD6"), false));
            if (RD6.isChecked()) {
                RD6.setText("Soon Be Over!!");
                clickCheck = 6;
            }
            RD7.setChecked(Gp.getBoolean(String.valueOf(habitHeading.getText().toString() + "RD7"), false));
            if (RD7.isChecked()) {
                RD7.setText("You are Doing Great!!");
                clickCheck = 7;
            }
            RD8.setChecked(Gp.getBoolean(String.valueOf(habitHeading.getText().toString() + "RD8"), false));
            if (RD8.isChecked()) {
                RD8.setText("Feeling Better!!");
                clickCheck = 8;
            }
            RD9.setChecked(Gp.getBoolean(String.valueOf(habitHeading.getText().toString() + "RD9"), false));
            if (RD9.isChecked()) {
                RD9.setText("Getting Changed!!");
                clickCheck = 9;
            }
            RD10.setChecked(Gp.getBoolean(String.valueOf(habitHeading.getText().toString() + "RD10"), false));
            if (RD10.isChecked()) {
                RD10.setText("Not too bad!!");
                clickCheck = 10;
            }
            RD11.setChecked(Gp.getBoolean(String.valueOf(habitHeading.getText().toString() + "RD11"), false));
            if (RD11.isChecked()) {
                RD11.setText("Almost through!!");
                clickCheck = 11;
            }
            RD12.setChecked(Gp.getBoolean(String.valueOf(habitHeading.getText().toString() + "RD12"), false));
            if (RD12.isChecked()) {
                RD12.setText("Well Done!!");
                clickCheck = 12;

            }
            RD13.setChecked(Gp.getBoolean(String.valueOf(habitHeading.getText().toString() + "RD13"), false));
            if (RD13.isChecked()) {
                RD13.setText("Moving on!!");
                clickCheck = 13;


            }
            RD14.setChecked(Gp.getBoolean(String.valueOf(habitHeading.getText().toString() + "RD14"), false));
            if (RD14.isChecked()) {
                RD14.setText("Few Days to Go!!");
                clickCheck = 14;
            }
            RD15.setChecked(Gp.getBoolean(String.valueOf(habitHeading.getText().toString() + "RD15"), false));
            if (RD15.isChecked()) {
                RD15.setText("Almost Over!!");
                clickCheck = 15;

            }
            RD16.setChecked(Gp.getBoolean(String.valueOf(habitHeading.getText().toString() + "RD16"), false));
            if (RD16.isChecked()) {
                RD16.setText("Don't relax!!");
                clickCheck = 16;
            }

            RD17.setChecked(Gp.getBoolean(String.valueOf(habitHeading.getText().toString() + "RD17"), false));
            if (RD17.isChecked()) {
                RD17.setText("Not yet over!!");
                clickCheck = 17;

            }
            RD18.setChecked(Gp.getBoolean(String.valueOf(habitHeading.getText().toString() + "RD18"), false));
            if (RD18.isChecked()) {
                RD18.setText("Some Days to go!!");
                clickCheck = 18;

            }

            RD19.setChecked(Gp.getBoolean(String.valueOf(habitHeading.getText().toString() + "RD19"), false));
            if (RD19.isChecked()) {
                RD19.setText("Almost over!!");
                clickCheck = 19;

            }
            RD20.setChecked(Gp.getBoolean(String.valueOf(habitHeading.getText().toString() + "RD20"), false));
            if (RD20.isChecked()) {
                RD20.setText("You can Overcome it!!");
                clickCheck = 20;

            }
            RD21.setChecked(Gp.getBoolean(String.valueOf(habitHeading.getText().toString() + "RD21"), false));
            if (RD21.isChecked()) {
                RD21.setText("CONGRATULATIONS YOU MADE A GREAT CHANGE!!");
                clickCheck = 21;
            }
        }

    }

    public void alertdel() {
        final Intent backHome = new Intent(ProgressActivity.this, MainActivity.class);
        AlertDialog.Builder mDialog = new AlertDialog.Builder(ProgressActivity.this);
        mDialog.setTitle("Alert");
        mDialog.setMessage("Do you want to delete ?");
        mDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                repo.delete(_Student_Id);
                startActivity(backHome);
                ProgressActivity.this.finish();
                Toast.makeText(getApplicationContext(),
                        "Habit deleted!!!", Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),
                        "Habit deleted!!!", Toast.LENGTH_LONG).show();
            }
        });
        mDialog.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = mDialog.create();
        alert.show();
    }


    public void onClick(View view) {
        Intent bthome = new Intent(ProgressActivity.this, MainActivity.class);

        if (view == mHabitDelet) {
            alertdel();

        }
        if (view == findViewById(R.id.Back)) {
            // Intent bthome = new Intent(ProgressActivity.this, MainActivity.class);
            startActivity(bthome);
            ProgressActivity.this.finish();
            Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow", Toast.LENGTH_LONG).show();

        }
        if (view == findViewById(R.id.radioButton22)) {
            if (clickCheck == 0) {
                RD1.setText("Welcome!!");
                Toast.makeText(ProgressActivity.this, RD1.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD1.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD1.getText().toString(), Toast.LENGTH_LONG).show();
                playsound("app-6.mp3");
                countcheck = 1;
                startTimer();
                RDcount = 0;
                startActivity(bthome);
                ProgressActivity.this.finish();
                Toast.makeText(ProgressActivity.this, "You make a good choice", Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, "You make a good choice", Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, "You make a good choice", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow", Toast.LENGTH_LONG).show();
            }

        }
        if (view == findViewById(R.id.radioButton23)) {

            if (RD1.isChecked() && clickCheck != 2) {
                RD2.setText("Moving On!!");
                Toast.makeText(ProgressActivity.this, RD2.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD2.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD2.getText().toString(), Toast.LENGTH_LONG).show();
                playsound("app-6.mp3");
                countcheck = 2;
                startTimer();
                startActivity(bthome);
                ProgressActivity.this.finish();
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow", Toast.LENGTH_LONG).show();
            } else if (clickCheck == 2) {
                RD2.setChecked(true);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            } else {
                RD2.setChecked(false);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            }

        }
        if (view == findViewById(R.id.radioButton24)) {

            if (RD2.isChecked() && clickCheck != 3) {
                RD3.setText("Don't Give Up!!");
                Toast.makeText(ProgressActivity.this, RD3.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD3.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD3.getText().toString(), Toast.LENGTH_LONG).show();
                countcheck = 3;
                playsound("app-6.mp3");
                startTimer();
                startActivity(bthome);
                ProgressActivity.this.finish();
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow", Toast.LENGTH_LONG).show();
            } else if (clickCheck == 3) {
                RD3.setChecked(true);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            } else {
                RD3.setChecked(false);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            }

            //moveTaskToBack(true);
            //android.os.Process.killProcess(android.os.Process.myPid());
            //System.exit(1);
        }
        if (view == findViewById(R.id.radioButton25)) {

            if (RD3.isChecked() && clickCheck != 4) {
                RD4.setText("Getting Better!!");
                Toast.makeText(ProgressActivity.this, RD4.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD4.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD4.getText().toString(), Toast.LENGTH_LONG).show();
                playsound("app-6.mp3");
                countcheck = 4;
                startTimer();
                startActivity(bthome);
                ProgressActivity.this.finish();
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow", Toast.LENGTH_LONG).show();
            } else if (clickCheck == 4) {
                RD4.setChecked(true);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            } else {
                RD4.setChecked(false);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            }
        }

        if (view == findViewById(R.id.radioButton26)) {

            if (RD4.isChecked() && clickCheck != 5) {
                RD5.setText("Fight It!!");
                Toast.makeText(ProgressActivity.this, RD5.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD5.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD5.getText().toString(), Toast.LENGTH_LONG).show();
                playsound("app-6.mp3");
                countcheck = 5;
                startTimer();
                startActivity(bthome);
                ProgressActivity.this.finish();
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow", Toast.LENGTH_LONG).show();
            } else if (clickCheck == 5) {
                RD5.setChecked(true);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            } else {
                RD5.setChecked(false);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            }
        }
        if (view == findViewById(R.id.radioButton27)) {

            if (RD5.isChecked() && clickCheck != 6) {
                RD6.setText("Soon Be Over!!");
                Toast.makeText(ProgressActivity.this, RD6.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD6.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD6.getText().toString(), Toast.LENGTH_LONG).show();
                countcheck = 6;
                startTimer();
                playsound("app-6.mp3");
                RDcount++;
                startActivity(bthome);
                ProgressActivity.this.finish();
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow", Toast.LENGTH_LONG).show();
            } else if (clickCheck == 6) {
                RD6.setChecked(true);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            } else {
                RD6.setChecked(false);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            }

        }
        if (view == findViewById(R.id.radioButton28)) {

            if (RD6.isChecked() && clickCheck != 7) {
                RD7.setText("You are Doing Great!!");
                Toast.makeText(ProgressActivity.this, RD7.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD7.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD7.getText().toString(), Toast.LENGTH_LONG).show();
                playsound("app-6.mp3");
                countcheck = 7;
                startActivity(bthome);
                ProgressActivity.this.finish();
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow", Toast.LENGTH_LONG).show();
            } else if (clickCheck == 7) {
                RD7.setChecked(true);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            } else {
                RD7.setChecked(false);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            }
        }
        if (view == findViewById(R.id.radioButton29)) {

            if (RD7.isChecked() && clickCheck != 8) {
                RD8.setText("Feeling Better!!");
                Toast.makeText(ProgressActivity.this, RD8.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD8.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD8.getText().toString(), Toast.LENGTH_LONG).show();
                playsound("app-6.mp3");
                countcheck = 8;
                startTimer();
                startActivity(bthome);
                ProgressActivity.this.finish();
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow", Toast.LENGTH_LONG).show();
            } else if (clickCheck == 8) {
                RD8.setChecked(true);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            } else {
                RD8.setChecked(false);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            }

        }
        if (view == findViewById(R.id.radioButton30)) {
            if (RD8.isChecked() && clickCheck != 9) {
                RD9.setText("Getting Changed!!");
                Toast.makeText(ProgressActivity.this, RD9.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD9.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD9.getText().toString(), Toast.LENGTH_LONG).show();
                playsound("app-6.mp3");
                countcheck = 9;
                startTimer();
                startActivity(bthome);
                ProgressActivity.this.finish();
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow", Toast.LENGTH_LONG).show();
            } else if (clickCheck == 9) {
                RD9.setChecked(true);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            } else {
                RD9.setChecked(false);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            }
        }
        if (view == findViewById(R.id.radioButton31)) {

            if (RD9.isChecked() && clickCheck != 10) {
                RD10.setText("Not too bad!!");
                Toast.makeText(ProgressActivity.this, RD10.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD10.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD10.getText().toString(), Toast.LENGTH_LONG).show();
                playsound("app-6.mp3");
                countcheck = 10;
                startActivity(bthome);
                ProgressActivity.this.finish();
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow", Toast.LENGTH_LONG).show();
            } else if (clickCheck == 10) {
                RD10.setChecked(true);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            } else {
                RD10.setChecked(false);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            }
        }
        if (view == findViewById(R.id.radioButton32)) {
            if (RD10.isChecked() && clickCheck != 11) {
                RD11.setText("Almost through!!");
                Toast.makeText(ProgressActivity.this, RD11.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD11.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD11.getText().toString(), Toast.LENGTH_LONG).show();
                playsound("app-6.mp3");
                startTimer();
                countcheck = 11;
                startActivity(bthome);
                ProgressActivity.this.finish();
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow", Toast.LENGTH_LONG).show();

            } else if (clickCheck == 11) {
                RD11.setChecked(true);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            } else {
                RD11.setChecked(false);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            }
        }
        if (view == findViewById(R.id.radioButton33)) {

            if (RD11.isChecked() && clickCheck != 12) {
                RD12.setText("Well Done!!");
                Toast.makeText(ProgressActivity.this, RD12.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD12.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD12.getText().toString(), Toast.LENGTH_LONG).show();
                playsound("app-6.mp3");
                startTimer();
                countcheck = 12;
                startActivity(bthome);
                ProgressActivity.this.finish();
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow", Toast.LENGTH_LONG).show();
            } else if (clickCheck == 12) {
                RD12.setChecked(true);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            } else {
                RD12.setChecked(false);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            }
        }
        if (view == findViewById(R.id.radioButton34)) {

            if (RD12.isChecked() && clickCheck != 13) {
                RD13.setText("Moving on!!");
                RD13.setChecked(true);
                Toast.makeText(ProgressActivity.this, RD13.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD13.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD13.getText().toString(), Toast.LENGTH_LONG).show();
                playsound("app-6.mp3");
                startTimer();
                countcheck = 13;
                startActivity(bthome);
                ProgressActivity.this.finish();
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow", Toast.LENGTH_LONG).show();

            } else if (clickCheck == 13) {
                RD13.setChecked(true);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            } else {
                RD13.setChecked(false);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            }
        }
        if (view == findViewById(R.id.radioButton35)) {

            if (RD13.isChecked() && clickCheck != 14) {
                RD14.setText("Few Days to Go!!");
                Toast.makeText(ProgressActivity.this, RD14.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD14.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD14.getText().toString(), Toast.LENGTH_LONG).show();
                playsound("app-6.mp3");
                countcheck = 14;
                startActivity(bthome);
                ProgressActivity.this.finish();
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow", Toast.LENGTH_LONG).show();
            } else if (clickCheck == 14) {
                RD14.setChecked(true);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            } else {
                RD14.setChecked(false);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            }

        }
        if (view == findViewById(R.id.radioButton36)) {
            if (RD14.isChecked() && clickCheck != 15) {
                RD15.setText("Almost Over!!");
                Toast.makeText(ProgressActivity.this, RD15.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD15.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD15.getText().toString(), Toast.LENGTH_LONG).show();
                playsound("app-6.mp3");
                countcheck = 15;
                startTimer();
                startActivity(bthome);
                ProgressActivity.this.finish();
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow", Toast.LENGTH_LONG).show();
            } else if (clickCheck == 15) {
                RD15.setChecked(true);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            } else {
                RD15.setChecked(false);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            }
        }
        if (view == findViewById(R.id.radioButton37)) {
            if (RD15.isChecked() && clickCheck != 16) {
                RD16.setText("Don't relax!!");
                Toast.makeText(ProgressActivity.this, RD16.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD16.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD16.getText().toString(), Toast.LENGTH_LONG).show();
                playsound("app-6.mp3");
                countcheck = 16;
                startActivity(bthome);
                ProgressActivity.this.finish();
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow", Toast.LENGTH_LONG).show();

            } else if (clickCheck == 16) {
                RD16.setChecked(true);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            } else {
                RD16.setChecked(false);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            }

        }
        if (view == findViewById(R.id.radioButton38)) {
            if (RD16.isChecked() && !RD17.isChecked() && clickCheck != 17) {
                RD17.setText("Not yet over!!");
                Toast.makeText(ProgressActivity.this, RD17.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD17.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD17.getText().toString(), Toast.LENGTH_LONG).show();
                playsound("app-6.mp3");
                countcheck = 17;
                startTimer();
                startActivity(bthome);
                ProgressActivity.this.finish();
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow", Toast.LENGTH_LONG).show();

            } else if (clickCheck == 17) {
                RD17.setChecked(true);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            } else {
                RD17.setChecked(false);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            }
        }
        if (view == findViewById(R.id.radioButton39)) {
            if (RD17.isChecked() && clickCheck != 18) {
                RD18.setText("Some Days to go!!");
                Toast.makeText(ProgressActivity.this, RD18.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD18.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD18.getText().toString(), Toast.LENGTH_LONG).show();
                playsound("app-6.mp3");
                countcheck = 18;
                startTimer();
                startActivity(bthome);
                ProgressActivity.this.finish();
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow", Toast.LENGTH_LONG).show();

            } else if (clickCheck == 18) {
                RD18.setChecked(true);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            } else {
                RD18.setChecked(false);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            }
        }
        if (view == findViewById(R.id.radioButton40)) {
            if (RD18.isChecked() && clickCheck != 19) {
                RD19.setText("Almost over!!");
                Toast.makeText(ProgressActivity.this, RD19.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD19.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD19.getText().toString(), Toast.LENGTH_LONG).show();
                playsound("app-29.wav");
                countcheck = 19;
                startTimer();
                startActivity(bthome);
                ProgressActivity.this.finish();
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow", Toast.LENGTH_LONG).show();
            } else if (clickCheck == 19) {
                RD19.setChecked(true);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            } else {
                RD19.setChecked(false);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            }
        }
        if (view == findViewById(R.id.radioButton41)) {
            if (RD19.isChecked() && clickCheck != 20) {
                RD20.setText("You can Overcome it!!");
                Toast.makeText(ProgressActivity.this, RD20.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD20.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD20.getText().toString(), Toast.LENGTH_LONG).show();
                playsound("app-29.wav");
                countcheck = 20;
                startTimer();
                startActivity(bthome);
                ProgressActivity.this.finish();
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow", Toast.LENGTH_LONG).show();
            } else if (clickCheck == 20) {
                RD20.setChecked(true);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            } else {
                RD20.setChecked(false);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            }
        }
        if (view == findViewById(R.id.radioButton42)) {
            if (RD19.isChecked()) {
                RD21.setText("CONGRATULATIONS YOU MAKE A CHANGE!!");
                Toast.makeText(ProgressActivity.this, RD21.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD21.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD21.getText().toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ProgressActivity.this, RD21.getText().toString(), Toast.LENGTH_LONG).show();
                playsound("app-29.wav");
                countcheck = 21;
                startActivity(bthome);
                ProgressActivity.this.finish();
                ProgressActivity.this.finish();
            } else {
                RD21.setChecked(false);
                Toast.makeText(ProgressActivity.this, "Please Remember To Check Tomorrow, click once a day", Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences Gp = getSharedPreferences("setting", MODE_PRIVATE);
        if (actCheck == _Student_Id) {
            //Toast.makeText(ProgressActivity.this, "Change in ", Toast.LENGTH_LONG).show();
            SharedPreferences.Editor e = Gp.edit();
            e.putBoolean(String.valueOf(habitHeading.getText().toString() + "RD1"), RD1.isChecked());
            e.putBoolean(String.valueOf(habitHeading.getText().toString() + "RD2"), RD2.isChecked());
            e.putBoolean(String.valueOf(habitHeading.getText().toString() + "RD3"), RD3.isChecked());
            e.putBoolean(String.valueOf(habitHeading.getText().toString() + "RD4"), RD4.isChecked());
            e.putBoolean(String.valueOf(habitHeading.getText().toString() + "RD5"), RD5.isChecked());
            e.putBoolean(String.valueOf(habitHeading.getText().toString() + "RD6"), RD6.isChecked());
            e.putBoolean(String.valueOf(habitHeading.getText().toString() + "RD7"), RD7.isChecked());
            e.putBoolean(String.valueOf(habitHeading.getText().toString() + "RD8"), RD8.isChecked());
            e.putBoolean(String.valueOf(habitHeading.getText().toString() + "RD9"), RD9.isChecked());
            e.putBoolean(String.valueOf(habitHeading.getText().toString() + "RD10"), RD10.isChecked());
            e.putBoolean(String.valueOf(habitHeading.getText().toString() + "RD11"), RD11.isChecked());
            e.putBoolean(String.valueOf(habitHeading.getText().toString() + "RD12"), RD12.isChecked());
            e.putBoolean(String.valueOf(habitHeading.getText().toString() + "RD13"), RD13.isChecked());
            e.putBoolean(String.valueOf(habitHeading.getText().toString() + "RD14"), RD14.isChecked());
            e.putBoolean(String.valueOf(habitHeading.getText().toString() + "RD15"), RD15.isChecked());
            e.putBoolean(String.valueOf(habitHeading.getText().toString() + "RD16"), RD16.isChecked());
            e.putBoolean(String.valueOf(habitHeading.getText().toString() + "RD17"), RD17.isChecked());
            e.putBoolean(String.valueOf(habitHeading.getText().toString() + "RD18"), RD18.isChecked());
            e.putBoolean(String.valueOf(habitHeading.getText().toString() + "RD19"), RD19.isChecked());
            e.putBoolean(String.valueOf(habitHeading.getText().toString() + "RD20"), RD20.isChecked());
            e.putBoolean(String.valueOf(habitHeading.getText().toString() + "RD21"), RD21.isChecked());
            e.commit();
            // eTxt.commit();


        }

    }


    public void playsound(String soundfile) {

        if (mp.isPlaying()) {
            mp.stop();
        }
        try {
            mp.reset();
            AssetFileDescriptor afd;
            afd = getAssets().openFd(soundfile);
            mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mp.prepare();
            mp.start();

        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void startTimer() {
        //get the current timeStamp
        StudentRepo repo2 = new StudentRepo(ProgressActivity.this);
        Student student = new Student();
        student.student_ID = _Student_Id;
        student = repo2.getStudentById(_Student_Id);
        Name = student.name;
        if (countcheck < 21) {
            day_counter = day_counterNew + 1;
            // Toast.makeText(ProgressActivity.this," New day no " + String.valueOf(day_counter), Toast.LENGTH_LONG).show();
            Student student1 = new Student();
            student1.name = Name;
            student1.student_ID = _Student_Id;
            String day_Counts = String.valueOf(countcheck);
            student.email = day_no + "  " + day_Counts;
            student.age = day_counter;
            repo2.update(student);
            // Toast.makeText(ProgressActivity.this, "Day" + " " + day_Counts + " " + "task completed", Toast.LENGTH_LONG).show();

        } else if (countcheck == 21) {
            DelRep Habrep = new DelRep(ProgressActivity.this);
            Habit habit = new Habit();
            habit.delname = Name;
            habit.habit_ID = _Habit_Id;
            if (habit.delname != null) {
                if (RD1.isChecked() && RD2.isChecked() && RD3.isChecked() && RD4.isChecked() && RD5.isChecked() && RD6.isChecked() && RD7.isChecked() && RD8.isChecked() && RD9.isChecked() && RD10.isChecked() && RD11.isChecked() && RD12.isChecked() && RD13.isChecked() && RD14.isChecked() && RD15.isChecked() && RD16.isChecked() && RD17.isChecked() && RD18.isChecked() && RD19.isChecked() && RD20.isChecked() && RD21.isChecked()) {
                    _Habit_Id = Habrep.insert(habit);
                    Toast.makeText(ProgressActivity.this, "Task" + " " + Name + " " + "Completed", Toast.LENGTH_LONG).show();
                    Toast.makeText(ProgressActivity.this, "Congratulations!! You have successfully finish the task", Toast.LENGTH_LONG).show();
                    Toast.makeText(ProgressActivity.this, " Click On Task In completed  Task to remove ", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ProgressActivity.this, "Task" + " " + Name + " " + "Failed ", Toast.LENGTH_LONG).show();
                    Toast.makeText(ProgressActivity.this, "Reenter Task" + " " + Name + " " + "To Start Again", Toast.LENGTH_LONG).show();

                }
            }
            Intent restartin = new Intent(ProgressActivity.this, MainActivity.class);
            startActivity(restartin);
            ProgressActivity.this.finish();
            day_counter = 1;
            repo2.delete(_Student_Id);
            if (timer != null) {
                timer.cancel();
                timer = null;
            }

        }

    }


}