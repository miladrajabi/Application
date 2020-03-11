package com.example.application.Objects;

public class RecyclerViewObject {

    private String singerName, songName;
    int like, view, comment;

    public RecyclerViewObject(String singerName, String songName, int like, int view, int comment) {
        this.singerName = singerName;
        this.songName = songName;
        this.like = like;
        this.view = view;
        this.comment = comment;
    }

    public RecyclerViewObject() {
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }
}
