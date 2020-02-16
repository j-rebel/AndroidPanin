package com.example.androidpanin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class T_122 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_122);

        TextView currentImageLink = findViewById(R.id.currentImageLink);
        currentImageLink.setText(createLink());


        Button forwardButton = findViewById(R.id.forwardButton);
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(T_122.this, T_122.class);
                startActivity(intent);
            }
        });

        Button backwardButton = findViewById(R.id.backwardButton);
        backwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T_122.this.finish();
            }
        });
    }

    public String createLink() {
        return "http://myfile.org/" + new Random().nextInt(100);
    }
}
