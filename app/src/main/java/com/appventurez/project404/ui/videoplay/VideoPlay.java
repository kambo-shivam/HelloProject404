package com.appventurez.project404.ui.videoplay;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.appventurez.project404.R;
import com.appventurez.project404.databinding.ActivityVideoPlayBinding;

import java.io.File;

public class VideoPlay extends AppCompatActivity implements View.OnClickListener {
    ActivityVideoPlayBinding binding;
    final static int REQUEST = 222;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_video_play);
        binding.openVideoCamera.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.open_video_camera:
                File file = new File(Environment.getExternalStoragePublicDirectory("MyVideo").getAbsolutePath());
                if (!file.exists())
                    file.mkdirs();
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                /*Uri fileUri = Uri.fromFile(file);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);*/
                startActivityForResult(intent, REQUEST);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST && resultCode == RESULT_OK) {
            if (data != null) {
                Uri uri = data.getData();
                binding.idVideoView.setVideoURI(uri);


            }
        }

    }
}


