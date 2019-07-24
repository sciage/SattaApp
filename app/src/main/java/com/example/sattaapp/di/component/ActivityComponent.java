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

package com.example.sattaapp.di.component;


import com.example.sattaapp.di.PerActivity;
import com.example.sattaapp.di.module.ActivityModule;
import com.example.sattaapp.ui.History.HistoryActivity;
import com.example.sattaapp.ui.Homepage.LocationPageActivity;
import com.example.sattaapp.ui.Homepage.LoginScreenActivity;
import com.example.sattaapp.ui.Homepage.MainActivity;
import com.example.sattaapp.ui.PlayMatka.PlayMatkaActivity;
import com.example.sattaapp.ui.Result.ResultActivity;
import com.example.sattaapp.ui.Withdraw.WithdrawActivity;

import dagger.Component;

/**
 * Created by janisharali on 27/01/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginScreenActivity activity);
    void inject(MainActivity activity);
    void inject(PlayMatkaActivity activity);
    void inject(HistoryActivity activity);
    void inject(LocationPageActivity activity);
    void inject(ResultActivity activity);
    void inject(WithdrawActivity activity);



  //  void inject(RateUsDialog dialog);

}
