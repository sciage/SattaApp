package com.example.sattaapp.ui.Homepage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;

import com.example.sattaapp.R;
import com.crashlytics.android.Crashlytics;
import com.example.sattaapp.data.DataManager;
import com.example.sattaapp.ui.PlayMatka.PlayMatkaActivity;
import com.example.sattaapp.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends BaseActivity implements MainActivityMvpView{
    @Inject
    DataManager mDataManager;

    @Inject
    MainActivityMvpPresenter<MainActivityMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_launcher);


        if (!isLoggedIn){
            Intent intent = new Intent(MainActivity.this, LoginScreenActivity.class);
            startActivity(intent);
        }

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(MainActivity.this);


        GridView view = (GridView) findViewById(R.id.gridmain);


        getSupportActionBar().setTitle("Satta Home Page");


        view.setAdapter(new GridAdapter(getBaseContext()));
        view.setFocusable(false);

    }

    @Override
    protected void setUp() {

    }

    @Override
    protected void onDestroy() {
        isLoggedIn = false;

        super.onDestroy();
    }
}
