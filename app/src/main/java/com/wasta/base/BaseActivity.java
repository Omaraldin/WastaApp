package com.wasta.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wasta.R;

public abstract class BaseActivity extends AppCompatActivity implements BaseContract.View {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        this.injectDependency();
    }

    protected abstract void injectDependency();

}
