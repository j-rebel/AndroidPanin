package com.example.androidpanin.task511;

import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
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
import java.util.Random;

public class T_511 extends ToolbarActivity {

    private ItemsDataAdapter511 adapter;
    private int permissionStatus;
    private int permissionWrStatus;
    public static final int REQUEST_CODE_PERMISSION_READ_STORAGE = 10;
    public static final int REQUEST_CODE_PERMISSION_WRITE_STORAGE = 20;
    public static final File DOWNLOADS_PATH = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
    public static final String FILE_NAME = "data.txt";
    private ArrayList<ItemData511> adapterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_511);
        permissionStatus = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE);
        permissionWrStatus = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

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
                generateRandomItem();
            }
        });
    }

    public void initAdapter() {
        ListView listView = findViewById(R.id.customList);

        adapterList = readDataTxt(FILE_NAME);
        if (adapterList.isEmpty()) {
            adapterList = createListFromResourceArray();
            writeDataTxt(FILE_NAME, adapterList);
        }

        adapter = new ItemsDataAdapter511(this, adapterList);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showItemData(position);
                return true;
            }
        });
    }

    private ArrayList<ItemData511> createListFromResourceArray() {

        String[] itemIds = getResources().getStringArray(R.array.classes);
        ArrayList<ItemData511> result = new ArrayList<>();

        for (String id : itemIds) {
            result.add(createItemFromIdString(id));
        }

        return result;
    }

    private ItemData511 createItemFromIdString(String id) {
        return new ItemData511(loadImg("screen_" + id + ".png"),
                "Задача " + id,
                getStringFromResourcesByName("start_screen_option_" + id),
                returnCorrectClassPath(id));
    }

    private ArrayList<ItemData511> createItemsFromString(String longString) {
        Log.i("createItemsFromString", longString);
        ArrayList<ItemData511> result = new ArrayList<>();
        if (!longString.equals("")) {
            String[] arr = longString.split(";");
            for (String s : arr) {
                String[] temp = s.split(",");
                result.add(new ItemData511(loadImg(temp[0]),
                        temp[1],
                        getStringFromResourcesByName("start_screen_option_" + temp[3]),
                        returnCorrectClassPath(temp[3])));
                }
        }
        return result;
        }

    private String transformItemToString(ItemData511 item) {
        StringBuilder builder = new StringBuilder();
        builder.append("screen_" + item.getClassId() + ".png,");
        builder.append(item.getHeader() + ",");
        builder.append(item.getDescription() + ",");
        builder.append(item.getClassId() + ";");
        return builder.toString();
    }

    public void requestReadPerm() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                REQUEST_CODE_PERMISSION_READ_STORAGE);
    }

    public void requestWritePerm() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                REQUEST_CODE_PERMISSION_WRITE_STORAGE);
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    private String getStringFromResourcesByName(String resourceName) {
        String packageName = getPackageName();
        String result = "";
        try {
            int resourceId = getResources().getIdentifier(resourceName, "string", packageName);
            result = getString(resourceId);
        } catch (Exception e) {
            result = "Нет ресурса";
        }
        return result;
    }

    public void generateRandomItem() {
        final Bitmap DEFAULT_IMG = BitmapFactory.decodeResource(getResources(), R.drawable.def_img);

        Random random = new Random();
        adapter.addItem(new ItemData511(DEFAULT_IMG,
                "Задача " + random.nextInt(),
                "Описание случайно сгенерированного элемента",
                "com.example.androidpanin.T_" + random.nextInt()));
        writeDataTxt(FILE_NAME, (ArrayList<ItemData511>) adapter.getItems());
    }

    public String returnCorrectClassPath(String id) {
        if (Integer.parseInt(id) > 411) {
            return "com.example.androidpanin.task" + id + ".T_" + id;
        } else {
            return "com.example.androidpanin.T_" + id;
        }

    }

    private void showItemData(int position) {
        ItemData511 itemData = adapter.getItem(position);
        Toast.makeText(T_511.this,
                "Header: " + itemData.getHeader() + "\n" +
                        "Class: " + itemData.getClassName() + "\n",
                Toast.LENGTH_SHORT).show();
    }

    private Bitmap loadImg(String fileName) {

        final Bitmap DEFAULT_IMG = BitmapFactory.decodeResource(getResources(), R.drawable.def_img);

        if (permissionStatus == PackageManager.PERMISSION_GRANTED & isExternalStorageWritable()) {
            File file = new File(DOWNLOADS_PATH, fileName);
            if (file.exists()) {
                return BitmapFactory.decodeFile(file.getAbsolutePath());
            } else {
                return DEFAULT_IMG;
            }
        } else {
            requestReadPerm();
            loadImg(fileName);
        }
        return DEFAULT_IMG;
    }

    private void writeDataTxt(String fileName, ArrayList<ItemData511> list) {
        if (permissionWrStatus == PackageManager.PERMISSION_GRANTED & isExternalStorageWritable()) {
            File file = new File(DOWNLOADS_PATH, fileName);
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(file));

                StringBuilder result = new StringBuilder();

                for (ItemData511 item : list) {
                    result.append(transformItemToString(item));
                }
                writer.write(result.toString());
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            requestWritePerm();
            writeDataTxt(fileName, list);
        }
    }

    public ArrayList<ItemData511> readDataTxt(String fileName) {
        if (permissionStatus == PackageManager.PERMISSION_GRANTED & isExternalStorageWritable()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(new File(DOWNLOADS_PATH, fileName)));
                String dataFromFile;
                StringBuilder builder = new StringBuilder();
                while ((dataFromFile = reader.readLine()) != null) {
                    builder.append(dataFromFile);
                    //Log.i("readDataTxt cycle", reader.readLine());
                }
                dataFromFile = builder.toString();
                reader.close();
                return createItemsFromString(dataFromFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new ArrayList<ItemData511>();
        } else {
            requestWritePerm();
            readDataTxt(fileName);
            return new ArrayList<ItemData511>();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        writeDataTxt(FILE_NAME, (ArrayList<ItemData511>) adapter.getItems());
    }
}
