package com.wasta.ui.views.categories;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.wasta.R;
import com.wasta.api.APIService;
import com.wasta.rx.RxSchedulers;
import com.wasta.util.NetworkUtils;

import java.util.Locale;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public class CategoryListPresenter implements CategoryListContract.Presenter {

    private CategoryListView view;

    private Context context;

    public APIService api;

    public RxSchedulers rxSchedulers;

    public CategoryListPresenter(APIService api, RxSchedulers rxSchedulers) {
        this.api = api;
        this.rxSchedulers = rxSchedulers;
    }

    @Override
    public void attach(CategoryListContract.View view) {
        this.view = (CategoryListView) view;
        this.context = this.view.getContext();

        this.loadCategories();
    }

    @Override
    public void detach() {
    }

    @Override
    public void loadCategories() {
        Locale locale = view.getResources().getConfiguration().getLocales().get(0);
        Observable.just(NetworkUtils.isNetworkAvailable(view.getContext()))
                .doOnNext(available -> {
                    if (!available) {
                        Toast.makeText(view.getContext(), view.getResources().getString(R.string.connection_error), Toast.LENGTH_SHORT).show();
                    }
                })
                .filter(available -> true)
                .flatMap(available -> api.getAllCategories(locale.getLanguage()))
                .subscribeOn(rxSchedulers.internet())
                .observeOn(rxSchedulers.androidThread())
                .subscribe(categories -> {
                    view.showLoadError(false);
                    view.updateCategoryList(categories.getData());

                }, throwable -> {
                    view.showLoadError(true);
                });
    }

}
