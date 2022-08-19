package com.wasta.ui.views.topbar;

import com.wasta.ui.views.topbar.TopBarContract;

import javax.inject.Inject;

public class TopBarPresenter implements TopBarContract.Presenter {

    public TopBarContract.View view;

    @Inject
    public TopBarPresenter() {

    }

    @Override
    public void attach(TopBarContract.View view) {
        this.view = view;
    }

    @Override
    public void detach() {

    }

}
