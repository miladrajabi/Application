package com.example.application.Objects;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;

import com.example.application.R;
import com.example.application.interfaces.ICustomAlertListener;

public class myDialogObject {

    String message;
    String title;
    String color;
    String positiveMessage;
    String negativeMessage;
    String neutralMessage;

    boolean positive, negative, neutral;

    ICustomAlertListener listener;


    @DrawableRes
    int positiveIcon = R.drawable.ic_arrow_back_black_24dp;
    @DrawableRes
    int negativeIcon = R.drawable.ic_arrow_back_black_24dp;
    @DrawableRes
    int neutralIcon = R.drawable.ic_arrow_back_black_24dp;
    @DrawableRes
    int titleIcon = R.drawable.ic_arrow_back_black_24dp;

    @ColorRes
    int positiveColor = R.color.design_default_color_primary_dark;
    @ColorRes
    int negativeColor = R.color.design_default_color_primary_dark;
    @ColorRes
    int neutralColor = R.color.design_default_color_primary_dark;
    @ColorRes
    int titleColor = R.color.design_default_color_primary_dark;

    boolean dissMissAble = true;
    boolean input = false;

    public myDialogObject() {
    }


    public String getMessage() {
        return message;
    }

    public myDialogObject setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public myDialogObject setTitle(String title) {
        this.title = title;
        return this;

    }

    public String getColor() {
        return color;
    }

    public myDialogObject setColor(String color) {
        this.color = color;
        return this;

    }

    public String getPositiveMessage() {
        return positiveMessage;
    }

    public myDialogObject setPositiveMessage(String positiveMessage) {
        this.positiveMessage = positiveMessage;
        return this;

    }

    public String getNegativeMessage() {
        return negativeMessage;
    }

    public myDialogObject setNegativeMessage(String negativeMessage) {
        this.negativeMessage = negativeMessage;
        return this;

    }

    public String getNeutralMessage() {
        return neutralMessage;
    }

    public myDialogObject setNeutralMessage(String neutralMessage) {
        this.neutralMessage = neutralMessage;
        return this;

    }

    public boolean isPositive() {
        return positive;
    }

    public myDialogObject setPositive(boolean positive) {
        this.positive = positive;
        return this;

    }

    public boolean isNegative() {
        return negative;
    }

    public myDialogObject setNegative(boolean negative) {
        this.negative = negative;
        return this;

    }

    public boolean isNeutral() {
        return neutral;
    }

    public myDialogObject setNeutral(boolean neutral) {
        this.neutral = neutral;
        return this;

    }

    public int getPositiveIcon() {
        return positiveIcon;
    }

    public myDialogObject setPositiveIcon(int positiveIcon) {
        this.positiveIcon = positiveIcon;
        return this;

    }

    public int getNegativeIcon() {
        return negativeIcon;
    }

    public myDialogObject setNegativeIcon(int negativeIcon) {
        this.negativeIcon = negativeIcon;
        return this;

    }

    public int getNeutralIcon() {
        return neutralIcon;
    }

    public myDialogObject setNeutralIcon(int neutralIcon) {
        this.neutralIcon = neutralIcon;
        return this;

    }

    public int getTitleIcon() {
        return titleIcon;
    }

    public myDialogObject setTitleIcon(int titleIcon) {
        this.titleIcon = titleIcon;
        return this;

    }

    public int getPositiveColor() {
        return positiveColor;
    }

    public myDialogObject setPositiveColor(int positiveColor) {
        this.positiveColor = positiveColor;
        return this;

    }

    public int getNegativeColor() {
        return negativeColor;
    }

    public myDialogObject setNegativeColor(int negativeColor) {
        this.negativeColor = negativeColor;
        return this;

    }

    public int getNeutralColor() {
        return neutralColor;
    }

    public myDialogObject setNeutralColor(int neutralColor) {
        this.neutralColor = neutralColor;
        return this;

    }

    public int getTitleColor() {
        return titleColor;
    }

    public myDialogObject setTitleColor(int titleColor) {
        this.titleColor = titleColor;
        return this;

    }

    public ICustomAlertListener getListener() {
        return listener;
    }

    public myDialogObject setListener(ICustomAlertListener listener) {
        this.listener = listener;
        return this;
    }

    public boolean isDissMissAble() {
        return dissMissAble;
    }

    public myDialogObject setDissMissAble(boolean dissMissAble) {
        this.dissMissAble = dissMissAble;
        return this;
    }

    public boolean isInput() {
        return input;
    }

    public myDialogObject setInput(boolean input) {
        this.input = input;
        return this;

    }
}
