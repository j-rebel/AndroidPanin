package com.example.androidpanin.task511;

import android.graphics.Bitmap;

public class ItemData511 {

    private Bitmap image;
    private String header;
    private String description;
    private String className;
    private String classId;
    private Class activityClass;

    public ItemData511(Bitmap image, String header, String description, String className) {
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

    public Bitmap getImage() {
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
}
