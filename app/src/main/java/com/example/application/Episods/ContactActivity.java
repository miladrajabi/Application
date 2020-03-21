package com.example.application.Episods;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import com.example.application.Adapter.ContactsAdapter;
import com.example.application.Objects.contactObject;
import com.example.application.R;
import com.example.application.app.app;
import com.example.application.fragment.contactsFragment;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 115;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        setTitle(this.getClass().getSimpleName());
        startContact();
    }

    private void startContact() {

        if (checkPermission()) {
            contactsFragment.lister.onPermissionChange(true);
        }
    }


    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            int res = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
            if (res == PackageManager.PERMISSION_GRANTED) {
                contactsFragment.lister.onPermissionChange(true);
                return true;
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_CODE);
            }
        } else {
            contactsFragment.lister.onPermissionChange(true);
            return true;
        }
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    contactsFragment.lister.onPermissionChange(true);
                } else {
                    startContact();
                    app.toast(getString(R.string.permissionDenied));
                }
                break;
            }
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

    }
}
