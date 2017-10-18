package com.example.cpu11112_local.testleanbackshowcase.dagger.module;

import android.support.v17.leanback.widget.PresenterSelector;

import com.example.cpu11112_local.testleanbackshowcase.card.presenters.CardPresenterSelector;
import com.example.cpu11112_local.testleanbackshowcase.card.ui.grid.GridExampleFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by CPU11112-local on 10/18/2017.
 */
@Module
public class GridExampleModule {
    // here cannot provide Fragment, always GridExampleFragment
    @Provides
    PresenterSelector providePresenterSelector(GridExampleFragment fragment) {
        return new CardPresenterSelector(fragment.getActivity());
    }
}
