package com.example.androidpanin;

import androidx.appcompat.widget.Toolbar;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class T_341 extends ToolbarActivity implements View.OnClickListener {

    private Button mOkBtn;
    private Spinner mLangSpinner;
    private Spinner mColorSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_341);
        initViews();
    }

    @Override
    public void onClick(View v) {

        switch (mLangSpinner.getSelectedItemPosition()) {
            case 0:
                setLocaleAndColor("ru");
                break;
            case 1:
                setLocaleAndColor("en");
                break;
        }
    }

    private void initViews() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        initLangSpinner();
        initColorSpinner();

        mOkBtn = findViewById(R.id.okBtn);
        mOkBtn.setOnClickListener(this);

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

    private void initColorSpinner() {

        mColorSpinner = findViewById(R.id.colorSpinner);

        ArrayAdapter<CharSequence> adapterColor = ArrayAdapter.createFromResource(
                this,
                R.array.colors,
                android.R.layout.simple_spinner_item
        );
        adapterColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mColorSpinner.setAdapter(adapterColor);

    }

    private void setLocaleAndColor(String localePrefix) {
        Locale locale = new Locale(localePrefix);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        Utils.changeToTheme(this, mColorSpinner.getSelectedItemPosition());
        //recreate();
    }


}
