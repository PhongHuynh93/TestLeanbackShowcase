package com.example.cpu11112_local.testleanbackshowcase.card.presenters;

import android.content.Context;
import android.support.v17.leanback.widget.BaseCardView;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.cpu11112_local.testleanbackshowcase.R;
import com.example.cpu11112_local.testleanbackshowcase.models.Card;

/**
 * Created by CPU11112-local on 10/17/2017.
 */

public class SideInfoCardPresenter extends AbstractCardPresenter<BaseCardView>{

    public SideInfoCardPresenter(Context context) {
        super(context);
    }

    @Override
    protected BaseCardView onCreateView() {
        final BaseCardView cardView = new BaseCardView(getContext(), null,
                R.style.SideInfoCardStyle);
        cardView.setFocusable(true);
        cardView.addView(LayoutInflater.from(getContext()).inflate(R.layout.side_info_card, null));
        return cardView;
    }

    @Override
    public void onBindViewHolder(Card card, BaseCardView cardView) {
        ImageView imageView = (ImageView) cardView.findViewById(R.id.main_image);
        if (card.getLocalImageResourceName() != null) {
            int width = (int) getContext().getResources()
                    .getDimension(R.dimen.sidetext_image_card_width);
            int height = (int) getContext().getResources()
                    .getDimension(R.dimen.sidetext_image_card_height);
            int resourceId = getContext().getResources()
                    .getIdentifier(card.getLocalImageResourceName(),
                            "drawable", getContext().getPackageName());
            RequestOptions myOptions = new RequestOptions()
                    .override(width, height);
            Glide.with(getContext())
                    .asBitmap()
                    .load(resourceId)
                    .apply(myOptions)
                    .into(imageView);
        }

        TextView primaryText = (TextView) cardView.findViewById(R.id.primary_text);
        primaryText.setText(card.getTitle());

        TextView secondaryText = (TextView) cardView.findViewById(R.id.secondary_text);
        secondaryText.setText(card.getDescription());

        TextView extraText = (TextView) cardView.findViewById(R.id.extra_text);
        extraText.setText(card.getExtraText());
    }

}
