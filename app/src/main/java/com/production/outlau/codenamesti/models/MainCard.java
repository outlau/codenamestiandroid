package com.production.outlau.codenamesti.models;

public class MainCard {
    private String name;
    private int thumbnail;
    private int color;
    private Class activity;

    public MainCard(String name, int thumbnail, int color, Class activity) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.color = color;
        this.activity = activity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Class getNextActivity() { return activity; }

    public int getColor() { return color; }
}
