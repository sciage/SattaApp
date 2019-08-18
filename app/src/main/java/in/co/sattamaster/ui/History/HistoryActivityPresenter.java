package in.co.sattamaster.ui.History;

import com.androidnetworking.error.ANError;

import java.util.List;

import in.co.sattamaster.data.DataManager;
import in.co.sattamaster.ui.Result.PastResultPOJO;
import in.co.sattamaster.ui.base.BasePresenter;
import in.co.sattamaster.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class HistoryActivityPresenter <V extends HistoryActivityMvpView> extends BasePresenter<V>
        implements HistoryActivityMvpPresenter<V> {

    @Inject
    public HistoryActivityPresenter(DataManager dataManager,
                                 SchedulerProvider schedulerProvider,
                                 CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void getBids(String token) {
        getCompositeDisposable().add(getDataManager()
                .getBids(token)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<List<HistoryResponse>>() {
                    @Override
                    public void accept(List<HistoryResponse> response) throws Exception {

                        getMvpView().getAllBids(response);

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

