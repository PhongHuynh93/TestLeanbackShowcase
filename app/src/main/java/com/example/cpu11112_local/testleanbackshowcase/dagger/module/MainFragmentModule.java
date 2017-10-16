package com.example.cpu11112_local.testleanbackshowcase.dagger.module;

import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.PresenterSelector;

import com.example.cpu11112_local.testleanbackshowcase.MainFragment;
import com.example.cpu11112_local.testleanbackshowcase.MainView;
import com.example.cpu11112_local.testleanbackshowcase.card.presenters.CardPresenterSelector;

import dagger.Module;
import dagger.Provides;

/**
 * Created by CPU11112-local on 10/16/2017.
 */
@Module
public class MainFragmentModule {

    @Provides
    MainView provideMainView(MainFragment mainFragment) {
        return mainFragment;
    }

//
//    @Provides
//    MainPresenter provideMainPresenter(MainView mainView, ApiService apiService) {
//        return new MainPresenterImpl(mainView, apiService);
//    }

    @Provides
    ArrayObjectAdapter provideArrayObjectAdapter() {
        return new ArrayObjectAdapter(new ListRowPresenter());
    }

    @Provides
    PresenterSelector providePresenterSelector(MainFragment mainFragment) {
        return new CardPresenterSelector(mainFragment.getActivity());
    }
}
