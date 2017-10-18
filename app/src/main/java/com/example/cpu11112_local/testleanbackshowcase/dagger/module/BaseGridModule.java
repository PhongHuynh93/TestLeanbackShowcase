package com.example.cpu11112_local.testleanbackshowcase.dagger.module;

import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.PresenterSelector;
import android.support.v17.leanback.widget.VerticalGridPresenter;

import dagger.Module;
import dagger.Provides;

import static com.example.cpu11112_local.testleanbackshowcase.utils.Constant.COLUMNS;
import static com.example.cpu11112_local.testleanbackshowcase.utils.Constant.ZOOM_FACTOR;

/**
 * Created by CPU11112-local on 10/18/2017.
 */
@Module
public class BaseGridModule {

    @Provides
    VerticalGridPresenter provideVerticalGridPresenter() {
        VerticalGridPresenter gridPresenter = new VerticalGridPresenter(ZOOM_FACTOR);
        gridPresenter.setNumberOfColumns(COLUMNS);
        return gridPresenter;
    }

    @Provides
    ArrayObjectAdapter provideArrayObjectAdapter(PresenterSelector presenterSelector) {
        return new ArrayObjectAdapter(presenterSelector);
    }
}
