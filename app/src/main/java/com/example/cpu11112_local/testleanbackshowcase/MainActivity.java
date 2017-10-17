package com.example.cpu11112_local.testleanbackshowcase;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by CPU11112-local on 10/17/2017.
 */

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            Fragment fragment = new MainFragment();
            getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment)
                    .commit();
        }
    }
}
