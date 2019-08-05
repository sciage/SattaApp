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

package in.co.sattamaster.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import in.co.sattamaster.di.ActivityContext;
import in.co.sattamaster.ui.History.HistoryActivityMvpPresenter;
import in.co.sattamaster.ui.History.HistoryActivityMvpView;
import in.co.sattamaster.ui.History.HistoryActivityPresenter;
import in.co.sattamaster.ui.Homepage.LocationPageMvpPresenter;
import in.co.sattamaster.ui.Homepage.LocationPageMvpView;
import in.co.sattamaster.ui.Homepage.LocationPagePresenter;
import in.co.sattamaster.ui.login.LoginScreenMvpPresenter;
import in.co.sattamaster.ui.login.LoginScreenMvpView;
import in.co.sattamaster.ui.login.LoginScreenPresenter;
import in.co.sattamaster.ui.Homepage.MainActivityMvpPresenter;
import in.co.sattamaster.ui.Homepage.MainActivityMvpView;
import in.co.sattamaster.ui.Homepage.MainActivityPresenter;
import in.co.sattamaster.ui.PlayMatka.PlayMatkaActivityMvpPresenter;
import in.co.sattamaster.ui.PlayMatka.PlayMatkaActivityMvpView;
import in.co.sattamaster.ui.PlayMatka.PlayMatkaActivityPresenter;
import in.co.sattamaster.ui.Result.ResultActivityMvpPresenter;
import in.co.sattamaster.ui.Result.ResultActivityMvpView;
import in.co.sattamaster.ui.Result.ResultActivityPresenter;
import in.co.sattamaster.ui.Withdraw.WithdrawMvpPresenter;
import in.co.sattamaster.ui.Withdraw.WithdrawMvpView;
import in.co.sattamaster.ui.Withdraw.WithdrawPresenter;
import in.co.sattamaster.ui.login.RegisterMvpPresenter;
import in.co.sattamaster.ui.login.RegisterMvpView;
import in.co.sattamaster.ui.login.RegisterPresenter;
import in.co.sattamaster.utils.rx.AppSchedulerProvider;
import in.co.sattamaster.utils.rx.SchedulerProvider;

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
    RegisterMvpPresenter<RegisterMvpView> provideRegisterMvpPresenter(
            RegisterPresenter<RegisterMvpView> presenter) {
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
