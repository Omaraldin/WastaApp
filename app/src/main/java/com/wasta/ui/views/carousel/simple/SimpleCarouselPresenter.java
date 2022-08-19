package com.wasta.ui.views.carousel.simple;

import android.content.Context;
import android.widget.Toast;

import com.wasta.R;
import com.wasta.api.APIService;
import com.wasta.models.slider.Slider;
import com.wasta.rx.RxSchedulers;
import com.wasta.util.NetworkUtils;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class SimpleCarouselPresenter implements SimpleCarouselContract.Presenter {
    private SimpleCarouselView view;

    private Context context;

    public APIService api;

    public RxSchedulers rxSchedulers;

    public SimpleCarouselPresenter(APIService api, RxSchedulers rxSchedulers) {
        this.api = api;
        this.rxSchedulers = rxSchedulers;
    }

    @Override
    public void attach(SimpleCarouselContract.View view) {
        this.view = (SimpleCarouselView) view;
        this.context = this.view.getContext();

        this.loadSliders();
    }

    @Override
    public void detach() {

    }

    @Override
    public void loadSliders() {
        Observable.just(NetworkUtils.isNetworkAvailable(view.getContext()))
                .doOnNext(available -> {
                    if (!available) {
                        Toast.makeText(view.getContext(), view.getResources().getString(R.string.connection_error), Toast.LENGTH_SHORT).show();
                    }
                })
                .filter(available -> true)
                .flatMap(available -> api.getSliders())
                .subscribeOn(rxSchedulers.internet())
                .observeOn(rxSchedulers.androidThread())
                .subscribe(sliders -> {
                    view.showLoadError(false);
                    List<Slider> sliderList = sliders.getData().get("SliderDTOs");
                    if (sliderList != null) {
                        view.updateSliders(sliderList);
                    } else {
                        view.showLoadError(true);
                    }
                }, throwable -> {
                    view.showLoadError(true);
                });
    }
}
