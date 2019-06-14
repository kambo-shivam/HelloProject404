package com.appventurez.project404.ui.newpostapi;

import android.app.ProgressDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.appventurez.project404.R;
import com.appventurez.project404.databinding.ActivityAnotherPostApiBinding;
import com.appventurez.project404.ui.newpostapi.api.ErrorHandler;
import com.appventurez.project404.utility.constant.AppConstants;
import com.appventurez.project404.vo.RequestDate;
import com.bumptech.glide.Glide;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AnotherPostApi extends AppCompatActivity implements View.OnClickListener {
    ActivityAnotherPostApiBinding mBinding;
    AnotherPostApiVM mViewModel;
    ProgressBar progressBar;
    private String flag0 = "";
    private String fileName = "";
    private String folder = "";
    private File apkStorage;
    private String downloadFileName;
    private File outputFile;
    private Bitmap bitmap;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_another_post_api);
        setProgressBarOrDialog();
        mBinding.imageFlag.setOnClickListener(this);
        mViewModel = ViewModelProviders.of(this).get(AnotherPostApiVM.class);
        hitNewPostApi();
        hitIsdCodeApi();
        readImageFile();
    }

    private void downloadAndSetImage() {
        if (!flag0.isEmpty()) {
            new AsyncTask<String, Void, Void>() {
                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setProgress(0);
                }

                @Override
                protected Void doInBackground(String... strings) {
                    try {
                        URL url = new URL(flag0);//Create Download URl
                        HttpURLConnection c = (HttpURLConnection) url.openConnection();//Open Url Connection
                        c.setRequestMethod("GET");//Set Request Method to "GET" since we are grtting data
                        c.connect();//connect the URL Connection

                        //If Connection response is not OK then show Logs
                        if (c.getResponseCode() != HttpURLConnection.HTTP_OK) {
                            Log.e("TAG", "Server returned HTTP " + c.getResponseCode()
                                    + " " + c.getResponseMessage());

                        }
                        InputStream inputStream = new URL(flag0).openStream();   // Download Image from URL
                        bitmap = BitmapFactory.decodeStream(inputStream);       // Decode Bitmap

                        inputStream.close();


                        //Get File if SD card is present
                        if (new CheckForSDCard().isSDCardPresent()) {

                            apkStorage = new File(
                                    Environment.getExternalStoragePublicDirectory("MyFile1").getAbsolutePath());
                        } else
                            Toast.makeText(getApplicationContext(), "Oops!! There is no SD Card.", Toast.LENGTH_SHORT).show();

                        //If File is not present create directory
                        if (!apkStorage.exists()) {
                            apkStorage.mkdir();
                            Log.e("TAG===>", "Directory Created.");
                        }
                        FileOutputStream fos = new FileOutputStream(apkStorage.getAbsolutePath() + "MyFile.jpg");//Get OutputStream for NewFile Location
                        try {
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos); // bmp is your Bitmap instance
                            // PNG is a lossless format, the compression factor (100) is ignored
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        fos.close();

                    } catch (Exception e) {

                        //Read exception if something went wrong
                        e.printStackTrace();
                        outputFile = null;
                        Log.e("TAG", "Download Error Exception " + e.getMessage());
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);
                }

            }.execute(flag0);
        }

    }


    private void setProgressBarOrDialog() {
        progressBar = new ProgressBar(this);
        progressBar.setIndeterminate(false);
        progressBar = findViewById(R.id.id_progress);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setProgress(0);
        progressDialog.setMax(100);
        progressDialog.setMessage("Downlaoding");
        progressBar.setProgressDrawable(getDrawable(R.drawable.flag_chad));
        progressBar.setVisibility(View.GONE);
        progressBar.setProgress(0);
    }


    private void readImageFile() {
        File sdCard = Environment.getExternalStorageDirectory();
        File directory = new File(sdCard.getAbsolutePath());
        File file = new File(directory, "MyFile1MyFile.jpg"); //or any other format supported
        FileInputStream streamIn = null;
        try {
            streamIn = new FileInputStream(file);
            Bitmap bitmap = BitmapFactory.decodeStream(streamIn); //This gets the image
            Glide.with(this).load(bitmap).into(mBinding.readImageFlag);
            streamIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Glide.with(this).load((Environment.getExternalStoragePublicDirectory("MyFile").getAbsolutePath())+"MyFile").into(mBinding.readImageFlag);
        //FileInputStream inputStream=new FileInputStream()
    }

    private void hitIsdCodeApi() {
        mViewModel.setIsdRequest();
        if (!mViewModel.getIsdResponse().hasObservers()) {
            mViewModel.getIsdResponse().observe(this, response -> {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                if (response != null && response.getResult() != null) {
                    flag0 = response.getResult().get(4).getCountryFlag();
                    Glide.with(this).load(flag0).into(mBinding.imageFlag);

                } else {
                    ErrorHandler.showErrorMsg(this, "");
                }
            });
        }
    }

    private void hitNewPostApi() {
        mViewModel.setRequest(getRequest());
        if (!mViewModel.getResponseList().hasObservers()) {
            mViewModel.getResponseList().observe(this, response -> {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                if (response != null && response.getResult() != null) {
                  /*  if (response.getStatus().equalsIgnoreCase(AppConstants.STATUS_SUCCESS)){
                }
                    else
                        ErrorHandler.showErrorMsg(this, response.getMessage());*/
                } else {
                    ErrorHandler.showErrorMsg(this, "");
                }
            });
        }
    }

    private RequestDate getRequest() {
        String date = new SimpleDateFormat(AppConstants.APP_DATE_TIME_YYYYMMDD, Locale.getDefault()).format(new Date());
        RequestDate requestDate = new RequestDate();
        requestDate.setDate(date);
        return requestDate;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_flag: {
                downloadAndSetImageFromStorage(flag0);
            }
            break;
        }

    }

    private void downloadAndSetImageFromStorage(String flag0) {
        if (this.flag0 != null && !this.flag0.isEmpty()) {
            new AsyncTask<String, Void, Void>() {
                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                    progressDialog.show();
                }

                @Override
                protected Void doInBackground(String... strings) {
                    try {
                        File file = new File(Environment.getExternalStoragePublicDirectory("AppleProjectId").getAbsolutePath(), "MypROJECT");
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        File file1 = new File(file, "MyProject.txt");
                        if (!file1.exists()) {
                            file1.mkdir();
                        }
                        FileOutputStream outputStream = new FileOutputStream(file1);
                        outputStream.write("String".getBytes());
                        outputStream.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                protected void onProgressUpdate(Void... values) {
                    super.onProgressUpdate(values);
                }

                @Override
                protected void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);
                }
            }.execute(flag0);
        }

    }

}
