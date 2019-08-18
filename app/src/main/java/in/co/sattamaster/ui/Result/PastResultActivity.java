package in.co.sattamaster.ui.Result;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.co.sattamaster.R;
import in.co.sattamaster.ui.base.BaseActivity;
import in.co.sattamaster.ui.base.Constants;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PastResultActivity extends BaseActivity implements PastResultMvpView  {
    String FROM_TEXT;
    String TO_TEXT;
    String LOCATION_ID;
    TableViewAdapter adapter;
    RecyclerView recyclerView;

    @BindView(R.id.pastresult_progressbar) View progressFrame;
    @BindView(R.id.location_heading)
    TextView location_heading;


    @Inject
    PastResultMvpPresenter<PastResultMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_result);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(PastResultActivity.this);

        toolbar.setNavigationIcon(R.drawable.ic_clear_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setTitle("Past Results");

        Intent intent = getIntent();
        FROM_TEXT = intent.getStringExtra(Constants.FROM_TEXT);
        TO_TEXT = intent.getStringExtra(Constants.TO_TEXT);
        LOCATION_ID = intent.getStringExtra(Constants.LOCATION_ID);

        recyclerView = findViewById(R.id.recyclerViewDeliveryProductList);

        adapter = new TableViewAdapter(this);

        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);

        try {
            progressFrame.setVisibility(View.VISIBLE);
            mPresenter.getAllResult(LOCATION_ID, FROM_TEXT, TO_TEXT);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void getAllResult(List<PastResultPOJO> response) {

        adapter.addAll(response);

        location_heading.setText(response.get(0).getCentre().getName());

        progressFrame.setVisibility(View.INVISIBLE);

    }
}
