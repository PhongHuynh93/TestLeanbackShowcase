package com.example.cpu11112_local.testleanbackshowcase

import android.app.Activity
import android.os.Bundle
import com.example.cpu11112_local.testleanbackshowcase.extensions.replaceFragmentSafely

/**
 * Created by CPU11112-local on 10/16/2017.
 */

class MainActivity : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            MainFragment.newInstance().replaceFragmentSafely(fragment = MainFragment.newInstance(), tag = "MainFragment", allowStateLoss = true, containerViewId = R.id.fragmentContainer)
        }
    }
}
