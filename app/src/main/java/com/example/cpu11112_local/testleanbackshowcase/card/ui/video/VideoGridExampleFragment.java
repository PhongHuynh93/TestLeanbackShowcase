package com.example.cpu11112_local.testleanbackshowcase.card.ui.video;

import android.os.Bundle;
import android.support.v17.leanback.app.VerticalGridFragment;

import dagger.android.AndroidInjection;

/**
 * Created by CPU11112-local on 10/18/2017.
 */

public class VideoGridExampleFragment extends VerticalGridFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }
}
