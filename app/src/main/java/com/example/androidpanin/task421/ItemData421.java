package com.example.androidpanin.task421;

import android.graphics.drawable.Drawable;

public class ItemData421 {

    private Drawable image;
    private String header;
    private String description;
    private boolean checked;

    public ItemData421(Drawable image, String header, String description, boolean checked) {
        this.image = image;
        this.header = header;
        this.description = description;
        this.checked = checked;
    }

    public Drawable getImage() {
        return image;
    }

    public String getHeader() {
        return header;
    }

    public String getDescription() {
        return description;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

}
