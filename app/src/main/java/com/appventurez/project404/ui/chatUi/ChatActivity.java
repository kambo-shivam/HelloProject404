package com.appventurez.project404.ui.chatUi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.appventurez.project404.R;
import com.appventurez.project404.databinding.ActivityChatBinding;

public class ChatActivity extends AppCompatActivity {
    ActivityChatBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }
}
