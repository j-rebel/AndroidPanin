package com.example.androidpanin.task522;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidpanin.R;
import com.example.androidpanin.ToolbarActivity;
import com.example.androidpanin.Utils;
import com.example.androidpanin.task511.ItemData511;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class T_522 extends ToolbarActivity {

    private int permissionStatus;
    private int permissionWrStatus;
    public static final int REQUEST_CODE_PERMISSION_READ_STORAGE = 10;
    public static final int REQUEST_CODE_PERMISSION_WRITE_STORAGE = 20;
    public static final File DOWNLOADS_PATH = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
    public static final String FILE_NAME = "pass.txt";

    private EditText mPswrdInput;
    private EditText mLoginInput;
    private Button mLoginBtn;
    private Button mRegBtn;
    private CheckBox mSaveModeCheckbox;
    private static boolean isExternal = false;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_522);
        permissionStatus = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE);
        permissionWrStatus = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        initView();
    }

    private void initView() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mPswrdInput = findViewById(R.id.pswrdInput);
        mLoginInput = findViewById(R.id.loginInput);

        mLoginBtn = findViewById(R.id.loginBtn);
        mRegBtn = findViewById(R.id.regBtn);

        mSaveModeCheckbox = findViewById(R.id.saveModeCheckbox);

        sp = getSharedPreferences("SAVE_MODE", MODE_PRIVATE);
        getSaveMode();

        mSaveModeCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setSaveMode(isChecked);
                if(isChecked) {
                    mLoginBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkDataTxt();
                        }
                    });
                    mRegBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            saveDataTxt();
                        }
                    });
                } else {
                    mLoginBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkData();
                        }
                    });
                    mRegBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            saveData();
                        }
                    });
                }
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

    private void setSaveMode(boolean isExternal) {
        SharedPreferences.Editor myEditor = sp.edit();
        myEditor.putBoolean("isExternal", isExternal);
        myEditor.apply();
    }

    private void saveDataTxt() {
        if (permissionWrStatus == PackageManager.PERMISSION_GRANTED & isExternalStorageWritable()) {
            String login = mLoginInput.getText().toString();
            String password = mPswrdInput.getText().toString();
            if (!login.equals("") && !password.equals("")) {
                String data = login + "\n" + password;

                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(new File(DOWNLOADS_PATH, FILE_NAME)));
                    writer.write(data);
                    writer.close();
                    Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(this, "Empty input", Toast.LENGTH_LONG).show();
            }
        } else {
            requestWritePerm();
            saveDataTxt();
        }
    }

    public void checkDataTxt() {
        if (permissionStatus == PackageManager.PERMISSION_GRANTED) {
            String login = mLoginInput.getText().toString();
            String password = mPswrdInput.getText().toString();
            String checkLogin = "";
            String checkPswrd = "";
            try {
                BufferedReader reader = new BufferedReader(new FileReader(new File(DOWNLOADS_PATH, FILE_NAME)));
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
        } else {
            requestReadPerm();
            checkDataTxt();
        }
    }

    private void getSaveMode(){
        isExternal = sp.getBoolean("isExternal", false);
        mSaveModeCheckbox.setChecked(isExternal);
    }

    public void requestReadPerm() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                REQUEST_CODE_PERMISSION_READ_STORAGE);
    }

    public void requestWritePerm() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                REQUEST_CODE_PERMISSION_WRITE_STORAGE);
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

}
