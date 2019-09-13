package in.co.sattamaster.ui.Result;

import android.content.SharedPreferences;

import in.co.sattamaster.di.PerActivity;
import in.co.sattamaster.ui.base.MvpPresenter;

@PerActivity
public interface PastResultMvpPresenter<V extends PastResultMvpView> extends MvpPresenter<V> {
    void getAllResult(String location_id, String from, String to, SharedPreferences sharedPreferences);
}
