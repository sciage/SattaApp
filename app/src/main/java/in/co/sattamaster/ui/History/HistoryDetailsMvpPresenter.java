package in.co.sattamaster.ui.History;

import android.content.SharedPreferences;

import in.co.sattamaster.ui.base.MvpPresenter;

public interface HistoryDetailsMvpPresenter <V extends HistoryDetailsMvpView> extends MvpPresenter<V> {
    void getBidDetails(String id,  SharedPreferences sharedPreferences);
}
