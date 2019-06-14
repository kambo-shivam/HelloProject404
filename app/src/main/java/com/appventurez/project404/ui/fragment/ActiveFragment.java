package com.appventurez.project404.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appventurez.project404.R;
import com.appventurez.project404.callback.GetCallBack;

public class ActiveFragment extends Fragment {
    public static ActiveFragment INSTANCE;
    GetCallBack getCallBack;
    public ActiveFragment(){

    }


    public static ActiveFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ActiveFragment();
        }
        return INSTANCE;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        getCallBack= (GetCallBack) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getCallBack.getCall("1");
        return inflater.inflate(R.layout.fragment_active, container, false);
    }
}
