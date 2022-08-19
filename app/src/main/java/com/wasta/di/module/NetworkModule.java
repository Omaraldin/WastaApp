package com.wasta.di.module;

import android.content.Context;
import android.util.Log;

import com.wasta.api.APIService;
import com.wasta.di.scope.PerApplication;
import com.wasta.rx.ApplicationSchedulers;
import com.wasta.util.AppConstants;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    public static final String BASE_URL = "http://www.wk-egypt.com";
    public static final String API_URL = BASE_URL + "/api/";

    @PerApplication
    @Provides
    Retrofit provideRetrofit(OkHttpClient client, GsonConverterFactory converter, RxJava3CallAdapterFactory adapter) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(API_URL)
                .addCallAdapterFactory(adapter)
                .addConverterFactory(converter)
                .build();
    }

    @PerApplication
    @Provides
    OkHttpClient provideHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .cache(cache)
                .build();
    }

    @PerApplication
    @Provides
    Cache provideCache(File file) {
        return new Cache(file, 1024L * AppConstants.CACHE_SIZE);
    }


    @PerApplication
    @Provides
    File provideCacheFile(Context context) {
        return context.getFilesDir();
    }

    @Provides
    APIService provideAPIService(Retrofit retrofit) {
        return retrofit.create(APIService.class);
    }

    @PerApplication
    @Provides
    RxJava3CallAdapterFactory provideRxAdapter() {
        return RxJava3CallAdapterFactory.createWithScheduler(ApplicationSchedulers.INTERNET_SCHEDULER);
    }

    @Provides
    GsonConverterFactory provideGsonConverter() {
        return GsonConverterFactory.create();
    }
}
