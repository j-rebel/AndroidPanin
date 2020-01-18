package com.example.androidpanin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
    }

    public void proceedTo121(View view) {
        Intent intent = new Intent(this, LessonTwoTaskOneActivity.class);
        startActivity(intent);
    }

    public void proceedTo122(View view) {
        Intent intent = new Intent(this, LessonTwoTaskTwoActivity.class);
        startActivity(intent);
    }
}
