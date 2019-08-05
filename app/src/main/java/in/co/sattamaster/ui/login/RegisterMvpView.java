package in.co.sattamaster.ui.login;

import java.util.List;

import in.co.sattamaster.ui.base.MvpView;

public interface RegisterMvpView extends MvpView {

    void getListAllGroups(List<AllModerators> response);
    void getUserRegister(RegisterResponse response);
}
