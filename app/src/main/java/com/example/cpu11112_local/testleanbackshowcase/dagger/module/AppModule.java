package com.example.cpu11112_local.testleanbackshowcase.dagger.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.cpu11112_local.testleanbackshowcase.api.TestApiService;
import com.example.cpu11112_local.testleanbackshowcase.db.GithubDb;
import com.example.cpu11112_local.testleanbackshowcase.db.VideoDao;
import com.example.cpu11112_local.testleanbackshowcase.utils.Constant;
import com.example.cpu11112_local.testleanbackshowcase.utils.LiveDataCallAdapterFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

    //    step after getting from remote, add this into livedata(not observable)
    @Singleton
    @Provides
    OkHttpClient getClient(Context context) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // add loggingInterceptor to client
        // step - can add the key into the header via the interceptor
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(Constant.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(Constant.WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(Constant.TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor);
//                .addInterceptor(new AuthorizationInterceptor());

        // add cache to client
        final File baseDir = context.getCacheDir();
        if (baseDir != null) {
            final File cacheDir = new File(baseDir, Constant.CACHE_DIR);
            builder.cache(new Cache(cacheDir, Constant.CACHE_SIZE));
        }

        // build all client
        return builder.build();
    }

    @Singleton
    @Provides
    TestApiService provideTestApiService(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl("https://storage.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .client(client)
                .build()
                .create(TestApiService.class);
    }

    @Singleton
    @Provides
    GithubDb provideDb(Application app) {
        return Room.databaseBuilder(app, GithubDb.class, "github.db").build();
    }

    @Singleton
    @Provides
    VideoDao provideUserDao(GithubDb db) {
        return db.userDao();
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
