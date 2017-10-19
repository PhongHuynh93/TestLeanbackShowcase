package com.example.cpu11112_local.testleanbackshowcase.card.ui.video;

import android.os.Bundle;
import android.os.Handler;
import android.support.v17.leanback.app.VerticalGridFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.VerticalGridPresenter;

import com.example.cpu11112_local.testleanbackshowcase.R;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by CPU11112-local on 10/18/2017.
 */

public class VideoGridExampleFragment extends VerticalGridFragment {
    @Inject
    VerticalGridPresenter mVerticalGridPresenter;
    @Inject
    ArrayObjectAdapter mArrayObjectAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.video_grid_example_title));
        setupRowAdapter();
    }

    private void setupRowAdapter() {
        setGridPresenter(mVerticalGridPresenter);
        setAdapter(mArrayObjectAdapter);
        prepareEntranceTransition();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                createRows();
            }
        }, 1000);

//        setOnItemViewSelectedListener(this);
//        setOnItemViewClickedListener(this);
    }

    private void createRows() {
        String urlToFetch = getResources().getString(R.string.videos_url);
//        fetchVideosInfo(urlToFetch);
    }
}
