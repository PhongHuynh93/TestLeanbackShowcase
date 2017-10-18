package com.example.cpu11112_local.testleanbackshowcase.card.ui.pageListRow;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.v17.leanback.widget.TitleViewAdapter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.cpu11112_local.testleanbackshowcase.R;
import com.example.cpu11112_local.testleanbackshowcase.databinding.CustomTitleviewBinding;

/**
 * Created by CPU11112-local on 10/18/2017.
 * info - create the custome title with the image
 */
public class CustomTitleView extends RelativeLayout implements TitleViewAdapter.Provider {
    private CustomTitleviewBinding mDataBinding;

    // step - need this adapter to auto show/hide the title in the toolbar
    private TitleViewAdapter mAdapter = new TitleViewAdapter() {
        @Override
        public View getSearchAffordanceView() {
            return mDataBinding.searchOrb;
        }


        @Override
        public void setTitle(CharSequence titleText) {
            CustomTitleView.this.setTitle(titleText);
        }

        @Override
        public void setBadgeDrawable(Drawable drawable) {
            //CustomTitleView.this.setBadgeDrawable(drawable);
        }

        @Override
        public void setOnSearchClickedListener(OnClickListener listener) {
            mDataBinding.searchOrb.setOnClickListener(listener);
        }

        @Override
        public void updateComponentsVisibility(int flags) {
            /*if ((flags & BRANDING_VIEW_VISIBLE) == BRANDING_VIEW_VISIBLE) {
                updateBadgeVisibility(true);
            } else {
                mAnalogClockView.setVisibility(View.GONE);
                mTitleView.setVisibility(View.GONE);
            }*/

            int visibility = (flags & SEARCH_VIEW_VISIBLE) == SEARCH_VIEW_VISIBLE
                    ? View.VISIBLE : View.INVISIBLE;
            mDataBinding.searchOrb.setVisibility(visibility);
        }

        private void updateBadgeVisibility(boolean visible) {
            if (visible) {
                mDataBinding.clock.setVisibility(View.VISIBLE);
                mDataBinding.titleTv.setVisibility(View.VISIBLE);
            } else {
                mDataBinding.clock.setVisibility(View.GONE);
                mDataBinding.titleTv.setVisibility(View.GONE);
            }
        }
    };

    public CustomTitleView(Context context) {
        super(context, null);
    }

    public CustomTitleView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public CustomTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mDataBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.custom_titleview, this, false);
    }

    public void setTitle(CharSequence title) {
        if (title != null) {
            mDataBinding.titleTv.setText(title);
            mDataBinding.titleTv.setVisibility(View.VISIBLE);
            mDataBinding.clock.setVisibility(View.VISIBLE);
        }
    }


    public void setBadgeDrawable(Drawable drawable) {
        if (drawable != null) {
            mDataBinding.titleTv.setVisibility(View.GONE);
            mDataBinding.clock.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public TitleViewAdapter getTitleViewAdapter() {
        return mAdapter;
    }
}
