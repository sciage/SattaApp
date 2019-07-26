package in.co.sattamaster.ui.Homepage;

import in.co.sattamaster.di.PerActivity;
import in.co.sattamaster.ui.base.MvpPresenter;

@PerActivity
public interface LocationPageMvpPresenter <V extends LocationPageMvpView> extends MvpPresenter<V> {
}
