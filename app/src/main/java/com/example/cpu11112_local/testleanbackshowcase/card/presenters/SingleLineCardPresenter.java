package com.example.cpu11112_local.testleanbackshowcase.card.presenters;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v17.leanback.widget.ImageCardView;

import com.example.cpu11112_local.testleanbackshowcase.R;
import com.example.cpu11112_local.testleanbackshowcase.models.Card;

/**
 * Created by CPU11112-local on 10/17/2017.
 */

public class SingleLineCardPresenter extends ImageCardViewPresenter {
    public SingleLineCardPresenter(Context context) {
        super(context, R.style.SingleLineCardTheme);
    }

    @Override
    public void onBindViewHolder(Card card, ImageCardView cardView) {
        super.onBindViewHolder(card, cardView);
        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(R.styleable.lbImageCardView);
        android.util.Log.d("SHAAN", "lbImageCardViewType =" + typedArray.getInt(R.styleable.lbImageCardView_lbImageCardViewType, -1));
        cardView.setInfoAreaBackgroundColor(card.getFooterColor());
    }

}
