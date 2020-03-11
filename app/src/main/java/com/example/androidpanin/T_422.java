package com.example.androidpanin;

import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class T_422 extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_422);
        initView();
    }

    private void initView() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }
}
