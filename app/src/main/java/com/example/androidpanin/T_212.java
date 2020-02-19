package com.example.androidpanin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class T_212 extends AppCompatActivity {

    private Spinner mCountriesSpinner;
    private Spinner mCitiesSpinner;
    private Spinner mHousesSpinner;
    private Button mOkButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_212);
        initViews();
    }

    private void initViews() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        mCountriesSpinner = findViewById(R.id.countriesSpinner);
        mCitiesSpinner = findViewById(R.id.citiesSpinner);
        mHousesSpinner = findViewById(R.id.housesSpinner);
        mOkButton = findViewById(R.id.okButton);
        initSpinnerCountries();
        initHousNumbersSpinner();
        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMsg();
            }
        });
    }

    private void initSpinnerCountries() {
        ArrayAdapter<CharSequence> adapterCountries = ArrayAdapter.createFromResource(
                this,
                R.array.countries,
                android.R.layout.simple_spinner_item
        );
        adapterCountries.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCountriesSpinner.setAdapter(adapterCountries);

        mCountriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] countries = getResources().getStringArray(R.array.countries);
                initSpinnerCities(countries[i]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void initHousNumbersSpinner() {
        Integer[] houseNumbers = new Integer[50];
        for (int i = 1; i <= 50; i++) {
            houseNumbers[i - 1] = i;
        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(
                this,
                android.R.layout.simple_spinner_item,
                houseNumbers
        );
        mHousesSpinner.setAdapter(adapter);
    }

    private void initSpinnerCities(String country) {
        ArrayAdapter<CharSequence> adapter = null;
        switch (country) {
            case "Россия":
                adapter = ArrayAdapter.createFromResource(
                        this,
                        R.array.r_cities,
                        android.R.layout.simple_spinner_item
                );
                break;
            case "Украина":
                adapter = ArrayAdapter.createFromResource(
                        this,
                        R.array.u_cities,
                        android.R.layout.simple_spinner_item
                );
                break;
            case "Белоруссия":
                adapter = ArrayAdapter.createFromResource(
                        this,
                        R.array.b_cities,
                        android.R.layout.simple_spinner_item
                );
                break;
        }
        if (adapter != null) {
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mCitiesSpinner.setAdapter(adapter);
        }
    }

    private void showMsg() {
        Toast.makeText(T_212.this
                ,mCountriesSpinner.getSelectedItem().toString()
                        + " "
                        + mCitiesSpinner.getSelectedItem().toString()
                        + " "
                        + mHousesSpinner.getSelectedItem().toString()
                ,Toast.LENGTH_LONG)
                .show();
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
