package in.co.sattamaster.ui.Withdraw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.co.sattamaster.R;
import in.co.sattamaster.ui.History.HistoryActivity;
import in.co.sattamaster.ui.History.HistoryActivityMvpView;
import in.co.sattamaster.ui.History.MyRecyclerViewAdapter;
import in.co.sattamaster.ui.InfiniteScrollProvider;
import in.co.sattamaster.ui.OnLoadMoreListener;
import in.co.sattamaster.ui.base.BaseActivity;
import in.co.sattamaster.ui.base.Constants;

public class WithdrawDetailsActivity extends BaseActivity implements WithdrawMvpView, OnLoadMoreListener{

    @Inject
    WithdrawMvpPresenter<WithdrawMvpView> mPresenter;

    WithdrawDetailsAdapter adapter;
    private String USER_NAME;
    private String USER_MOBILE;
    private String MODERATOR_NAME;
    private String MODERATOR_MOBILE;
    private String WALLET_BALANCE;
    private WithdrawDetailsPojo data;

    private static final int PAGE_START = 1;

    private int currentPage = PAGE_START;

    @BindView(R.id.history_progressbar)
    View progressFrame;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw_details);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(WithdrawDetailsActivity.this);

        toolbar.setNavigationIcon(R.drawable.ic_clear_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setTitle("History");


        Intent intent = getIntent();
        USER_NAME = intent.getStringExtra(Constants.USER_NAME);
        USER_MOBILE = intent.getStringExtra(Constants.USER_MOBILE);
        MODERATOR_NAME = intent.getStringExtra(Constants.MODERATOR_NAME);
        MODERATOR_MOBILE = intent.getStringExtra(Constants.MODERATOR_MOBILE);
        WALLET_BALANCE = intent.getStringExtra(Constants.WALLET_BALANCE);

        // set up the RecyclerView
        recyclerView = findViewById(R.id.history_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //  recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        //   recyclerView.setHasFixedSize(true);
        InfiniteScrollProvider infiniteScrollProvider = new InfiniteScrollProvider();
        infiniteScrollProvider.attach(recyclerView,this);

        adapter = new WithdrawDetailsAdapter(this);

        recyclerView.setAdapter(adapter);

        progressFrame.setVisibility(View.VISIBLE);

        mPresenter.getWithdraw(preferences, currentPage);
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void withdrawResponse(WithdrawResponseTop response) {

    }

    @Override
    public void getWithdrawResponse(WithdrawDetailsPojo response) {

        data = response;
        adapter.addAll(response.getData());

        progressFrame.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onLoadMore() {
        if (data.getTo().equalsIgnoreCase("20")){

            try {
                currentPage += 1;
                progressFrame.setVisibility(View.VISIBLE);

                mPresenter.getWithdraw(preferences, currentPage);

                //  loadNextPage();
                //  isLoading = true;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
