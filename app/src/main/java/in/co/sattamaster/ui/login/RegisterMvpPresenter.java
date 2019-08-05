package in.co.sattamaster.ui.login;

import in.co.sattamaster.di.PerActivity;
import in.co.sattamaster.ui.base.MvpPresenter;

@PerActivity
public interface RegisterMvpPresenter <V extends RegisterMvpView> extends MvpPresenter<V> {

    void getAllModerator();
}
