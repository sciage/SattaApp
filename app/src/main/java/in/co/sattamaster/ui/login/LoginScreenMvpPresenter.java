package in.co.sattamaster.ui.login;

import android.content.SharedPreferences;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import in.co.sattamaster.di.PerActivity;
import in.co.sattamaster.ui.base.MvpPresenter;

@PerActivity
public interface LoginScreenMvpPresenter <V extends LoginScreenMvpView> extends MvpPresenter<V> {

    void sendBidSet(JsonObject login, SharedPreferences sharedPreferences);
}
