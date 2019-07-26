package in.co.sattamaster.ui.History;

import in.co.sattamaster.data.DataManager;
import in.co.sattamaster.ui.base.BasePresenter;
import in.co.sattamaster.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class HistoryActivityPresenter <V extends HistoryActivityMvpView> extends BasePresenter<V>
        implements HistoryActivityMvpPresenter<V> {

    @Inject
    public HistoryActivityPresenter(DataManager dataManager,
                                 SchedulerProvider schedulerProvider,
                                 CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}

