package com.appventurez.project404.ui.MyLocalRoom;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appventurez.project404.R;
import com.appventurez.project404.databinding.RecyclerDbBinding;
import com.appventurez.project404.ui.roomdatabase.RecyclerClickListener;

import java.util.List;

public class DataBaseRecycler extends RecyclerView.Adapter<DataBaseRecycler.MyViewHolder> implements View.OnClickListener {
    private List<LocalDBEntity> localDBEntities;
    private RecyclerClickListener recyclerClickListener;


    public DataBaseRecycler(Context applicationContext, RecyclerClickListener recyclerClickListener) {
        Context context = applicationContext;
        this.recyclerClickListener = recyclerClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerDbBinding mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.recycler_db, parent, false);
        return new MyViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mBinding.textFeed.setText(localDBEntities.get(position).getName());
        holder.mBinding.textFeed.setTag(position);
        holder.mBinding.textFeed.setOnClickListener(this);
        holder.mBinding.textDelete.setOnClickListener(this);
        holder.mBinding.textDelete.setTag(position);
    }

    @Override
    public int getItemCount() {
        if (localDBEntities != null)
            return localDBEntities.size();
        else return 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_feed: {
                int id = (int) v.getTag();
                recyclerClickListener.ItemClick(id, localDBEntities.get(id).getName());
            }
            break;
            case R.id.text_delete: {
                int id = (int) v.getTag();
                recyclerClickListener.ItemClick(id, localDBEntities.get(id).getName());
            }

        }

    }

    public void setNames(List<LocalDBEntity> entities) {
        localDBEntities = entities;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerDbBinding mBinding;

        public MyViewHolder(RecyclerDbBinding itemView) {
            super(itemView.getRoot());
            this.mBinding = itemView;
        }
    }
}
