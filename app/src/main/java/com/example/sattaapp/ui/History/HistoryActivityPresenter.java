package com.example.sattaapp.ui.History;

import com.example.sattaapp.data.DataManager;
import com.example.sattaapp.ui.base.BasePresenter;
import com.example.sattaapp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class HistoryActivityPresenter <V extends HistoryActivityMvpView> extends BasePresenter<V>
        implements HistoryActivityMvpPresenter<V> {

    @Inject
    public HistoryActivityPresenter(DataManager dataManager,
                                 SchedulerProvider schedulerProvider,
                                 CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}

