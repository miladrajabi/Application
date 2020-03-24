package com.example.application.Adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.application.Objects.ViewPagerObject;
import com.example.application.fragment.ViewPagerFragment;
import com.example.application.fragment.contactsFragment;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    List<ViewPagerObject> objects;


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior, List<ViewPagerObject> objects) {
        super(fm, behavior);
        this.objects = objects;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        ViewPagerFragment fragment = new ViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        bundle.putSerializable("object", objects.get(position));

        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return this.objects.size();
    }
}
