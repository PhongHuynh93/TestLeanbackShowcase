package com.example.cpu11112_local.testleanbackshowcase.dagger.module;

import android.support.v17.leanback.app.DetailsFragmentBackgroundController;
import android.support.v17.leanback.widget.Action;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.ClassPresenterSelector;
import android.support.v17.leanback.widget.DetailsOverviewRow;
import android.support.v17.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import android.support.v17.leanback.widget.FullWidthDetailsOverviewSharedElementHelper;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.RowPresenter;
import android.view.View;
import android.view.ViewGroup;

import com.example.cpu11112_local.testleanbackshowcase.R;
import com.example.cpu11112_local.testleanbackshowcase.card.presenters.CardPresenterSelector;
import com.example.cpu11112_local.testleanbackshowcase.card.presenters.DetailsDescriptionPresenter;
import com.example.cpu11112_local.testleanbackshowcase.card.ui.detail.DetailViewExampleFragment;
import com.example.cpu11112_local.testleanbackshowcase.models.Card;
import com.example.cpu11112_local.testleanbackshowcase.models.DetailedCard;
import com.example.cpu11112_local.testleanbackshowcase.utils.CardListRow;
import com.example.cpu11112_local.testleanbackshowcase.utils.Constant;
import com.example.cpu11112_local.testleanbackshowcase.utils.Utils;
import com.google.gson.Gson;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

import static com.example.cpu11112_local.testleanbackshowcase.card.ui.detail.DetailViewExampleFragment.ACTION_BUY;
import static com.example.cpu11112_local.testleanbackshowcase.card.ui.detail.DetailViewExampleFragment.ACTION_RELATED;
import static com.example.cpu11112_local.testleanbackshowcase.card.ui.detail.DetailViewExampleFragment.ACTION_WISHLIST;
import static com.example.cpu11112_local.testleanbackshowcase.card.ui.detail.DetailViewExampleFragment.TRANSITION_NAME;

/**
 * Created by CPU11112-local on 10/16/2017.
 */
@Module
public class DetailViewExampleFragmentModule {

//    @Provides
//    CardBrowserFragmentView provideMainView(CardExampleFragment mainFragment) {
//        return mainFragment;
//    }

//
//    @Provides
//    MainPresenter provideMainPresenter(MainView mainView, ApiService apiService) {
//        return new MainPresenterImpl(mainView, apiService);
//    }

//    @Provides
//    PresenterSelector provideSelectorPresenter() {
//        return new ShadowRowPresenterSelector();
//    }

    @Provides
    DetailsFragmentBackgroundController provideDetailsFragmentBackgroundController(DetailViewExampleFragment fragment) {
        return new DetailsFragmentBackgroundController(fragment);
    }

    @Provides
    FullWidthDetailsOverviewRowPresenter provideFullWidthDetailsOverviewRowPresenter(DetailViewExampleFragment fragment) {
        FullWidthDetailsOverviewRowPresenter rowPresenter = new FullWidthDetailsOverviewRowPresenter(new DetailsDescriptionPresenter(fragment.getActivity())) {
            @Override
            protected RowPresenter.ViewHolder createRowViewHolder(ViewGroup parent) {
                // Customize Actionbar and Content by using custom colors.
                RowPresenter.ViewHolder viewHolder = super.createRowViewHolder(parent);

                View actionsView = viewHolder.view.
                        findViewById(R.id.details_overview_actions_background);
                actionsView.setBackgroundColor(fragment.getActivity().getResources().
                        getColor(R.color.detail_view_actionbar_background));

                View detailsView = viewHolder.view.findViewById(R.id.details_frame);
                detailsView.setBackgroundColor(
                        fragment.getActivity().getResources().getColor(R.color.detail_view_background));
                return viewHolder;
            }
        };

        FullWidthDetailsOverviewSharedElementHelper mHelper = new FullWidthDetailsOverviewSharedElementHelper();
        mHelper.setSharedElementEnterTransition(fragment.getActivity(), TRANSITION_NAME);
        rowPresenter.setListener(mHelper);
        rowPresenter.setParticipatingEntranceTransition(false);
        return rowPresenter;
    }

    @Provides
    @Named(Constant.ROW_NOT_SHADOW)
    ListRowPresenter provideListRowPresenter() {
        ListRowPresenter shadowDisabledRowPresenter = new ListRowPresenter();
        shadowDisabledRowPresenter.setShadowEnabled(false);
        return shadowDisabledRowPresenter;
    }

    @Provides
    @Named(Constant.ROW_SHADOW)
    ListRowPresenter provideListRowPresenterWithShadow() {
        return new ListRowPresenter();
    }

    @Provides
    ClassPresenterSelector provideClassPresenterSelector(FullWidthDetailsOverviewRowPresenter rowPresenter, @Named(Constant.ROW_NOT_SHADOW) ListRowPresenter shadowDisabledRowPresenter, @Named(Constant.ROW_SHADOW) ListRowPresenter shadowEnabledRowPresenter) {
        ClassPresenterSelector rowPresenterSelector = new ClassPresenterSelector();
        rowPresenterSelector.addClassPresenter(DetailsOverviewRow.class, rowPresenter);
        rowPresenterSelector.addClassPresenter(CardListRow.class, shadowDisabledRowPresenter);
        rowPresenterSelector.addClassPresenter(ListRow.class, shadowEnabledRowPresenter);
        return rowPresenterSelector;
    }

    @Provides
    @Named(Constant.BIG_ADAPTER)
    ArrayObjectAdapter provideBigArrayObjectAdapter(ClassPresenterSelector presenter) {
        return new ArrayObjectAdapter(presenter);
    }

    @Provides
    DetailedCard provideDetailedCard(DetailViewExampleFragment fragment) {
        String json = Utils
                .inputStreamToString(fragment.getResources().openRawResource(R.raw.detail_example));
        DetailedCard data = new Gson().fromJson(json, DetailedCard.class);
        return data;
    }

    @Provides
    @Named(Constant.ACTION_ADAPTER)
    ArrayObjectAdapter provideActionArrayObjectAdapter(DetailViewExampleFragment fragment, DetailedCard data) {
        ArrayObjectAdapter actionAdapter = new ArrayObjectAdapter();

        Action mActionBuy = new Action(ACTION_BUY, fragment.getString(R.string.action_buy) + data.getPrice());
        Action mActionWishList = new Action(ACTION_WISHLIST, fragment.getString(R.string.action_wishlist));
        Action mActionRelated = new Action(ACTION_RELATED, fragment.getString(R.string.action_related));

        actionAdapter.add(mActionBuy);
        actionAdapter.add(mActionWishList);
        actionAdapter.add(mActionRelated);
        return actionAdapter;
    }

    @Provides
    CardListRow provideCardListRow(DetailViewExampleFragment fragment, DetailedCard data) {
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(
                new CardPresenterSelector(fragment.getActivity()));
        for (Card characterCard : data.getCharacters()) listRowAdapter.add(characterCard);
        HeaderItem header = new HeaderItem(0, fragment.getString(R.string.header_related));
        CardListRow cardListRow = new CardListRow(header, listRowAdapter, null);
        return cardListRow;
    }

    @Provides
    ListRow provideListRow(DetailViewExampleFragment fragment, DetailedCard data) {
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new CardPresenterSelector(fragment.getActivity()));
        for (Card card : data.getRecommended()) listRowAdapter.add(card);
        HeaderItem header = new HeaderItem(1, fragment.getString(R.string.header_recommended));
        return new ListRow(header, listRowAdapter);
    }

    @Provides
    DetailsOverviewRow provideDetailsOverviewRow(DetailedCard data, @Named(Constant.ACTION_ADAPTER) ArrayObjectAdapter actionAdapter) {
        DetailsOverviewRow detailsOverview = new DetailsOverviewRow(data);
        detailsOverview.setActionsAdapter(actionAdapter);
        return detailsOverview;
    }

}
