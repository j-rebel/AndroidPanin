package com.example.androidpanin.task521;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidpanin.R;
import com.example.androidpanin.ToolbarActivity;
import com.example.androidpanin.Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class T_521 extends ToolbarActivity {

    private EditText mPswrdInput;
    private EditText mLoginInput;
    private Button mLoginBtn;
    private Button mRegBtn;

    private final static String FILE_NAME = "data.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_521);
        initView();
    }

    private void initView() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mPswrdInput = findViewById(R.id.pswrdInput);
        mLoginInput = findViewById(R.id.loginInput);

        mLoginBtn = findViewById(R.id.loginBtn);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkData();
            }
        });

        mRegBtn = findViewById(R.id.regBtn);
        mRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });


    }

    public void checkData() {
        String login = mLoginInput.getText().toString();
        String password = mPswrdInput.getText().toString();
        String checkLogin = "";
        String checkPswrd = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(getFilesDir(), FILE_NAME)));
            checkLogin = reader.readLine();
            checkPswrd = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(!checkLogin.equals("") || !checkPswrd.equals("")) {
            if (login.equals(checkLogin) && password.equals(checkPswrd)) {
                Toast.makeText(this, "Correct input", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Incorrect input", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "No data found", Toast.LENGTH_LONG).show();
        }
    }

    public void saveData() {
        String login = mLoginInput.getText().toString();
        String password = mPswrdInput.getText().toString();
        if (!login.equals("") && !password.equals("")) {
            String data = login + "\n" + password;

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(new File(getFilesDir(), FILE_NAME)));
                writer.write(data);
                writer.close();
                Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "Empty input", Toast.LENGTH_LONG).show();
        }
    }
}
