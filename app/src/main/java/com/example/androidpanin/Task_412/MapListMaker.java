package com.example.androidpanin.Task_412;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapListMaker {

    private String firstKey;
    private String secondKey;

    private List<Map<String, String>> mapList;

    public MapListMaker(String data, String regex, String firstKey, String secondKey) {

        this.firstKey = firstKey;
        this.secondKey = secondKey;

        String[] strings = data.split(regex);

        this.mapList = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            Map<String, String> map = new HashMap<>();
            map.put(firstKey, strings[i]);
            map.put(secondKey, String.valueOf(strings[i].length()));
            mapList.add(map);
        }
    }

    public List<Map<String, String>> getMapList() {
        return mapList;
    }

    public String getFirstKey() {
        return firstKey;
    }

    public String getSecondKey() {
        return secondKey;
    }
}
