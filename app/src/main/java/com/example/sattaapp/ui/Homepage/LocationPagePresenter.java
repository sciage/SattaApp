package com.example.sattaapp.ui.Homepage;

import com.example.sattaapp.data.DataManager;
import com.example.sattaapp.ui.base.BasePresenter;
import com.example.sattaapp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class LocationPagePresenter <V extends LocationPageMvpView> extends BasePresenter<V>
        implements LocationPageMvpPresenter<V> {

    @Inject
    public LocationPagePresenter(DataManager dataManager,
                                 SchedulerProvider schedulerProvider,
                                 CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
