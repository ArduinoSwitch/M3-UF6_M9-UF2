package com.example.m3_uf6_m9_uf2.models;

public class UserModel {
    private int id;
    private String name;
    private String birthday;

    public UserModel(int id,  String birthday, String name) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }
}
