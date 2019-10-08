package in.co.sattamaster.ui.login;

import android.content.SharedPreferences;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import in.co.sattamaster.data.DataManager;
import in.co.sattamaster.retrofit.ANError;
import in.co.sattamaster.ui.base.BasePresenter;
import in.co.sattamaster.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import retrofit2.HttpException;

public class LoginScreenPresenter <V extends LoginScreenMvpView> extends BasePresenter<V>
        implements LoginScreenMvpPresenter<V> {

    @Inject
    public LoginScreenPresenter(DataManager dataManager,
                                 SchedulerProvider schedulerProvider,
                                 CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void sendBidSet(JsonObject login, SharedPreferences sharedPreferences) {

        getCompositeDisposable().add(getDataManager()
                .loginUser(login, sharedPreferences)
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

                        HttpException exception = (HttpException) throwable;
                        switch (exception.code()) {
                            case 409:
                                // Handle code 400
                                getMvpView().getLoginError("Invalid Login and Password");
                                break;
                            case 500:
                                // Handle code 500
                                break;
                            default:
                                break;
                        }

                       // if (throwable.getMessage()

                       /// getMvpView().getLoginError(throwable.getMessage());

                        // handle the login error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));


    }


}
