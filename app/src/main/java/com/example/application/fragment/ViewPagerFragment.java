package com.example.application.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.application.Objects.ViewPagerObject;
import com.example.application.R;

public class ViewPagerFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewPagerObject object = (ViewPagerObject) getArguments().getSerializable("object");
        View view = inflater.inflate(R.layout.layout_viewpager_row, container, false);
        ImageView imgSh = view.findViewById(R.id.imgSh);
        imgSh.setImageResource(object.getImageResId());
        return view;
    }
}
