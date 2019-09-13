package in.co.sattamaster.ui.PlayMatka;

import android.content.SharedPreferences;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import in.co.sattamaster.di.PerActivity;
import in.co.sattamaster.ui.base.MvpPresenter;

@PerActivity
public interface PlayMatkaActivityMvpPresenter <V extends PlayMatkaActivityMvpView> extends MvpPresenter<V> {

    void sendBidSet(JsonObject bidset, SharedPreferences sharedPreferences);
}
