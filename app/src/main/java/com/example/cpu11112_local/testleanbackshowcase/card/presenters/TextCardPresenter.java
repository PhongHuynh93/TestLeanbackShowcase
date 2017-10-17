package com.example.cpu11112_local.testleanbackshowcase.card.presenters;

import android.content.Context;

import com.example.cpu11112_local.testleanbackshowcase.models.Card;

/**
 * Created by CPU11112-local on 10/17/2017.
 */

public class TextCardPresenter extends AbstractCardPresenter<TextCardView> {

    public TextCardPresenter(Context context) {
        super(context);
    }

    @Override
    protected TextCardView onCreateView() {
        return new TextCardView(getContext());
    }

    @Override
    public void onBindViewHolder(Card card, TextCardView cardView) {
        cardView.updateUi(card);
    }

}
