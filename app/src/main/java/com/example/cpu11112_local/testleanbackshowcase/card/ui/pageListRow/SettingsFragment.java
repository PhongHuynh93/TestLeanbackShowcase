package com.example.cpu11112_local.testleanbackshowcase.card.ui.pageListRow;

import android.app.Activity;
import android.os.Handler;
import android.support.v17.leanback.app.RowsFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;

import com.example.cpu11112_local.testleanbackshowcase.R;
import com.example.cpu11112_local.testleanbackshowcase.card.presenters.SettingsIconPresenter;
import com.example.cpu11112_local.testleanbackshowcase.models.Card;
import com.example.cpu11112_local.testleanbackshowcase.models.CardRow;
import com.example.cpu11112_local.testleanbackshowcase.utils.CardListRow;
import com.example.cpu11112_local.testleanbackshowcase.utils.Utils;
import com.google.gson.Gson;

/**
 * Created by CPU11112-local on 10/18/2017.
 * // FIXME: 10/18/2017 what is the different between GridFragment(custom fragment) and VerticalGridFragment(layout in leanback)
 */
public class SettingsFragment extends RowsFragment {
    private final ArrayObjectAdapter mRowsAdapter;

    public SettingsFragment() {
        ListRowPresenter selector = new ListRowPresenter();
        selector.setNumRows(2);
        mRowsAdapter = new ArrayObjectAdapter(selector);
        setAdapter(mRowsAdapter);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadData();
            }
        }, 200);
    }

    private void loadData() {
        if (isAdded()) {
            String json = Utils.inputStreamToString(getResources().openRawResource(
                    R.raw.icon_example));
            CardRow cardRow = new Gson().fromJson(json, CardRow.class);
            mRowsAdapter.add(createCardRow(cardRow));
            getMainFragmentAdapter().getFragmentHost().notifyDataReady(
                    getMainFragmentAdapter());
        }
    }

    private ListRow createCardRow(CardRow cardRow) {
        SettingsIconPresenter iconCardPresenter = new SettingsIconPresenter(getActivity());
        ArrayObjectAdapter adapter = new ArrayObjectAdapter(iconCardPresenter);
        for(Card card : cardRow.getCards()) {
            adapter.add(card);
        }

        HeaderItem headerItem = new HeaderItem(cardRow.getTitle());
        return new CardListRow(headerItem, adapter, cardRow);
    }
}
