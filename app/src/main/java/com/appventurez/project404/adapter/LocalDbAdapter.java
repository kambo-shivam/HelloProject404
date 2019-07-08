package com.appventurez.project404.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appventurez.project404.R;
import com.appventurez.project404.databinding.RecycleAdapterBinding;
import com.appventurez.project404.db.dao.MyEntity;
import com.appventurez.project404.ui.roomdatabase.RecyclerClickListener;

import java.util.List;

public class LocalDbAdapter extends RecyclerView.Adapter<LocalDbAdapter.MyViewHolder> implements View.OnClickListener {
    private RecycleAdapterBinding mBinding;
    private Context context;
    private List<MyEntity> myEntities;
    private RecyclerClickListener clickListener;

    public LocalDbAdapter(Context context, List<MyEntity> myEntities, RecyclerClickListener clickListener) {
        this.context = context;
        this.myEntities = myEntities;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.recycle_adapter, parent, false);
        return new MyViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        notifyDataSetChanged();
        mBinding.name.setText(myEntities.get(position).getName());
        mBinding.time.setText(myEntities.get(position).getTime());
        mBinding.editTextRecycler.setTag(position);
        mBinding.editTextRecycler.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return myEntities.size();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edit_text_recycler: {
                if (clickListener != null) {
                    int pos = (int) v.getTag();
                    String stringData = myEntities.get(pos).getName();
                    clickListener.ItemClick(pos, stringData);
                }
            }

        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        RecycleAdapterBinding mBindingView;

        MyViewHolder(RecycleAdapterBinding itemView) {
            super(itemView.getRoot());
            this.mBindingView = itemView;


        }

    }
}
