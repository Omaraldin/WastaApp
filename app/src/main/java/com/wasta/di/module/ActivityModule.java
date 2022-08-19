package com.wasta.di.module;

import com.wasta.di.scope.PerActivity;
import com.wasta.ui.activities.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    @PerActivity
    @Provides
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

}
