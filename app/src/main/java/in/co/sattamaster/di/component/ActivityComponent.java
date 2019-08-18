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

package in.co.sattamaster.di.component;


import in.co.sattamaster.di.PerActivity;
import in.co.sattamaster.di.module.ActivityModule;
import in.co.sattamaster.ui.History.HistoryActivity;
import in.co.sattamaster.ui.Homepage.LocationPageActivity;
import in.co.sattamaster.ui.Result.PastResultActivity;
import in.co.sattamaster.ui.Result.ResultActivity;
import in.co.sattamaster.ui.login.LoginScreenActivity;
import in.co.sattamaster.ui.Homepage.MainActivity;
import in.co.sattamaster.ui.PlayMatka.PlayMatkaActivity;
import in.co.sattamaster.ui.Withdraw.WithdrawActivity;

import dagger.Component;
import in.co.sattamaster.ui.login.RegisterActivity;

/**
 * Created by janisharali on 27/01/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginScreenActivity activity);
    void inject(RegisterActivity activity);
    void inject(MainActivity activity);
    void inject(PlayMatkaActivity activity);
    void inject(HistoryActivity activity);
    void inject(LocationPageActivity activity);
    void inject(ResultActivity activity);
    void inject(WithdrawActivity activity);
    void inject(PastResultActivity activity);



  //  void inject(RateUsDialog dialog);

}
