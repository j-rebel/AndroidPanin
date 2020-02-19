package com.example.androidpanin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class T_211 extends AppCompatActivity {

    private EditText mPayInfoInput;
    private EditText mSumInput;
    private CheckBox mPayCardChkBx;
    private CheckBox mPayMobileChkBx;
    private CheckBox mPayCashChkBx;
    private Button mOkButton;

    private CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton checkbox, boolean isChecked) {
            if (isChecked) {
                switch (checkbox.getId()) {
                    case R.id.payCardChkBx:
                        resetCheckBoxes();
                        mPayCardChkBx.setChecked(true);
                        mPayInfoInput.setInputType(InputType.TYPE_CLASS_NUMBER);
                        break;
                    case R.id.payMobileChkBx:
                        resetCheckBoxes();
                        mPayMobileChkBx.setChecked(true);
                        mPayInfoInput.setInputType(InputType.TYPE_CLASS_PHONE);
                        break;
                    case R.id.payCashChkBx:
                        resetCheckBoxes();
                        mPayCashChkBx.setChecked(true);
                        mPayInfoInput.setInputType(InputType.TYPE_CLASS_TEXT);
                        break;
                }

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_211);
        initViews();

        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMsg();
            }
        });
    }

    private void initViews() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mPayInfoInput = findViewById(R.id.payInfoInput);
        mSumInput = findViewById(R.id.sumInput);
        mPayCardChkBx = findViewById(R.id.payCardChkBx);
        mPayMobileChkBx = findViewById(R.id.payMobileChkBx);
        mPayCashChkBx = findViewById(R.id.payCashChkBx);
        mOkButton = findViewById(R.id.okButton);

        mPayCardChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mPayMobileChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mPayCashChkBx.setOnCheckedChangeListener(checkedChangeListener);
    }

    private void resetCheckBoxes() {
        mPayCardChkBx.setChecked(false);
        mPayMobileChkBx.setChecked(false);
        mPayCashChkBx.setChecked(false);
    }

    private void showMsg() {
        Toast.makeText(T_211.this, "Произведен перевод на сумму: " + mSumInput.getText(), Toast.LENGTH_LONG).show();
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
