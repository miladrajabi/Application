package com.example.application.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.application.Objects.CustomListViewObject;
import com.example.application.R;
import com.example.application.app.Application;

import java.util.List;

public class CustomlistViewAdapter extends ArrayAdapter<CustomListViewObject> {

    List<CustomListViewObject> objects;

    public CustomlistViewAdapter(@NonNull Context context, int resource, @NonNull List<CustomListViewObject> objects) {
        super(context, resource, objects);
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) Application.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_customlistview_row, parent, false);
        ImageView imgCustom = view.findViewById(R.id.imgCustom);
        TextView txtCustomTitle = view.findViewById(R.id.txtCustomTitle);
        TextView txtCustomDesc = view.findViewById(R.id.txtCustomDesc);

        txtCustomTitle.setText(objects.get(position).getTitle());
        txtCustomDesc.setText(objects.get(position).getDescription());
        imgCustom.setImageResource(objects.get(position).getImageResourceId());

        return view;
    }
}
