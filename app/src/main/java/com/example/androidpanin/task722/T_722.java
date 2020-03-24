package com.example.androidpanin.task722;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.androidpanin.R;
import com.example.androidpanin.ToolbarActivity;
import com.example.androidpanin.Utils;

public class T_722 extends ToolbarActivity {

    private static final int PERMISSIONS_REQUEST_CALL_PHONE = 11;
    private static final int PERMISSIONS_REQUEST_SMS = 12;

    private Switch mOptionSwitch;
    private EditText mInputSMS;
    private EditText mInputPhone;
    private Button mSubmitBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_722);
        initView();
    }

    private void initView() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mOptionSwitch = findViewById(R.id.optionSwitch);
        mInputPhone = findViewById(R.id.inputPhone);
        mInputSMS = findViewById(R.id.inputSms);
        mSubmitBtn = findViewById(R.id.submitBtn);
        initCallButton();

        mOptionSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    initCallButton();
                } else {
                    initSMSButton();
                }
            }
        });
    }

    public void initCallButton() {
        mOptionSwitch.setText(R.string.switch_call);
        mInputSMS.setVisibility(View.GONE);
        mSubmitBtn.setText(R.string.call_button);

        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callByNumber();
            }
        });
    }

    public void initSMSButton() {
        mOptionSwitch.setText(R.string.switch_sms);
        mInputSMS.setVisibility(View.VISIBLE);
        mSubmitBtn.setText(R.string.sms_button);

        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMS();
            }
        });
    }

    public void callByNumber() {
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE}, PERMISSIONS_REQUEST_CALL_PHONE);
            } else{
                String phone = mInputPhone.getText().toString();
                if(!phone.equals("")) {
                Intent dialIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
                startActivity(dialIntent);
                } else {
                    Toast.makeText(this, getString(R.string.input_empty_msg), Toast.LENGTH_LONG).show();
                }
            }
    }

    public void sendSMS() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS}, PERMISSIONS_REQUEST_SMS);
        } else{
            String phone = mInputPhone.getText().toString();
            String msg = mInputSMS.getText().toString();
            if(!phone.equals("") || !msg.equals("")) {
                SmsManager smgr = SmsManager.getDefault();
                smgr.sendTextMessage(phone,null,msg,null,null);
                Toast.makeText(this, getString(R.string.success), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, getString(R.string.input_empty_msg), Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch(requestCode) {
            case PERMISSIONS_REQUEST_CALL_PHONE:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    callByNumber();
                } else {
                    finish();
                }
            case PERMISSIONS_REQUEST_SMS:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    sendSMS();
                } else {
                    finish();
                }
        }
    }
}
