package com.wasta.di.component;

import com.wasta.App;
import com.wasta.api.APIService;
import com.wasta.di.module.ApplicationModule;
import com.wasta.di.module.NetworkModule;
import com.wasta.di.module.RxModule;
import com.wasta.di.scope.PerApplication;
import com.wasta.rx.RxSchedulers;

import dagger.Component;

@PerApplication
@Component(modules = {ApplicationModule.class, NetworkModule.class, RxModule.class})
public interface ApplicationComponent {

    APIService getAPIService();

    RxSchedulers getRxSchedulers();

    void inject(App application);

}
