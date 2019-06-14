package com.appventurez.project404.ui.Signup;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.appventurez.project404.R;
import com.appventurez.project404.databinding.ActivityLogInBinding;
import com.appventurez.project404.ui.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityLogInBinding mBinding;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_log_in);
        mBinding.login.setOnClickListener(this);
        auth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login: {
                auth.signInWithEmailAndPassword(mBinding.emailLogin.getText().toString().trim(), mBinding.passwordLogin.getText().toString().trim())
                        .addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(LogInActivity.this, MainActivity.class);
                                    startActivity(intent);
                                } else
                                    Toast.makeText(LogInActivity.this, "LogIn Failed", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
            break;
        }
    }
}
