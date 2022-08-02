package com.example.day01_0725_keylisn;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String s;
    private String address;
    private String num;

    public Person(String name, String s, String address, String num) {
        this.name = name;
        this.s = s;
        this.address = address;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
