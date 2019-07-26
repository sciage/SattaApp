package in.co.sattamaster.ui.Homepage;

import in.co.sattamaster.di.PerActivity;
import in.co.sattamaster.ui.base.MvpPresenter;

@PerActivity
public interface LoginScreenMvpPresenter  <V extends LoginScreenMvpView> extends MvpPresenter<V> {

    void doLogin (String phone, String password);
}
