package com.example.androidpanin.task412;

import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.widget.ListView;

import com.example.androidpanin.R;
import com.example.androidpanin.ToolbarActivity;
import com.example.androidpanin.Utils;

public class T_412 extends ToolbarActivity {

    private MapListMaker mapListMaker;
    private AdapterCreator ac;
    private SharedDataCreator sdc;

    private ListView list;
    SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_412);
        initView();
    }

    private void initView() {

        initToolbar();
        list = findViewById(R.id.list);
        String resString = getString(R.string.large_text);

        sdc = new SharedDataCreator(this, "T_412", resString);

        mapListMaker = new MapListMaker(
                sdc.getSp().getString(
                        SharedDataCreator.getPrefText(),
                        ""),
                "\n",
                "Заголовок",
                "Подзаголовок");


        String[] from = {mapListMaker.getFirstKey(), mapListMaker.getSecondKey()};
        int[] to = {R.id.bookName, R.id.bookDescription};

        ac = new AdapterCreator(this, mapListMaker, list, to, from);

        initSwipe();
    }

    private void initSwipe() {
        swipeLayout = findViewById(R.id.swipeRefresh);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                                             @Override
                                             public void onRefresh() {
                                                 swipeLayout.setRefreshing(false);
                                                 ac.getValues().clear();
                                                 ac.getValues().addAll(mapListMaker.getMapList());
                                                 ac.getListContentAdapter().notifyDataSetChanged();
                                             }
                                         }
        );
    }

    private void initToolbar() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

}
