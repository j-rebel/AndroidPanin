package com.example.androidpanin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class T_321 extends ToolbarActivity implements View.OnClickListener {

    TextView mInputField;
    Button mNineBtn;
    Button mEightBtn;
    Button mSevenBtn;
    Button mSixBtn;
    Button mFiveBtn;
    Button mFourBtn;
    Button mThreeBtn;
    Button mTwoBtn;
    Button mOneBtn;
    Button mZeroBtn;
    Button mDotBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_321);
        initViews();
    }


    private void initViews() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mInputField = findViewById(R.id.inputField);
        mNineBtn = findViewById(R.id.nineBtn);
        mEightBtn = findViewById(R.id.eightBtn);
        mSevenBtn = findViewById(R.id.sevenBtn);
        mSixBtn = findViewById(R.id.sixBtn);
        mFiveBtn = findViewById(R.id.fiveBtn);
        mFourBtn = findViewById(R.id.fourBtn);
        mThreeBtn = findViewById(R.id.threeBtn);
        mTwoBtn = findViewById(R.id.twoBtn);
        mOneBtn = findViewById(R.id.oneBtn);
        mZeroBtn = findViewById(R.id.zeroBtn);
        mDotBtn = findViewById(R.id.dotBtn);

        mNineBtn.setOnClickListener(this);
        mEightBtn.setOnClickListener(this);
        mSevenBtn.setOnClickListener(this);
        mSixBtn.setOnClickListener(this);
        mFiveBtn.setOnClickListener(this);
        mFourBtn.setOnClickListener(this);
        mThreeBtn.setOnClickListener(this);
        mTwoBtn.setOnClickListener(this);
        mOneBtn.setOnClickListener(this);
        mZeroBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nineBtn:
                mInputField.setText(mNineBtn.getText());
                break;
            case R.id.eightBtn:
                mInputField.setText(mEightBtn.getText());
                break;
            case R.id.sevenBtn:
                mInputField.setText(mSevenBtn.getText());
                break;
            case R.id.sixBtn:
                mInputField.setText(mSixBtn.getText());
                break;
            case R.id.fiveBtn:
                mInputField.setText(mFiveBtn.getText());
                break;
            case R.id.fourBtn:
                mInputField.setText(mFourBtn.getText());
                break;
            case R.id.threeBtn:
                mInputField.setText(mThreeBtn.getText());
                break;
            case R.id.twoBtn:
                mInputField.setText(mTwoBtn.getText());
                break;
            case R.id.oneBtn:
                mInputField.setText(mOneBtn.getText());
                break;
            case R.id.zeroBtn:
                mInputField.setText(mZeroBtn.getText());
                break;
        }
    }
}
