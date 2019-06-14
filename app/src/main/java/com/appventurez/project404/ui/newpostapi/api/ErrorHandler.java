package com.appventurez.project404.ui.newpostapi.api;

import android.content.Context;
import android.widget.Toast;

import com.appventurez.project404.R;


public class ErrorHandler {


    public static void showErrorMsg(Context context, String msg) {
        if (msg == null || msg.isEmpty())
            msg = context.getString(R.string.something_went_wrong);
        // DialogUtil.showAlertDialog(context, context.getString(R.string.label_error), msg);
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
