package com.example.sattaapp.ui.Result;

import com.example.sattaapp.data.DataManager;
import com.example.sattaapp.ui.base.BasePresenter;
import com.example.sattaapp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class ResultActivityPresenter <V extends ResultActivityMvpView> extends BasePresenter<V>
        implements ResultActivityMvpPresenter<V> {

    @Inject
    public ResultActivityPresenter(DataManager dataManager,
                                   SchedulerProvider schedulerProvider,
                                   CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
