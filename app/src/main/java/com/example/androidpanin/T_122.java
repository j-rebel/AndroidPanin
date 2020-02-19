package com.example.androidpanin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class T_122 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_122);

        initViews();

        TextView currentImageLink = findViewById(R.id.currentImageLink);
        currentImageLink.setText(createLink());


        Button forwardButton = findViewById(R.id.forwardButton);
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(T_122.this, T_122.class);
                startActivity(intent);
            }
        });

        Button backwardButton = findViewById(R.id.backwardButton);
        backwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T_122.this.finish();
            }
        });
    }

    public String createLink() {
        return "http://myfile.org/" + new Random().nextInt(100);
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

    private void initViews() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    public void proceedToTask(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}
