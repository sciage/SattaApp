package in.co.sattamaster.ui.login;

import com.androidnetworking.error.ANError;

import org.json.JSONObject;

import in.co.sattamaster.data.DataManager;
import in.co.sattamaster.ui.base.BasePresenter;
import in.co.sattamaster.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class LoginScreenPresenter <V extends LoginScreenMvpView> extends BasePresenter<V>
        implements LoginScreenMvpPresenter<V> {

    @Inject
    public LoginScreenPresenter(DataManager dataManager,
                                 SchedulerProvider schedulerProvider,
                                 CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void sendBidSet(JSONObject login) {

        getCompositeDisposable().add(getDataManager()
                .loginUser(login)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse response) throws Exception {

                        getMvpView().getLoginResponse(response);

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
