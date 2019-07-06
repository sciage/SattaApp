package com.example.sattaapp.ui.PlayMatka;

import com.example.sattaapp.data.DataManager;
import com.example.sattaapp.ui.base.BasePresenter;
import com.example.sattaapp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class PlayMatkaActivityPresenter <V extends PlayMatkaActivityMvpView> extends BasePresenter<V>
        implements PlayMatkaActivityMvpPresenter<V> {

    @Inject
    public PlayMatkaActivityPresenter(DataManager dataManager,
                                      SchedulerProvider schedulerProvider,
                                      CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
