package com.appventurez.project404.ui.filehandling;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.appventurez.project404.R;
import com.appventurez.project404.databinding.ActivityFileHandlingBinding;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.Manifest.permission_group.CAMERA;

public class FileHandlingActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int PERMISSION_REQUEST_CODE = 200;
    ActivityFileHandlingBinding mBinding;
    private String file = "internalFile";
    private File externalFile;
    private String filename = "download";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_file_handling);
        externalFile = new File(getExternalFilesDir(file), filename);

        mBinding.bttnSaveFile.setOnClickListener(this);
        mBinding.bttnReadFile.setOnClickListener(this);
        if (!checkPermission()) {
            requestPermission();
        }
        try {
            Toast.makeText(this, Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "Notiicatio", Toast.LENGTH_LONG).show();
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            }
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "Notiications");
            if (!file.exists()) {
                file.createNewFile();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bttn_save_file: {
                // generateNoteOnSD(getApplicationContext(), "filewithname", "appendthis");
                //setFileInExternalStorage();

                setDataInExternalStorage();
            }
            break;
            case R.id.bttn_read_file: {
                readFileFromExternalStorage();

            }
            break;
        }
    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA);

        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {

        ActivityCompat.requestPermissions(this, new String[]{WRITE_EXTERNAL_STORAGE, CAMERA}, PERMISSION_REQUEST_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0) {

                    boolean locationAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean cameraAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if (locationAccepted && cameraAccepted) {

                    }
                    //  Snackbar.make(view, "Permission Granted, Now you can access location data and camera.", Snackbar.LENGTH_LONG).show();
                    else {
                    }

                    //   Snackbar.make(view, "Permission Denied, You cannot access location data and camera.", Snackbar.LENGTH_LONG).show();

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE)) {
                            showMessageOKCancel("You need to allow access to both the permissions",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                requestPermissions(new String[]{ACCESS_FINE_LOCATION, CAMERA},
                                                        PERMISSION_REQUEST_CODE);
                                            }
                                        }
                                    });
                            return;
                        }
                    }

                }
                break;

        }


    }


    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(FileHandlingActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }


    private boolean isExternalStorageWritable() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            Log.i("State", "Yes, it is writable!");
            return true;
        } else {
            return false;
        }
    }

    private void setDataInExternalStorage() {
        File file = new File(Environment.getExternalStoragePublicDirectory("MyProject404").getAbsolutePath());
        if (!file.exists()) {
            file.mkdir();
        }
        File file1 = new File(file.getAbsolutePath(), "MyChild");
        if (!file1.exists()) {
            file1.mkdir();
        }
        File file2 = new File(file1, "child2.txt");
        try {
            FileOutputStream outputStream = new FileOutputStream(file2);
            outputStream.write(mBinding.idEditTxt.getText().toString().trim().getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readFileFromExternalStorage() {
        File file = new File(Environment.getExternalStorageDirectory(), "MyProject404");
        File file1 = new File(file.getAbsolutePath(), "MyChild");
        File file2 = new File(file1, "child2.txt");
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(file2);

            int c;
            StringBuilder temp = new StringBuilder();
            while ((c = inputStream.read()) != -1) {
                temp.append(Character.toString((char) c));
            }
            mBinding.SaveFileRead.setText(temp);
            String state = Environment.getExternalStorageState();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateNoteOnSD(Context context, String sFileName, String sBody) {
        try {
            File root = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + externalFile);
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, sFileName);
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(sBody);
            writer.flush();
            writer.close();
            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setFileInExternalStorage() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(externalFile);
            outputStream.write(mBinding.idEditTxt.getText().toString().trim().getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readFileFromStorage() {
        FileInputStream inputStream = null;
        try {
            inputStream = openFileInput(file);

            int c;
            StringBuilder temp = new StringBuilder();
            while ((c = inputStream.read()) != -1) {
                temp.append(Character.toString((char) c));
            }
            mBinding.SaveFileRead.setText(temp);
            String state = Environment.getExternalStorageState();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setFileInStorage() {
        try {
            FileOutputStream outputStream = openFileOutput(file, MODE_PRIVATE);
            outputStream.write(mBinding.idEditTxt.getText().toString().trim().getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

