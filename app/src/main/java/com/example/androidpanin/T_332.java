package com.example.androidpanin;

import androidx.appcompat.widget.Toolbar;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class T_332 extends ToolbarActivity {

    private static final String TAG = "T_332";

    private Button mOkBtn;
    private Spinner mLangSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called");
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_332);
        initViews();

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    private void initViews() {
        Log.d(TAG, "initViews() called");
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        initLangSpinner();

        mOkBtn = findViewById(R.id.okBtn);
        mOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (mLangSpinner.getSelectedItemPosition()) {
                    case 0:
                        Log.d(TAG, "setLocale() - button click - RU case - called");
                        setLocale("ru");
                        break;
                    case 1:
                        Log.d(TAG, "setLocale() - button click - EN case - called");
                        setLocale("en");
                        break;
                }

            }
        });
        Log.d(TAG, "initViews() finished");
    }

    private void initLangSpinner() {
        Log.d(TAG, "initLangSpinner() called");
        mLangSpinner = findViewById(R.id.langSpinner);

        ArrayAdapter<CharSequence> adapterLang = ArrayAdapter.createFromResource(
                this,
                R.array.languages,
                android.R.layout.simple_spinner_item
        );
        adapterLang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mLangSpinner.setAdapter(adapterLang);
        Log.d(TAG, "initLangSpinner() finished");
    }

    private void setLocale(String localePrefix) {
        Log.d(TAG, "setLocale() called");
        Locale locale = new Locale(localePrefix);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }
}
