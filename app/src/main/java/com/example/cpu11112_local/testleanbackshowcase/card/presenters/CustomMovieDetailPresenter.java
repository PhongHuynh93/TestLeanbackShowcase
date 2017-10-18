package com.example.cpu11112_local.testleanbackshowcase.card.presenters;

import android.support.v17.leanback.widget.DetailsOverviewLogoPresenter;
import android.support.v17.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.RowPresenter;
import android.view.View;
import android.view.ViewGroup;

import com.example.cpu11112_local.testleanbackshowcase.R;

/**
 * Created by CPU11112-local on 10/18/2017.
 */

public class CustomMovieDetailPresenter extends FullWidthDetailsOverviewRowPresenter {
    private int mPreviousState = STATE_FULL;

    public CustomMovieDetailPresenter(Presenter detailsPresenter) {
        super(detailsPresenter);
    }

    public CustomMovieDetailPresenter(Presenter detailsPresenter, DetailsOverviewLogoPresenter logoPresenter) {
        super(detailsPresenter, logoPresenter);
        setInitialState(FullWidthDetailsOverviewRowPresenter.STATE_FULL);
    }

    @Override
    protected void onBindRowViewHolder(RowPresenter.ViewHolder holder, Object item) {
        super.onBindRowViewHolder(holder, item);
        // The only difference here is that instead of creating a new ViewHolder we are just accessing the already created one.
        FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder = (FullWidthDetailsOverviewRowPresenter.ViewHolder) holder;
//        View v = vh.getOverviewView();
//        v.setBackgroundColor(getBackgroundColor());
//        v.findViewById(android.support.v17.leanback.R.id.details_overview_actions_background)
//                .setBackgroundColor(getActionsBackgroundColor());

        // Customize Actionbar and Content by using custom colors.
//        RowPresenter.ViewHolder viewHolder = super.createRowViewHolder(holder);

        // FIXME: 10/17/2017 not set these 2 colors is blue for all type, set the pallete color like in movie detail
        View actionsView = viewHolder.view.
                findViewById(R.id.details_overview_actions_background);
        actionsView.setBackgroundColor(getBackgroundColor());

        View detailsView = viewHolder.view.findViewById(R.id.details_frame);
        detailsView.setBackgroundColor(getBackgroundColor());
    }

    // info - make the logo go smooth by using the transition
    @Override
    protected void onLayoutLogo(ViewHolder viewHolder, int oldState, boolean logoChanged) {
        View v = viewHolder.getLogoViewHolder().view;
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) v.getLayoutParams();

        lp.setMarginStart(v.getResources().getDimensionPixelSize(
                android.support.v17.leanback.R.dimen.lb_details_v2_logo_margin_start));
        lp.topMargin = v.getResources().getDimensionPixelSize(android.support.v17.leanback.R.dimen.lb_details_v2_blank_height) - lp.height / 2;

        float offset = v.getResources().getDimensionPixelSize(android.support.v17.leanback.R.dimen.lb_details_v2_actions_height) + v
                .getResources().getDimensionPixelSize(android.support.v17.leanback.R.dimen.lb_details_v2_description_margin_top) + (lp.height / 2);

        switch (viewHolder.getState()) {
            case STATE_FULL:
            default:
                if (mPreviousState == STATE_HALF) {
                    v.animate().translationYBy(-offset);
                }

                break;
            case STATE_HALF:
                if (mPreviousState == STATE_FULL) {
                    v.animate().translationYBy(offset);
                }

                break;
        }
        mPreviousState = viewHolder.getState();
        v.setLayoutParams(lp);
    }
}
