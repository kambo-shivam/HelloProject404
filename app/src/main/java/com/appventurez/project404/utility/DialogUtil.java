package com.appventurez.project404.utility;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.appventurez.project404.R;
import com.appventurez.project404.common.callback.PopupCallbackListener;


public class DialogUtil {

    /**
     * get a blocking progress dialog.
     *
     * @param context context of current activity/fragment
     * @return create of {@link ProgressDialog}
     */
    public static ProgressDialog getProgressDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(context.getResources().getString(R.string.please_wait));
        progressDialog.setCancelable(true);
        return progressDialog;
    }

    /**
     * Static method to get an create of material styled progress bar
     *
     * @param context Context of the current class
     * @param resId   Resource Id of the progress bar
     * @return An create of MaterialProgressBar
     */
    public static ProgressBar getProgressBarInstance(Context context, int resId) {
        ProgressBar nonBlockingProgressBar = ((Activity) context).getWindow().findViewById(resId);
        return nonBlockingProgressBar;
    }

    public static ProgressBar getProgressBarInstance(View view, int resId) {
        ProgressBar nonBlockingProgressBar = view.findViewById(resId);
        return nonBlockingProgressBar;
    }

    public static Snackbar showSnackBar(View anyView, int msg) {
        Resources res = anyView.getContext().getResources();
        return showSnackBar(anyView, res.getString(msg));
    }

    public static void showToast(@NonNull Context context, String msg) {
        Toast.makeText(context.getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    public static void showToast(@NonNull Context context, int msg) {
        Toast.makeText(context.getApplicationContext(), context.getResources().getString(msg), Toast.LENGTH_LONG).show();
    }

    public static Snackbar showNoNetworkSnackBar(@NonNull View anyView) {
        return showSnackBar(anyView, R.string.error_internet);
    }

    public static Snackbar showSnackBar(View anyView, String msg) {
        final Snackbar snackBar = Snackbar.make(anyView, msg, Snackbar.LENGTH_SHORT);
        snackBar.setActionTextColor(Color.WHITE);
        View view = snackBar.getView();
        TextView tv = view.findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextColor(Color.WHITE);
        tv.setMaxLines(5);
        snackBar.show();
        return snackBar;
    }
//
    public static void showNoNetworkToast(Context context) {
        showToast(context, context.getString(R.string.error_internet));
    }

    public static void showActionNoNetworkSnackBar(View rootView, String actionText, View.OnClickListener actionListener) {
        showActionSnackBar(rootView, rootView.getContext().getString(R.string.error_internet), actionText, actionListener);
    }

    public static Snackbar showActionSnackBar(View parentView, String msg, String actionText, final View.OnClickListener actionListener) {
        try {
            final Snackbar snackBar = Snackbar.make(parentView, msg, Snackbar.LENGTH_INDEFINITE);
            snackBar.setActionTextColor(Color.WHITE);
            View view = snackBar.getView();
            TextView tv = view.findViewById(android.support.design.R.id.snackbar_text);
            tv.setTextColor(Color.WHITE);
            tv.setMaxLines(5);
            snackBar.setAction(actionText, v -> {
                snackBar.dismiss();
                actionListener.onClick(v);
            });
            snackBar.show();
            return snackBar;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

//    public static void showCountryPicker(FragmentManager fragmentManager, List<CountryResponseEntity> data, CountryPickerListener countryPickerListener, int typeChoice, String dialogTitle) {
//        String TAG_COUNTRY_CODE_PICKER = "COUNTRY_PICKER";
//        CountryPicker picker = CountryPicker.newInstance(dialogTitle, typeChoice);  // dialog title
//        picker.setListener(countryPickerListener);
//        picker.setCountriesList(data);
////        picker.setCancelable(false);
//        picker.show(fragmentManager, TAG_COUNTRY_CODE_PICKER);
//    }
//
//    public static void showCityPicker(FragmentManager fragmentManager, List<CityResponseEntity> data, CityPickerListener cityPickerListener, int typeChoice, String dialogTitle) {
//        String TAG_COUNTRY_CODE_PICKER = "CITY_PICKER";
//        CityPicker picker = CityPicker.newInstance(dialogTitle, typeChoice);  // dialog title
//        picker.setListener(cityPickerListener);
//        picker.setCitiesList(data);
////        picker.setCancelable(false);
//        picker.show(fragmentManager, TAG_COUNTRY_CODE_PICKER);
//    }

    /**
     * Static method to show alert dialog with Ok cancel buttons
     *
     * @param context      Context of the calling class
     * @param text         Text to show in toast
     * @param positiveText Text to show on OKAY button
     * @param negativeText Text to show on CANCEL button
     */


    public static void showAlertDialogWithCallbackAndText(Context context, String text, String title,
                                                          final PopupCallbackListener dialogCallBack, String positiveText, String negativeText, boolean isCancelable) {

        if (text == null)
            text = "";
        AlertDialog mAlertDialog = new AlertDialog.Builder(context).setMessage(text).setCancelable(isCancelable)
                .setNegativeButton(negativeText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if (dialogCallBack != null)
                            dialogCallBack.onPopupNegativeButtonClicked();
                    }
                })
                .setPositiveButton(positiveText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if (dialogCallBack != null)
                            dialogCallBack.onPopupPositiveButtonClicked();

                    }
                }).create();
        mAlertDialog.setTitle(title);
        mAlertDialog.show();
        Button nbutton = mAlertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        nbutton.setTransformationMethod(null);
        nbutton.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
        Button pbutton = mAlertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        pbutton.setTransformationMethod(null);
        pbutton.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
    }

    /**
     * Static method to show alert dialog with single button
     *
     * @param mContext Context of the calling class
     * @param text     Text to show in toast
     */
    public static void showAlertDialog(Context mContext, String text, String buttonText, DialogInterface.OnClickListener clickListener, boolean isCancelable) {
        if (text == null)
            text = "";
        AlertDialog mAlertDialog = new AlertDialog.Builder(mContext).setMessage(text)
                .setTitle(mContext.getString(R.string.app_name)).setCancelable(isCancelable)
                .setPositiveButton(buttonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        clickListener.onClick(dialog, which);
                    }
                }).create();

        mAlertDialog.show();
        Button button = mAlertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        button.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
    }

}
