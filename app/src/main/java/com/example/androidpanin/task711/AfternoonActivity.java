package com.example.androidpanin.task711;

import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidpanin.R;
import com.example.androidpanin.ToolbarActivity;
import com.example.androidpanin.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AfternoonActivity extends ToolbarActivity {

    private TextView mCurrentTimeView;
    private Button mRunBtn;
    private Date date = new Date() ;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm") ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_711_afternoon);
        initView();
    }

    private void initView() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mCurrentTimeView = findViewById(R.id.currentTimeView);

        mCurrentTimeView.setText(dateFormat.format(date));

        mRunBtn = findViewById(R.id.syncBtn);
        mRunBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMsg();
            }
        });
    }

    public void showMsg() {
        Toast.makeText(this, "Sync running..", Toast.LENGTH_LONG).show();
    }
}
