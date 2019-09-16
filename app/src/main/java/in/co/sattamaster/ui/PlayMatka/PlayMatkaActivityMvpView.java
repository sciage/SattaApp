package in.co.sattamaster.ui.PlayMatka;

import in.co.sattamaster.dto.Bid;
import in.co.sattamaster.ui.base.MvpView;

public interface PlayMatkaActivityMvpView extends MvpView {

    void receiveBidSetResult(Bid response);
    void biderror(String response);

}
