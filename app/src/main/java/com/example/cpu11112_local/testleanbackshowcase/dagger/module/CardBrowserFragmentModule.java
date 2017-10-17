package com.example.cpu11112_local.testleanbackshowcase.dagger.module;

import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.PresenterSelector;

import com.example.cpu11112_local.testleanbackshowcase.card.presenters.ShadowRowPresenterSelector;

import dagger.Module;
import dagger.Provides;

/**
 * Created by CPU11112-local on 10/16/2017.
 */
@Module
public class CardBrowserFragmentModule {

//    @Provides
//    CardBrowserFragmentView provideMainView(CardExampleFragment mainFragment) {
//        return mainFragment;
//    }

//
//    @Provides
//    MainPresenter provideMainPresenter(MainView mainView, ApiService apiService) {
//        return new MainPresenterImpl(mainView, apiService);
//    }

    @Provides
    PresenterSelector provideSelectorPresenter() {
        return new ShadowRowPresenterSelector();
    }

    @Provides
    ArrayObjectAdapter provideArrayObjectAdapter(PresenterSelector presenter) {
        return new ArrayObjectAdapter(presenter);
    }
}
