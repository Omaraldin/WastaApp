package com.wasta.ui.views.carousel.simple;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.wasta.App;
import com.wasta.R;
import com.wasta.databinding.ViewSimpleCarouselBinding;
import com.wasta.di.component.DaggerViewComponent;
import com.wasta.di.component.ViewComponent;
import com.wasta.di.module.ViewModule;
import com.wasta.models.slider.Slider;

import java.util.List;

import javax.inject.Inject;

public class SimpleCarouselView extends RelativeLayout implements SimpleCarouselContract.View {

    private static final String TAG = "SimpleCarouselView";

    @Inject
    public SimpleCarouselPresenter presenter;

    private boolean pagination;

    private int delay;

    private ViewPager2 mPager;

    private LinearLayout mPagination;

    private SimpleCarouselAdapter mAdapter;

    private TextView mLoadError;

    private Runnable runnable;

    private Handler localHandler;

    public SimpleCarouselView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.injectDependency();
        this.init(attrs);
    }

    public boolean isPagination() {
        return pagination;
    }

    public void setPagination(boolean pagination) {
        this.pagination = pagination;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public void init(@Nullable AttributeSet attrs) {
        final TypedArray attributes = getContext().obtainStyledAttributes(attrs, R.styleable.SimpleCarouselView);

        pagination = attributes.getBoolean(R.styleable.SimpleCarouselView_pagination, true);

        delay = attributes.getInteger(R.styleable.SimpleCarouselView_delay, 5000);

        localHandler = new Handler(Looper.myLooper());

        this.presenter.attach(this);
        this.initView();
    }

    @Override
    public void initView() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        ViewSimpleCarouselBinding binding = ViewSimpleCarouselBinding.inflate(inflater, this, true);

        mPager = binding.pager;
        mPagination = binding.pagination;

        if (!pagination) {
            mPagination.setVisibility(INVISIBLE);
        }

        mAdapter = new SimpleCarouselAdapter(this);
        mLoadError = binding.loadError;

        initEvents();

        mPager.setAdapter(mAdapter);
        mPager.setOffscreenPageLimit(3);
        mPager.setClipToPadding(false);
        mPager.setClipChildren(false);
        mPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

    }

    private void initEvents() {
        runnable = () -> {
            if (mPager.getCurrentItem() == mAdapter.getItemCount() - 1) {
                mPager.setCurrentItem(0);
            } else {
                mPager.setCurrentItem(mPager.getCurrentItem() + 1);
            }
        };

        localHandler.postDelayed(runnable, delay);

        mPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                localHandler.removeCallbacks(runnable);
                localHandler.postDelayed(runnable, delay);

                for (int i = 0; i < mAdapter.getItemCount(); ++i) {
                    @Nullable ImageView pageShape = (ImageView) mPagination.getChildAt(i);
                    if (pageShape != null) {
                        pageShape.setAlpha(position == i ? 1 : 0.5f);
                    }
                }

            }
        });

        mAdapter.registerOnChange(() -> {
            mPagination.removeAllViews();

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            for (int i = 0; i < mAdapter.getItemCount(); ++i) {
                int position = i;

                ImageView pageShape = new ImageView(getContext());
                pageShape.setImageResource(R.drawable.slider_dot);
                pageShape.setLayoutParams(layoutParams);
                pageShape.setOnClickListener(view -> {
                    mPager.setCurrentItem(position);
                });
                pageShape.setPadding(5, 5, 20, 5);
                mPagination.addView(pageShape);
            }

        });
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
    public void addSlider(Slider slider) {
        mAdapter.addOne(slider);
    }

    @Override
    public void updateSliders(List<Slider> sliders) {
        mAdapter.updateList(sliders);
    }

    @Override
    public void showLoadError(boolean visible) {
        mLoadError.setVisibility(visible ? VISIBLE : INVISIBLE);
    }

    @Override
    public void onSliderClick(Slider slider) {
        Log.d(TAG, "onSliderClick (" + slider.toString() + ")");
    }
}
