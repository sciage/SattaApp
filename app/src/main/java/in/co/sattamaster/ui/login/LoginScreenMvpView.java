package in.co.sattamaster.ui.login;

import in.co.sattamaster.ui.base.MvpView;

public interface LoginScreenMvpView  extends MvpView {

    void getLoginResponse(LoginResponse response);
    void getLoginError(String response);
}
