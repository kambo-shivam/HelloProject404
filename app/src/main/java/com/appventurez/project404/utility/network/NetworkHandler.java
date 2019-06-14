package com.appventurez.project404.utility.network;

import android.content.Context;
import android.view.View;

import com.appventurez.project404.utility.DialogUtil;


public class NetworkHandler {

    public static boolean isConnected;

    public static boolean isConnected() {
        return isConnected;
    }

    public static boolean isConnected(Context context) {
        if (!isConnected) DialogUtil.showNoNetworkToast(context.getApplicationContext());
        return isConnected;
    }

    public static boolean isConnected(View anyView) {
        if (!isConnected)
            DialogUtil.showNoNetworkSnackBar(anyView);
        return isConnected;
    }

    public static boolean isConnected(View anyView, View.OnClickListener retryListener) {
        if (!isConnected) DialogUtil.showNoNetworkSnackBar(anyView);
        return isConnected;
    }


}
