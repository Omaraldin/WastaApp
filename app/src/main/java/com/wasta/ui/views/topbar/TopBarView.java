package com.wasta.ui.views.topbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.wasta.App;
import com.wasta.R;
import com.wasta.di.component.DaggerViewComponent;
import com.wasta.di.component.ViewComponent;
import com.wasta.di.module.ViewModule;

import javax.inject.Inject;

public class TopBarView extends LinearLayout implements TopBarContract.View {

    @Inject
    TopBarPresenter presenter;

    public TopBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.injectDependency();
        this.init(attrs);
    }

    public void init(@Nullable AttributeSet attrs) {
        final TypedArray attributes = getContext().obtainStyledAttributes(attrs, R.styleable.TopBar);

        this.initView();
        this.presenter.attach(this);
    }

    public void initView() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.view_topbar, this);
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

}
