package com.example.cpu11112_local.testleanbackshowcase.dagger.component;

import android.app.Application;

import com.example.cpu11112_local.testleanbackshowcase.App;
import com.example.cpu11112_local.testleanbackshowcase.dagger.module.ActivityBuilder;
import com.example.cpu11112_local.testleanbackshowcase.dagger.module.AppModule;
import com.example.cpu11112_local.testleanbackshowcase.dagger.module.FragmentBuilder;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by CPU11112-local on 10/16/2017.
 * step - AndroidInjectionModule:  Provides our activities and fragments with given module.
 * step - ActivityBuilder: This is a given module to dagger. We map all our activities here. And Dagger know our activities in compile time. In our app we have Main and Detail activity. So we map both activities here.
 * step - AppModule: We provide retrofit, okhttp, persistence db, shared pref etc here. There is an important detail here. We have to add our subcomponents to AppModule. So our dagger graph will undestand that.
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class, FragmentBuilder.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {

        // step - must have one argument, is the class we want to bind
        @BindsInstance
        Builder testapplication(Application application);

        AppComponent build();

    }

    void inject(App app);
}
