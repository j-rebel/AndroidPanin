package com.example.androidpanin.task422;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.androidpanin.R;
import com.example.androidpanin.StartScreenActivity;
import com.example.androidpanin.ToolbarActivity;
import com.example.androidpanin.Utils;
import com.example.androidpanin.task421.T_421;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class T_422 extends ToolbarActivity {

    private ItemsDataAdapter422 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_422);
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
                Toast.makeText(T_422.this,
                        "This is a floating button!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initAdapter(){
        ListView listView = findViewById(R.id.customList);

        adapter = new ItemsDataAdapter422(this, null);
        listView.setAdapter(adapter);

        addData();

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showItemData(position);
                return true;
            }
        });
    }

    private void addData() {
        adapter.addItem(new ItemData422(getDrawable(R.drawable.screen_121),"Задача 1", getString(R.string.start_screen_option_121), false, "com.example.androidpanin.T-121"));
        adapter.addItem(new ItemData422(getDrawable(R.drawable.screen_122),"Задача 2", getString(R.string.start_screen_option_122), false, "com.example.androidpanin.T-122"));
        adapter.addItem(new ItemData422(getDrawable(R.drawable.screen_211),"Задача 3", getString(R.string.start_screen_option_211), false, "com.example.androidpanin.T-211"));
        adapter.addItem(new ItemData422(getDrawable(R.drawable.screen_212),"Задача 4", getString(R.string.start_screen_option_212), false, "com.example.androidpanin.T-212"));
        adapter.addItem(new ItemData422(getDrawable(R.drawable.screen_213),"Задача 5", getString(R.string.start_screen_option_213), false, "com.example.androidpanin.T-213"));
        adapter.addItem(new ItemData422(getDrawable(R.drawable.screen_221),"Задача 6", getString(R.string.start_screen_option_221), false, "com.example.androidpanin.T-221"));
        adapter.addItem(new ItemData422(getDrawable(R.drawable.screen_311),"Задача 7", getString(R.string.start_screen_option_311), false, "com.example.androidpanin.T-311"));
        adapter.addItem(new ItemData422(getDrawable(R.drawable.screen_312),"Задача 8", getString(R.string.start_screen_option_312), false, "com.example.androidpanin.T-312"));
        adapter.addItem(new ItemData422(getDrawable(R.drawable.screen_321),"Задача 9", getString(R.string.start_screen_option_321), false, "com.example.androidpanin.T-321"));
        adapter.addItem(new ItemData422(getDrawable(R.drawable.screen_322),"Задача 10", getString(R.string.start_screen_option_322), false, "com.example.androidpanin.T-322"));
        adapter.addItem(new ItemData422(getDrawable(R.drawable.screen_331),"Задача 11", getString(R.string.start_screen_option_331), false, "com.example.androidpanin.T-331"));
        adapter.addItem(new ItemData422(getDrawable(R.drawable.screen_332),"Задача 12", getString(R.string.start_screen_option_332), false, "com.example.androidpanin.T-332"));
        adapter.addItem(new ItemData422(getDrawable(R.drawable.screen_341),"Задача 13", getString(R.string.start_screen_option_341), false, "com.example.androidpanin.T-341"));
        adapter.addItem(new ItemData422(getDrawable(R.drawable.screen_342),"Задача 14", getString(R.string.start_screen_option_342), false, "com.example.androidpanin.T-342"));
        adapter.addItem(new ItemData422(getDrawable(R.drawable.screen_411),"Задача 15", getString(R.string.start_screen_option_411), false, "com.example.androidpanin.T-411"));
        adapter.addItem(new ItemData422(getDrawable(R.drawable.screen_412),"Задача 16", getString(R.string.start_screen_option_412), false, "com.example.androidpanin.task412.T-412"));
    }

    private void showItemData(int position) {
        ItemData422 itemData = adapter.getItem(position);
        Toast.makeText(T_422.this,
                "Header: " + itemData.getHeader() + "\n" +
                        "Description: " + itemData.getDescription() + "\n" +
                        "Checked: " + itemData.isChecked(),
                Toast.LENGTH_SHORT).show();
    }
}
