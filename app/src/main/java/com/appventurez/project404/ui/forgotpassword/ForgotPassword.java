package com.appventurez.project404.ui.forgotpassword;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.appventurez.project404.R;
import com.appventurez.project404.databinding.ActivityForgotPasswordBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity implements View.OnClickListener {
    ActivityForgotPasswordBinding mBinding;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_forgot_password);
        auth = FirebaseAuth.getInstance();
        mBinding.setPasswordBttn.setOnClickListener(this);
       // mBinding.setPasswordBttn.setTag("TAG");

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.set_password_bttn: {
                auth.sendPasswordResetEmail(mBinding.emailLoginForgot.getText().toString().trim()).addOnCompleteListener(
                        ForgotPassword.this, new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(ForgotPassword.this, NewActivity.class);
                                    startActivity(intent);
                                } else
                                    Toast.makeText(ForgotPassword.this, "Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                );
            }
        }
    }
}
