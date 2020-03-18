package com.example.application.Episods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.application.Adapter.RecyclerViewAdapter;
import com.example.application.Objects.RecyclerViewObject;
import com.example.application.R;
import com.example.application.app.app;
import com.example.application.interfaces.RclClickListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity implements View.OnClickListener, RclClickListener {

    RecyclerView rclView;
    List<RecyclerViewObject> list;
    RecyclerViewAdapter adapter;
    public static final int LAYOUT_MANAGER_LINEAR = 1;
    public static final int LAYOUT_MANAGER_GRID = 2;
    int layoutManager = LAYOUT_MANAGER_LINEAR;
    FloatingActionButton fabLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        init();
    }

    private void init() {
        fabLinear = findViewById(R.id.fabLinear);
        fabLinear.setOnClickListener(this);
        rclView = findViewById(R.id.rclView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rclView.setLayoutManager(linearLayoutManager);
        Animation animation = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        LayoutAnimationController animationController = new LayoutAnimationController(animation);
        rclView.setLayoutAnimation(animationController);
        list = prepareData();
        adapter = new RecyclerViewAdapter(list, this);
        rclView.setAdapter(adapter);
    }

    private List<RecyclerViewObject> prepareData() {
        List<RecyclerViewObject> list = new ArrayList<>();
        RecyclerViewObject object = new RecyclerViewObject();

        object.setSongName(getString(R.string.Sina_Shabankhani_song));
        object.setSingerName(getString(R.string.sina_shabankhani));
        object.setSongLike(Integer.parseInt(getString(R.string.sina_shabankhani_like)));
        object.setSongView(Integer.parseInt(getString(R.string.sina_shabankhani_view)));
        object.setSongComment(Integer.parseInt(getString(R.string.sina_shabankhani_comment)));
        object.setSongDate(getString(R.string.sina_shabankhani_date));
        object.setSongImage(R.drawable.behishkinagoo);
        list.add(object);

        object = new RecyclerViewObject();
        object.setSongName(getString(R.string.omid_shabani_song));
        object.setSingerName(getString(R.string.omid_shabani));
        object.setSongLike(Integer.parseInt(getString(R.string.omid_shabani_like)));
        object.setSongView(Integer.parseInt(getString(R.string.omid_shabani_view)));
        object.setSongComment(Integer.parseInt(getString(R.string.omid_shabani_comment)));
        object.setSongDate(getString(R.string.omid_shabani_date));
        object.setSongImage(R.drawable.doretbegardam);
        list.add(object);

        return list;
    }

    private void setLayoutManager() {

        if (layoutManager == LAYOUT_MANAGER_LINEAR) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            fabLinear.setImageResource(R.drawable.ic_dehaze_black_24dp);
            rclView.setLayoutManager(linearLayoutManager);
        } else if (layoutManager == LAYOUT_MANAGER_GRID) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
            fabLinear.setImageResource(R.drawable.ic_add_black_24dp);
            rclView.setLayoutManager(gridLayoutManager);
        }
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fabLinear) {
            if (layoutManager == LAYOUT_MANAGER_LINEAR) {
                layoutManager = LAYOUT_MANAGER_GRID;
            } else {
                layoutManager = LAYOUT_MANAGER_LINEAR;
            }
            setLayoutManager();
        }
    }

    @Override
    public void onClick(RecyclerViewObject object) {
        Intent intent = new Intent(this, ImageViewItemActivity.class);
        intent.putExtra("object", object);
        startActivity(intent);

    }
}


