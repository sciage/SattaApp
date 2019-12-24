package in.co.sattamaster.ui.Withdraw;

import android.content.SharedPreferences;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import in.co.sattamaster.data.DataManager;
import in.co.sattamaster.dto.Bid;
import in.co.sattamaster.retrofit.ANError;
import in.co.sattamaster.ui.base.BasePresenter;
import in.co.sattamaster.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class WithdrawPresenter <V extends WithdrawMvpView> extends BasePresenter<V>
        implements WithdrawMvpPresenter<V> {

    @Inject
    public WithdrawPresenter(DataManager dataManager,
                                   SchedulerProvider schedulerProvider,
                                   CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void sendBidSet(JsonObject withdraw, SharedPreferences sharedPreferences) {

        getCompositeDisposable().add(getDataManager()
                .makeWithdrawRequest(withdraw, sharedPreferences)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<WithdrawResponseTop>() {

                    @Override
                    public void accept(@NonNull WithdrawResponseTop response)
                            throws Exception {

                        getMvpView().withdrawResponse(response);

                        //     getMvpView().hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)
                            throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
    }

    @Override
    public void getWithdraw(SharedPreferences sharedPreferences, int page) {

        getCompositeDisposable().add(getDataManager()
                .getWithdrawDetails(sharedPreferences, String.valueOf(page))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<WithdrawDetailsPojo>() {

                    @Override
                    public void accept(@NonNull WithdrawDetailsPojo response)
                            throws Exception {

                        getMvpView().getWithdrawResponse(response);

                        //     getMvpView().hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)
                            throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));

    }
}
