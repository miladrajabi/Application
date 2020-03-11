package com.example.application.Episods;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.RadioGroup;

import com.example.application.Adapter.CustomGridAdapter;
import com.example.application.Objects.CustomListViewObject;
import com.example.application.R;

import java.util.ArrayList;
import java.util.List;

public class CustomGridViewActivity extends AppCompatActivity {

    GridView customGrd;
    List<CustomListViewObject> list;
    CustomGridAdapter adapter;
    CheckBox chkName, chkDesc, chkImg;
    public static boolean nameShow = false;
    public static boolean descShow = false;
    public static boolean imgShow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_grid_view);
        init();
    }

    private void init() {
        customGrd = findViewById(R.id.customGrd);
        chkName = findViewById(R.id.chkName);
        chkDesc = findViewById(R.id.chkDesc);
        chkImg = findViewById(R.id.chkImg);
        checkItems();
        list = prepareData();
        adapter = new CustomGridAdapter(this, 0, list);
        customGrd.setAdapter(adapter);
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
        object = new CustomListViewObject();

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

    private void checkItems() {
        nameShow = chkName.isChecked();
        descShow = chkDesc.isChecked();
        imgShow = chkImg.isChecked();
    }

    public void onCheckboxClicked(View view) {
        checkItems();
        adapter.notifyDataSetChanged();
    }


}
