package com.example.cpu11112_local.testleanbackshowcase.card.ui.pageListRow;

import android.os.Bundle;
import android.os.Handler;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.PageRow;
import android.view.View;
import android.widget.Toast;

import com.example.cpu11112_local.testleanbackshowcase.R;
import com.example.cpu11112_local.testleanbackshowcase.utils.Constant;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjection;

/**
 * Created by CPU11112-local on 10/18/2017.
 */

public class PageAndListRowFragment extends BrowseFragment {
    @Inject
    ArrayObjectAdapter mRowsAdapter;
    @Inject
    @Named(Constant.PAGE_1)
    PageRow mPageRow1;
    @Inject
    @Named(Constant.PAGE_2)
    PageRow mPageRow2;
    @Inject
    @Named(Constant.PAGE_3)
    PageRow mPageRow3;
    @Inject
    @Named(Constant.PAGE_4)
    PageRow mPageRow4;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        setupUi();
        setAdapter(mRowsAdapter);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRowsAdapter.add(mPageRow1);
                mRowsAdapter.add(mPageRow2);
                mRowsAdapter.add(mPageRow3);
                mRowsAdapter.add(mPageRow4);
                startEntranceTransition();
            }
        }, 2000);

        getMainFragmentRegistry().registerFragment(PageRow.class,
                new PageRowFragmentFactory());
    }

    private void setupUi() {
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);
        setBrandColor(getResources().getColor(R.color.fastlane_background));
        setTitle("Title goes here");
        setOnSearchClickedListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(
                        getActivity(), getString(R.string.implement_search), Toast.LENGTH_SHORT)
                        .show();
            }
        });

        prepareEntranceTransition();
    }
}
