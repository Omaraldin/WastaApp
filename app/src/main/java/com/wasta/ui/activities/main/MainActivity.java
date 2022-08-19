package com.wasta.ui.activities.main;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.wasta.App;
import com.wasta.base.BaseActivity;
import com.wasta.databinding.ActivityMainBinding;
import com.wasta.di.component.ActivityComponent;
import com.wasta.di.component.DaggerActivityComponent;
import com.wasta.di.module.ActivityModule;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainContract.View, SwipeRefreshLayout.OnRefreshListener {
    @Inject
    public MainPresenter presenter;

    public SwipeRefreshLayout mRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mRefreshLayout = binding.refreshLayout;
        mRefreshLayout.setOnRefreshListener(this);

        this.presenter.attach(this);
    }

    @Override
    protected void injectDependency() {
        ActivityComponent activityComponent = DaggerActivityComponent
                .builder()
                .activityModule(new ActivityModule())
                .applicationComponent(App.getApplicationComponent())
                .build();
        activityComponent.inject(this);
    }

    @Override
    public void onRefresh() {
        mRefreshLayout.setRefreshing(false);

        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
    }
}
