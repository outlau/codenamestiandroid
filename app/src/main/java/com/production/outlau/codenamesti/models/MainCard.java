package com.production.outlau.codenamesti.models;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class MainCard {
    private String name;
    private String subTitle;
    private int thumbnail;
    private int color;
    private View.OnClickListener onClickListener;


    public MainCard(String name, String subTitle, int thumbnail, int color,  View.OnClickListener onClickListener) {
        this.name = name;
        this.subTitle = subTitle;
        this.thumbnail = thumbnail;
        this.color = color;
        this.onClickListener = onClickListener;
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

    public View.OnClickListener getOnClickListener() { return onClickListener; }

    public String getSubTitle() { return subTitle; }

    public int getColor() { return color; }
}
