package com.example.day01_0725_keylisn;

public class Car {
    private int img_id;
    private String s;

    public Car(int img_id, String s) {
        this.img_id = img_id;
        this.s = s;
    }

    public int getImage_id() {
        return img_id;
    }

    public void setImage(int img_id) {
        this.img_id = img_id;
    }

    public String getTitle() {
        return s;
    }

    public void setTitle(String s) {
        this.s = s;
    }
}
