package com.example.cpu11112_local.testleanbackshowcase.dagger.module;

import com.example.cpu11112_local.testleanbackshowcase.MainFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by CPU11112-local on 10/16/2017.
 */
@Module
public abstract class FragmentBuilder {
    @ContributesAndroidInjector(modules = MainFragmentModule.class)
    abstract MainFragment bindMainFragment();
}
