package com.example.cpu11112_local.testleanbackshowcase;

import android.app.Fragment;
import android.support.multidex.MultiDexApplication;

import com.example.cpu11112_local.testleanbackshowcase.dagger.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;

/**
 * Created by CPU11112-local on 10/16/2017.
 */

public class App extends MultiDexApplication implements HasFragmentInjector {
//    @Inject
//    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent.builder()
                .testapplication(this)
                .build()
                .inject(this);
    }

//    @Override
//    public DispatchingAndroidInjector<Activity> activityInjector() {
//        return activityDispatchingAndroidInjector;
//    }

    @Override
    public DispatchingAndroidInjector<Fragment> fragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
