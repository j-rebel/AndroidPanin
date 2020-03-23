package com.example.androidpanin.task511;

import androidx.annotation.NonNull;
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
import java.util.List;
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

        if (permissionStatus == PackageManager.PERMISSION_GRANTED & isExternalStorageWritable()) {
            initList();
        } else {
            requestReadPerm();
        }
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

        adapterList = readDataTxt();
        if (adapterList.isEmpty()) {
            adapterList = createListFromResourceArray();
            writeDataTxt(adapterList);
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

    private void initList() {
        adapterList = readDataTxt();

        if (adapterList.isEmpty()) {
            adapterList = createListFromResourceArray();
            adapter.setItems(adapterList);
            if (permissionWrStatus == PackageManager.PERMISSION_GRANTED & isExternalStorageWritable()) {
                writeDataTxt(adapterList);
            } else {
                requestWritePerm();
            }
        } else {
            adapter.setItems(adapterList);
        }
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
                getString(R.string.task_label) + id,
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
        builder.append("screen_");
        builder.append(item.getClassId());
        builder.append(".png,");
        builder.append(item.getHeader());
        builder.append(",");
        builder.append(item.getDescription());
        builder.append(",");
        builder.append(item.getClassId());
        builder.append(";");
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

    public void generateRandomItem() {
        final Bitmap DEFAULT_IMG = BitmapFactory.decodeResource(getResources(), R.drawable.def_img);

        Random random = new Random();
        adapter.addItem(new ItemData511(DEFAULT_IMG,
                getString(R.string.task_label) + random.nextInt(),
                "Описание случайно сгенерированного элемента",
                "com.example.androidpanin.T_" + random.nextInt()));
        writeDataTxt(adapter.getItems());
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
                getString(R.string.header_label) + itemData.getHeader() + "\n" +
                        getString(R.string.class_label) + itemData.getClassName() + "\n",
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

    private void writeDataTxt(List<ItemData511> list) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(DOWNLOADS_PATH, FILE_NAME)))) {
                StringBuilder result = new StringBuilder();
                for (ItemData511 item : list) {
                    result.append(transformItemToString(item));
                }
                writer.write(result.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public ArrayList<ItemData511> readDataTxt() {
            try(BufferedReader br = new BufferedReader(new FileReader(new File(DOWNLOADS_PATH, FILE_NAME)))){
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
            return new ArrayList<ItemData511>();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (permissionWrStatus == PackageManager.PERMISSION_GRANTED & isExternalStorageWritable()) {
            writeDataTxt(adapter.getItems());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE_PERMISSION_READ_STORAGE && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            initList();
        } else if (requestCode == REQUEST_CODE_PERMISSION_WRITE_STORAGE && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            writeDataTxt(adapterList);
        }
    }
}
