package com.example.cpu11112_local.testleanbackshowcase.card.ui.pageListRow;

import android.os.Bundle;
import android.support.v17.leanback.app.RowsFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.OnItemViewClickedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.PresenterSelector;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;
import android.widget.Toast;

import com.example.cpu11112_local.testleanbackshowcase.R;
import com.example.cpu11112_local.testleanbackshowcase.card.presenters.CardPresenterSelector;
import com.example.cpu11112_local.testleanbackshowcase.card.presenters.ShadowRowPresenterSelector;
import com.example.cpu11112_local.testleanbackshowcase.models.Card;
import com.example.cpu11112_local.testleanbackshowcase.models.CardRow;
import com.example.cpu11112_local.testleanbackshowcase.utils.CardListRow;
import com.example.cpu11112_local.testleanbackshowcase.utils.Utils;
import com.google.gson.Gson;

/**
 * Created by CPU11112-local on 10/18/2017.
 * // FIXME: 10/18/2017 what is the different between GridFragment(custom fragment) and VerticalGridFragment(layout in leanback)
 */
public class SampleFragmentB extends RowsFragment {
    private final ArrayObjectAdapter mRowsAdapter;

    public SampleFragmentB() {
        mRowsAdapter = new ArrayObjectAdapter(new ShadowRowPresenterSelector());

        setAdapter(mRowsAdapter);
        setOnItemViewClickedListener(new OnItemViewClickedListener() {
            @Override
            public void onItemClicked(
                    Presenter.ViewHolder itemViewHolder,
                    Object item,
                    RowPresenter.ViewHolder rowViewHolder,
                    Row row) {
                Toast.makeText(getActivity(), "Implement click handler", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createRows();
        getMainFragmentAdapter().getFragmentHost().notifyDataReady(getMainFragmentAdapter());
    }

    private void createRows() {
        String json = Utils.inputStreamToString(getResources().openRawResource(
                R.raw.page_row_example));
        CardRow[] rows = new Gson().fromJson(json, CardRow[].class);
        for (CardRow row : rows) {
            if (row.getType() == CardRow.TYPE_DEFAULT) {
                mRowsAdapter.add(createCardRow(row));
            }
        }
    }

    private Row createCardRow(CardRow cardRow) {
        PresenterSelector presenterSelector = new CardPresenterSelector(getActivity());
        ArrayObjectAdapter adapter = new ArrayObjectAdapter(presenterSelector);
        for (Card card : cardRow.getCards()) {
            adapter.add(card);
        }

        HeaderItem headerItem = new HeaderItem(cardRow.getTitle());
        return new CardListRow(headerItem, adapter, cardRow);
    }
}
