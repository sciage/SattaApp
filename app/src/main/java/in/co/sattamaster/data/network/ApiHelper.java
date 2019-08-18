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


import org.json.JSONObject;

import java.util.List;

import in.co.sattamaster.dto.Bid;
import in.co.sattamaster.ui.History.HistoryDetailsResponse;
import in.co.sattamaster.ui.History.HistoryResponse;
import in.co.sattamaster.ui.Homepage.LocationPojo;
import in.co.sattamaster.ui.Homepage.UserObject;
import in.co.sattamaster.ui.Result.PastResultPOJO;
import in.co.sattamaster.ui.Result.ResultResponse;
import in.co.sattamaster.ui.Withdraw.WithdrawResponse;
import in.co.sattamaster.ui.Withdraw.WithdrawResponseTop;
import in.co.sattamaster.ui.login.AllModerators;
import in.co.sattamaster.ui.login.LoginResponse;
import in.co.sattamaster.ui.login.RegisterResponse;
import in.co.sattamaster.ui.login.UserProfile;
import io.reactivex.Single;

/**
 * Created by janisharali on 27/01/17.
 */

public interface ApiHelper {

    ApiHeader getApiHeader();

    Single<Bid> sendBidset(JSONObject bidset);
    Single<RegisterResponse> registerUser(JSONObject bids);
    Single<List<AllModerators>> getAllModerator();
    Single<LoginResponse> loginUser(JSONObject bids);
    Single<UserObject> getUserProfile(String token);
    Single<List<LocationPojo>> getCentres(String token);
    Single<WithdrawResponseTop> makeWithdrawRequest(JSONObject withdraw, String token);
    Single<ResultResponse> getAllResult(String from, String to);
    Single<List<PastResultPOJO>> getAllPastResult(String location_id, String from, String to);
    Single<List<HistoryResponse>> getBids(String token);
    Single<HistoryDetailsResponse> getBidDetails(String id);

  //  Single<List<PostsModel>> getImagePosts(String user_id, String onlyImages, String page);


}
