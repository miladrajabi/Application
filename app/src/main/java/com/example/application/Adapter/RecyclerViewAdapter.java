package com.example.application.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.Objects.RecyclerViewObject;
import com.example.application.R;
import com.example.application.app.Application;
import com.example.application.interfaces.RclClickListener;

import java.util.List;

import io.supercharge.shimmerlayout.ShimmerLayout;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    List<RecyclerViewObject> objects;
    RclClickListener listener;

    public RecyclerViewAdapter() {
    }

    public RecyclerViewAdapter(List<RecyclerViewObject> list, RclClickListener listener) {
        this.objects = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(Application.getContext()).inflate(R.layout.layout_recyclerview_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RecyclerViewObject object = objects.get(position);

        holder.txtSongName.setText(object.getSongName());
        holder.txtSinger.setText(object.getSingerName());
        holder.txtSongComment.setText(object.getSongComment() + "");
        holder.txtSongView.setText(object.getSongView() + "");
        holder.txtSongLike.setText(object.getSongLike() + "");
        holder.txtSongDate.setText(object.getSongDate());
        holder.imgSong.setImageResource(object.getSongImage());

    }

    @Override
    public int getItemCount() {
        return objects.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtSongName, txtSinger, txtSongView, txtSongLike, txtSongDate, txtSongComment;
        ImageView imgSong;
        ShimmerLayout shimmerLayout;
        LinearLayout parent;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            txtSongName = itemView.findViewById(R.id.txtSongName);
            txtSinger = itemView.findViewById(R.id.txtSinger);
            txtSongView = itemView.findViewById(R.id.txtSongView);
            txtSongLike = itemView.findViewById(R.id.txtSongLike);
            txtSongDate = itemView.findViewById(R.id.txtSongDate);
            txtSongComment = itemView.findViewById(R.id.txtSongComment);
            imgSong = itemView.findViewById(R.id.imgSong);
            shimmerLayout = itemView.findViewById(R.id.shimmerLayout);
            shimmerLayout.startShimmerAnimation();
            parent = itemView.findViewById(R.id.parent);
            parent.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(objects.get(getAdapterPosition()));
        }
    }
}

