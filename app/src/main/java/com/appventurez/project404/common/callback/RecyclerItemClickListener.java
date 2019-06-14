package com.appventurez.project404.common.callback;


import android.view.View;

public interface RecyclerItemClickListener<T> {

    void onItemClick(int position, T item, View v);
}
