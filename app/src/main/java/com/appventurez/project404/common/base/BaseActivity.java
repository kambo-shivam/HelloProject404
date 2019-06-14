package com.appventurez.project404.common.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;

import com.appventurez.project404.utility.DialogUtil;


public class BaseActivity extends AppCompatActivity implements BaseListener, View.OnClickListener {

    protected BaseActivity mThis;
    private ProgressDialog mProgressDialog;
    private ProgressBar mProgressBar;
//    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mThis = this;
    }


    @Override
    public void showHideProgressDialog(boolean isShow) {
        if (mProgressDialog != null) {
            if (isShow)
                mProgressDialog.show();
            else {
                if (mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                    mProgressDialog = null;
                }
            }
        } else {
            mProgressDialog = DialogUtil.getProgressDialog(this);
            showHideProgressDialog(isShow);

        }
    }


    @Override
    public synchronized void showHideProgressBar(boolean iShow) {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.GONE);
            if (iShow)
                mProgressBar.setVisibility(View.VISIBLE);
            else {
                mProgressBar.setVisibility(View.GONE);
                mProgressBar = null;
            }
        } else {
//         mProgressBar = DialogUtil.getProgressBarInstance(this, R.id.circular_progress_bar);
            if (mProgressBar == null) return;
            showHideProgressBar(iShow);
        }
    }

    @Override
    public void onClick(View view) {
    }


}