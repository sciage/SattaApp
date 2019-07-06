package com.example.sattaapp.ui.Homepage;

import com.example.sattaapp.di.PerActivity;
import com.example.sattaapp.ui.base.MvpPresenter;

@PerActivity
public interface LocationPageMvpPresenter <V extends LocationPageMvpView> extends MvpPresenter<V> {
}
