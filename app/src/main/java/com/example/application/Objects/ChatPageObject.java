package com.example.application.Objects;

public class ChatPageObject {

    public static final int TYPE_MESSAGE = 0;
    public static final int TYPE_DATE = 1;
    private String txtMessageMe;
    private boolean me, seen;
    String date;
    int type;

    public ChatPageObject(String txtMessageMe) {
        this.txtMessageMe = txtMessageMe;
    }

    public ChatPageObject() {
    }

    public ChatPageObject(String txtMessageMe, boolean me, boolean seen, String date, int type) {
        this.txtMessageMe = txtMessageMe;
        this.me = me;
        this.seen = seen;
        this.date = date;
        this.type = type;
    }

    public String getTxtMessageMe() {
        return txtMessageMe;
    }

    public void setTxtMessageMe(String txtMessageMe) {
        this.txtMessageMe = txtMessageMe;
    }

    public boolean isMe() {
        return me;
    }

    public void setMe(boolean me) {
        this.me = me;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
