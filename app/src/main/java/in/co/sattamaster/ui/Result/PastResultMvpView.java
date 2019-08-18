package in.co.sattamaster.ui.Result;

import java.util.List;

import in.co.sattamaster.ui.base.MvpView;

public interface PastResultMvpView extends MvpView {
    void getAllResult(List<PastResultPOJO> response);
}
