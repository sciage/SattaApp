package in.co.sattamaster.ui.PlayMatka;

import org.json.JSONArray;
import org.json.JSONObject;

import in.co.sattamaster.di.PerActivity;
import in.co.sattamaster.ui.base.MvpPresenter;

@PerActivity
public interface PlayMatkaActivityMvpPresenter <V extends PlayMatkaActivityMvpView> extends MvpPresenter<V> {

    void sendBidSet(String user_id, String centre_id, JSONObject bidset);
}
