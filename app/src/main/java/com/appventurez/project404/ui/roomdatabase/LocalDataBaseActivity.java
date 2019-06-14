package com.appventurez.project404.ui.roomdatabase;

import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.appventurez.project404.R;
import com.appventurez.project404.adapter.LocalDbAdapter;
import com.appventurez.project404.databinding.ActivityLocalDataBaseBinding;
import com.appventurez.project404.db.dao.MyEntity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LocalDataBaseActivity extends AppCompatActivity implements View.OnClickListener, RecyclerClickListener {
    ActivityLocalDataBaseBinding mBinding;
    LocalDbAdapter localDbAdapter;
    LocalRepository localRepository;
    List<MyEntity> myEntitie = new ArrayList<>();
    private int position = -1;
    private String stringData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_local_data_base);
        localRepository = new LocalRepository(getApplicationContext());
        mBinding.bttnDone.setOnClickListener(this);
        mBinding.clearBttn.setOnClickListener(this);
        updateList();
    }

    private void updateList() {
        localRepository.getTasks().observe(this, new Observer<List<MyEntity>>() {
            @Override
            public void onChanged(@Nullable List<MyEntity> myEntities) {
                if (myEntities != null && myEntities.size() > 0) {
                    myEntitie = myEntities;
                    setRecyclerView(myEntitie);

                }
                setRecyclerView(myEntities);
            }
        });

    }

    private void setRecyclerView(List<MyEntity> myEntities) {
        localDbAdapter = new LocalDbAdapter(this, myEntities, this);
        mBinding.recyclerView.setHasFixedSize(true);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mBinding.recyclerView.setAdapter(localDbAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bttn_done:
                String name = mBinding.editText.getText().toString();
                Date currentTime = Calendar.getInstance().getTime();
                String time = String.valueOf(currentTime);
                mBinding.editText.getText().toString().trim();
                if (mBinding.editText.getText().toString().trim().length() > 0) {
                    localRepository.insertTask(name, time);
                    updateList();

                }
                mBinding.editText.setText("");
                break;
            case R.id.clear_bttn:
                localRepository.deleteTask();
                updateList();
                break;
        }
    }

    @Override
    public void ItemClick(int i, String string) {
        position = i;
        stringData = string;
        mBinding.editText.setText(string);
        mBinding.editText.setSelection(string.length());


    }

    /*@Override
    public void ItemClick(int string) {

    }*/
}
