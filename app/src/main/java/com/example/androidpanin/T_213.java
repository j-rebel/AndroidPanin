package com.example.androidpanin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.GregorianCalendar;

public class T_213 extends AppCompatActivity {

    private Button mChooseStartDate;
    private Button mChooseEndDate;
    private CalendarView mStartDateCalendar;
    private CalendarView mEndDateCalendar;
    private Button mBtnOK;
    private long mStartDate;
    private String mStartDateTxt;
    private long mEndDate;
    private String mEndDateTxt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_213);
        initViews();

        mChooseStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStartDateCalendar.setVisibility(View.VISIBLE);
                mEndDateCalendar.setVisibility(View.GONE);
            }
        });

        mChooseEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEndDateCalendar.setVisibility(View.VISIBLE);
                mStartDateCalendar.setVisibility(View.GONE);
            }
        });

        mStartDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

            }
        });

        mEndDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

            }
        });

        mStartDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                mStartDateTxt = i+"-"+i1+"-"+i2;
                mChooseStartDate.setText("Дата-время старта задачи: " + mStartDateTxt);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(i, i1, i2);
                mStartDate = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);
            }
        });

        mEndDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                mEndDateTxt = i+"-"+i1+"-"+i2;
                mChooseEndDate.setText("Дата-время окончания задачи: " + mEndDateTxt);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(i, i1, i2);
                mEndDate = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);
            }
        });

        mBtnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStartDate > mEndDate){
                    Toast.makeText(T_213.this, "Ошибка", Toast.LENGTH_LONG).show();
                    mChooseStartDate.setText("Дата-время старта задачи:");
                    mChooseEndDate.setText("Дата-время окончания задачи:");
                } else {
                    Toast.makeText(T_213.this, "старт: " + mStartDateTxt + " окончаниe: " + mEndDateTxt, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void initViews() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        mChooseStartDate = findViewById(R.id.chooseStartDate);
        mChooseEndDate = findViewById(R.id.chooseEndDate);
        mStartDateCalendar = findViewById(R.id.startDateCalendar);
        mEndDateCalendar = findViewById(R.id.endDateCalendar);
        mBtnOK = findViewById(R.id.btnOK);

        mStartDateCalendar.setVisibility(View.GONE);
        mEndDateCalendar.setVisibility(View.GONE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_start:
                Toast.makeText(this, "Переходим к стартовому экрану", Toast.LENGTH_LONG).show();
                proceedToTask(StartScreenActivity.class);
                return true;
            case R.id.action_121:
                Toast.makeText(this, "Переходим к 1.2.1", Toast.LENGTH_LONG).show();
                proceedToTask(T_121.class);
                return true;
            case R.id.action_122:
                Toast.makeText(this, "Переходим к 1.2.2", Toast.LENGTH_LONG).show();
                proceedToTask(T_122.class);
                return true;
            case R.id.action_211:
                Toast.makeText(this, "Переходим к 2.1.1", Toast.LENGTH_LONG).show();
                proceedToTask(T_211.class);
                return true;
            case R.id.action_212:
                Toast.makeText(this, "Переходим к 2.1.2", Toast.LENGTH_LONG).show();
                proceedToTask(T_212.class);
                return true;
            case R.id.action_213:
                Toast.makeText(this, "Переходим к 2.1.3", Toast.LENGTH_LONG).show();
                proceedToTask(T_213.class);
                return true;
            case R.id.action_221:
                Toast.makeText(this, "Переходим к 2.2.1", Toast.LENGTH_LONG).show();
                proceedToTask(T_221.class);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void proceedToTask(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}
