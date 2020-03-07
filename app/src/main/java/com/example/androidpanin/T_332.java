package com.example.androidpanin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class T_332 extends ToolbarActivity {

    Button mOkBtn;
    Spinner mLangSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_332);
        initViews();

    }

    private void initViews() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mLangSpinner = findViewById(R.id.langSpinner);
        initLangSpinner();

        mOkBtn = findViewById(R.id.okBtn);

        mOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (mLangSpinner.getSelectedItemPosition()) {
                    case 0:
                        Locale localeRU = new Locale("ru");
                        Configuration configRU = new Configuration();
                        configRU.setLocale(localeRU);
                        getResources().updateConfiguration(configRU, getBaseContext().getResources().getDisplayMetrics());
                        recreate();
                        break;
                    case 1:
                        Locale localeEN = new Locale("en");
                        Configuration configEN = new Configuration();
                        configEN.setLocale(localeEN);
                        getResources().updateConfiguration(configEN, getBaseContext().getResources().getDisplayMetrics());
                        recreate();
                        break;
                }

            }
        });


    }

    private void initLangSpinner() {

        ArrayAdapter<CharSequence> adapterLang = ArrayAdapter.createFromResource(
                this,
                R.array.languages,
                android.R.layout.simple_spinner_item
        );
        adapterLang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mLangSpinner.setAdapter(adapterLang);

    }
}
