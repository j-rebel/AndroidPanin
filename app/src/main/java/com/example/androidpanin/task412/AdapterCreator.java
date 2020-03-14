package com.example.androidpanin.task412;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.androidpanin.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdapterCreator {

    private BaseAdapter listContentAdapter;
    private List<Map<String, String>> values;

    public AdapterCreator(Context ctx, MapListMaker mapListMaker, ListView list, int[] to, String[] from) {

        this.values = new ArrayList<>(mapListMaker.getMapList());

        this.listContentAdapter = new SimpleAdapter(
                ctx,
                values,
                R.layout.two_fields_list_item,
                from,
                to);

        list.setAdapter(listContentAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                values.remove(position);
                listContentAdapter.notifyDataSetChanged();
            }
        });
    }

    public BaseAdapter getListContentAdapter() {
        return listContentAdapter;
    }

    public List<Map<String, String>> getValues() {
        return values;
    }
}
