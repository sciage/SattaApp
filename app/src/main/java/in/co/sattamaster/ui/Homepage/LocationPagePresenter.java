package in.co.sattamaster.ui.Homepage;

import com.androidnetworking.error.ANError;

import org.json.JSONObject;

import in.co.sattamaster.data.DataManager;
import in.co.sattamaster.dto.Bid;
import in.co.sattamaster.ui.base.BasePresenter;
import in.co.sattamaster.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class LocationPagePresenter <V extends LocationPageMvpView> extends BasePresenter<V>
        implements LocationPageMvpPresenter<V> {

    @Inject
    public LocationPagePresenter(DataManager dataManager,
                                 SchedulerProvider schedulerProvider,
                                 CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void sendBidSet(JSONObject bidset) {

    /*    getCompositeDisposable().add(getDataManager()
                .registerUser(bidset)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<Bid>() {
                    @Override
                    public void accept(@NonNull Bid response)
                            throws Exception {

                    //    getMvpView().receiveBidSetResult(response);

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

     */
    }
}
