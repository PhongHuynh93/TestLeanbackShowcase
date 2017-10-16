package com.example.cpu11112_local.testleanbackshowcase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v17.leanback.app.BrowseFragment;

/**
 * Created by CPU11112-local on 10/16/2017.
 */

public class MainFragment extends BrowseFragment {
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupUIElements();
        setupRowAdapter();
        setupEventListeners();
    }

    private void setupUIElements() {

    }

    private void setupRowAdapter() {

    }

    private void setupEventListeners() {

    }

}
