package com.example.cpu11112_local.testleanbackshowcase.dagger.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by CPU11112-local on 10/16/2017.
 */
@Module
public class AppModule {
    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

//    @Provides
//    @Singleton
//    ApiService provideApiService() {
//        return new ApiService();
//    }
//    @Provides
//    @Singleton
//    DBService provideDBService(Context context) {
//        return new DBService(context);
//    }
    // for brevity
}
