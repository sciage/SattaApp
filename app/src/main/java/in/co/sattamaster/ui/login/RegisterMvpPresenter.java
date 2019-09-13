package in.co.sattamaster.ui.login;

import android.content.SharedPreferences;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import in.co.sattamaster.di.PerActivity;
import in.co.sattamaster.ui.base.MvpPresenter;

@PerActivity
public interface RegisterMvpPresenter <V extends RegisterMvpView> extends MvpPresenter<V> {

    void getAllModerator(SharedPreferences sharedPreferences);
    void registerNewUser(JsonObject bids, SharedPreferences sharedPreferences);

}
