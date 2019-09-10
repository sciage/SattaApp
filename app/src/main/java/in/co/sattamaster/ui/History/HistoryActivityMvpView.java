package in.co.sattamaster.ui.History;

import java.util.List;

import in.co.sattamaster.ui.base.MvpView;

public interface HistoryActivityMvpView extends MvpView {
    void getAllBids(HistoryPojo response);
}
