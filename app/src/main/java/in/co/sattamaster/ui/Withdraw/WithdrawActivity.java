package in.co.sattamaster.ui.Withdraw;

import android.os.Bundle;
import android.view.View;

import in.co.sattamaster.R;
import in.co.sattamaster.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class WithdrawActivity extends BaseActivity implements WithdrawMvpView {

    @Inject
    WithdrawMvpPresenter<WithdrawMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(WithdrawActivity.this);


        toolbar.setNavigationIcon(R.drawable.ic_clear_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setTitle("Withdraw Balance");
    }

    @Override
    protected void setUp() {

    }
}
