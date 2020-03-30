package com.example.application.Episods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.view.View;

import com.example.application.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CustomAlertActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatEditText txtTitle, txtMsg, txtPositive, txtNegative, txtNeutral, txtColor;
    FloatingActionButton fabAddMsg;
    AppCompatCheckBox chkPositive, chkNegative, chkNeutral, chkDismissable;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_alert);
        setTitle(this.getClass().getSimpleName());
        init();
    }

    private void init() {
        txtTitle = findViewById(R.id.txtTitle);
        txtMsg = findViewById(R.id.txtMsg);
        txtPositive = findViewById(R.id.txtPositive);
        txtNegative = findViewById(R.id.txtNegative);
        txtNeutral = findViewById(R.id.txtNeutral);
        txtColor = findViewById(R.id.txtColor);

        fabAddMsg = findViewById(R.id.fabAddMsg);
        fabAddMsg.setOnClickListener(this);

        chkPositive = findViewById(R.id.chkPositive);
        chkNegative = findViewById(R.id.chkNegative);
        chkNeutral = findViewById(R.id.chkNeutral);
        chkDismissable = findViewById(R.id.chkDismissable);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fabAddMsg) {
            prepareDialog();
        }

    }

    private void prepareDialog() {
        String title = txtTitle.getText().toString().equals("") ? getString(R.string.title) : txtTitle.getText().toString();
        String msg = txtMsg.getText().toString().equals("") ? getString(R.string.message) : txtMsg.getText().toString();
        String color = txtColor.getText().toString().equals("") ? getString(R.string.clr) : txtColor.getText().toString();
        String positive = txtPositive.getText().toString().equals("") ? getString(R.string.message) : txtPositive.getText().toString();
        String negative = txtNegative.getText().toString().equals("") ? getString(R.string.message) : txtNegative.getText().toString();
        String neutral = txtNeutral.getText().toString().equals("") ? getString(R.string.message) : txtNeutral.getText().toString();
    }
}
