package in.co.sattamaster.ui.History;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.co.sattamaster.R;
import in.co.sattamaster.ui.Homepage.LocationPageActivity;
import in.co.sattamaster.ui.Result.PastResultActivity;
import in.co.sattamaster.ui.base.BaseActivity;
import in.co.sattamaster.ui.base.Constants;

public class HistoryDetailsActivity extends BaseActivity implements HistoryDetailsMvpView {

    @Inject
    HistoryDetailsMvpPresenter<HistoryDetailsMvpView> mPresenter;

    String BIDSET_ID;
    private HistoryDetailsAdapter mHistoryDetailsAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    public static final String DATE_FORMAT_1 = "yyyy-MM-dd";


    HistoryDetailsResponse response;

    List<HistoryBidHeader> myCommentList = null;

    @BindView(R.id.historydetails_progressbar) View progressFrame;
    @BindView(R.id.history_details_location) TextView history_details_location;
    @BindView(R.id.history_details_check_reveal) TextView history_details_check_reveal;
    @BindView(R.id.history_details_number_reveal_time) TextView history_details_number_reveal_time;
    @BindView(R.id.detail_rv_messages) protected RecyclerView mMessageRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_details);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(HistoryDetailsActivity.this);

        toolbar.setNavigationIcon(R.drawable.ic_clear_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setTitle("History Bidding");

        initRecyclerView();

        Intent intent = getIntent();
        BIDSET_ID = intent.getStringExtra(Constants.BIDSET_ID);

        history_details_check_reveal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HistoryDetailsActivity.this, PastResultActivity.class);
                intent.putExtra(Constants.FROM_TEXT, response.getBidDate());
                intent.putExtra(Constants.TO_TEXT, response.getBidDate());
                intent.putExtra(Constants.LOCATION_ID, response.getCentreId());

                startActivity(intent);

            }
        });

        progressFrame.setVisibility(View.VISIBLE);

        mPresenter.getBidDetails(BIDSET_ID, preferences);
    }

    private void initRecyclerView() {

        mHistoryDetailsAdapter = new HistoryDetailsAdapter(HistoryDetailsActivity.this, myCommentList);

        mLinearLayoutManager = new LinearLayoutManager(HistoryDetailsActivity.this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mLinearLayoutManager.setStackFromEnd(true);
//        mLinearLayoutManager.setReverseLayout(true);

        mMessageRecyclerView.setLayoutManager(mLinearLayoutManager);
        mMessageRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        mMessageRecyclerView.setAdapter(mHistoryDetailsAdapter);

    }

    @Override
    protected void setUp() {

    }

    @Override
    public void getBidDetails(HistoryDetailsResponse response) {
        showComments(response);
        history_details_location.setText(String.valueOf("Location : " + response.getCentre().getName()));
        history_details_number_reveal_time.setText(String.valueOf("Reveal Time : " + response.getCentre().getNumberRevealTime()));
        progressFrame.setVisibility(View.GONE);
        this.response = response;

    }

    private void showComments(final HistoryDetailsResponse myList) {

        this.myCommentList = myList.getBids();
        mHistoryDetailsAdapter = new HistoryDetailsAdapter(HistoryDetailsActivity.this, myList.getBids());
        mMessageRecyclerView.setAdapter(mHistoryDetailsAdapter);


    }

}
