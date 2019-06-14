package com.appventurez.project404.ui.Signup;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.appventurez.project404.R;
import com.appventurez.project404.databinding.ActivitySignUpBinding;
import com.appventurez.project404.ui.MainActivity;
import com.appventurez.project404.ui.forgotpassword.ForgotPassword;
import com.appventurez.project404.utility.constant.AppConstants;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener, RewardedVideoAdListener {
    ActivitySignUpBinding mBinding;
    FirebaseAuth auth;
    private FirebaseUser fireBaseUser;
    private RewardedVideoAd mRewardedVideoAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);
        auth = FirebaseAuth.getInstance();

        fireBaseUser = FirebaseAuth.getInstance().getCurrentUser();
        mBinding.registerId.setOnClickListener(this);
        mBinding.loginId.setOnClickListener(this);
        mBinding.forgotId.setOnClickListener(this);
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();
        mRewardedVideoAd.show();
        Toast.makeText(this, String.valueOf(FirebaseAuth.getInstance().getCurrentUser()), Toast.LENGTH_LONG).show();
    }

    private void loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd(AppConstants.APP_ID_MOB,
                new AdRequest.Builder().build());
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_id: {

                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                auth.createUserWithEmailAndPassword(mBinding.emailId.getText().toString().trim(), mBinding
                        .passwordId.getText().toString().trim()).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            UserProfileChangeRequest request = new UserProfileChangeRequest.Builder().setDisplayName("").build();
                            Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else
                            Toast.makeText(SignUpActivity.this, "SignUp Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            break;
            case R.id.login_id: {
                Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.forgot_id: {
                Intent intent = new Intent(SignUpActivity.this, ForgotPassword.class);
                startActivity(intent);

            }
            break;
        }
    }

    @Override
    public void onResume() {
        mRewardedVideoAd.resume(this);
        super.onResume();
    }

    @Override
    public void onPause() {
        mRewardedVideoAd.pause(this);
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mRewardedVideoAd.destroy(this);
        super.onDestroy();
    }

    @Override
    public void onRewarded(RewardItem reward) {
        Toast.makeText(this, "onRewarded! currency: " + reward.getType() + "  amount: " +
                reward.getAmount(), Toast.LENGTH_SHORT).show();
        // Reward the user.
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
        Toast.makeText(this, "onRewardedVideoAdLeftApplication",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdClosed() {
        Toast.makeText(this, "onRewardedVideoAdClosed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int errorCode) {
        Toast.makeText(this, "onRewardedVideoAdFailedToLoad", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        Toast.makeText(this, "onRewardedVideoAdLoaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdOpened() {
        Toast.makeText(this, "onRewardedVideoAdOpened", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoStarted() {
        Toast.makeText(this, "onRewardedVideoStarted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoCompleted() {
        Toast.makeText(this, "onRewardedVideoCompleted", Toast.LENGTH_SHORT).show();
    }
}
