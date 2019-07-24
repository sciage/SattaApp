/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.example.sattaapp.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sattaapp.di.ActivityContext;
import com.example.sattaapp.ui.History.HistoryActivityMvpPresenter;
import com.example.sattaapp.ui.History.HistoryActivityMvpView;
import com.example.sattaapp.ui.History.HistoryActivityPresenter;
import com.example.sattaapp.ui.Homepage.LocationPageMvpPresenter;
import com.example.sattaapp.ui.Homepage.LocationPageMvpView;
import com.example.sattaapp.ui.Homepage.LocationPagePresenter;
import com.example.sattaapp.ui.Homepage.LoginScreenMvpPresenter;
import com.example.sattaapp.ui.Homepage.LoginScreenMvpView;
import com.example.sattaapp.ui.Homepage.LoginScreenPresenter;
import com.example.sattaapp.ui.Homepage.MainActivityMvpPresenter;
import com.example.sattaapp.ui.Homepage.MainActivityMvpView;
import com.example.sattaapp.ui.Homepage.MainActivityPresenter;
import com.example.sattaapp.ui.PlayMatka.PlayMatkaActivityMvpPresenter;
import com.example.sattaapp.ui.PlayMatka.PlayMatkaActivityMvpView;
import com.example.sattaapp.ui.PlayMatka.PlayMatkaActivityPresenter;
import com.example.sattaapp.ui.Result.ResultActivityMvpPresenter;
import com.example.sattaapp.ui.Result.ResultActivityMvpView;
import com.example.sattaapp.ui.Result.ResultActivityPresenter;
import com.example.sattaapp.ui.Withdraw.WithdrawMvpPresenter;
import com.example.sattaapp.ui.Withdraw.WithdrawMvpView;
import com.example.sattaapp.ui.Withdraw.WithdrawPresenter;
import com.example.sattaapp.utils.rx.AppSchedulerProvider;
import com.example.sattaapp.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by janisharali on 27/01/17.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }


    @Provides
    HistoryActivityMvpPresenter<HistoryActivityMvpView> provideHistoryActivityMvpPresenter(
            HistoryActivityPresenter<HistoryActivityMvpView> presenter) {
        return presenter;
    }

    @Provides
    LoginScreenMvpPresenter<LoginScreenMvpView> provideLoginScreenMvpPresenter(
            LoginScreenPresenter<LoginScreenMvpView> presenter) {
        return presenter;
    }

    @Provides
    LocationPageMvpPresenter<LocationPageMvpView> provideLocationPageMvpPresenter(
            LocationPagePresenter<LocationPageMvpView> presenter) {
        return presenter;
    }

    @Provides
    MainActivityMvpPresenter<MainActivityMvpView> provideMainActivityMvpPresenter(
            MainActivityPresenter<MainActivityMvpView> presenter) {
        return presenter;
    }

    @Provides
    PlayMatkaActivityMvpPresenter<PlayMatkaActivityMvpView> providePlayMatkaMvpPresenter(
            PlayMatkaActivityPresenter<PlayMatkaActivityMvpView> presenter) {
        return presenter;
    }

    @Provides
    ResultActivityMvpPresenter<ResultActivityMvpView> provideResultMvpPresenter(
            ResultActivityPresenter<ResultActivityMvpView> presenter) {
        return presenter;
    }

    @Provides
    WithdrawMvpPresenter<WithdrawMvpView> provideWithdrawtMvpPresenter(
            WithdrawPresenter<WithdrawMvpView> presenter) {
        return presenter;
    }

   /* @Provides
    ChatMvpPresenter<ChatMvpView> provideChatMvpPresenter(
            ChatPresenter<ChatMvpView> presenter) {
        return presenter;
    }
    */

    /*@Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    AboutMvpPresenter<AboutMvpView> provideAboutPresenter(
            AboutPresenter<AboutMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    RatingDialogMvpPresenter<RatingDialogMvpView> provideRateUsPresenter(
            RatingDialogPresenter<RatingDialogMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedMvpPresenter<FeedMvpView> provideFeedPresenter(
            FeedPresenter<FeedMvpView> presenter) {
        return presenter;
    }

    @Provides
    OpenSourceMvpPresenter<OpenSourceMvpView> provideOpenSourcePresenter(
            OpenSourcePresenter<OpenSourceMvpView> presenter) {
        return presenter;
    }

    @Provides
    BlogMvpPresenter<BlogMvpView> provideBlogMvpPresenter(
            BlogPresenter<BlogMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedPagerAdapter provideFeedPagerAdapter(AppCompatActivity activity) {
        return new FeedPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    OpenSourceAdapter provideOpenSourceAdapter() {
        return new OpenSourceAdapter(new ArrayList<OpenSourceResponse.Repo>());
    }

    @Provides
    BlogAdapter provideBlogAdapter() {
        return new BlogAdapter(new ArrayList<BlogResponse.Blog>());
    }



    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    } */
}
