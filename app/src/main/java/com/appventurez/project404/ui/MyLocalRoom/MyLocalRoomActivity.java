package com.appventurez.project404.ui.MyLocalRoom;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.appventurez.project404.R;
import com.appventurez.project404.databinding.ActivityMyLocalRoomBinding;
import com.appventurez.project404.ui.roomdatabase.RecyclerClickListener;

import java.util.ArrayList;
import java.util.List;

public class MyLocalRoomActivity extends AppCompatActivity implements View.OnClickListener, RecyclerClickListener {
    ActivityMyLocalRoomBinding mBinding;
    DataBaseRecycler dataBaseRecycler;
    DataBaseVM dataBaseVM;
    List<LocalDBEntity> localDBEntitie = new ArrayList<>();
    private String itemClicked;
    private int position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_my_local_room);
        mBinding.saveBtn.setOnClickListener(this);
        mBinding.deleteAll.setOnClickListener(this);
        mBinding.deleteOne.setOnClickListener(this);
        mBinding.updateBtn.setOnClickListener(this);
        dataBaseVM = ViewModelProviders.of(this).get(DataBaseVM.class);
        setRecyclerView();
        dataBaseVM.getListLiveData().observe(this, new Observer<List<LocalDBEntity>>() {
            @Override
            public void onChanged(@Nullable List<LocalDBEntity> localDBEntities) {
                localDBEntitie = localDBEntities;
                dataBaseRecycler.setNames(localDBEntities);

            }
        });

    }

    private void setRecyclerView() {
        dataBaseRecycler = new DataBaseRecycler(this, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mBinding.recyclerId.setLayoutManager(layoutManager);
        mBinding.recyclerId.setAdapter(dataBaseRecycler);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save_btn: {

                if (!mBinding.editTextDb.getText().toString().trim().isEmpty()) {
                    LocalDBEntity entity = new LocalDBEntity();
                    entity.setName(mBinding.editTextDb.getText().toString().trim());
                    dataBaseVM.insertName(entity);
                    mBinding.editTextDb.setText("");
                } else
                    Toast.makeText(this, "Enter a word please", Toast.LENGTH_SHORT).show();
            }
            break;

            case R.id.delete_all: {
                dataBaseVM.deleteAll();
            }
            break;

            case R.id.delete_one: {
                dataBaseVM.deleteWord(localDBEntitie.get(position));
                localDBEntitie.remove(position);
                mBinding.editTextDb.setText("");

            }
            break;

            case R.id.update_btn: {
                if (itemClicked != null && itemClicked.length() > 0) {
                    if (position != -1) {
                        dataBaseVM.updateList(new LocalDBEntity(position, mBinding.editTextDb.getText().toString().trim()));
                        mBinding.editTextDb.setText("");

                    }
                }
            }
            break;

        }
    }


    @Override
    public void ItemClick(int pos, String s) {
        if (localDBEntitie != null && localDBEntitie.size() > 0) {
            mBinding.editTextDb.setText(localDBEntitie.get(pos).getName());
            itemClicked = "itemClick";
            position = pos;
            mBinding.editTextDb.setSelection(localDBEntitie.get(pos).getName().length());

        }
    }
}
