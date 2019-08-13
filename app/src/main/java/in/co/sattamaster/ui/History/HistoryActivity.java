package in.co.sattamaster.ui.History;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import in.co.sattamaster.R;
import in.co.sattamaster.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import in.co.sattamaster.ui.base.Constants;

public class HistoryActivity extends BaseActivity implements HistoryActivityMvpView ,MyRecyclerViewAdapter.ItemClickListener
{
    @Inject
    HistoryActivityMvpPresenter<HistoryActivityMvpView> mPresenter;

    MyRecyclerViewAdapter adapter;
    private String USER_NAME;
    private String USER_MOBILE;
    private String MODERATOR_NAME;
    private String MODERATOR_MOBILE;
    private String WALLET_BALANCE;


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


        Intent intent = getIntent();
        USER_NAME = intent.getStringExtra(Constants.USER_NAME);
        USER_MOBILE = intent.getStringExtra(Constants.USER_MOBILE);
        MODERATOR_NAME = intent.getStringExtra(Constants.MODERATOR_NAME);
        MODERATOR_MOBILE = intent.getStringExtra(Constants.MODERATOR_MOBILE);
        WALLET_BALANCE = intent.getStringExtra(Constants.WALLET_BALANCE);



        // data to populate the RecyclerView with
        List<HistoryPojo> animalNames = new ArrayList<>();
        animalNames.add(new HistoryPojo("Faridabad", "Andar", "17-07-2019", "1,2,3,4,5", "1000"));
        animalNames.add(new HistoryPojo("Faridabad", "Andar", "17-07-2019", "1,2,3,4,5", "1000"));
        animalNames.add(new HistoryPojo("Faridabad", "Andar", "17-07-2019", "1,2,3,4,5", "1000"));
        animalNames.add(new HistoryPojo("Faridabad", "Andar", "17-07-2019", "1,2,3,4,5", "1000"));

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.history_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, animalNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {
       // Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void setUp() {

    }
}
