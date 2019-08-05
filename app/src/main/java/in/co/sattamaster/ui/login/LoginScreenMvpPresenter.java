package in.co.sattamaster.ui.login;

import org.json.JSONObject;

import in.co.sattamaster.di.PerActivity;
import in.co.sattamaster.ui.base.MvpPresenter;

@PerActivity
public interface LoginScreenMvpPresenter <V extends LoginScreenMvpView> extends MvpPresenter<V> {

    void sendBidSet(JSONObject login);
}
