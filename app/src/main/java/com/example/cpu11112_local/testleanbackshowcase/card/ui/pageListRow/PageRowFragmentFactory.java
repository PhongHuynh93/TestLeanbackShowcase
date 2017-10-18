package com.example.cpu11112_local.testleanbackshowcase.card.ui.pageListRow;

import android.app.Fragment;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.Row;
import android.webkit.WebViewFragment;

/**
 * Created by CPU11112-local on 10/18/2017.
 */

public class PageRowFragmentFactory extends BrowseFragment.FragmentFactory {
    private static final long HEADER_ID_1 = 1;
    private static final String HEADER_NAME_1 = "Page Fragment";
    private static final long HEADER_ID_2 = 2;
    private static final String HEADER_NAME_2 = "Rows Fragment";
    private static final long HEADER_ID_3 = 3;
    private static final String HEADER_NAME_3 = "Settings Fragment";
    private static final long HEADER_ID_4 = 4;
    private static final String HEADER_NAME_4 = "User agreement Fragment";

    @Override
    public Fragment createFragment(Object rowObj) {
        Row row = (Row)rowObj;
        // FIXME: 10/18/2017 why set this to null
//        mBackgroundManager.setDrawable(null);
        if (row.getHeaderItem().getId() == HEADER_ID_1) {
            return new SampleFragmentA();
        } else if (row.getHeaderItem().getId() == HEADER_ID_2) {
            return new SampleFragmentB();
        } else if (row.getHeaderItem().getId() == HEADER_ID_3) {
            return new SettingsFragment();
        } else if (row.getHeaderItem().getId() == HEADER_ID_4) {
            return new WebViewFragment();
        }

        throw new IllegalArgumentException(String.format("Invalid row %s", rowObj));
    }
}
