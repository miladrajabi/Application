package com.example.application.Episods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.view.View;

import com.example.application.Objects.myDialogObject;
import com.example.application.R;
import com.example.application.Views.CustomDialog;
import com.example.application.app.app;
import com.example.application.interfaces.ICustomAlertListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CustomAlertActivity extends AppCompatActivity implements View.OnClickListener, ICustomAlertListener {

    AppCompatEditText txtTitle, txtMsg, txtPositive, txtNegative, txtNeutral, txtColor;
    FloatingActionButton fabAddMsg;
    AppCompatCheckBox chkPositive, chkNegative, chkNeutral, chkDismissable, chkInput;
    CustomDialog dialog;

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
        chkInput = findViewById(R.id.chkInput);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fabAddMsg) {
            prepareDialog();
        }

    }

    private void prepareDialog() {
        String msg = txtMsg.getText().toString().equals("") ? getString(R.string.message) : txtMsg.getText().toString();
        String title = txtTitle.getText().toString().equals("") ? getString(R.string.title) : txtTitle.getText().toString();
        String color = txtColor.getText().toString().equals("") ? getString(R.string.clr) : txtColor.getText().toString();
        String positive = txtPositive.getText().toString().equals("") ? getString(R.string.message) : txtPositive.getText().toString();
        String negative = txtNegative.getText().toString().equals("") ? getString(R.string.message) : txtNegative.getText().toString();
        String neutral = txtNeutral.getText().toString().equals("") ? getString(R.string.message) : txtNeutral.getText().toString();

        myDialogObject object = new myDialogObject().setTitle(title)
                .setMessage(msg)
                .setColor(color)
                .setPositiveMessage(positive)
                .setNegativeMessage(negative)
                .setNeutralMessage(neutral)
                .setPositive(chkPositive.isChecked())
                .setNeutral(chkNeutral.isChecked())
                .setNegative(chkNegative.isChecked())
                .setDissMissAble(chkDismissable.isChecked())
                .setInput(chkInput.isChecked())
                .setTitleIcon(R.drawable.ic_contacts_black_24dp)
                .setPositiveIcon(R.drawable.ic_check_black_24dp)
                .setNegativeIcon(R.drawable.ic_arrow_back_black_24dp)
                .setNeutralIcon(R.drawable.ic_child_care_black_24dp)
                .setTitleColor(R.color.colorAccent)
                .setPositiveColor(R.color.telegramColor)
                .setNegativeColor(R.color.colorPrimary)
                .setNeutralColor(R.color.color2)
                .setListener(this);

        dialog = new CustomDialog(this, object);
        dialog.setCancelable(object.isDissMissAble());
        dialog.show();
    }

    @Override
    public void onPositiveClick(String inputText) {
        dialog.hide();
        dialog = null;
        app.toast(inputText);
    }

    @Override
    public void onNegativeClick(String inputText) {

    }

    @Override
    public void onNeutralClick(String inputText) {

    }

    @Override
    public void onDismissClick(String inputText) {

    }
}
