package in.co.sattamaster.ui.Homepage;

import java.util.List;

import in.co.sattamaster.ui.base.MvpView;

public interface LocationPageMvpView extends MvpView {
    void getLocationData(List<LocationPojo> response);
}
