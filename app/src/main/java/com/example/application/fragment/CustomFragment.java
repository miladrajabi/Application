package com.example.application.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.Adapter.CustomFragmentAdapter;
import com.example.application.Objects.ChatPageObject;
import com.example.application.R;
import com.example.application.interfaces.IChatMessageListener;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

public class CustomFragment extends Fragment implements View.OnClickListener {
    public static IChatMessageListener listener;

    AppBarLayout appBar;
    RecyclerView rclChat;
    AppCompatTextView txtNoMessage;
    AppCompatEditText editTxtContent;
    AppCompatImageView imgSend, frgBack;
    CustomFragmentAdapter adapter;
    List<ChatPageObject> chatPageObjectList = new ArrayList<>();

    boolean me = true;
    boolean seen = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_custom_fragment, container, false);
        findView(view);
        return view;
    }

    private void findView(View view) {
        appBar = view.findViewById(R.id.appBar);
        rclChat = view.findViewById(R.id.rclChat);
        txtNoMessage = view.findViewById(R.id.txtNoMessage);
        editTxtContent = view.findViewById(R.id.editTxtContent);
        imgSend = view.findViewById(R.id.imgSend);
        frgBack = view.findViewById(R.id.frgBack);


        adapter = new CustomFragmentAdapter(chatPageObjectList);
        rclChat.setAdapter(adapter);
        rclChat.setLayoutManager(new LinearLayoutManager(getActivity()));

        imgSend.setOnClickListener(this);
        frgBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        txtNoMessage.setVisibility(View.GONE);
        switch (v.getId()) {
            case R.id.frgBack: {
                getActivity().finish();
                return;
            }
            case R.id.imgSend: {
                sendMessage();
                break;
            }
        }
    }

    private void sendMessage() {
        me = !me;
        seen = !seen;
        Calendar c = Calendar.getInstance();
        String time = c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE);
        String msg = editTxtContent.getText().toString();
        if (TextUtils.isEmpty(msg)) {
            return;
        } else {
            ChatPageObject obj = new ChatPageObject(msg, me, seen, time, ChatPageObject.TYPE_MESSAGE);
            if (listener != null) {
                listener.onMessage(obj);
            }
            chatPageObjectList.add(obj);

            adapter.notifyDataSetChanged();
            rclChat.smoothScrollToPosition(chatPageObjectList.size());
            editTxtContent.setText("");
        }
    }
}
