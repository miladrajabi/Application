package com.example.application.Episods;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.application.R;
import com.example.application.app.app;

public class CustomPermissionActivity extends AppCompatActivity {

    Button btnPermission;
    TextView txtPermission;
    public static final int REQUEST_CODE = 115;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_permission);
        setTitle(this.getClass().getSimpleName());
        init();
    }

    private void init() {
        btnPermission = findViewById(R.id.btnPermission);
        txtPermission = findViewById(R.id.txtPermission);
        btnPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPermission()) {
                    myAction();
                } else {
                    txtPermission.setText("No Permission");

                }
            }
        });
    }

    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            int res = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
            if (res == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_CODE);
            }
        } else {
            return true;
        }
        return false;
    }

    private void myAction() {
        txtPermission.setText(R.string.permissionGranted);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    myAction();
                } else {
                    txtPermission.setText(R.string.permissionDenied);
                }
                break;
            }
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

    }
}
