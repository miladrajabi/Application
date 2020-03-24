package com.example.application.Adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.Objects.ChatPageObject;
import com.example.application.R;
import com.example.application.app.Application;

import java.util.List;

public class CustomFragmentAdapter extends RecyclerView.Adapter<CustomFragmentAdapter.ChatPageViewHolder> {

    List<ChatPageObject> objects;

    public CustomFragmentAdapter(List<ChatPageObject> objects) {
        this.objects = objects;
    }

    @NonNull
    @Override
    public ChatPageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(Application.getContext()).inflate(R.layout.layout_chat_me_row, parent, false);

        return new ChatPageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatPageViewHolder holder, int position) {
        ChatPageObject object = objects.get(position);
        holder.txtMessageMe.setText(object.getTxtMessageMe());
        holder.txtTime.setText(object.getDate());

        if (!object.isSeen()) {
            holder.imgSeen.setVisibility(View.GONE);
        } else {
            holder.imgSeen.setVisibility(View.VISIBLE);
        }
        if (!object.isMe()) {
            holder.txtMessageMe.setTextColor(Color.DKGRAY);
            holder.imgUser.setImageResource(R.drawable.male_icon);
        } else {
            holder.txtMessageMe.setTextColor(Color.BLACK);
            holder.imgUser.setImageResource(R.drawable.female_icon);

        }
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class ChatPageViewHolder extends RecyclerView.ViewHolder {

        TextView txtMessageMe, txtTime;
        AppCompatImageView imgSeen;
        ImageView imgUser;

        public ChatPageViewHolder(@NonNull View itemView) {
            super(itemView);

            txtMessageMe = itemView.findViewById(R.id.txtMessageMe);
            txtTime = itemView.findViewById(R.id.txtTime);
            imgSeen = itemView.findViewById(R.id.imgSeen);
            imgUser = itemView.findViewById(R.id.imgUser);
        }
    }
}
