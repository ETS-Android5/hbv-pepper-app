package com.example.hsb_pepper.Fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.hsb_pepper.MainActivity;
import com.example.hsb_pepper.R;

public class MainFragment extends Fragment {

    private static final String TAG = "MSI_MainFragment";
    private MainActivity ma;

    /**
     * inflates the layout associated with this fragment
     * if an application theme is set it will be applied to this fragment.
     */

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        int fragmentId = R.layout.fragment_main;
        this.ma = (MainActivity) getActivity();
        if (ma != null) {
            Integer themeId = ma.getThemeId();
            if (themeId != null) {
                final Context contextThemeWrapper = new ContextThemeWrapper(ma, themeId);
                LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
                return localInflater.inflate(fragmentId, container, false);
            } else {
                return inflater.inflate(fragmentId, container, false);
            }
        } else {
            Log.e(TAG, "could not get mainActivity, can't create fragment");
            return null;
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //  ----- L O A D - V I E W ---- ---- (on tablet click)
        view.findViewById(R.id.main_button_reset).setOnClickListener(
                (v) -> ma.setFragment(new MainFragment()));

        view.findViewById(R.id.main_button_frag_one).setOnClickListener(
                (v) -> ma.setFragment(new ScreenOneFragment()));


        view.findViewById(R.id.main_button_frag_two).setOnClickListener(
                (v) -> ma.setFragment(new ScreenTwoFragment()));
    }
}
