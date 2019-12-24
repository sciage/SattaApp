package in.co.sattamaster.ui.Withdraw;

import android.content.SharedPreferences;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import in.co.sattamaster.di.PerActivity;
import in.co.sattamaster.ui.base.MvpPresenter;

@PerActivity
public interface WithdrawMvpPresenter <V extends WithdrawMvpView> extends MvpPresenter<V> {

    void sendBidSet(JsonObject withdraw, SharedPreferences sharedPreferences);

    void getWithdraw(SharedPreferences sharedPreferences, int page);


}
