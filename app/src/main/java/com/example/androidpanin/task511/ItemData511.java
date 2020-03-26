package com.example.androidpanin.task511;

import androidx.annotation.DrawableRes;

import com.example.androidpanin.R;

public class ItemData511 {

    private int image;
    private String header;
    private String description;
    private String className;
    private String classId;
    private Class activityClass;
    private static int COUNT_GENERATED = 1;

    public ItemData511() {
        this.image = R.drawable.def_img;
        this.header = "Задача " + COUNT_GENERATED;
        this.description = "Описание случайно сгенерированного элемента";
        this.classId = "511";
        this.className = "511";
        this.activityClass = T_511.class;
        COUNT_GENERATED++;
    }

    public ItemData511(@DrawableRes int image, String header, String description, String className) {
        this.image = image;
        this.header = header;
        this.description = description;
        this.className = className;
        this.classId = className.substring(className.indexOf("T_") + 2);
        try {
            this.activityClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            this.className = "511";
            this.activityClass = T_511.class;
        }
    }

    @DrawableRes
    public int getImage() {
        return image;
    }
    public String getHeader() {
        return header;
    }

    public String getDescription() {
        return description;
    }

    public String getClassName() {
        return className;
    }

    public Class getActivityClass() {
        return activityClass;
    }

    public String getClassId() {
        return classId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getImage());
        builder.append(",");
        builder.append(getHeader());
        builder.append(",");
        builder.append(getDescription());
        builder.append(",");
        builder.append(getClassId());
        builder.append(";");
        return builder.toString();
    }
}
