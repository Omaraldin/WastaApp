package com.wasta.base;

public interface BaseContract {

    interface View {
    }

    interface Presenter<T> {
        void attach(T view);

        void detach();
    }
}