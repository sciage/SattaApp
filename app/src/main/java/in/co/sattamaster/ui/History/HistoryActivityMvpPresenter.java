package in.co.sattamaster.ui.History;

import android.content.SharedPreferences;

import in.co.sattamaster.di.PerActivity;
import in.co.sattamaster.ui.base.MvpPresenter;

@PerActivity
public interface HistoryActivityMvpPresenter <V extends HistoryActivityMvpView> extends MvpPresenter<V> {

    void getBids(SharedPreferences sharedPreferences);
}
