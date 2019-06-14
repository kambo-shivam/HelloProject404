package com.appventurez.project404.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.appventurez.project404.R;
import com.appventurez.project404.callback.GetCallBack;
import com.appventurez.project404.databinding.ActivityHomeBaseBinding;
import com.appventurez.project404.utility.constant.AppConstants;

public class HomeBaseActivity extends AppCompatActivity implements GetCallBack {
    ActivityHomeBaseBinding mBinidng;
    int backPressed;
    Fragment fragment;
    private int mBackpress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinidng = DataBindingUtil.setContentView(this, R.layout.activity_home_base);
        fragment = ActiveFragment.getInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).addToBackStack(AppConstants.ADDTOBACKSTACK).commit();
        mBinidng.navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu1: {
                        fragment = ActiveFragment.getInstance();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).addToBackStack(AppConstants.ADDTOBACKSTACK).commit();
                        return true;
                    }
                    case R.id.menu2: {
                        fragment = InActiveFragment.getInstance();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).addToBackStack(AppConstants.ADDTOBACKSTACK).commit();
                        return true;
                    }
                    case R.id.menu3: {
                        fragment = HideFragment.getInstance();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).addToBackStack(AppConstants.ADDTOBACKSTACK).commit();
                        return true;
                    }
                    case R.id.menu4: {
                        fragment = ShowFragment.getInstance();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).addToBackStack(AppConstants.ADDTOBACKSTACK).commit();
                        return true;
                    }
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
       /* if (getSupportFragmentManager().findFragmentByTag(AppConstants.ADDTOBACKSTACK) instanceof ActiveFragment) {
            if (mBackpress == 1) {
                super.onBackPressed();
            } else {
                Toast.makeText(this, getResources().getString(R.string.press_back_button_to_exit), Toast.LENGTH_SHORT)
                        .show();
                mBackpress = 1;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // finish();
                        mBackpress = 0;
                    }
                }, 1500);
            }
        } else {
            finish();
        }
*/
        if (!(getSupportFragmentManager().findFragmentByTag(AppConstants.ADDTOBACKSTACK) instanceof ActiveFragment)) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            fragment = ActiveFragment.getInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
        }

    }

    @Override
    public void getCall(String i) {
        Toast.makeText(this, i, Toast.LENGTH_SHORT).show();
    }
}
