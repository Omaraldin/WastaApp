package com.wasta.ui.views.toprestaurants;

import android.content.Context;
import android.widget.Toast;

import com.wasta.R;
import com.wasta.api.APIService;
import com.wasta.rx.RxSchedulers;
import com.wasta.util.NetworkUtils;

import io.reactivex.rxjava3.core.Observable;

public class TopRestaurantsPresenter implements TopRestaurantsContract.Presenter {
    TopRestaurantsView view;

    private Context context;

    public APIService api;

    public RxSchedulers rxSchedulers;

    public TopRestaurantsPresenter(APIService api, RxSchedulers rxSchedulers) {
        this.api = api;
        this.rxSchedulers = rxSchedulers;
    }

    @Override
    public void attach(TopRestaurantsContract.View view) {
        this.view = (TopRestaurantsView) view;
        this.context = this.view.getContext();

        this.loadTopData();
    }

    @Override
    public void detach() {

    }

    @Override
    public void loadTopData() {
        Observable.just(NetworkUtils.isNetworkAvailable(view.getContext()))
                .doOnNext(available -> {
                    if (!available) {
                        Toast.makeText(view.getContext(), view.getResources().getString(R.string.connection_error), Toast.LENGTH_SHORT).show();
                    }
                })
                .filter(available -> true)
                .flatMap(available -> api.getTopItems(-1))
                .subscribeOn(rxSchedulers.internet())
                .observeOn(rxSchedulers.androidThread())
                .subscribe(topResponse -> {
                    view.showLoadError(false);
                    topResponse.getTopItems()
                            .stream()
                            .filter(items -> items.getType() == 0)
                            .forEach(topItems -> {
                                if (topItems.getStores() != null) {
                                    view.addRestaurants(topItems.getStores());
                                }
                            });
                }, throwable -> {
                    view.showLoadError(true);
                    throwable.printStackTrace();
                });
    }
}
