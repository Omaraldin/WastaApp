package com.wasta.di.module;

import android.content.Context;

import com.wasta.di.scope.PerApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    @PerApplication
    @Provides
    Context provideContext() {
        return this.context;
    }
}
