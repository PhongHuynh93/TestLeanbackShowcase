package com.example.cpu11112_local.testleanbackshowcase.card.presenters;

import android.content.Context;

import com.example.cpu11112_local.testleanbackshowcase.models.Card;

/**
 * Created by CPU11112-local on 10/17/2017.
 */
public class CharacterCardPresenter extends AbstractCardPresenter<CharacterCardView> {

    public CharacterCardPresenter(Context context) {
        super(context);
    }

    @Override
    protected CharacterCardView onCreateView() {
        return new CharacterCardView(getContext());
    }

    @Override
    public void onBindViewHolder(Card card, CharacterCardView cardView) {
        cardView.updateUi(card);
    }

}
