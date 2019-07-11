package com.example.sattaapp.ui.Homepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.example.sattaapp.R;
import com.example.sattaapp.ui.CreateGroupTagActivity;
import com.example.sattaapp.ui.PlayMatka.PlayMatkaActivity;
import com.example.sattaapp.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class LocationPageActivity extends BaseActivity implements LocationPageMvpView {
    Button place_bid;
    LocationGridAdapter locationGridAdapter;

    @Inject
    LocationPageMvpPresenter<LocationPageMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  if (!isLoggedIn){
            Intent intent = new Intent(LocationPageActivity.this, LoginScreenActivity.class);
            startActivity(intent);
        }
       */

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(LocationPageActivity.this);

        toolbar.setNavigationIcon(R.drawable.ic_clear_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setTitle("Satta");

        GridView view = (GridView) findViewById(R.id.grid);


        locationGridAdapter = new LocationGridAdapter(getBaseContext());
        view.setAdapter(locationGridAdapter);
        view.setFocusable(false);
    }

    @Override
    protected void setUp() {

    }
}
