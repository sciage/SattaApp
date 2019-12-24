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

package in.co.sattamaster.data;


import android.content.Context;
import android.content.SharedPreferences;


import com.google.gson.JsonObject;

import java.util.List;

import in.co.sattamaster.data.network.ApiHeader;
import in.co.sattamaster.data.network.ApiHelper;
import in.co.sattamaster.data.prefs.PreferencesHelper;
import in.co.sattamaster.di.ApplicationContext;
import in.co.sattamaster.dto.Bid;
import in.co.sattamaster.ui.History.HistoryDetailsResponse;
import in.co.sattamaster.ui.History.HistoryPojo;
import in.co.sattamaster.ui.History.HistoryResponse;
import in.co.sattamaster.ui.Homepage.LocationPojo;
import in.co.sattamaster.ui.Homepage.UserObject;
import in.co.sattamaster.ui.Result.PastResultPOJO;
import in.co.sattamaster.ui.Result.ResultResponse;
import in.co.sattamaster.ui.Withdraw.WithdrawDetailsPojo;
import in.co.sattamaster.ui.Withdraw.WithdrawResponse;
import in.co.sattamaster.ui.Withdraw.WithdrawResponseTop;
import in.co.sattamaster.ui.login.AllModerators;
import in.co.sattamaster.ui.login.LoginResponse;
import in.co.sattamaster.ui.login.RegisterResponse;
import in.co.sattamaster.ui.login.UserProfile;
import io.reactivex.Single;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by janisharali on 27/01/17.
 */

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;


    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public Single<Bid> sendBidset(JsonObject bid, SharedPreferences sharedPreferences) {
        return mApiHelper.sendBidset(bid, sharedPreferences);
    }

    @Override
    public Single<RegisterResponse> registerUser(JsonObject bids, SharedPreferences sharedPreferences) {
        return mApiHelper.registerUser(bids,sharedPreferences);
    }

    @Override
    public Single<List<AllModerators>> getAllModerator(SharedPreferences sharedPreferences) {
        return mApiHelper.getAllModerator(sharedPreferences);
    }

    @Override
    public Single<LoginResponse> loginUser(JsonObject bids, SharedPreferences sharedPreferences) {
        return mApiHelper.loginUser(bids, sharedPreferences);
    }

    @Override
    public Single<UserObject> getUserProfile(SharedPreferences sharedPreferences) {
        return mApiHelper.getUserProfile(sharedPreferences);
    }

    @Override
    public Single<List<LocationPojo>> getCentres(SharedPreferences sharedPreferences) {
        return mApiHelper.getCentres(sharedPreferences);
    }

    @Override
    public Single<WithdrawResponseTop> makeWithdrawRequest(JsonObject withdraw, SharedPreferences sharedPreferences) {
        return mApiHelper.makeWithdrawRequest(withdraw, sharedPreferences);
    }

    @Override
    public Single<ResultResponse> getAllResult(String from, String to, SharedPreferences sharedPreferences) {
        return mApiHelper.getAllResult(from, to, sharedPreferences);
    }

    @Override
    public Single<List<PastResultPOJO>> getAllPastResult(String location_id, String from, String to, SharedPreferences sharedPreferences) {
        return mApiHelper.getAllPastResult(location_id, from, to, sharedPreferences);
    }

    @Override
    public Single<HistoryPojo> getBids(SharedPreferences sharedPreferences, String page) {
        return mApiHelper.getBids(sharedPreferences, page);
    }

    @Override
    public Single<HistoryDetailsResponse> getBidDetails(String id, SharedPreferences sharedPreferences) {
        return mApiHelper.getBidDetails(id, sharedPreferences);
    }

    @Override
    public Single<WithdrawDetailsPojo> getWithdrawDetails(SharedPreferences sharedPreferences, String page) {
        return mApiHelper.getWithdrawDetails(sharedPreferences, page);
    }

 /*   @Override
    public Single<List<PostsModel>> getImagePosts(String user_id, String onlyImages, String page) {
        return mApiHelper.getImagePosts(user_id, onlyImages, page);
    }
    */




    @Override
    public void updateApiHeader(Long userId, String accessToken) {

    }

    @Override
    public void setUserAsLoggedOut() {

    }

    @Override
    public void updateUserInfo(String userId, String user_token, LoggedInMode loggedInMode) {

    }

    @Override
    public void registerUserId(String userId) {

    }

    @Override
    public String getUserId() {
        return mPreferencesHelper.getUserId();
    }

    @Override
    public void registerToken(String token) {

    }

    @Override
    public String getToken() {
        return null;
    }

    /*
    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferencesHelper.setAccessToken(accessToken);
        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }


    @Override
    public Observable<Long> insertUser(User user) {
        return mDbHelper.insertUser(user);
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return mDbHelper.getAllUsers();
    }

    @Override
    public Single<RegisterResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest
                                                              request) {
        return mApiHelper.doGoogleLoginApiCall(request);
    }

    @Override
    public Single<RegisterResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest
                                                                request) {
        return mApiHelper.doFacebookLoginApiCall(request);
    }

    @Override
    public Single<RegisterResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest
                                                              request) {
        return mApiHelper.doServerLoginApiCall(request);
    }

    @Override
    public Single<LogoutResponse> doLogoutApiCall() {
        return mApiHelper.doLogoutApiCall();
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPreferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode);
    }

    @Override
    public Long getCurrentUserId() {
        return mPreferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Long userId) {
        mPreferencesHelper.setCurrentUserId(userId);
    }

    @Override
    public String getCurrentUserName() {
        return mPreferencesHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPreferencesHelper.setCurrentUserName(userName);
    }

    @Override
    public String getCurrentUserEmail() {
        return mPreferencesHelper.getCurrentUserEmail();
    }

    @Override
    public void setCurrentUserEmail(String email) {
        mPreferencesHelper.setCurrentUserEmail(email);
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return mPreferencesHelper.getCurrentUserProfilePicUrl();
    }

    @Override
    public void setCurrentUserProfilePicUrl(String profilePicUrl) {
        mPreferencesHelper.setCurrentUserProfilePicUrl(profilePicUrl);
    }

    @Override
    public void updateApiHeader(Long userId, String accessToken) {
        mApiHelper.getApiHeader().getProtectedApiHeader().setUserId(userId);
        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }

    @Override
    public void updateUserInfo(
            String accessToken,
            Long userId,
            LoggedInMode loggedInMode,
            String userName,
            String email,
            String profilePicPath) {

        setAccessToken(accessToken);
        setCurrentUserId(userId);
        setCurrentUserLoggedInMode(loggedInMode);
        setCurrentUserName(userName);
        setCurrentUserEmail(email);
        setCurrentUserProfilePicUrl(profilePicPath);

        updateApiHeader(userId, accessToken);
    }

    @Override
    public void setUserAsLoggedOut() {
        updateUserInfo(
                null,
                null,
                DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT,
                null,
                null,
                null);
    }

    @Override
    public Observable<Boolean> isQuestionEmpty() {
        return mDbHelper.isQuestionEmpty();
    }

    @Override
    public Observable<Boolean> isOptionEmpty() {
        return mDbHelper.isOptionEmpty();
    }

    @Override
    public Observable<Boolean> saveQuestion(Question question) {
        return mDbHelper.saveQuestion(question);
    }

    @Override
    public Observable<Boolean> saveOption(Option option) {
        return mDbHelper.saveOption(option);
    }

    @Override
    public Observable<Boolean> saveQuestionList(List<Question> questionList) {
        return mDbHelper.saveQuestionList(questionList);
    }

    @Override
    public Observable<Boolean> saveOptionList(List<Option> optionList) {
        return mDbHelper.saveOptionList(optionList);
    }

    @Override
    public Observable<List<Question>> getAllQuestions() {
        return mDbHelper.getAllQuestions();
    }

    @Override
    public Observable<Boolean> seedDatabaseQuestions() {

        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        return mDbHelper.isQuestionEmpty()
                .concatMap(new Function<Boolean, ObservableSource<? extends Boolean>>() {
                    @Override
                    public ObservableSource<? extends Boolean> apply(Boolean isEmpty)
                            throws Exception {
                        if (isEmpty) {
                            Type type = $Gson$Types
                                    .newParameterizedTypeWithOwner(null, List.class,
                                            Question.class);
                            List<Question> questionList = gson.fromJson(
                                    CommonUtils.loadJSONFromAsset(mContext,
                                            AppConstants.SEED_DATABASE_QUESTIONS),
                                    type);

                            return saveQuestionList(questionList);
                        }
                        return Observable.just(false);
                    }
                });
    }

    @Override
    public Observable<Boolean> seedDatabaseOptions() {

        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        return mDbHelper.isOptionEmpty()
                .concatMap(new Function<Boolean, ObservableSource<? extends Boolean>>() {
                    @Override
                    public ObservableSource<? extends Boolean> apply(Boolean isEmpty)
                            throws Exception {
                        if (isEmpty) {
                            Type type = new TypeToken<List<Option>>() {
                            }
                                    .getType();
                            List<Option> optionList = gson.fromJson(
                                    CommonUtils.loadJSONFromAsset(mContext,
                                            AppConstants.SEED_DATABASE_OPTIONS),
                                    type);

                            return saveOptionList(optionList);
                        }
                        return Observable.just(false);
                    }
                });
    }

    @Override
    public Single<BlogResponse> getBlogApiCall() {
        return mApiHelper.getBlogApiCall();
    }

    @Override
    public Single<OpenSourceResponse> getOpenSourceApiCall() {
        return mApiHelper.getOpenSourceApiCall();
    }
    */
}
