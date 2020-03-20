package com.example.androidpanin.task611;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

import com.example.androidpanin.R;
import com.example.androidpanin.ToolbarActivity;
import com.example.androidpanin.Utils;

public class T_611 extends ToolbarActivity {

    private TextView mLogView;
    private static String logStr = "Activity lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String bundleState = (savedInstanceState == null) ? "onCreate::Bundle == null" : "onCreate::Bundle != null";
        Log.i("T_611", bundleState);
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_611);
        initView();
        mLogView.append("\n" + bundleState);
    }

    private void initView() {
        Log.i("T_611", "initView");
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        mLogView = findViewById(R.id.logView);
        mLogView.setText(logStr);
        mLogView.append("\n" + "initView");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("T_611", "onStart");
        mLogView.append("\n" + "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("T_611", "onResume");
        mLogView.append("\n" + "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("T_611", "onPause");
        mLogView.append("\n" + "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("T_611", "onStop");
        mLogView.append("\n" + "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("T_611", "onDestroy");
        mLogView.append("\n" + "onDestroy");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("T_611", "onRestart");
        mLogView.append("\n" + "onRestart");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.i("T_611", "onPostCreate");
        mLogView.append("\n" + "onPostCreate");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.i("T_611", "onPostResume");
        mLogView.append("\n" + "onPostResume");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i("T_611", "onKeyDown");
        mLogView.append("\n" + "onKeyDown");
        //return super.onKeyDown(keyCode, event);
        return true;
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Log.i("T_611", "onKeyLongPress");
        mLogView.append("\n" + "onKeyLongPress");
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.i("T_611", "onBackPressed");
        mLogView.append("\n" + "onBackPressed");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i("T_611", "onSaveInstanceState");
        mLogView.append("\n" + "onSaveInstanceState");
        logStr = mLogView.getText().toString();
        super.onSaveInstanceState(outState);
    }

    /*@Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("T_611", "onRestoreInstanceState");
        mLogView.append("\n" + "onRestoreInstanceState");
    }*/
}
