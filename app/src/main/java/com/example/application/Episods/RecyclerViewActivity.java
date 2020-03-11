package com.example.application.Episods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.application.Adapter.RecyclerViewAdapter;
import com.example.application.Objects.RecyclerViewObject;
import com.example.application.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView rclView;
    List<RecyclerViewObject> list;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        init();
    }

    private void init() {
        rclView = findViewById(R.id.rclView);
        list = prepareData();
        adapter = new RecyclerViewAdapter(list);
        rclView.setAdapter(adapter);
    }

    private ArrayList<RecyclerViewObject> prepareData() {

        return new ArrayList<>();
    }
}
