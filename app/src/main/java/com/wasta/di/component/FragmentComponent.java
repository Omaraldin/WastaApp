package com.wasta.di.component;

import com.wasta.base.BaseFragment;
import com.wasta.di.module.FragmentModule;
import com.wasta.di.scope.PerActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    void inject(BaseFragment fragment);
}
