package com.example.cpu11112_local.testleanbackshowcase.card.ui.detail;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v17.leanback.app.DetailsFragment;
import android.support.v17.leanback.app.DetailsFragmentBackgroundController;
import android.support.v17.leanback.widget.Action;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.DetailsOverviewRow;
import android.support.v17.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.OnItemViewClickedListener;
import android.support.v17.leanback.widget.OnItemViewSelectedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;
import android.support.v7.graphics.Palette;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.example.cpu11112_local.testleanbackshowcase.R;
import com.example.cpu11112_local.testleanbackshowcase.models.DetailedCard;
import com.example.cpu11112_local.testleanbackshowcase.models.PaletteColors;
import com.example.cpu11112_local.testleanbackshowcase.utils.CardListRow;
import com.example.cpu11112_local.testleanbackshowcase.utils.Constant;
import com.example.cpu11112_local.testleanbackshowcase.utils.PaletteUtils;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjection;

/**
 * Created by CPU11112-local on 10/17/2017.
 */

public class DetailViewExampleFragment extends DetailsFragment implements OnItemViewClickedListener,
        OnItemViewSelectedListener {
    public static final String TRANSITION_NAME = "t_for_transition";
    public static final String EXTRA_CARD = "card";
    public static final long ACTION_BUY = 1;
    public static final long ACTION_WISHLIST = 2;
    public static final long ACTION_RELATED = 3;

    @Inject
    @Named(Constant.BIG_ADAPTER)
    ArrayObjectAdapter mRowsAdapter;
    @Inject
    DetailsFragmentBackgroundController mDetailsBackground;
    @Inject
    DetailedCard data;
    @Inject
    DetailsOverviewRow detailsOverview;
    @Inject
    CardListRow cardListRow;
    @Inject
    ListRow listRow;
    @Inject
    FullWidthDetailsOverviewRowPresenter mFullWidthDetailsOverviewRowPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setupUi();
        setupEventListeners();
    }

    private void setupUi() {
        setTitle(getString(R.string.detail_view_title));
        prepareEntranceTransition();
        int imageResId = data.getLocalImageResourceId(getActivity());

        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null && extras.containsKey(EXTRA_CARD)) {
            imageResId = extras.getInt(EXTRA_CARD, imageResId);
        }
//        use glide to show this image -> so we can get the pallete color
        Glide.with(getActivity())
                .asBitmap()
                .load(imageResId)
                .listener(new RequestListener<Bitmap>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                        Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                            @Override
                            public void onGenerated(Palette palette) {
                                // FIXME: 10/17/2017 find out why the background color didn't change the color, still have blue depite i didn't set blue to it
                                PaletteColors colors = PaletteUtils.getPaletteColors(palette);
                                mFullWidthDetailsOverviewRowPresenter.setActionsBackgroundColor(colors.getStatusBarColor());
                                mFullWidthDetailsOverviewRowPresenter.setBackgroundColor(colors.getToolbarBackgroundColor());
                                if (data != null) {
                                    data.setPaletteColors(colors);
                                }
                                detailsOverview.setItem(data);
                                notifyDetailsChanged();
                            }
                        });
                        return false;
                    }
                })
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                        // when we have the bitmap, set to the image
                        detailsOverview.setImageBitmap(getActivity(), resource);
                    }
                });

        // step - detail row
        mRowsAdapter.add(detailsOverview);
        // step - related row
        mRowsAdapter.add(cardListRow);
        // step - recommend row
        mRowsAdapter.add(listRow);
        setAdapter(mRowsAdapter);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startEntranceTransition();
            }
        }, 500);
        initializeBackground(data);
    }

    // step - notify the big adapter to change the background color
    private void notifyDetailsChanged() {
        // only notify the detail row (not the list under)
        int index = mRowsAdapter.indexOf(detailsOverview);
        mRowsAdapter.notifyArrayItemRangeChanged(index, 1);
    }

    private void initializeBackground(DetailedCard data) {
        mDetailsBackground.enableParallax();
        mDetailsBackground.setCoverBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.background_canyon));
    }

    private void setupEventListeners() {
//        setOnItemViewSelectedListener(this);
        setOnItemViewClickedListener(this);
    }

    @Override
    public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
        if (!(item instanceof Action)) return;
        Action action = (Action) item;

        if (action.getId() == ACTION_RELATED) {
            setSelectedPosition(1);
        } else {
            Toast.makeText(getActivity(), getString(R.string.action_cicked), Toast.LENGTH_LONG)
                    .show();
        }
    }

    @Override
    public void onItemSelected(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
        if (mRowsAdapter.indexOf(row) > 0) {
            // FIXME: 10/18/2017 what does this method do, change what background
            int backgroundColor = getResources().getColor(R.color.detail_view_related_background);
            getView().setBackgroundColor(backgroundColor);
        } else {
            getView().setBackground(null);
        }
    }
}
