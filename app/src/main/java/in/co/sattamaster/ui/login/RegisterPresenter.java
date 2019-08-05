package in.co.sattamaster.ui.login;

import com.androidnetworking.error.ANError;

import java.util.List;

import javax.inject.Inject;

import in.co.sattamaster.data.DataManager;
import in.co.sattamaster.ui.base.BasePresenter;
import in.co.sattamaster.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class RegisterPresenter  <V extends RegisterMvpView> extends BasePresenter<V>
        implements RegisterMvpPresenter<V> {


    @Inject
    public RegisterPresenter(DataManager dataManager,
                                SchedulerProvider schedulerProvider,
                                CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void getAllModerator() {
        //   getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager()
                .getAllModerator()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<List<AllModerators>>() {
                    @Override
                    public void accept(List<AllModerators> response) throws Exception {

                        getMvpView().getListAllGroups(response);

                     /*   getDataManager().updateUserInfo(

                                response.info.getId(),
                                response.info.getUser_token(),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER
                        );
                        */



                        //   getMvpView().openMainActivity();

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
