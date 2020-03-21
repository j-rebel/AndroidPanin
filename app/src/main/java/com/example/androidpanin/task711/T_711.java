package com.example.androidpanin.task711;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidpanin.R;
import com.example.androidpanin.ToolbarActivity;
import com.example.androidpanin.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class T_711 extends ToolbarActivity {

    private TextView mCurrentTimeView;
    private Button mSyncBtn;
    private Date date = new Date() ;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm") ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_711);
        initView();
    }

    private void initView() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mCurrentTimeView = findViewById(R.id.currentTimeView);

        mCurrentTimeView.setText(dateFormat.format(date));

        mSyncBtn = findViewById(R.id.syncBtn);
        mSyncBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUri = "";
                if(isMorning(date)) {
                    strUri = "http://morning";
                } else if(isAfternoon(date)) {
                    strUri = "http://afternoon";
                } else if(isEvening(date)) {
                    strUri = "http://evening";
                }

                Intent intent = new Intent(Intent.ACTION_SYNC);
                intent.setData(Uri.parse(strUri));
                startActivity(intent);
            }
        });
    }

    public boolean isMorning(Date date) {
        try {
            if (dateFormat.parse(dateFormat.format(date)).after(dateFormat.parse("05:59")) &&
                    dateFormat.parse(dateFormat.format(date)).before(dateFormat.parse("14:00"))) {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isAfternoon(Date date) {
        try {
            if (dateFormat.parse(dateFormat.format(date)).after(dateFormat.parse("13:59")) &&
                    dateFormat.parse(dateFormat.format(date)).before(dateFormat.parse("15:00"))) {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isEvening(Date date) {
        try {
            if (dateFormat.parse(dateFormat.format(date)).after(dateFormat.parse("14:59")) ||
                    dateFormat.parse(dateFormat.format(date)).before(dateFormat.parse("06:00"))) {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }




}
