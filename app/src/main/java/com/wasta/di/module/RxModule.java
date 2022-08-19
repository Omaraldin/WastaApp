package com.wasta.di.module;

import com.wasta.di.scope.PerActivity;
import com.wasta.di.scope.PerApplication;
import com.wasta.rx.ApplicationSchedulers;
import com.wasta.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;

@Module
public class RxModule {

    @Provides
    RxSchedulers provideSchedulers() {
        return new ApplicationSchedulers();
    }

}
