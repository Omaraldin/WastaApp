package com.wasta;

import android.app.Application;

import com.wasta.di.component.ApplicationComponent;
import com.wasta.di.component.DaggerApplicationComponent;
import com.wasta.di.module.ApplicationModule;
import com.wasta.di.module.NetworkModule;
import com.wasta.di.module.RxModule;

public class App extends Application {

    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        this.injectDependency();
    }

    private void injectDependency() {
        App.applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(getApplicationContext()))
                .networkModule(new NetworkModule())
                .rxModule(new RxModule())
                .build();

        App.applicationComponent.inject(this);
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
