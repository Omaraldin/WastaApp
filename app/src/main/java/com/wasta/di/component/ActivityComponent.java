package com.wasta.di.component;

import com.wasta.di.module.ActivityModule;
import com.wasta.di.scope.PerActivity;
import com.wasta.ui.activities.main.MainActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
}
