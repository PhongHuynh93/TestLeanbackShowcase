package com.example.cpu11112_local.testleanbackshowcase.card.ui.grid;

import android.os.Bundle;
import android.os.Handler;
import android.support.v17.leanback.app.VerticalGridFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.FocusHighlight;
import android.support.v17.leanback.widget.PresenterSelector;
import android.support.v17.leanback.widget.VerticalGridPresenter;

import com.example.cpu11112_local.testleanbackshowcase.R;
import com.example.cpu11112_local.testleanbackshowcase.card.presenters.CardPresenterSelector;
import com.example.cpu11112_local.testleanbackshowcase.models.CardRow;
import com.example.cpu11112_local.testleanbackshowcase.utils.Utils;
import com.google.gson.Gson;

/**
 * Created by CPU11112-local on 10/18/2017.
 * note - we can see the different between VerticalGridFragment and GridFragment we created it custom
 * info - VerticalGridFragment is so simple -> use this instead of GridFragment
 */

public class GridExampleFragment extends VerticalGridFragment {
    private static final int COLUMNS = 4;
    private static final int ZOOM_FACTOR = FocusHighlight.ZOOM_FACTOR_MEDIUM;

    private ArrayObjectAdapter mAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.grid_example_title));
        setupRowAdapter();
    }

    private void setupRowAdapter() {
        VerticalGridPresenter gridPresenter = new VerticalGridPresenter(ZOOM_FACTOR);
        gridPresenter.setNumberOfColumns(COLUMNS);
        setGridPresenter(gridPresenter);

        PresenterSelector cardPresenterSelector = new CardPresenterSelector(getActivity());
        mAdapter = new ArrayObjectAdapter(cardPresenterSelector);
        setAdapter(mAdapter);

        prepareEntranceTransition();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                createRows();
                startEntranceTransition();
            }
        }, 1000);
    }

    private void createRows() {
        String json = Utils.inputStreamToString(getResources()
                .openRawResource(R.raw.grid_example));
        CardRow row = new Gson().fromJson(json, CardRow.class);
        mAdapter.addAll(0, row.getCards());
    }
}
