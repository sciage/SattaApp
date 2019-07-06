package com.example.sattaapp.ui.Result;

import android.os.Bundle;
import android.view.View;

import com.example.sattaapp.R;
import com.example.sattaapp.ui.PlayMatka.PlayMatkaActivity;
import com.example.sattaapp.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class ResultActivity extends BaseActivity implements ResultActivityMvpView {

    @Inject
    ResultActivityMvpPresenter<ResultActivityMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(ResultActivity.this);

        toolbar.setNavigationIcon(R.drawable.ic_clear_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setTitle("Results");
    }

    @Override
    protected void setUp() {

    }
}
