package com.example.androidpanin.task421;

import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.androidpanin.R;
import com.example.androidpanin.ToolbarActivity;
import com.example.androidpanin.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class T_421 extends ToolbarActivity {

    private ItemsDataAdapter421 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_421);
        initViews();
    }

    private void initViews() {
        initToolbar();
        initFab();
        initAdapter();

    }

    public void initToolbar() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    public void initFab() {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(T_421.this,
                        "This is a floating button!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initAdapter() {
        ListView listView = findViewById(R.id.customList);

        adapter = new ItemsDataAdapter421(this, null);
        listView.setAdapter(adapter);

        addData();
    }

    private void addData() {
        adapter.addItem(new ItemData421(getDrawable(R.drawable.screen_121), getString(R.string.task_title_placeholder, 1), getString(R.string.start_screen_option_121), false));
        adapter.addItem(new ItemData421(getDrawable(R.drawable.screen_122), getString(R.string.task_title_placeholder, 2), getString(R.string.start_screen_option_122), false));
        adapter.addItem(new ItemData421(getDrawable(R.drawable.screen_211), getString(R.string.task_title_placeholder, 3), getString(R.string.start_screen_option_211), false));
        adapter.addItem(new ItemData421(getDrawable(R.drawable.screen_212), getString(R.string.task_title_placeholder, 4), getString(R.string.start_screen_option_212), false));
        adapter.addItem(new ItemData421(getDrawable(R.drawable.screen_213), getString(R.string.task_title_placeholder, 5), getString(R.string.start_screen_option_213), false));
        adapter.addItem(new ItemData421(getDrawable(R.drawable.screen_221), getString(R.string.task_title_placeholder, 6), getString(R.string.start_screen_option_221), false));
        adapter.addItem(new ItemData421(getDrawable(R.drawable.screen_311), getString(R.string.task_title_placeholder, 7), getString(R.string.start_screen_option_311), false));
        adapter.addItem(new ItemData421(getDrawable(R.drawable.screen_312), getString(R.string.task_title_placeholder, 8), getString(R.string.start_screen_option_312), false));
        adapter.addItem(new ItemData421(getDrawable(R.drawable.screen_321), getString(R.string.task_title_placeholder, 9), getString(R.string.start_screen_option_321), false));
        adapter.addItem(new ItemData421(getDrawable(R.drawable.screen_322), getString(R.string.task_title_placeholder, 10), getString(R.string.start_screen_option_322), false));
        adapter.addItem(new ItemData421(getDrawable(R.drawable.screen_331), getString(R.string.task_title_placeholder, 11), getString(R.string.start_screen_option_331), false));
        adapter.addItem(new ItemData421(getDrawable(R.drawable.screen_332), getString(R.string.task_title_placeholder, 12), getString(R.string.start_screen_option_332), false));
        adapter.addItem(new ItemData421(getDrawable(R.drawable.screen_341), getString(R.string.task_title_placeholder, 13), getString(R.string.start_screen_option_341), false));
        adapter.addItem(new ItemData421(getDrawable(R.drawable.screen_342), getString(R.string.task_title_placeholder, 14), getString(R.string.start_screen_option_342), false));
        adapter.addItem(new ItemData421(getDrawable(R.drawable.screen_411), getString(R.string.task_title_placeholder, 15), getString(R.string.start_screen_option_411), false));
        adapter.addItem(new ItemData421(getDrawable(R.drawable.screen_412), getString(R.string.task_title_placeholder, 16), getString(R.string.start_screen_option_412), false));
    }

}
