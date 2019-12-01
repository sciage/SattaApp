package in.co.sattamaster.retrofit;

import com.google.gson.JsonObject;

import java.util.List;

import in.co.sattamaster.data.network.ApiEndPoint;
import in.co.sattamaster.dto.Bid;
import in.co.sattamaster.ui.History.HistoryDetailsResponse;
import in.co.sattamaster.ui.History.HistoryPojo;
import in.co.sattamaster.ui.Homepage.LocationPojo;
import in.co.sattamaster.ui.Homepage.UserObject;
import in.co.sattamaster.ui.Result.PastResultPOJO;
import in.co.sattamaster.ui.Result.ResultResponse;
import in.co.sattamaster.ui.Withdraw.WithdrawResponseTop;
import in.co.sattamaster.ui.login.AllModerators;
import in.co.sattamaster.ui.login.LoginResponse;
import in.co.sattamaster.ui.login.RegisterResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NetworkInterface {

    @POST(ApiEndPoint.BIDSET)
    Single<Bid> sendBidset(@Body JsonObject bids);

    @POST(ApiEndPoint.WITHDRAW_REQUEST)
    Single<WithdrawResponseTop> makeWithdrawRequest(@Body JsonObject bids);

    @POST(ApiEndPoint.REGISTER_USER)
    Single<RegisterResponse> registerUser(@Body JsonObject bids);

   // @Headers("Content-Type: application/x-www-form-urlencoded")

   @POST(ApiEndPoint.LOGIN_USER)
    Single<LoginResponse> loginUser(@Body JsonObject object);


    @GET(ApiEndPoint.GET_ALL_MODERATORS)
    Single<List<AllModerators>> getAllModerator();

    @GET(ApiEndPoint.BIDSET)
    Single<HistoryPojo> getBids(@Query("page") String page);

    @GET(ApiEndPoint.BIDSET_ID)
    Single<HistoryDetailsResponse> getBidDetails(@Path("id") String id);

    @GET(ApiEndPoint.GET_ALL_PAST_RESULTS)
    Single<List<PastResultPOJO> >getAllPastResult(@Path("location_id") String location_id,
                                                  @Query("from") String from,
                                                  @Query("to") String to);

    @GET(ApiEndPoint.GET_USER_PROFILE)
    Single<UserObject> getUserProfile();

    @GET(ApiEndPoint.GET_ALL_MODERATORS)
    Single<ResultResponse> getAllResult();


    @GET(ApiEndPoint.GET_CENTRES)
    Single<List<LocationPojo>> getCentres();

}
