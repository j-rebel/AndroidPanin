package com.example.androidpanin;

import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class T_122 extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_122);

        initViews();

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

    private void initViews() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }
}
