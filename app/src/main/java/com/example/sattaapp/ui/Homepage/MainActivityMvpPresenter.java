package com.example.sattaapp.ui.Homepage;

import com.example.sattaapp.di.PerActivity;
import com.example.sattaapp.ui.base.MvpPresenter;

@PerActivity
public interface MainActivityMvpPresenter <V extends MainActivityMvpView> extends MvpPresenter<V> {
}
