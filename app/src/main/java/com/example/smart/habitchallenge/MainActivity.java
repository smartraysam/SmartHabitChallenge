package com.example.smart.habitchallenge;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageButton;

import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton mEditHabit, mInsertHabit;
    EditText mHabitText;
    TextView student_Id, habit_Id, mNoTask;
    int _Student_Id = 0, _Habit_Id = 0;
    ListView lv, lv2;
    int day_counter = 1;
    String day_no = "Day";
    int count = 0;
    GridLayout mLayout;
    RelativeLayout mMainLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        habit_Id = (TextView) findViewById(R.id.student_name);
        // mNoTask = (TextView) findViewById(R.id.textView22);
        mEditHabit = (ImageButton) findViewById(R.id.editHabitButton);
        mInsertHabit = (ImageButton) findViewById(R.id.insertButton);
        mHabitText = (EditText) findViewById(R.id.habitText);
        mLayout = (GridLayout) findViewById(R.id.gridLayout);
        mMainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
        mHabitText.setOnClickListener(MainActivity.this);
        mLayout.setOnClickListener(MainActivity.this);
        mMainLayout.setOnClickListener(MainActivity.this);
        mInsertHabit.setOnClickListener(MainActivity.this);
        mEditHabit.setOnClickListener(MainActivity.this);
        lv = (ListView) findViewById(R.id.list_habit);
        lv2 = (ListView) findViewById(R.id.list_complete);
        StudentRepo rep = new StudentRepo(MainActivity.this);
        ArrayList<HashMap<String, String>> studentList = rep.getStudentList();
        ListAdapter adapter = new SimpleAdapter(MainActivity.this, studentList, R.layout.view_student_entry, new String[]{"id", "email", "name"}, new int[]{R.id.student_Id, R.id.day_Num, R.id.student_name});
        lv.setAdapter(adapter);

        DelRep dlrep = new DelRep(MainActivity.this);
        ArrayList<HashMap<String, String>> habitList = dlrep.getHabitList();
        ListAdapter arrayAdapter = new SimpleAdapter(MainActivity.this, habitList, R.layout.view_del_entry, new String[]{"id", "delname"}, new int[]{R.id.habit_Id, R.id.habit_delname});
        lv2.setAdapter(arrayAdapter);
        if (habitList.size() >= 0) {

            lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    DelRep Habrep = new DelRep(MainActivity.this);
                    Habit habit = new Habit();
                    habit_Id = (TextView) view.findViewById(R.id.habit_Id);
                    String habitId = habit_Id.getText().toString();
                    habit = Habrep.getHabitById(Integer.parseInt(habitId));
                    Toast.makeText(MainActivity.this, habit.delname + " had been removed from completed task ", Toast.LENGTH_SHORT).show();
                    Habrep.delete(Integer.parseInt(habitId));
                    Intent restartin = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(restartin);
                    MainActivity.this.finish();

                }
            });

        } else {
            Toast.makeText(MainActivity.this, " No completed task, Insert new habit ", Toast.LENGTH_SHORT).show();

        }

        if (studentList.size() >= 0) {
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    student_Id = (TextView) view.findViewById(R.id.student_Id);
                    String studentId = student_Id.getText().toString();
                    Intent objIndent = new Intent(getApplicationContext(), ProgressActivity.class);
                    objIndent.putExtra("student_Id", Integer.parseInt(studentId));
                    startActivity(objIndent);
                    MainActivity.this.finish();

                }
            });
        }


    }


    @Override
    public void onClick(View v) {
        if (v == mHabitText) {
            mInsertHabit.setEnabled(true);
            mHabitText.setText("");

        } else if (v == mInsertHabit) {
            StudentRepo repo = new StudentRepo(MainActivity.this);
            Student student = new Student();
            student.name = mHabitText.getText().toString();
            String day_Counts = String.valueOf(day_counter);
            student.email = day_no + "  " + day_Counts;
            student.age = day_counter;
            String HabitText = mHabitText.getText().toString().trim();
            student.student_ID = _Student_Id;
            if (_Student_Id == 0 && HabitText != null && HabitText.length() != 0) {
                _Student_Id = repo.insert(student);
                Toast.makeText(MainActivity.this, "New Habit Insert", Toast.LENGTH_LONG).show();
                Intent restartin = new Intent(MainActivity.this, MainActivity.class);
                startActivity(restartin);
                MainActivity.this.finish();

            } else if (HabitText.equals("") || HabitText == null || HabitText.length() == 0) {
                Toast.makeText(MainActivity.this, "Enter habit name", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "Not Insert", Toast.LENGTH_LONG).show();
            }
            ArrayList<HashMap<String, String>> studentList = repo.getStudentList();
            ListAdapter adapter = new SimpleAdapter(MainActivity.this, studentList, R.layout.view_student_entry, new String[]{"id", "email", "name"}, new int[]{R.id.student_Id, R.id.day_Num, R.id.student_name});
            lv.setAdapter(adapter);

        } else if (v == mEditHabit) {

            mHabitText.setText("");

        } else if (v == mLayout) {

            mHabitText.setText("");

        }
        if (v == mMainLayout) {

            mHabitText.setText("");

        }
    }

}

