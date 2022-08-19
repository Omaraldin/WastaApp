package com.wasta.ui.activities.main;

import com.wasta.ui.activities.main.MainContract;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;

    public MainPresenter() {
    }

    @Override
    public void attach(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detach() {

    }
}
