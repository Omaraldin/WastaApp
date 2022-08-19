package com.wasta.rx;

import android.util.Log;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class ApplicationSchedulers implements RxSchedulers {
    private static final Executor INTERNET_EXECUTOR = Executors.newCachedThreadPool();

    public static Scheduler INTERNET_SCHEDULER = Schedulers.from(INTERNET_EXECUTOR);

    @Override
    public Scheduler androidThread() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler internet() {
        return INTERNET_SCHEDULER;
    }
}
