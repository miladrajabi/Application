package com.example.application.Episods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.application.Adapter.ViewPagerAdapter;
import com.example.application.Objects.ViewPagerObject;
import com.example.application.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager viewPg;
    Button btnNext, btnBack;
    TextView txtName;
    List<ViewPagerObject> list;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        setTitle(this.getClass().getSimpleName());
        init();
    }

    private void init() {
        viewPg = findViewById(R.id.viewPg);
        btnNext = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);
        txtName = findViewById(R.id.txtName);
        btnNext.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        list = prepareData();
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), 1, list);
        viewPg.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        int len = this.list.size();
        int position = viewPg.getCurrentItem();

        switch (v.getId()) {
            case R.id.btnNext: {
                if (position < len) {
                    viewPg.setCurrentItem(position + 1);
                }
                break;
            }
            case R.id.btnBack: {
                if (position > 0) {
                    viewPg.setCurrentItem(position - 1);
                }
                break;
            }
        }

    }

    private List<ViewPagerObject> prepareData() {
        List<ViewPagerObject> list = new ArrayList<>();

        ViewPagerObject object = new ViewPagerObject();
        object.setColor(25, 69, 108);
        object.setImageResId(R.drawable.devils_men);
        object.setTitle("devils_men");
        list.add(object);

        object = new ViewPagerObject();
        object.setColor(11, 10, 5);
        object.setImageResId(R.drawable.pledge);
        object.setTitle("pledge");
        list.add(object);

        object = new ViewPagerObject();
        object.setColor(124, 134, 110);
        object.setImageResId(R.drawable.highwaymen);
        object.setTitle("highwaymen");
        list.add(object);


        return list;
    }
}
