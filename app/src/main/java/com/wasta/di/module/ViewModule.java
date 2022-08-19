package com.wasta.di.module;

import com.wasta.api.APIService;
import com.wasta.di.scope.PerActivity;
import com.wasta.rx.RxSchedulers;
import com.wasta.ui.views.carousel.simple.SimpleCarouselPresenter;
import com.wasta.ui.views.categories.CategoryListPresenter;
import com.wasta.ui.views.topbar.TopBarPresenter;
import com.wasta.ui.views.toprestaurants.TopRestaurantsPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModule {

    @PerActivity
    @Provides
    CategoryListPresenter provideCategoryListPresenter(APIService apiService, RxSchedulers rxSchedulers) {
        return new CategoryListPresenter(apiService, rxSchedulers);
    }

    @PerActivity
    @Provides
    TopBarPresenter provideTopBarPresenter() {
        return new TopBarPresenter();
    }

    @PerActivity
    @Provides
    SimpleCarouselPresenter provideSimpleCarouselPresenter(APIService apiService, RxSchedulers rxSchedulers) {
        return new SimpleCarouselPresenter(apiService, rxSchedulers);
    }

    @Provides
    TopRestaurantsPresenter provideTopRestaurantsPresenter(APIService apiService, RxSchedulers rxSchedulers) {
        return new TopRestaurantsPresenter(apiService, rxSchedulers);
    }

}
