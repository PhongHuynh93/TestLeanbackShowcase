package com.example.cpu11112_local.testleanbackshowcase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.OnItemViewClickedListener;
import android.support.v17.leanback.widget.OnItemViewSelectedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.PresenterSelector;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;
import android.support.v4.app.ActivityOptionsCompat;

import com.example.cpu11112_local.testleanbackshowcase.card.ui.cardbrowser.CardExampleActivity;
import com.example.cpu11112_local.testleanbackshowcase.card.ui.grid.GridExampleActivity;
import com.example.cpu11112_local.testleanbackshowcase.card.ui.pageListRow.PageAndListRowActivity;
import com.example.cpu11112_local.testleanbackshowcase.models.Card;
import com.example.cpu11112_local.testleanbackshowcase.models.CardRow;
import com.example.cpu11112_local.testleanbackshowcase.utils.Utils;
import com.google.gson.Gson;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by CPU11112-local on 10/16/2017.
 */

public class MainFragment extends BrowseFragment implements MainView {
    @Inject
    ArrayObjectAdapter mRowsAdapter;

    @Inject
    PresenterSelector presenterSelector;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onActivityCreated(savedInstanceState);
        setupUIElements();
        setAdapter(mRowsAdapter);
        createRows();
        setupEventListeners();
    }

    private void setupUIElements() {
        setTitle(getString(R.string.browse_title));
        setBadgeDrawable(getResources().getDrawable(R.drawable.title_android_tv, null));
        setHeadersState(HEADERS_DISABLED);
        setHeadersTransitionOnBackEnabled(false);
        setBrandColor(getResources().getColor(R.color.fastlane_background));
    }

    private void createRows() {
        String json = Utils
                .inputStreamToString(getResources().openRawResource(R.raw.launcher_cards));
        CardRow[] rows = new Gson().fromJson(json, CardRow[].class);
        for (CardRow row : rows) {
            mRowsAdapter.add(createCardRow(row));
        }
    }

    private ListRow createCardRow(CardRow cardRow) {
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(presenterSelector);
        for (Card card : cardRow.getCards()) {
            listRowAdapter.add(card);
        }
        return new ListRow(listRowAdapter);
    }

    private void setupEventListeners() {
        setOnItemViewClickedListener(new ItemViewClickedListener());
        setOnItemViewSelectedListener(new ItemViewSelectedListener());
    }


    private final class ItemViewClickedListener implements OnItemViewClickedListener {
        @Override
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
            Intent intent = null;
            Card card = (Card) item;
            // info - should declare intdef
            int id = card.getId();
            switch (id) {
                case 0:
                    intent = new Intent(getActivity().getBaseContext(), CardExampleActivity.class);
                    break;
                case 1:
                    intent = new Intent(getActivity().getBaseContext(), PageAndListRowActivity.class);
                    break;
                case 2:
                    intent = new Intent(getActivity().getBaseContext(),
                            GridExampleActivity.class);
                    break;
                default:
                    break;
            }

            if (intent != null) {
                /**
                 step - or we want the share transition
                 Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(
                 this,
                 ((VideoCardView) itemViewHolder.view).getPreviewCard(),
                 MovieDetailsFragment.TRANSITION_NAME).toBundle();
                 */
                Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity())
                        .toBundle();
                startActivity(intent, bundle);
            }
        }
    }

    private final class ItemViewSelectedListener implements OnItemViewSelectedListener {

        @Override
        public void onItemSelected(Presenter.ViewHolder itemViewHolder, Object item,
                                   RowPresenter.ViewHolder rowViewHolder, Row row) {
        }
    }
}
