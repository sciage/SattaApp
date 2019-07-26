package in.co.sattamaster.ui.Homepage;

import in.co.sattamaster.data.DataManager;
import in.co.sattamaster.ui.base.BasePresenter;
import in.co.sattamaster.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class LocationPagePresenter <V extends LocationPageMvpView> extends BasePresenter<V>
        implements LocationPageMvpPresenter<V> {

    @Inject
    public LocationPagePresenter(DataManager dataManager,
                                 SchedulerProvider schedulerProvider,
                                 CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
