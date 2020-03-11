package com.example.androidpanin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T_411 extends ToolbarActivity {

    List<Map<String, String>> values = new ArrayList<>();
    BaseAdapter listContentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_411);
        initView();
    }

    private void initView() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ListView list = findViewById(R.id.list);

        values = prepareContent();

        String[] from = {"Заголовок", "Подзаголовок"};
        int[] to = {R.id.bookName, R.id.bookDescription};
        listContentAdapter = createAdapter(values, from, to);

        list.setAdapter(listContentAdapter);

    }

    private BaseAdapter createAdapter(List<Map<String, String>> values, String[] from, int[] to) {
        return new SimpleAdapter(this, values, R.layout.two_fields_list_item, from, to);
    }

    private List<Map<String, String>> prepareContent() {
        String[] strings = getString(R.string.large_text).split("\n");

        List<Map<String, String>> list = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("Заголовок", strings[i]);
            map.put("Подзаголовок", String.valueOf(strings[i].length()));
            list.add(map);
        }

        return list;
    }
}
