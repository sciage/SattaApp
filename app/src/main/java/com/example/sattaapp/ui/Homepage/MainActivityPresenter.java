package com.example.sattaapp.ui.Homepage;

import com.example.sattaapp.data.DataManager;
import com.example.sattaapp.ui.base.BasePresenter;
import com.example.sattaapp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivityPresenter <V extends MainActivityMvpView> extends BasePresenter<V>
        implements MainActivityMvpPresenter<V> {

    @Inject
    public MainActivityPresenter(DataManager dataManager,
                                      SchedulerProvider schedulerProvider,
                                      CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}


