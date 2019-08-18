package in.co.sattamaster.ui.History;

import in.co.sattamaster.ui.base.MvpPresenter;

public interface HistoryDetailsMvpPresenter <V extends HistoryDetailsMvpView> extends MvpPresenter<V> {
    void getBidDetails(String id);
}
