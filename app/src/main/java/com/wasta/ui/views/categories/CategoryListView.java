package com.wasta.ui.views.categories;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wasta.App;
import com.wasta.R;
import com.wasta.databinding.ViewCategoryListBinding;
import com.wasta.di.component.DaggerViewComponent;
import com.wasta.di.component.ViewComponent;
import com.wasta.di.module.ViewModule;
import com.wasta.models.category.Category;

import java.util.List;

import javax.inject.Inject;

public class CategoryListView extends LinearLayout implements CategoryListContract.View {
    private static final String TAG = "CategoryListView";
    
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    private int mOrientation;

    private CategoryListAdapter mAdapter;

    private TextView mLoadError;

    @Inject
    public CategoryListPresenter presenter;

    public CategoryListView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.injectDependency();
        this.init(attrs);
    }

    public void init(@Nullable AttributeSet attrs) {
        final TypedArray attributes = getContext().obtainStyledAttributes(attrs, R.styleable.CategoryListView);

        mOrientation = attributes.getInt(R.styleable.CategoryListView_orientation, HORIZONTAL);

        this.presenter.attach(this);
        this.initView();
    }

    public void initView() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        ViewCategoryListBinding binding = ViewCategoryListBinding.inflate(inflater, this, true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), mOrientation, false);

        mLoadError = binding.loadError;

        mAdapter = new CategoryListAdapter(this, null, HORIZONTAL);

        RecyclerView list = binding.categoryList;
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
    public void updateCategoryList(List<Category> categories) {
        mAdapter.updateList(categories);
    }

    @Override
    public void showLoadError(boolean visible) {
        mLoadError.setVisibility(visible ? VISIBLE : INVISIBLE);
    }

    @Override
    public void onCategoryClick(int id) {
        Log.d(TAG, "onCategoryClick(" + id + ")");
    }
}
