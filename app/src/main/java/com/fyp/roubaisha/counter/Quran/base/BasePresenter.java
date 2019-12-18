package com.fyp.roubaisha.counter.Quran.base;

/**
 * Created by jonesrandom on 2/21/18.
 *
 * @site www.androidexample.web.id
 * @github @alfianyusufabdullah
 */

public class BasePresenter<V> {

    public V mView;

    public void attach(V view) {
        mView = view;
    }

    public void detach() {
        mView = null;
    }
}
