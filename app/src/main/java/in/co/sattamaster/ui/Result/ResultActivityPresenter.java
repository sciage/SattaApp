package in.co.sattamaster.ui.Result;

import in.co.sattamaster.data.DataManager;
import in.co.sattamaster.ui.base.BasePresenter;
import in.co.sattamaster.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class ResultActivityPresenter <V extends ResultActivityMvpView> extends BasePresenter<V>
        implements ResultActivityMvpPresenter<V> {

    @Inject
    public ResultActivityPresenter(DataManager dataManager,
                                   SchedulerProvider schedulerProvider,
                                   CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
