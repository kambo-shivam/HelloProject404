package com.appventurez.project404.ui.splash;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.appventurez.project404.R;
import com.appventurez.project404.databinding.ActivitySplashBinding;
import com.appventurez.project404.ui.Signup.SignUpActivity;
import com.appventurez.project404.utility.constant.AppConstants;
import com.google.android.gms.ads.MobileAds;

public class SplashActivity extends AppCompatActivity {
    ActivitySplashBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        MobileAds.initialize(this, AppConstants.APP_ID_MOB);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        }, 3000);
    }
}
