package com.example.androidpanin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class StartScreenActivity extends AppCompatActivity {

    private Spinner mTaskSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        initViews();




    }

    private void initViews() {
        mTaskSpinner = findViewById(R.id.taskSpinner);
        initSpinnerTasks();
    }

    private void initSpinnerTasks() {
        ArrayAdapter<CharSequence> adapterTasks = ArrayAdapter.createFromResource(this, R.array.tasks, android.R.layout.simple_spinner_item);
        adapterTasks.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mTaskSpinner.setAdapter(adapterTasks);

        mTaskSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] taska = getResources().getStringArray(R.array.tasks);
                switch (taska[i]) {
                    case "Выберите значение":

                        break;
                    case "Задача 1.2.1: Универсальная форма ввода":
                        proceedTo121(view);
                        break;
                    case "Задача 1.2.2: Бесконечный переход между экранами":
                        proceedTo122(view);
                        break;
                    case "Задача 2.1.1: Взаимоисключающие CheckBox":
                        proceedTo211(view);
                        break;
                    case "Задача 2.1.2: Spinner «Страны-города-улицы»":
                        proceedTo212(view);
                        break;
                    case "Задача 2.1.3: CalendarView «Сроки задачи»":
                        proceedTo213(view);
                        break;
                    case "Задача 2.2.1: Записная книжка в SharedPreferences":
                        proceedTo221(view);
                        break;
                    case "Задача 2.2.2: AppBar приложения":
                        proceedTo222(view);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void proceedTo121(View view) {
        Intent intent = new Intent(this, T_121.class);
        startActivity(intent);
    }

    public void proceedTo122(View view) {
        Intent intent = new Intent(this, T_122.class);
        startActivity(intent);
    }

    public void proceedTo211(View view) {
        Intent intent = new Intent(this, T_211.class);
        startActivity(intent);
    }

    public void proceedTo212(View view) {
        Intent intent = new Intent(this, T_212.class);
        startActivity(intent);
    }

    public void proceedTo213(View view) {
        Intent intent = new Intent(this, T_213.class);
        startActivity(intent);
    }

    public void proceedTo221(View view) {
        Intent intent = new Intent(this, T_221.class);
        startActivity(intent);
    }

    public void proceedTo222(View view) {
        Intent intent = new Intent(this, T_222.class);
        startActivity(intent);
    }

}
