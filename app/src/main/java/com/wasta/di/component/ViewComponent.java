package com.wasta.di.component;

import com.wasta.di.module.ViewModule;
import com.wasta.di.scope.PerActivity;
import com.wasta.ui.views.carousel.simple.SimpleCarouselView;
import com.wasta.ui.views.categories.CategoryListView;
import com.wasta.ui.views.topbar.TopBarView;
import com.wasta.ui.views.toprestaurants.TopRestaurantsView;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ViewModule.class)
public interface ViewComponent {
    void inject(CategoryListView view);

    void inject(TopBarView view);

    void inject(SimpleCarouselView view);

    void inject(TopRestaurantsView view);
}
