package com.example.androidpanin.task512;

import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.androidpanin.R;
import com.example.androidpanin.ToolbarActivity;
import com.example.androidpanin.Utils;

import java.io.File;

public class T_512 extends ToolbarActivity implements View.OnClickListener {
    private TextView mInputField;
    private Button mNineBtn;
    private Button mEightBtn;
    private Button mSevenBtn;
    private Button mSixBtn;
    private Button mFiveBtn;
    private Button mFourBtn;
    private Button mThreeBtn;
    private Button mTwoBtn;
    private Button mOneBtn;
    private Button mZeroBtn;
    private Button mDotBtn;
    private Button mchangeBgBtn;

    private static final int REQUEST_CODE_PERMISSION_READ_STORAGE = 10;
    private static final File DOWNLOADS_PATH = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_512);
        int permissionStatus = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE);

        if (permissionStatus != PackageManager.PERMISSION_GRANTED && !isExternalStorageWritable()) {
            requestReadPerm();
        }

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
        mchangeBgBtn = findViewById(R.id.changeBgBtn);

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
        mchangeBgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceedToSettings();
            }
        });
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

    public void proceedToSettings() {
        Intent intent = new Intent(this, BackgroundSettings.class);
        startActivityForResult(intent, 1);
    }

    private void loadImg(String IMAGE_NAME) {
        ImageView view = findViewById(R.id.backgroundImg);
        if (isExternalStorageWritable()) {
            File file = new File(DOWNLOADS_PATH, IMAGE_NAME);
            Bitmap b = BitmapFactory.decodeFile(file.getAbsolutePath());
            //view.setImageBitmap(b);
            Glide.with(this)
                    .asBitmap()
                    .load(b)
                    .into(view);
            Toast.makeText(this, file.getAbsolutePath(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, getString(R.string.bg_not_found), Toast.LENGTH_LONG).show();
        }
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {return;}
        String IMAGE_NAME = data.getStringExtra("IMAGE_NAME");
        loadImg(IMAGE_NAME);
    }

    public void requestReadPerm() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                REQUEST_CODE_PERMISSION_READ_STORAGE);
    }
}
