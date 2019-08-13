package in.co.sattamaster.ui.Withdraw;

import org.json.JSONObject;

import in.co.sattamaster.di.PerActivity;
import in.co.sattamaster.ui.base.MvpPresenter;

@PerActivity
public interface WithdrawMvpPresenter <V extends WithdrawMvpView> extends MvpPresenter<V> {

    void sendBidSet(JSONObject withdraw);


}
