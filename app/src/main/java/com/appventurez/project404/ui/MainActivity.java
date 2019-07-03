package com.appventurez.project404.ui;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
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
import com.appventurez.project404.ui.videoplay.VideoPlay;
import com.appventurez.project404.utility.session.SessionManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, GetCallBack {
    ActivityMainBinding activityMainBinding;
    private boolean rememberPermission = false;

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
        activityMainBinding.bttnPermission.setOnClickListener(this);
        activityMainBinding.videoPlay.setOnClickListener(this);
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
            case R.id.video_play:
                Intent videoPlay = new Intent(this, VideoPlay.class);
                startActivity(videoPlay);
                break;
            case R.id.bttn_permission:
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                    openCamera();
                } else {
                    askUserForPermission();
                }
                break;

        }
    }

    private void askUserForPermission() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) !=
                PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) !=
                    PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 10);
            }
        } else {
            openCamera();
        }
    }

    private void showAlert() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("App needs to access the Camera.");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "DONT ALLOW",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        //finish();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "ALLOW",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[]{Manifest.permission.CAMERA},
                                10);

                    }
                });
        alertDialog.show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 10: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openCamera();
                }
            }

            break;

        }
        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            showSettingsAlert();
        }

    }


    private void showSettingsAlert() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("App needs to access the Camera.");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "DONT ALLOW",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        //finish();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "SETTINGS",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        startInstalledAppDetailsActivity(MainActivity.this);

                    }
                });
        alertDialog.show();
    }

    private void startInstalledAppDetailsActivity(MainActivity mainActivity) {
        final Intent i = new Intent();
        i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        i.addCategory(Intent.CATEGORY_DEFAULT);
        i.setData(Uri.parse("package:" + getApplicationContext().getPackageName()));
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        getApplicationContext().startActivity(i);

    }

    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }

    @Override
    public void getCall(String i) {
        Toast.makeText(this, i, Toast.LENGTH_SHORT).show();
    }
}
