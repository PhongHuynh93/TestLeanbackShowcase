package com.example.cpu11112_local.testleanbackshowcase.dagger.module;

import android.support.v17.leanback.widget.ArrayObjectAdapter;

import com.example.cpu11112_local.testleanbackshowcase.card.presenters.CardPresenterSelector;
import com.example.cpu11112_local.testleanbackshowcase.card.ui.pageListRow.SampleFragmentA;

import dagger.Module;
import dagger.Provides;

/**
 * Created by CPU11112-local on 10/18/2017.
 */
@Module
public class SampleAModule {
    @Provides
    CardPresenterSelector provideCardPresenterSelector(SampleFragmentA fragment) {
        return new CardPresenterSelector(fragment.getActivity());
    }

    @Provides
    ArrayObjectAdapter provideArrayObjectAdapter(CardPresenterSelector cardPresenter) {
        return new ArrayObjectAdapter(cardPresenter);
    }
}
