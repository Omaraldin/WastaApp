package com.wasta.ui.views.toprestaurants;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wasta.App;
import com.wasta.R;
import com.wasta.databinding.ViewTopRestaurantsBinding;
import com.wasta.di.component.DaggerViewComponent;
import com.wasta.di.component.ViewComponent;
import com.wasta.di.module.ViewModule;
import com.wasta.models.store.Store;

import java.util.List;

import javax.inject.Inject;

public class TopRestaurantsView extends LinearLayout implements TopRestaurantsContract.View {

    private static final String TAG = "TopRestaurantsView";

    private TopRestaurantsAdapter mAdapter;

    private TextView mLoadError;

    @Inject
    public TopRestaurantsPresenter presenter;

    public TopRestaurantsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.injectDependency();
        this.init(attrs);
    }

    @Override
    public void init(@Nullable AttributeSet attrs) {
        final TypedArray attributes = getContext().obtainStyledAttributes(attrs, R.styleable.TopRestaurantsView);

        this.presenter.attach(this);
        this.initView();
    }

    @Override
    public void initView() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        ViewTopRestaurantsBinding binding = ViewTopRestaurantsBinding.inflate(inflater, this, true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);

        mLoadError = binding.loadError;
        mAdapter = new TopRestaurantsAdapter(this);

        RecyclerView list = binding.restaurantList;
        list.setLayoutManager(layoutManager);
        list.setAdapter(mAdapter);
    }

    @Override
    public void injectDependency() {
        ViewComponent viewComponent = DaggerViewComponent
                .builder()
                .viewModule(new ViewModule())
                .applicationComponent(App.getApplicationComponent())
                .build();

        viewComponent.inject(this);
    }

    @Override
    public void updateRestaurants(List<Store> restaurants) {
        mAdapter.updateList(restaurants);
    }

    @Override
    public void addRestaurants(List<Store> stores) {
        mAdapter.addAll(stores);
    }

    @Override
    public void showLoadError(boolean visible) {
        mLoadError.setVisibility(visible ? VISIBLE : INVISIBLE);
    }

    @Override
    public void onStoreClick(Store store) {
        Log.d(TAG, "onStoreClick (" + store.toString() + ")");
    }
}
