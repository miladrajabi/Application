package com.example.application.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.Objects.contactObject;
import com.example.application.R;
import com.example.application.app.Application;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {

    List<contactObject> objects;

    public ContactsAdapter(List<contactObject> objects) {
        this.objects = objects;
    }

    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(Application.getContext()).inflate(R.layout.layout_contacts_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        contactObject object = objects.get(position);
        holder.txtContact.setText(object.getFullName());


    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgContact;
        TextView txtContact;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgContact = itemView.findViewById(R.id.imgContact);
            txtContact = itemView.findViewById(R.id.txtContact);
        }
    }
}
