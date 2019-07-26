package in.co.sattamaster.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import in.co.sattamaster.di.component.ActivityComponent;
import in.co.sattamaster.di.rxbus.RxBus;
import in.co.sattamaster.utils.CommonUtils;

import butterknife.Unbinder;

import static in.co.sattamaster.ui.base.Constants.CONSTANT_PREF_FILE;

public abstract class BaseFragment extends Fragment implements MvpView {
    protected VoicemeApplication application;
    protected RxBus bus;
  //  protected ActionScheduler scheduler;
    protected SharedPreferences preferences;
    public String android_id;
    private BaseActivity mActivity;


    private Unbinder mUnBinder;
    private ProgressDialog mProgressDialog;

    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        application = (VoicemeApplication) getActivity().getApplication();
      //  scheduler = new ActionScheduler(application);
        preferences = getActivity().getSharedPreferences(CONSTANT_PREF_FILE, Context.MODE_PRIVATE);

        setHasOptionsMenu(false);

        android_id = android.provider.Settings.Secure.getString(getActivity().getContentResolver(),
                android.provider.Settings.Secure.ANDROID_ID);

        bus = application.getBus();
       // getBus.register(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp(view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this.getBaseActivity());
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void onError(String message) {
        if (mActivity != null) {
            mActivity.onError(message);
        }
    }

    @Override
    public void onError(@StringRes int resId) {
        if (mActivity != null) {
            mActivity.onError(resId);
        }
    }

    @Override
    public void showMessage(String message) {
        if (mActivity != null) {
            mActivity.showMessage(message);
        }
    }

    @Override
    public void showMessage(@StringRes int resId) {
        if (mActivity != null) {
            mActivity.showMessage(resId);
        }
    }

    @Override
    public boolean isNetworkConnected() {
        if (mActivity != null) {
            return mActivity.isNetworkConnected();
        }
        return false;
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public void hideKeyboard() {
        if (mActivity != null) {
            mActivity.hideKeyboard();
        }
    }

    @Override
    public void openActivityOnTokenExpire() {
        if (mActivity != null) {
            mActivity.openActivityOnTokenExpire();
        }
    }

    public ActivityComponent getActivityComponent() {
        if (mActivity != null) {
            return mActivity.getActivityComponent();
        }
        return null;
    }

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    protected abstract void setUp(View view);


    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }

    @Override
    public void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
      //  getBus.unregister(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        // scheduler.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
      //  scheduler.onResume();
    }
}
