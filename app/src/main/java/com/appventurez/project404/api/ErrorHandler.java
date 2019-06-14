package com.appventurez.project404.api;

import android.support.design.widget.Snackbar;
import android.view.View;

import com.appventurez.project404.R;
import com.appventurez.project404.utility.DialogUtil;
import com.appventurez.project404.vo.common.ErrorResponse;
import com.google.gson.Gson;


public class ErrorHandler {

    public static Snackbar showErrorMsgWithAction(View view, String msg, String actionText, View.OnClickListener listener) {
        return DialogUtil.showActionSnackBar(view, msg, actionText, listener);
    }

    public static void showErrorMsg(View view, String msg) {
        ErrorResponse errorResponse=null;
        try {
            errorResponse = new Gson().fromJson(msg, ErrorResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (errorResponse != null)
            msg = errorResponse.getResult().getMessage();
        if (msg == null || msg.isEmpty())
            msg = view.getContext().getString(R.string.something_went_wrong);
        DialogUtil.showSnackBar(view, msg);
    }
}
