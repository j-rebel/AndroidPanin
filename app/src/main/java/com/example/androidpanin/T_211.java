package com.example.androidpanin;

import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class T_211 extends ToolbarActivity {

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
        Utils.onActivityCreateSetTheme(this);
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
        Toast.makeText(T_211.this, getText(R.string.pay_msg).toString() + mSumInput.getText(), Toast.LENGTH_LONG).show();
    }
}
