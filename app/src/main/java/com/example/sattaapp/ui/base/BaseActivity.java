package com.example.sattaapp.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.example.sattaapp.R;
import com.example.sattaapp.di.component.ActivityComponent;
import com.example.sattaapp.di.component.DaggerActivityComponent;
import com.example.sattaapp.di.module.ActivityModule;
import com.example.sattaapp.di.rxbus.RxBus;
import com.example.sattaapp.utils.NetworkUtils;
import com.google.android.material.snackbar.Snackbar;

import butterknife.Unbinder;

import static com.example.sattaapp.ui.base.Constants.CONSTANT_PREF_FILE;

public abstract class BaseActivity extends AppCompatActivity implements MvpView, BaseFragment.Callback {
  //  private static String TAG = MainActivity.class.getSimpleName();
   // testing protected static final String APP_ID = "ca-app-pub-3940256099942544~3347511713";
   // protected static final String APP_ID = "ca-app-pub-1116209838416672~3025851301";  // live

    protected VoicemeApplication application;
    protected Toolbar toolbar;
    protected SharedPreferences preferences;
    protected boolean isLoggedIn;


    // public String id;
   // public String android_id;
    private Unbinder mUnBinder;
  //  private ProgressDialog mProgressDialog;
    protected RxBus bus;

    public ActivityComponent mActivityComponent;
    public boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        application = (VoicemeApplication) getApplication();
      //  getBus = application.getBus();
      //  scheduler = new ActionScheduler(application);
        preferences = getSharedPreferences(CONSTANT_PREF_FILE, Context.MODE_PRIVATE);

        isLoggedIn = false;



        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((VoicemeApplication) getApplication()).getComponent())
                .build();


        bus = application.getBus();

       // android_id =


     /*    open URL directly inside the app

     Uri data = this.getIntent().getData();
        if (data != null && data.isHierarchical()) {
            String uri = this.getIntent().getDataString();
            String idStr = uri.substring(uri.lastIndexOf('=') + 1);
            id = (idStr);
            Log.e("int value", ":======" + id);

            if (!id.equals("0")) {
                Intent intent = new Intent(BaseActivity.this, PostsDetailsActivity.class);
                intent.putExtra(Constants.POST_BACKGROUND, id);
                startActivity(intent);
            }
        } */


       // mTracker = application.getDefaultTracker();

    }



    /* public void clearChatComponent() {
        // end lifecycle of chatComponent
        chatComponent = null;
    }
    */

  /*  public ActionScheduler getScheduler() {
        return scheduler;
    } */

    @Override
    protected void onResume() {
        super.onResume();
        isRunning = true;

    //    scheduler.onResume();
    }



    @Override
    protected void onPause() {
        super.onPause();
        isRunning = false;
   //     scheduler.onPause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mUnBinder != null) {
            mUnBinder.unbind();
        }



    }

    @Override
    public void finish() {
        super.finish();

    }



    @Override
    public void setContentView(@LayoutRes int layoutResId) {
        super.setContentView(layoutResId);

        toolbar = (Toolbar) findViewById(R.id.include_toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }


    public Toolbar getToolbar() {
        return toolbar;
    }

    public VoicemeApplication getVoicemeApplication() {
        return application;
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

  /*  @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }  */

    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void showLoading() {
    //    hideLoading();
    //    mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
      //  if (mProgressDialog != null && mProgressDialog.isShowing()) {
      //      mProgressDialog.cancel();
      //  }
    }

    private void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
        snackbar.show();
    }

    @Override
    public void onError(String message) {
        if (message != null) {
            showSnackBar(message);
        } else {
            showSnackBar(getString(R.string.some_error));
        }
    }

    @Override
    public void onError(@StringRes int resId) {
        onError(getString(resId));
    }

    @Override
    public void showMessage(String message) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showMessage(@StringRes int resId) {
        showMessage(getString(resId));
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void openActivityOnTokenExpire() {
      //  startActivity(StartPage01GetStarted.getStartIntent(this));
       // finish();
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    protected abstract void setUp();


    @Override
    public void onBackPressed(){
            super.onBackPressed();
    }
}
