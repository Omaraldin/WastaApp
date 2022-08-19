package com.wasta.rx;

import io.reactivex.rxjava3.core.Scheduler;

public interface RxSchedulers {

    Scheduler androidThread();

    Scheduler internet();

}
