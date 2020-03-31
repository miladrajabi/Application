package com.example.application.Views;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;

import com.example.application.Objects.myDialogObject;
import com.example.application.R;
import com.example.application.app.app;

public class CustomDialog extends AlertDialog implements View.OnClickListener {
    myDialogObject object;

    AppCompatImageView imgTitleIcon, icnPositive, icnNegative, icnNeutral;
    View vwColor;
    LinearLayout lnrParentPositive, lnrParentNegative, lnrParentNeutral, lnrPositive, lnrNegative, lnrNeutral;
    TextView tvPositive, tvNegative, tvNeutral, txtTlt, txvMessage;
    AppCompatEditText acetInput;
    Context context;

    public CustomDialog(@NonNull Context context, myDialogObject object) {
        super(context);
        this.object = object;
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);
        initViews();
        init();

    }

    private void init() {
        txtTlt.setText(object.getTitle());
        imgTitleIcon.setImageResource(object.getTitleIcon());
        txtTlt.setTextColor(context.getResources().getColor(object.getTitleColor()));
        txvMessage.setText(object.getMessage());
        if (object.isInput()) {
            acetInput.setVisibility(View.VISIBLE);
        }
        if (object.isPositive()) {
            lnrParentPositive.setVisibility(View.VISIBLE);
            lnrPositive.setBackgroundColor(context.getResources().getColor(object.getPositiveColor()));
            tvPositive.setText(object.getPositiveMessage());
            icnPositive.setImageResource(object.getPositiveIcon());
        }

        if (object.isNegative()) {
            lnrParentNegative.setVisibility(View.VISIBLE);
            lnrNegative.setBackgroundColor(context.getResources().getColor(object.getNegativeColor()));
            tvNegative.setText(object.getNegativeMessage());
            icnNegative.setImageResource(object.getNegativeIcon());
        }
        if (object.isNeutral()) {
            lnrParentNeutral.setVisibility(View.VISIBLE);
            lnrNeutral.setBackgroundColor(context.getResources().getColor(object.getNeutralColor()));
            tvNeutral.setText(object.getNeutralMessage());
            icnNeutral.setImageResource(object.getNeutralIcon());
        }

    }

    private void initViews() {
        imgTitleIcon = findViewById(R.id.imgTitleIcon);
        icnPositive = findViewById(R.id.icnPositive);
        icnNegative = findViewById(R.id.icnNegative);
        icnNeutral = findViewById(R.id.icnNeutral);

        vwColor = findViewById(R.id.vwColor);

        lnrParentPositive = findViewById(R.id.lnrParentPositive);
        lnrParentNegative = findViewById(R.id.lnrParentNegative);
        lnrParentNeutral = findViewById(R.id.lnrParentNeutral);

        tvPositive = findViewById(R.id.tvPositive);
        tvNegative = findViewById(R.id.tvNegative);
        tvNeutral = findViewById(R.id.tvNeutral);
        txtTlt = findViewById(R.id.txtTlt);
        txvMessage = findViewById(R.id.txvMessage);

        acetInput = findViewById(R.id.acetInput);

        lnrPositive = findViewById(R.id.lnrPositive);
        lnrNegative = findViewById(R.id.lnrNegative);
        lnrNeutral = findViewById(R.id.lnrNeutral);


        lnrPositive.setOnClickListener(this);
        lnrNegative.setOnClickListener(this);
        lnrNeutral.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        int id = v.getId();
        if (id == R.id.lnrPositive) {
            if (object.getListener() != null) {
                object.getListener().onPositiveClick(acetInput.getText().toString());
            }
        }
        if (id == R.id.lnrParentNegative) {

        }
        if (id == R.id.lnrParentNeutral) {

        }
    }
}
