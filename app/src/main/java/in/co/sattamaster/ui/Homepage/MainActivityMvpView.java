package in.co.sattamaster.ui.Homepage;

import in.co.sattamaster.ui.base.MvpView;
import in.co.sattamaster.ui.login.UserProfile;

public interface MainActivityMvpView extends MvpView {
    void getUserProfile(UserObject response);
}
