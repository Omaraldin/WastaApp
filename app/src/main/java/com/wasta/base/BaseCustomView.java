package com.wasta.base;

import android.util.AttributeSet;

import androidx.annotation.Nullable;

public interface BaseCustomView extends BaseContract.View {

    void init(@Nullable AttributeSet attrs);

    void initView();

    void injectDependency();
}
