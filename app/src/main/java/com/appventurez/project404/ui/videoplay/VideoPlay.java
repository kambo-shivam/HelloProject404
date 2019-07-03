package com.appventurez.project404.ui.videoplay;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.appventurez.project404.R;
import com.appventurez.project404.databinding.ActivityVideoPlayBinding;

public class VideoPlay extends AppCompatActivity {
    ActivityVideoPlayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_video_play);
    }
}
