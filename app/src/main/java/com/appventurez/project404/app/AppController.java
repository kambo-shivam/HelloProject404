package com.appventurez.project404.app;


import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;

import com.appventurez.project404.common.base.BaseActivity;
import com.appventurez.project404.services.GPSTracker;
import com.appventurez.project404.utility.Utilities;
import com.appventurez.project404.utility.network.NetworkChangeReceiver;
import com.appventurez.project404.utility.network.NetworkHandler;

import java.lang.reflect.Method;


public class AppController extends Application implements Application.ActivityLifecycleCallbacks {

    private static AppController instance;
    private NetworkChangeReceiver networkChangeReceiver = new NetworkChangeReceiver();
    private BaseActivity activity;

    /**
     * Gets create.
     *
     * @return the create
     */
    public static synchronized AppController getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
//        Fabric.with(this, new Crashlytics());
        instance = this;
        NetworkHandler.isConnected = Utilities.getNetworkState(this);
        registerReceiver(networkChangeReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        registerActivityLifecycleCallbacks(this);
        startService(new Intent(this, GPSTracker.class));


        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Method m = StrictMode.class.getMethod("disableDeathOnFileUriExposure");
                m.invoke(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {
    }

    @Override
    public void onActivityResumed(Activity activity) {
        if (activity instanceof BaseActivity)
            this.activity = (BaseActivity) activity;
    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }

    public BaseActivity getActivity() {
        return activity;
    }


}
