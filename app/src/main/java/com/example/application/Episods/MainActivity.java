package com.example.application.Episods;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.application.Adapter.CustomlistViewAdapter;
import com.example.application.Objects.CustomListViewObject;
import com.example.application.R;
import com.example.application.app.app;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView lstCustom;
    List<CustomListViewObject> list;
    CustomlistViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        lstCustom = findViewById(R.id.lstCustom);
        list = prepareData();
        adapter = new CustomlistViewAdapter(this, 0, list);
        lstCustom.setAdapter(adapter);
        lstCustom.setOnItemClickListener(this);
    }

    private List<CustomListViewObject> prepareData() {
        List<CustomListViewObject> lst = new ArrayList<>();
        CustomListViewObject object = new CustomListViewObject();

        object.setTitle(getString(R.string.devils_men));
        object.setDescription(getString(R.string.devils_men_desc));
        object.setImageResourceId(R.drawable.devils_men);
        lst.add(object);
        object = new CustomListViewObject();
        object.setTitle(getString(R.string.last_laugh));
        object.setDescription(getString(R.string.last_laugh_desc));
        object.setImageResourceId(R.drawable.last_laugh);
        lst.add(object);

        return lst;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        app.toast(list.get(position).getTitle());
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }
}
