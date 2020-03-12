package com.example.application.Episods;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.application.Objects.RecyclerViewObject;
import com.example.application.R;

import io.supercharge.shimmerlayout.ShimmerLayout;


public class ImageViewItemActivity extends AppCompatActivity {

    TextView txtSongName, txtSinger, txtSongView, txtSongLike, txtSongDate, txtSongComment;
    ImageView imgSong;
    ShimmerLayout shimmerLayout;
    LinearLayout parent;
    RecyclerViewObject object;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recyclerview_row);
        object = (RecyclerViewObject) getIntent().getSerializableExtra("object");
        setTitle(object.getSongName());
        init(object);
    }

    private void init(RecyclerViewObject object) {
        txtSongName = findViewById(R.id.txtSongName);
        txtSinger = findViewById(R.id.txtSinger);
        txtSongView = findViewById(R.id.txtSongView);
        txtSongLike = findViewById(R.id.txtSongLike);
        txtSongDate = findViewById(R.id.txtSongDate);
        txtSongComment = findViewById(R.id.txtSongComment);
        imgSong = findViewById(R.id.imgSong);
        shimmerLayout = findViewById(R.id.shimmerLayout);
        shimmerLayout.startShimmerAnimation();
        parent = findViewById(R.id.parent);

        txtSongName.setText(object.getSongName());
        txtSinger.setText(object.getSingerName());
        txtSongComment.setText(object.getSongComment() + "");
        txtSongView.setText(object.getSongView() + "");
        txtSongLike.setText(object.getSongLike() + "");
        txtSongDate.setText(object.getSongDate());
        imgSong.setImageResource(object.getSongImage());
    }
}
