package com.example.cpu11112_local.testleanbackshowcase.card.ui.pageListRow;

import android.app.Fragment;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.Row;

import static com.example.cpu11112_local.testleanbackshowcase.utils.Constant.HEADER_ID_1;
import static com.example.cpu11112_local.testleanbackshowcase.utils.Constant.HEADER_ID_2;
import static com.example.cpu11112_local.testleanbackshowcase.utils.Constant.HEADER_ID_3;
import static com.example.cpu11112_local.testleanbackshowcase.utils.Constant.HEADER_ID_4;

/**
 * Created by CPU11112-local on 10/18/2017.
 */

public class PageRowFragmentFactory extends BrowseFragment.FragmentFactory {
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
