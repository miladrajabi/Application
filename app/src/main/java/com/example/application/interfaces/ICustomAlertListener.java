package com.example.application.interfaces;

public interface ICustomAlertListener {
    void onPositiveClick(String inputText);

    void onNegativeClick(String inputText);

    void onNeutralClick(String inputText);

    void onDismissClick(String inputText);
}
