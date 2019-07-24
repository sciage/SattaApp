package com.example.sattaapp.ui.Homepage;

import com.example.sattaapp.di.PerActivity;
import com.example.sattaapp.ui.base.MvpPresenter;

@PerActivity
public interface LoginScreenMvpPresenter  <V extends LoginScreenMvpView> extends MvpPresenter<V> {

    void doLogin (String phone, String password);
}
