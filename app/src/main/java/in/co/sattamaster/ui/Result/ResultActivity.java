package in.co.sattamaster.ui.Result;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import in.co.sattamaster.R;
import in.co.sattamaster.ui.base.BaseActivity;
import com.jaredrummler.materialspinner.MaterialSpinner;

import javax.inject.Inject;

import butterknife.ButterKnife;
import in.co.sattamaster.ui.base.Constants;

public class ResultActivity extends BaseActivity implements ResultActivityMvpView {

    @Inject
    ResultActivityMvpPresenter<ResultActivityMvpView> mPresenter;

    private Button search_bid_button;

    private String USER_NAME;
    private String MODERATOR_NAME;
    private String MODERATOR_MOBILE;
    private String WALLET_BALANCE;

    @BindView(R.id.balance_amount_value)
    TextView balance_amount_value;
    @BindView(R.id.user_name) TextView user_name;
    @BindView(R.id.moderator) TextView moderator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(ResultActivity.this);


        search_bid_button = (Button) findViewById(R.id.search_bid_button);

        search_bid_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ResultActivity.this, PastResultActivity.class);
                startActivity(intent);
            }
        });



        toolbar.setNavigationIcon(R.drawable.ic_clear_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setTitle("Results");

        Intent intent = getIntent();
        USER_NAME = intent.getStringExtra(Constants.USER_NAME);
        MODERATOR_NAME = intent.getStringExtra(Constants.MODERATOR_NAME);
        MODERATOR_MOBILE = intent.getStringExtra(Constants.MODERATOR_MOBILE);
        WALLET_BALANCE = intent.getStringExtra(Constants.WALLET_BALANCE);

        balance_amount_value.setText(WALLET_BALANCE);
        user_name.setText(USER_NAME);
        moderator.setText(MODERATOR_NAME + " ( " + MODERATOR_MOBILE + " ) ");

        MaterialSpinner spinner = (MaterialSpinner) findViewById(R.id.year_spinner);
        spinner.setItems("2017", "2018", "2019", "2020", "2021", "2022", "2023");
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Toast.makeText(ResultActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();

              //  Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });

        MaterialSpinner spinner02 = (MaterialSpinner) findViewById(R.id.month_spinner);
        spinner02.setItems( "January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December");
        spinner02.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Toast.makeText(ResultActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();

                //  Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void setUp() {

    }
}
