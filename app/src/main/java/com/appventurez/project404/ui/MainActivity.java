package com.appventurez.project404.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.appventurez.project404.R;
import com.appventurez.project404.callback.GetCallBack;
import com.appventurez.project404.databinding.ActivityMainBinding;
import com.appventurez.project404.ui.MyLocalRoom.MyLocalRoomActivity;
import com.appventurez.project404.ui.ResponseActivity.GetResponseActivity;
import com.appventurez.project404.ui.fragment.HomeBaseActivity;
import com.appventurez.project404.ui.newpostapi.AnotherPostApi;
import com.appventurez.project404.ui.postapi.PostApiActivity;
import com.appventurez.project404.ui.roomdatabase.LocalDataBaseActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, GetCallBack {
    ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.bttn.setOnClickListener(this);
        activityMainBinding.postApiButton.setOnClickListener(this);
        activityMainBinding.saveDataDb.setOnClickListener(this);
        activityMainBinding.ndDataDb.setOnClickListener(this);
        activityMainBinding.postNewApiButton.setOnClickListener(this);
        activityMainBinding.fragments.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bttn:
                Intent intent = new Intent(this, GetResponseActivity.class);
                startActivity(intent);
                break;
            case R.id.post_api_button:
                Intent postintent = new Intent(this, PostApiActivity.class);
                startActivity(postintent);
                break;
            case R.id.save_data_db:
                Intent dbIntent = new Intent(this, LocalDataBaseActivity.class);
                startActivity(dbIntent);
                break;
            case R.id.nd_data_db:
                Intent database = new Intent(this, MyLocalRoomActivity.class);
                startActivity(database);
                break;
            case R.id.post_new_api_button:
                Intent newpostintent = new Intent(this, AnotherPostApi.class);
                startActivity(newpostintent);
                break;
            case R.id.fragments:
                Intent openFragment = new Intent(this, HomeBaseActivity.class);
                startActivity(openFragment);
                break;

        }
    }

    @Override
    public void getCall(String i) {
        Toast.makeText(this, i, Toast.LENGTH_SHORT).show();
    }
}
