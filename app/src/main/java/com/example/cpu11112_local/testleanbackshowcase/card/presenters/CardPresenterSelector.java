package com.example.cpu11112_local.testleanbackshowcase.card.presenters;

import android.content.Context;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.PresenterSelector;

/**
 * Created by CPU11112-local on 10/16/2017.
 */
// TODO: 10/16/2017 implement choose the correct presenter
public class CardPresenterSelector extends PresenterSelector {
    private final Context mContext;

    public CardPresenterSelector(Context context) {
        mContext = context;
    }

    @Override
    public Presenter getPresenter(Object item) {
        return null;
    }
}
