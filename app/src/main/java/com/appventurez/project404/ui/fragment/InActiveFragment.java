package com.appventurez.project404.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appventurez.project404.R;

public class InActiveFragment extends Fragment {
    public static InActiveFragment Instance;

    public static InActiveFragment getInstance() {
        if (Instance == null) {
            Instance = new InActiveFragment();
        }
        return Instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_in_active, container, false);
    }
}
