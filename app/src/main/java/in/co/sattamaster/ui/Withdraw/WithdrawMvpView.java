package in.co.sattamaster.ui.Withdraw;

import in.co.sattamaster.ui.base.MvpView;

public interface WithdrawMvpView extends MvpView {

    void withdrawResponse(WithdrawResponseTop response);
    void getWithdrawResponse(WithdrawDetailsPojo response);

}
