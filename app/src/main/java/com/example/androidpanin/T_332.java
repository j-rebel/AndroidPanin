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

    private Button mOkBtn;
    private Spinner mLangSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_332);
        initViews();

    }

    private void initViews() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        initLangSpinner();

        mOkBtn = findViewById(R.id.okBtn);
        mOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (mLangSpinner.getSelectedItemPosition()) {
                    case 0:
                        setLocale("ru");
                        break;
                    case 1:
                        setLocale("en");
                        break;
                }

            }
        });
    }

    private void initLangSpinner() {
        mLangSpinner = findViewById(R.id.langSpinner);

        ArrayAdapter<CharSequence> adapterLang = ArrayAdapter.createFromResource(
                this,
                R.array.languages,
                android.R.layout.simple_spinner_item
        );
        adapterLang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mLangSpinner.setAdapter(adapterLang);
    }

    private void setLocale(String localePrefix) {
        Locale locale = new Locale(localePrefix);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }
}
