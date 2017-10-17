package com.example.cpu11112_local.testleanbackshowcase.card.presenters;

import android.content.Context;
import android.support.v17.leanback.widget.ImageCardView;

import com.bumptech.glide.Glide;
import com.example.cpu11112_local.testleanbackshowcase.models.Card;
import com.example.cpu11112_local.testleanbackshowcase.models.VideoCard;

/**
 * Created by CPU11112-local on 10/17/2017.
 */

public class VideoCardViewPresenter extends ImageCardViewPresenter{
    public VideoCardViewPresenter(Context context, int cardThemeResId) {
        super(context, cardThemeResId);
    }

    public VideoCardViewPresenter(Context context) {
        super(context);
    }

    @Override
    public void onBindViewHolder(Card card, final ImageCardView cardView) {
        super.onBindViewHolder(card, cardView);
        VideoCard videoCard = (VideoCard) card;
        Glide.with(getContext())
                .asBitmap()
                .load(videoCard.getImageUrl())
                .into(cardView.getMainImageView());

    }
}
