package com.example.androidpanin.task511;

import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.androidpanin.R;
import com.example.androidpanin.ToolbarActivity;
import com.example.androidpanin.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class T_511 extends ToolbarActivity {

    private static final int PERMISSION_ALL = 15;
    String[] PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
    };
    public static final File DOWNLOADS_PATH = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
    public static final String FILE_NAME = "data.txt";

    private ItemsDataAdapter511 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_511);

        if (!hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }

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
                adapter.addItem(new ItemData511());
            }
        });
    }

    public void initAdapter() {

        ListView listView = findViewById(R.id.customList);

        adapter = new ItemsDataAdapter511(this, readDataTxt());

        if(adapter.getItems().isEmpty()) {
            adapter.setItems(createDefaultListFromRes());
        }

        writeDataTxt();

        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(T_511.this, adapter.getItem(position).toString(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private ArrayList<ItemData511> createDefaultListFromRes() {

        String[] itemIds = getResources().getStringArray(R.array.classes);
        ArrayList<ItemData511> result = new ArrayList<>();

        for (String id : itemIds) {
            String resName = "screen_" + id;
            int resId = getResources().getIdentifier(resName, "drawable", getPackageName());

            result.add(new ItemData511(resId,
                    getString(R.string.task_label) + " " + id,
                    getStringFromResourcesByName("start_screen_option_" + id),
                    returnCorrectClassPath(id)));
        }
        return result;
    }

    private ArrayList<ItemData511> createItemsFromString(String longString) {
        ArrayList<ItemData511> result = new ArrayList<>();
        if (!longString.equals("")) {
            String[] arr = longString.split(";");
            for (String s : arr) {
                String[] temp = s.split(",");
                result.add(new ItemData511(Integer.parseInt(temp[0]),
                        temp[1],
                        getStringFromResourcesByName("start_screen_option_" + temp[3]),
                        returnCorrectClassPath(temp[3])));
            }
        }
        return result;
    }

    public String returnCorrectClassPath(String id) {
        if (Integer.parseInt(id) > 411) {
            return "com.example.androidpanin.task" + id + ".T_" + id;
        } else {
            return "com.example.androidpanin.T_" + id;
        }
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
    }

    private String getStringFromResourcesByName(String resourceName) {
        String packageName = getPackageName();
        String result = "";
        try {
            int resourceId = getResources().getIdentifier(resourceName, "string", packageName);
            result = getString(resourceId);
        } catch (Exception e) {
            result = getString(R.string.no_resource_label);
        }
        return result;
    }

    private void writeDataTxt() {
        if (isExternalStorageWritable()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(DOWNLOADS_PATH, FILE_NAME)))) {
                if (!adapter.getItems().isEmpty()) {
                    StringBuilder result = new StringBuilder();
                    for (ItemData511 item : adapter.getItems()) {
                        result.append(item.toString());
                    }
                    writer.write(result.toString());
                } else {
                    writer.write("");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<ItemData511> readDataTxt() {
        try (BufferedReader br = new BufferedReader(new FileReader(new File(DOWNLOADS_PATH, FILE_NAME)))) {
            String dataFromFile;
            StringBuilder builder = new StringBuilder();
            while ((dataFromFile = br.readLine()) != null) {
                builder.append(dataFromFile);
            }
            dataFromFile = builder.toString();
            return createItemsFromString(dataFromFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            writeDataTxt();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            writeDataTxt();
        }
    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
}
