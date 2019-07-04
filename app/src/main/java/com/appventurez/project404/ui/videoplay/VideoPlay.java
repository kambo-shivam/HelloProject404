package com.appventurez.project404.ui.videoplay;

import android.content.Intent;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;

import com.appventurez.project404.R;
import com.appventurez.project404.common.base.BaseActivity;
import com.appventurez.project404.databinding.ActivityVideoPlayBinding;
import com.appventurez.project404.ui.roomdatabase.RecyclerClickListener;
import com.iceteck.silicompressorr.SiliCompressor;

import java.io.File;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class VideoPlay extends BaseActivity implements View.OnClickListener, RecyclerClickListener {
    ActivityVideoPlayBinding binding;
    final static int REQUEST = 222;
    VideoListRecycler videoListRecycler;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_video_play);
        binding.openVideoCamera.setOnClickListener(this);
        binding.playVideo.setOnClickListener(this);

        getAllMedia();
        setRecyclerView();
    }

    private void setRecyclerView() {
        videoListRecycler = new VideoListRecycler(this, getAllMedia(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recyclerVideoList.setLayoutManager(layoutManager);
        binding.recyclerVideoList.setAdapter(videoListRecycler);

    }

    public ArrayList<String> getAllMedia() {
        HashSet<String> videoItemHashSet = new HashSet<>();

        String[] projection = {MediaStore.Video.VideoColumns.DATA, MediaStore.Video.Media.DISPLAY_NAME};
        Cursor cursor = getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, projection, null, null, null);
        try {
            cursor.moveToFirst();
            do {
                videoItemHashSet.add((cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA))));
            } while (cursor.moveToNext());

            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<String> downloadedList = new ArrayList<>(videoItemHashSet);
        return downloadedList;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.open_video_camera:
                String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

                File file = new File(Environment.getExternalStoragePublicDirectory("MyVideo" + currentDateTimeString).getAbsolutePath());
                if (!file.exists())
                    file.mkdirs();
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                Uri fileUri = Uri.fromFile(file);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                startActivityForResult(intent, REQUEST);
                break;
            case R.id.play_video:
                if (uri != null) {
                    binding.idVideoView.setVideoURI(uri);
                    MediaController mediaController = new MediaController(this);
                    binding.idVideoView.setMediaController(mediaController);
                    mediaController.setAnchorView(binding.idVideoView);
                    binding.idVideoView.start();
                }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST && resultCode == RESULT_OK) {
            if (data != null) {
                uri = data.getData();

            }
        }

    }

    @Override
    public void ItemClick(int pos, String string) {

        if (string != null) {

/*
            binding.idVideoView.setVideoURI(Uri.parse(string));
            MediaController mediaController = new MediaController(getApplicationContext());
            binding.idVideoView.setMediaController(mediaController);
            mediaController.setAnchorView(binding.idVideoView);
            binding.idVideoView.start();
*/
            new AsyncTask<String, Void, String>() {
                @Override
                protected String doInBackground(String... strings) {
                    String compresedVideo = "";
                    File file=new File(string);
                    File file1=new File(Environment.getExternalStoragePublicDirectory("you").getAbsolutePath());
                    Log.d("BeforeCompression", String.valueOf((file.length()/(1024*1024))));
                    try {
                        compresedVideo=SiliCompressor.with(getApplicationContext()).compressVideo(string,file1.getAbsolutePath());

                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    return compresedVideo;
                }

                @Override
                protected void onPostExecute(String videoComp) {
                    super.onPostExecute(videoComp);
                    File file3=new File(videoComp);
                    Log.d("AfterCompression", String.valueOf((file3.length()/(1024*1024))));

                }
            }.execute();

        }

    }
}


