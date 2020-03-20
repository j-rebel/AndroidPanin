package com.example.androidpanin.task612;

import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.androidpanin.R;
import com.example.androidpanin.ToolbarActivity;
import com.example.androidpanin.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T_612 extends ToolbarActivity {

    private List<Map<String, String>> mapList = new ArrayList<>();
    private String[] strings;
    private BaseAdapter listContentAdapter;
    private SwipeRefreshLayout swipeLayout;
    private ArrayList<Integer> removedInd = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_612);
        if(savedInstanceState != null) {
            removedInd = savedInstanceState.getIntegerArrayList("Removed Ids");
        }
        initView();
    }

    private void initView() {

        initToolbar();
        ListView list = findViewById(R.id.list);
        String resString = getString(R.string.large_text);

        SharedPreferences sp = getSharedPreferences("T_612", MODE_PRIVATE);

        if (sp.getBoolean("firstRun", true)) {
            String LARGE_TEXT = "default text";
            sp.edit().putString(LARGE_TEXT, resString).putBoolean("firstRun", false).apply();
        }

        strings = sp.getString("default text", "").split("\n");

        fillMapList();
        removeIndxsFromMapList();

        String[] from = {"Заголовок", "Подзаголовок"};
        int[] to = {R.id.bookName, R.id.bookDescription};

        listContentAdapter = new SimpleAdapter(
                this,
                mapList,
                R.layout.two_fields_list_item,
                from,
                to);

        list.setAdapter(listContentAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mapList.remove(position);
                removedInd.add(position);
                listContentAdapter.notifyDataSetChanged();
            }
        });

        initSwipe();
    }

    private void initSwipe() {
        swipeLayout = findViewById(R.id.swipeRefresh);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                                             @Override
                                             public void onRefresh() {
                                                 swipeLayout.setRefreshing(false);
                                                 mapList.clear();
                                                 fillMapList();
                                                 removedInd.clear();
                                                 listContentAdapter.notifyDataSetChanged();
                                             }
                                         }
        );
    }

    private void initToolbar() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    private void fillMapList() {
        for (String string : strings) {
            Map<String, String> map = new HashMap<>();
            map.put("Заголовок", string);
            map.put("Подзаголовок", String.valueOf(string.length()));
            mapList.add(map);
        }
    }

    private void removeIndxsFromMapList() {
        if(removedInd != null) {
            for (Integer i : removedInd) {
                mapList.remove(i.intValue());
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putIntegerArrayList("Removed Ids", removedInd);
        super.onSaveInstanceState(outState);
    }


}
