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

package in.co.sattamaster.data.network;


import android.content.SharedPreferences;

import com.google.gson.JsonObject;

import java.security.cert.CertificateException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import in.co.sattamaster.dto.Bid;
import in.co.sattamaster.retrofit.NetworkClient;
import in.co.sattamaster.retrofit.NetworkInterface;
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
import in.co.sattamaster.ui.base.MySharedPreferences;
import in.co.sattamaster.ui.login.AllModerators;
import in.co.sattamaster.ui.login.LoginResponse;
import in.co.sattamaster.ui.login.RegisterResponse;
import in.co.sattamaster.ui.login.UserProfile;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;

/**
 * Created by janisharali on 28/01/17.
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    // LOGIN REQUEST




    @Override
    public Single<Bid> sendBidset(JsonObject bids, SharedPreferences sharedPreferences) {
       /* return Rx2AndroidNetworking.post(ApiEndPoint.BIDSET)
                .setOkHttpClient(getUnsafeOkHttpClient())
                .addJsonObjectBody(bids)
                .build()
                .getObjectSingle(Bid.class); */

        return  NetworkClient.getRetrofit(sharedPreferences).create(NetworkInterface.class)
                .sendBidset(bids)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    @Override
    public Single<RegisterResponse> registerUser(JsonObject bids, SharedPreferences sharedPreferences) {
     /*   return Rx2AndroidNetworking.post(ApiEndPoint.REGISTER_USER)
                .setOkHttpClient(getUnsafeOkHttpClient())
                .addJsonObjectBody(bids)
                .build()
                .getObjectSingle(RegisterResponse.class);

      */
        return  NetworkClient.getRetrofit(sharedPreferences).create(NetworkInterface.class)
                .registerUser(bids)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single<LoginResponse> loginUser(JsonObject bids, SharedPreferences sharedPreferences) {
       /* return Rx2AndroidNetworking.post(ApiEndPoint.LOGIN_USER)
                .setOkHttpClient(getUnsafeOkHttpClient())
                .addJsonObjectBody(bids)
                .build()
                .getObjectSingle(LoginResponse.class); */

        return  NetworkClient.getRetrofit(sharedPreferences).create(NetworkInterface.class)
                .loginUser(bids)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single<WithdrawResponseTop> makeWithdrawRequest(JsonObject withdraw, SharedPreferences sharedPreferences) {
      /*  return Rx2AndroidNetworking.post(ApiEndPoint.WITHDRAW_REQUEST)
                .addHeaders("Authorization", "Bearer" + " " + token)
                .setOkHttpClient(getUnsafeOkHttpClient())
                .addJsonObjectBody(withdraw)
                .build()
                .getObjectSingle(WithdrawResponseTop.class); */

        return  NetworkClient.getRetrofit(sharedPreferences).create(NetworkInterface.class)
                .makeWithdrawRequest(withdraw)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    @Override
    public Single<List<AllModerators>> getAllModerator(SharedPreferences sharedPreferences) {
     /*   return Rx2AndroidNetworking.get(ApiEndPoint.GET_ALL_MODERATORS)
                .setOkHttpClient(getUnsafeOkHttpClient())
                .build()
                .getObjectListSingle(AllModerators.class);


      */
        return  NetworkClient.getRetrofit(sharedPreferences).create(NetworkInterface.class)
                .getAllModerator()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    @Override
    public Single<HistoryPojo> getBids(SharedPreferences sharedPreferences, String page) {
      /*  return Rx2AndroidNetworking.get(ApiEndPoint.BIDSET)
                .setOkHttpClient(getUnsafeOkHttpClient())
                .addHeaders("Authorization", "Bearer" + " " + token)
                .build()
                .getObjectSingle(HistoryPojo.class);

       */
        return  NetworkClient.getRetrofit(sharedPreferences).create(NetworkInterface.class)
                .getBids(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single<HistoryDetailsResponse> getBidDetails(String id, SharedPreferences sharedPreferences) {
       /* return Rx2AndroidNetworking.get(ApiEndPoint.BIDSET_ID)
                .setOkHttpClient(getUnsafeOkHttpClient())
                .addPathParameter("id", id)
                .build()
                .getObjectSingle(HistoryDetailsResponse.class);

        */
        return  NetworkClient.getRetrofit(sharedPreferences).create(NetworkInterface.class)
                .getBidDetails(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    @Override
    public Single<WithdrawDetailsPojo> getWithdrawDetails(SharedPreferences sharedPreferences, String page) {
        return  NetworkClient.getRetrofit(sharedPreferences).create(NetworkInterface.class)
                .getWithdrawHistory(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single<List<PastResultPOJO>> getAllPastResult(String location_id, String from, String to, SharedPreferences sharedPreferences) {
     /*   return Rx2AndroidNetworking.get(ApiEndPoint.GET_ALL_PAST_RESULTS)
                .setOkHttpClient(getUnsafeOkHttpClient())
                .addPathParameter("location_id", location_id)
                .addQueryParameter("from", from)
                .addQueryParameter("to", to)
                .build()
                .getObjectListSingle(PastResultPOJO.class); */
        return  NetworkClient.getRetrofit(sharedPreferences).create(NetworkInterface.class)
                .getAllPastResult(location_id, from, to)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    @Override
    public Single<ResultResponse> getAllResult(String from, String to, SharedPreferences sharedPreferences) {
      /*  return Rx2AndroidNetworking.get(ApiEndPoint.GET_ALL_MODERATORS)
                .setOkHttpClient(getUnsafeOkHttpClient())
                .addQueryParameter("from", from)
                .addQueryParameter("to", to)
                .build()
                .getObjectSingle(ResultResponse.class); */

        return  NetworkClient.getRetrofit(sharedPreferences).create(NetworkInterface.class)
                .getAllResult()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    @Override
    public Single<UserObject> getUserProfile(SharedPreferences sharedPreferences) {
   /*     return Rx2AndroidNetworking.get(ApiEndPoint.GET_USER_PROFILE)
                .addHeaders("Authorization", "Bearer" + " " + token)
                .setOkHttpClient(getUnsafeOkHttpClient())
                .build()
                .getObjectSingle(UserObject.class); */

        return  NetworkClient.getRetrofit(sharedPreferences).create(NetworkInterface.class)
                .getUserProfile()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    @Override
    public Single<List<LocationPojo>> getCentres(SharedPreferences sharedPreferences) {
      /*  return Rx2AndroidNetworking.get(ApiEndPoint.GET_CENTRES)
                .setOkHttpClient(getUnsafeOkHttpClient())
                .build()
                .getObjectListSingle(LocationPojo.class); */

        return  NetworkClient.getRetrofit(sharedPreferences).create(NetworkInterface.class)
                .getCentres()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }


    private static OkHttpClient getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager)trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            OkHttpClient okHttpClient = builder.build();
            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // block_user_insert.php


















    // post community group
/*
    @Override
    public Single<RegisterResponse> sendAgeOnlineApi(String name, String email, String userId, String deviceId, String socialNetwork) {
        return Rx2AndroidNetworking.post(ApiEndPoint.JOIN_CATEGORIES)
                // .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter("firstname", "Amit").addPathParameter("pageNumber", "0")
                .addQueryParameter("name", "10")
                .addQueryParameter("email", "10")
                .addQueryParameter("limit", "10")
                .addQueryParameter("limit", "10")
                .addQueryParameter("limit", "10").addBodyParameter(name,email,userId,deviceId,socialNetwork)
                .build()
                .getObjectSingle(RegisterResponse.class);
    }

    // get all groups

    @Override
    public Single<OpenSourceResponse> getCommunityGroup() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_OPEN_SOURCE)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectSingle(OpenSourceResponse.class);
    }




    // join all groups

    @Override
    public Single<RegisterResponse> sendAgeOnlineApi(String name, String email, String userId, String deviceId, String socialNetwork) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGIN)
                // .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter("firstname", "Amit").addPathParameter("pageNumber", "0")
                .addQueryParameter("name", "10")
                .addQueryParameter("email", "10")
                .addQueryParameter("limit", "10")
                .addQueryParameter("limit", "10")
                .addQueryParameter("limit", "10").addBodyParameter(name,email,userId,deviceId,socialNetwork)
                .build()
                .getObjectSingle(RegisterResponse.class);
    }








    @Override
    public Single<RegisterResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest
                                                              request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_GOOGLE_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(RegisterResponse.class);
    }

    @Override
    public Single<RegisterResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest
                                                                request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_FACEBOOK_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(RegisterResponse.class);
    }

    @Override
    public Single<RegisterResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest
                                                              request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(RegisterResponse.class);
    }

    @Override
    public Single<LogoutResponse> doLogoutApiCall() {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGOUT)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectSingle(LogoutResponse.class);
    }

    @Override
    public Single<BlogResponse> getBlogApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_BLOG)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectSingle(BlogResponse.class);
    }

    @Override
    public Single<OpenSourceResponse> getOpenSourceApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_OPEN_SOURCE)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectSingle(OpenSourceResponse.class);
    }

    */
}

