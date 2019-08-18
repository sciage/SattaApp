package in.co.sattamaster.ui.History;

import com.androidnetworking.error.ANError;

import java.util.List;

import javax.inject.Inject;

import in.co.sattamaster.data.DataManager;
import in.co.sattamaster.ui.base.BasePresenter;
import in.co.sattamaster.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class HistoryDetailsPresenter<V extends HistoryDetailsMvpView> extends BasePresenter<V>
        implements HistoryDetailsMvpPresenter<V> {

    @Inject
    public HistoryDetailsPresenter(DataManager dataManager,
                                    SchedulerProvider schedulerProvider,
                                    CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void getBidDetails(String id) {
        getCompositeDisposable().add(getDataManager()
                .getBidDetails(id)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<HistoryDetailsResponse>() {
                    @Override
                    public void accept(HistoryDetailsResponse response) throws Exception {

                        getMvpView().getBidDetails(response);

                        // todo add data and loop to get all friends list
                     /*   getDataManager().updateUserInfo(

                                response.info.getId(),
                                response.info.getUser_token(),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER
                        );
                        */

                        //getMvpView().hideLoading();
                        // getMvpView().openMainActivity();

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the login error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
    }
}
