package com.example.sattaapp.ui.History;

import android.os.Bundle;
import android.view.View;

import com.example.sattaapp.R;
import com.example.sattaapp.ui.PlayMatka.PlayMatkaActivity;
import com.example.sattaapp.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class HistoryActivity extends BaseActivity implements HistoryActivityMvpView {

    @Inject
    HistoryActivityMvpPresenter<HistoryActivityMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(HistoryActivity.this);

        toolbar.setNavigationIcon(R.drawable.ic_clear_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setTitle("History");
    }

    @Override
    protected void setUp() {

    }
}
