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
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class, FragmentBuilder.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

    void inject(App app);
}
