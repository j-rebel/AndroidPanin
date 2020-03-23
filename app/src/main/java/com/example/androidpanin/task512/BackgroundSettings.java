package com.example.androidpanin.task512;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidpanin.R;
import com.example.androidpanin.ToolbarActivity;
import com.example.androidpanin.Utils;

public class BackgroundSettings extends ToolbarActivity {

    private EditText mNameInput;
    private Button mOkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_background_settings);
        initViews();
    }

    private void initViews() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mNameInput = findViewById(R.id.imgNameInput);

        mOkBtn = findViewById(R.id.okBtn);
        mOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("IMAGE_NAME", mNameInput.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

}
