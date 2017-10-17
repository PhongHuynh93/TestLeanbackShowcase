package com.example.cpu11112_local.testleanbackshowcase.card.ui.detail;

import android.app.Activity;
import android.os.Bundle;

import com.example.cpu11112_local.testleanbackshowcase.R;

/**
 * Created by CPU11112-local on 10/17/2017.
 */

public class DetailViewExampleActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_example);

        if (savedInstanceState == null) {
            DetailViewExampleFragment fragment = new DetailViewExampleFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.details_fragment, fragment)
                    .commit();
        }
    }
}
