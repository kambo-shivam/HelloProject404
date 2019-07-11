package com.appventurez.project404.ui.chatUi;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.appventurez.project404.R;
import com.appventurez.project404.adapter.LocalDbAdapter;
import com.appventurez.project404.databinding.ActivityChatBinding;
import com.appventurez.project404.db.dao.MyEntity;

import java.util.List;

public class ChatActivity extends AppCompatActivity {
    ActivityChatBinding mBinding;
    ChatAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_chat);
        setRecyclerView();
    }

    private void setRecyclerView() {
        adapter = new ChatAdapter(getApplicationContext());/*
        mBinding.recyclerView.setHasFixedSize(true);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mBinding.recyclerView.setAdapter(localDbAdapter);*/
    }

}
