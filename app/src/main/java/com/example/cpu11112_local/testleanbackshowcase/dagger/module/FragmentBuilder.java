package com.example.cpu11112_local.testleanbackshowcase.dagger.module;

import com.example.cpu11112_local.testleanbackshowcase.MainFragment;
import com.example.cpu11112_local.testleanbackshowcase.card.ui.cardbrowser.CardExampleFragment;
import com.example.cpu11112_local.testleanbackshowcase.card.ui.detail.DetailViewExampleFragment;
import com.example.cpu11112_local.testleanbackshowcase.card.ui.pageListRow.GridFragment;
import com.example.cpu11112_local.testleanbackshowcase.card.ui.pageListRow.PageAndListRowFragment;
import com.example.cpu11112_local.testleanbackshowcase.card.ui.pageListRow.SampleFragmentA;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by CPU11112-local on 10/16/2017.
 */
@Module
public abstract class FragmentBuilder {
    @ContributesAndroidInjector(modules = MainFragmentModule.class)
    abstract MainFragment bindMainFragment();

    @ContributesAndroidInjector(modules = CardBrowserFragmentModule.class)
    abstract CardExampleFragment bindCardExampleFragment();

    @ContributesAndroidInjector(modules = DetailViewExampleFragmentModule.class)
    abstract DetailViewExampleFragment bindDetailViewExampleFragment();

    @ContributesAndroidInjector(modules = PageListRowModule.class)
    abstract PageAndListRowFragment bindPageAndListRowFragment();

    @ContributesAndroidInjector(modules = GridModule.class)
    abstract GridFragment bindGridFragment();

    @ContributesAndroidInjector(modules = SampleAModule.class)
    abstract SampleFragmentA bindSampleFragmentA();
}
