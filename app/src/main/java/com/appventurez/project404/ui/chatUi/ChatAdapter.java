package com.appventurez.project404.ui.chatUi;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyRecyclerView> {

    @NonNull
    @Override
    public MyRecyclerView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerView myRecyclerView, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyRecyclerView extends RecyclerView.ViewHolder {
        public MyRecyclerView(@NonNull View itemView) {
            super(itemView);
        }
    }
}
