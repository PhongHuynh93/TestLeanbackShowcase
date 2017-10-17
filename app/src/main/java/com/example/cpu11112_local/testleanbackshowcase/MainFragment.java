package com.example.cpu11112_local.testleanbackshowcase;

import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.PresenterSelector;

import javax.inject.Inject;

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
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        AndroidInjection.inject(this);
//        super.onActivityCreated(savedInstanceState);
//        setupUIElements();
//        setAdapter(mRowsAdapter);
//        createRows();
//        setupEventListeners();
//    }
//
//    private void setupUIElements() {
//        setTitle(getString(R.string.browse_title));
//        setBadgeDrawable(getResources().getDrawable(R.drawable.title_android_tv, null));
//        setHeadersState(HEADERS_DISABLED);
//        setHeadersTransitionOnBackEnabled(false);
//        setBrandColor(getResources().getColor(R.color.fastlane_background));
//    }
//
//    private void createRows() {
//        String json = Utils
//                .inputStreamToString(getResources().openRawResource(R.raw.launcher_cards));
//        CardRow[] rows = new Gson().fromJson(json, CardRow[].class);
//        for (CardRow row : rows) {
//            mRowsAdapter.add(createCardRow(row));
//        }
//    }
//
//    private ListRow createCardRow(CardRow cardRow) {
//        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(presenterSelector);
//        for (Card card : cardRow.getCards()) {
//            listRowAdapter.add(card);
//        }
//        return new ListRow(listRowAdapter);
//    }
//
//    private void setupEventListeners() {
//        setOnItemViewClickedListener(new ItemViewClickedListener());
//        setOnItemViewSelectedListener(new ItemViewSelectedListener());
//    }
//
//
//    private final class ItemViewClickedListener implements OnItemViewClickedListener {
//        @Override
//        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item,
//                                  RowPresenter.ViewHolder rowViewHolder, Row row) {
//            // TODO: 10/17/2017 implement this method
//        }
//    }
//
//    private final class ItemViewSelectedListener implements OnItemViewSelectedListener {
//
//        @Override
//        public void onItemSelected(Presenter.ViewHolder itemViewHolder, Object item,
//                                   RowPresenter.ViewHolder rowViewHolder, Row row) {
//        }
//    }
}
