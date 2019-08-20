package in.co.sattamaster.ui.History;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.co.sattamaster.R;
import in.co.sattamaster.ui.base.BaseActivity;
import in.co.sattamaster.ui.base.Constants;

public class HistoryDetailsActivity extends BaseActivity implements HistoryDetailsMvpView {

    @Inject
    HistoryDetailsMvpPresenter<HistoryDetailsMvpView> mPresenter;

    String BIDSET_ID;
    private MessageAdapter mMessageAdapter;
    private LinearLayoutManager mLinearLayoutManager;


    List<HistoryBidHeader> myCommentList = null;



    @BindView(R.id.historydetails_progressbar) View progressFrame;
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

        Intent intent = getIntent();
        BIDSET_ID = intent.getStringExtra(Constants.BIDSET_ID);

        initRecyclerView();

        progressFrame.setVisibility(View.VISIBLE);

        mPresenter.getBidDetails(BIDSET_ID);



    }

    private void initRecyclerView() {
        /**code edited by nirmal
         * Replacing the linearlayout manager
         */

        //    geocoder = new Geocoder(PostsDetailsActivity.this, Locale.getDefault());


        //    mLinearLayoutManager = new LinearLayoutManager(PostsDetailsActivity.this,LinearLayoutManager.VERTICAL,true);

        mMessageAdapter = new MessageAdapter(HistoryDetailsActivity.this, myCommentList);

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
        mMessageRecyclerView.setAdapter(mMessageAdapter);

    }

    @Override
    protected void setUp() {

    }

    @Override
    public void getBidDetails(HistoryDetailsResponse response) {


        showComments(response);
        progressFrame.setVisibility(View.GONE);

    }

    private void showComments(final HistoryDetailsResponse myList) {

        this.myCommentList = myList.getBids();
        mMessageAdapter = new MessageAdapter(HistoryDetailsActivity.this, myList.getBids());
        mMessageRecyclerView.setAdapter(mMessageAdapter);


    }

}