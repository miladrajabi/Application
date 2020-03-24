package com.example.application.Episods;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.application.Objects.ChatPageObject;
import com.example.application.R;
import com.example.application.app.app;
import com.example.application.fragment.CustomFragment;
import com.example.application.interfaces.IChatMessageListener;

public class CustomFragmentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_fragment);
        setTitle(this.getClass().getSimpleName());
        init();
    }

    private void init() {

        CustomFragment.listener = new IChatMessageListener() {
            @Override
            public void onMessage(ChatPageObject msg) {
//                app.toast(msg.getTxtMessageMe());
            }
        };

    }
}
