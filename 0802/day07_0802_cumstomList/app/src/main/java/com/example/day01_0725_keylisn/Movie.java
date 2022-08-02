package com.example.day01_0725_keylisn;

import android.graphics.drawable.Drawable;

public class Movie {
    Drawable img;
    String title;
    String type;

    public Movie(Drawable image, String s, String s1) {
        this.img = image;
        this.title = s;
        this.type = s1;
    }

    public Drawable getImage() {
        return img;
    }

    public void setImage(Drawable image) {
        this.img = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
