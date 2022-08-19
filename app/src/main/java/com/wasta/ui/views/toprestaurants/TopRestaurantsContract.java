package com.wasta.ui.views.toprestaurants;

import com.wasta.base.BaseContract;
import com.wasta.base.BaseCustomView;
import com.wasta.models.store.Store;

import java.util.List;

public interface TopRestaurantsContract {
    interface View extends BaseCustomView {
        void updateRestaurants(List<Store> restaurants);

        void addRestaurants(List<Store> stores);

        void showLoadError(boolean visible);

        void onStoreClick(Store store);
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void loadTopData();
    }
}
