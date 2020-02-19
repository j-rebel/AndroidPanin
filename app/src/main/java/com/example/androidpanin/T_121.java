package com.example.androidpanin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class T_121 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_121);

        initViews();

        final TextView formMsg = findViewById(R.id.formMsg);
        final TextView formErr = findViewById(R.id.formErr);

        final EditText nameInput = findViewById(R.id.nameInput);
        nameInput.setText("");
        final EditText emailInput = findViewById(R.id.emailInput);
        emailInput.setText("");


        Button sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String name = nameInput.getText().toString();
                final String email = emailInput.getText().toString();

                final String formMsgText = "Подписка на рассылку успешно оформлена для пользователя " + name + " на электронный адрес " + email;
                final String errText = "Не заполнено одно из полей!";

                if ("".equals(name) || "".equals(email)) {
                    formErr.setText(errText);
                } else {
                    formErr.setText("");
                    formMsg.setText(formMsgText);
                }
            }
        });

        Button resetButton = findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formErr.setText("");
                formMsg.setText("");
                nameInput.setText("");
                emailInput.setText("");
            }
        });

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
