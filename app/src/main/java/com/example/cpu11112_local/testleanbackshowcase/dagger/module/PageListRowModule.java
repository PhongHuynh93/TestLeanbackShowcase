package com.example.cpu11112_local.testleanbackshowcase.dagger.module;

import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.PageRow;

import com.example.cpu11112_local.testleanbackshowcase.utils.Constant;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

import static com.example.cpu11112_local.testleanbackshowcase.utils.Constant.HEADER_ID_1;
import static com.example.cpu11112_local.testleanbackshowcase.utils.Constant.HEADER_ID_2;
import static com.example.cpu11112_local.testleanbackshowcase.utils.Constant.HEADER_ID_3;
import static com.example.cpu11112_local.testleanbackshowcase.utils.Constant.HEADER_ID_4;
import static com.example.cpu11112_local.testleanbackshowcase.utils.Constant.HEADER_NAME_1;
import static com.example.cpu11112_local.testleanbackshowcase.utils.Constant.HEADER_NAME_2;
import static com.example.cpu11112_local.testleanbackshowcase.utils.Constant.HEADER_NAME_3;
import static com.example.cpu11112_local.testleanbackshowcase.utils.Constant.HEADER_NAME_4;

/**
 * Created by CPU11112-local on 10/16/2017.
 */
@Module
public class PageListRowModule {
//
//    @Provides
//    MainView provideMainView(MainFragment mainFragment) {
//        return mainFragment;
//    }
//
    @Provides
    ArrayObjectAdapter provideArrayObjectAdapter() {
        return new ArrayObjectAdapter(new ListRowPresenter());
    }

    @Provides
    @Named(Constant.PAGE_1)
    PageRow providePageRow1() {
        HeaderItem headerItem = new HeaderItem(HEADER_ID_1, HEADER_NAME_1);
        return new PageRow(headerItem);
    }

    @Provides
    @Named(Constant.PAGE_2)
    PageRow providePageRow2() {
        HeaderItem headerItem = new HeaderItem(HEADER_ID_2, HEADER_NAME_2);
        return new PageRow(headerItem);
    }

    @Provides
    @Named(Constant.PAGE_3)
    PageRow providePageRow3() {
        HeaderItem headerItem = new HeaderItem(HEADER_ID_3, HEADER_NAME_3);
        return new PageRow(headerItem);
    }

    @Provides
    @Named(Constant.PAGE_4)
    PageRow providePageRow4() {
        HeaderItem headerItem = new HeaderItem(HEADER_ID_4, HEADER_NAME_4);
        return new PageRow(headerItem);
    }
//
//    @Provides
//    PresenterSelector providePresenterSelector(MainFragment mainFragment) {
//        return new CardPresenterSelector(mainFragment.getActivity());
//    }
}
