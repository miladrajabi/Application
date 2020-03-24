package com.example.application.Objects;

import android.graphics.Color;

import androidx.annotation.ColorRes;
import androidx.annotation.StringDef;

import com.example.application.app.Application;

import java.io.Serializable;

public class ViewPagerObject implements Serializable {
    String title;
    int imageResId, color;

    public ViewPagerObject(String title, int imageResId, int color) {
        this.title = title;
        this.imageResId = imageResId;
        this.color = color;
    }

    public ViewPagerObject() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public int getColor() {
        return color;
    }

    public void setColor(@ColorRes int color) {
        this.color = Application.getContext().getResources().getColor(color);
    }

    public void setColor(String color) {
        this.color = Color.parseColor(color);
    }

    public void setColor(int R, int G, int B) {
        this.color = Color.argb(1, R, G, B);
    }
}
