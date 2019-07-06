package com.example.sattaapp.ui.Withdraw;

import com.example.sattaapp.data.DataManager;
import com.example.sattaapp.ui.base.BasePresenter;
import com.example.sattaapp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class WithdrawPresenter <V extends WithdrawMvpView> extends BasePresenter<V>
        implements WithdrawMvpPresenter<V> {

    @Inject
    public WithdrawPresenter(DataManager dataManager,
                                   SchedulerProvider schedulerProvider,
                                   CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
