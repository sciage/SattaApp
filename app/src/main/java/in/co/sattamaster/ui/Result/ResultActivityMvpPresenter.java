package in.co.sattamaster.ui.Result;

import in.co.sattamaster.di.PerActivity;
import in.co.sattamaster.ui.base.MvpPresenter;

@PerActivity
public interface ResultActivityMvpPresenter <V extends ResultActivityMvpView> extends MvpPresenter<V> {
}
