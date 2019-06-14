package com.appventurez.project404.common.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ProgressBar;

import com.appventurez.project404.utility.DialogUtil;


public class BaseFragment extends Fragment implements BaseListener, View.OnClickListener {

    public BaseActivity context;
    private ProgressDialog progressDialog;
    private ProgressBar mProgressBar;
//    private FirebaseAnalytics mFirebaseAnalytics;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mFirebaseAnalytics = FirebaseAnalytics.getInstance(getActivity());
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        context = (BaseActivity) getActivity();
    }

    @Override
    public void showHideProgressDialog(boolean isShow) {
        if (progressDialog != null) {
            if (progressDialog.isShowing()) {
                if (!isShow) {
                    progressDialog.dismiss();
                    progressDialog = null;
                }
            } else {
                if (isShow)
                    progressDialog.show();
            }
        } else {
            progressDialog = DialogUtil.getProgressDialog(getActivity());
            showHideProgressDialog(isShow);

        }
    }

    @Override
    public void showHideProgressBar(boolean iShow) {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.GONE);
            if (iShow)
                mProgressBar.setVisibility(View.VISIBLE);
            else {
                mProgressBar.setVisibility(View.GONE);
                mProgressBar = null;
            }
        } else {
//            mProgressBar = DialogUtil.getProgressBarInstance(getView(), R.id.circular_progress_bar);
            if (mProgressBar == null) return;
            showHideProgressBar(iShow);
        }


    }

    @Override
    public void onClick(View v) {

    }

    protected void addFragment(Fragment fragment, int container, boolean isAddToBackStack) {
        String fragmentName = fragment.getClass().getSimpleName();
        if (isAddToBackStack) {
            getFragmentManager()
                    .beginTransaction()
                    .add(container, fragment, fragmentName)
                    .addToBackStack(fragmentName)
                    .commitAllowingStateLoss();
        } else {
            getFragmentManager()
                    .beginTransaction()
                    .replace(container, fragment, fragmentName)
                    .addToBackStack(fragmentName)
                    .commitAllowingStateLoss();
        }
    }







}
