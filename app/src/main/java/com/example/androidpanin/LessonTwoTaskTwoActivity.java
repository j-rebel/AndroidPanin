package com.example.androidpanin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class LessonTwoTaskTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_two_task_two);

        TextView currentImageLink = findViewById(R.id.currentImageLink);
        currentImageLink.setText(createLink());


        Button forwardButton = findViewById(R.id.forwardButton);
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LessonTwoTaskTwoActivity.this, LessonTwoTaskTwoActivity.class);
                startActivity(intent);
            }
        });

        Button backwardButton = findViewById(R.id.backwardButton);
        backwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LessonTwoTaskTwoActivity.this.finish();
            }
        });
    }

    public String createLink() {
        return "http://myfile.org/" + new Random().nextInt(100);
    }
}
