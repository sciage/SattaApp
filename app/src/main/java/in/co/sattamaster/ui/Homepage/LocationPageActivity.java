package in.co.sattamaster.ui.Homepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import in.co.sattamaster.R;
import in.co.sattamaster.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import in.co.sattamaster.ui.base.Constants;
import in.co.sattamaster.ui.base.MySharedPreferences;
import timber.log.Timber;

public class LocationPageActivity extends BaseActivity implements LocationPageMvpView {
    Button place_bid;
    LocationGridAdapter locationGridAdapter;
    private int totalItems;

    @BindView(R.id.balance_amount_value) TextView balance_amount_value;
    @BindView(R.id.user_name) TextView user_name;
    @BindView(R.id.moderator) TextView moderator;

    @BindView(R.id.location_progressbar) View location_progressbar;

    private GridView view;
    private List<LocationPojo> response;

    private String USER_NAME;
    private String MODERATOR_NAME;
    private String MODERATOR_MOBILE;
    private String WALLET_BALANCE;

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

        location_progressbar.setVisibility(View.VISIBLE);

        toolbar.setNavigationIcon(R.drawable.ic_clear_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setTitle("Satta");

        view = (GridView) findViewById(R.id.grid);

        Intent intent = getIntent();
        USER_NAME = intent.getStringExtra(Constants.USER_NAME);
        MODERATOR_NAME = intent.getStringExtra(Constants.MODERATOR_NAME);
        MODERATOR_MOBILE = intent.getStringExtra(Constants.MODERATOR_MOBILE);
        WALLET_BALANCE = intent.getStringExtra(Constants.WALLET_BALANCE);

        locationGridAdapter = new LocationGridAdapter(getBaseContext());

        view.setAdapter(locationGridAdapter);
        view.setFocusable(false);


        mPresenter.getLocation(MySharedPreferences.getToken(preferences));

        balance_amount_value.setText(WALLET_BALANCE);
        user_name.setText(USER_NAME);
        moderator.setText(MODERATOR_NAME + " ( " + MODERATOR_MOBILE + " ) ");

    }

    @Override
    protected void setUp() {

    }

    private void arraylistCurrent(List<LocationPojo> response){
        this.response = response;
    }

    @Override
    public void getLocationData(List<LocationPojo> response) {

        locationGridAdapter.addAll(response);
        locationGridAdapter.AddActivityData(USER_NAME, MODERATOR_NAME, MODERATOR_MOBILE, WALLET_BALANCE);
        view.setAdapter(locationGridAdapter);
        arraylistCurrent(response);

        totalItems = response.size();

        location_progressbar.setVisibility(View.GONE);
    }

    public static String getFormatedDateTime(String dateStr, String strReadFormat, String strWriteFormat) {

        String formattedDate = dateStr;

        DateFormat readFormat = new SimpleDateFormat(strReadFormat, Locale.getDefault());
        DateFormat writeFormat = new SimpleDateFormat(strWriteFormat, Locale.getDefault());

        Date date = null;

        try {
            date = readFormat.parse(dateStr);
        } catch (ParseException e) {
        }

        if (date != null) {
            formattedDate = writeFormat.format(date);
        }

        return formattedDate;
    }
}
