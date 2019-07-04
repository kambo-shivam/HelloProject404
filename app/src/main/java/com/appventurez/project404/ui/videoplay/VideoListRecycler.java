package com.appventurez.project404.ui.videoplay;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appventurez.project404.R;
import com.appventurez.project404.databinding.RecycleVideoListBinding;
import com.appventurez.project404.ui.roomdatabase.RecyclerClickListener;

import java.io.File;
import java.util.ArrayList;

public class VideoListRecycler extends RecyclerView.Adapter<VideoListRecycler.MyViewHolder> {
    ArrayList<String> allVideoList;

    private RecyclerClickListener clickListener;

    public VideoListRecycler(Context context, ArrayList<String> allVideoList, RecyclerClickListener clickListener) {
        this.allVideoList = allVideoList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecycleVideoListBinding mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.recycle_video_list, parent, false);
        return new VideoListRecycler.MyViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String filename = allVideoList.get(position).substring(allVideoList.get(position).lastIndexOf("/") + 1);
        holder.mBinding.videoName.setText(filename);
        File file = new File(allVideoList.get(position));
        holder.mBinding.videoSize.setText("" + (file.length()) / (1024 * 1024));
        holder.mBinding.videoName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.ItemClick(position, allVideoList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return allVideoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RecycleVideoListBinding mBinding;

        public MyViewHolder(RecycleVideoListBinding itemView) {
            super(itemView.getRoot());
            this.mBinding = itemView;
        }
    }
}
