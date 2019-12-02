package in.co.sattamaster.ui.Homepage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.instacart.library.truetime.TrueTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import butterknife.BindView;
import in.co.sattamaster.R;
import in.co.sattamaster.ui.Result.PastResultActivity;
import in.co.sattamaster.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import in.co.sattamaster.ui.base.Constants;

public class LocationPageActivity extends BaseActivity implements LocationPageMvpView {
    Button place_bid;
    LocationGridAdapter locationGridAdapter;
    private int totalItems;

    @BindView(R.id.balance_amount_value) TextView balance_amount_value;
    @BindView(R.id.user_name) TextView user_name;
    @BindView(R.id.moderator) TextView moderator;
    @BindView(R.id.hourly_bids) TextView hourly_bids;

    @BindView(R.id.location_progressbar) View location_progressbar;
    @BindView(R.id.live_time) TextView live_time;

    private GridView view;
    private List<LocationPojo> response;

    private String currentDate;
    private String currentTime;


    private String USER_NAME;
    private String MODERATOR_NAME;
    private String MODERATOR_MOBILE;
    private String WALLET_BALANCE;

    private Handler handler;
    private Date trueDate;

    public static final String DATE_FORMAT_1 = "yyyy-MM-dd";
    public static final String TIME_FORMAT = "h:mm";



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
                Intent intent = new Intent(LocationPageActivity.this, MainActivity.class);
                intent.putExtra("isLoggedIn", true);

                startActivity(intent);
            }
        });
        getSupportActionBar().setTitle("Satta");

        view = (GridView) findViewById(R.id.grid);

        hourly_bids = (TextView) findViewById(R.id.hourly_bids);

        Intent intent = getIntent();
        USER_NAME = intent.getStringExtra(Constants.USER_NAME);
        MODERATOR_NAME = intent.getStringExtra(Constants.MODERATOR_NAME);
        MODERATOR_MOBILE = intent.getStringExtra(Constants.MODERATOR_MOBILE);
        WALLET_BALANCE = intent.getStringExtra(Constants.WALLET_BALANCE);

        locationGridAdapter = new LocationGridAdapter(getBaseContext());

        view.setAdapter(locationGridAdapter);
        view.setFocusable(false);

        trueDate = TrueTime.now();


        mPresenter.getLocation(preferences);

        balance_amount_value.setText(WALLET_BALANCE);
        user_name.setText(USER_NAME);
        moderator.setText(MODERATOR_NAME + " ( " + MODERATOR_MOBILE + " ) ");


        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_1);
        SimpleDateFormat timeFormat = new SimpleDateFormat(TIME_FORMAT);
        // dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));

        currentDate = dateFormat.format(trueDate);
        currentTime = timeFormat.format(trueDate);


        handler = new Handler();
        handler.post(runnable);

        hourly_bids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LocationPageActivity.this, PastResultActivity.class);
                intent.putExtra(Constants.FROM_TEXT, currentDate);
                intent.putExtra(Constants.TO_TEXT, currentDate);
                intent.putExtra(Constants.LOCATION_ID, "11");

                startActivity(intent);
            }
        });

    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {

            long now_time = System.currentTimeMillis();

            live_time.setText(DateFormat.getDateInstance(DateFormat.FULL).format(now_time).concat(", ").concat(DateFormat.getTimeInstance().format(now_time)));

            handler.postDelayed(this, 0);
        }
    };

    private String getTimeZoneInfo() {
        Calendar calendar = Calendar.getInstance();
        TimeZone timeZone = calendar.getTimeZone();
        return timeZone.getID().concat("\n").concat(timeZone.getDisplayName());
    }

    @Override
    public void onBackPressed() {
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
        super.onBackPressed();
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
        locationGridAdapter.AddActivityData(USER_NAME, MODERATOR_NAME, MODERATOR_MOBILE, WALLET_BALANCE, trueDate, LocationPageActivity.this);
        view.setAdapter(locationGridAdapter);
        arraylistCurrent(response);

        totalItems = response.size();

        location_progressbar.setVisibility(View.GONE);
    }


}
