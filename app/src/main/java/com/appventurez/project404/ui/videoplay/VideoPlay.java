package com.appventurez.project404.ui.videoplay;

import android.content.Intent;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;

import com.appventurez.project404.R;
import com.appventurez.project404.common.base.BaseActivity;
import com.appventurez.project404.databinding.ActivityVideoPlayBinding;
import com.appventurez.project404.ui.roomdatabase.RecyclerClickListener;
import com.iceteck.silicompressorr.SiliCompressor;

import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class VideoPlay extends BaseActivity implements View.OnClickListener, RecyclerClickListener {
    ActivityVideoPlayBinding binding;
    final static int REQUEST = 222;
    VideoListRecycler videoListRecycler;
    VideoPlay mThis;
    Uri uri;
    private String string = "";

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
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                /*StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
                StrictMode.setVmPolicy(builder.build());
                intent.putExtra(MediaStore.EXTRA_OUTPUT, string.getAbsolutePath()); */
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


            }
        }

    }

    @Override
    public void ItemClick(int pos, String string) {

        if (string != null) {

            new AsyncTask<String, Void, String>() {
                @Override
                protected String doInBackground(String... strings) {
                    showHideProgressBar(true);
                    String compresedVideo = "";
                    File file = new File(string);
                    File file1 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath());
                    if (!file1.exists())
                        file1.mkdirs();
                    Log.d("BeforeCompression", String.valueOf((file.length() / (1024 * 1024))));
                    try {
                        compresedVideo = SiliCompressor.with(getApplicationContext()).compressVideo(file.getAbsolutePath(), file1.getAbsolutePath());
                        Log.d("Compression", compresedVideo);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    File file3 = new File(compresedVideo);
                    if (!file3.exists())
                        file3.mkdirs();
                    Log.d("AfterCompression", String.valueOf((file3.length() / (1024 * 1024))));
                    return compresedVideo;
                }

                @Override
                protected void onPostExecute(String videoComp) {
                    showHideProgressBar(false);
                    super.onPostExecute(videoComp);
                    File file3 = new File(videoComp);
                    Log.d("AfterCompression", String.valueOf((file3.length() / (1024 * 1024))));
                    binding.idVideoView.setVideoURI(Uri.fromFile(file3));
                    MediaController mediaController = new MediaController(getApplicationContext());
                    binding.idVideoView.setMediaController(mediaController);
                    mediaController.setAnchorView(binding.idVideoView);
                    binding.idVideoView.start();
                }
            }.execute(string);
        }

    }
}



