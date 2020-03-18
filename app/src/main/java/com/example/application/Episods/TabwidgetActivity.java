package com.example.application.Episods;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;

import com.example.application.R;

public class TabwidgetActivity extends TabActivity {

    TabWidget tbWidget;
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabwidget);
        setTitle(this.getClass().getSimpleName());
        init();
    }

    private void init() {
        tabHost = findViewById(android.R.id.tabhost);
        tabHost.setup(this.getLocalActivityManager());
        TabSpec tab1 = tabHost.newTabSpec("tab1");
        TabSpec tab2 = tabHost.newTabSpec("tab2");

        tab1.setIndicator("Tab1");
        tab1.setContent(new Intent(this, RecyclerViewActivity.class));

        tab2.setIndicator("Tab2");
        tab1.setContent(new Intent(this, CustomGridViewActivity.class));


        tabHost.addTab(tab1);
        tabHost.addTab(tab2);


    }
}
