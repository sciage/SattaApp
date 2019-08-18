package in.co.sattamaster.ui.Result;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import butterknife.BindView;
import in.co.sattamaster.R;
import in.co.sattamaster.ui.DateTime.Pico;
import in.co.sattamaster.ui.DateTime.codec.Type;
import in.co.sattamaster.ui.DateTime.helper.PicoListener;
import in.co.sattamaster.ui.Homepage.LocationPageActivity;
import in.co.sattamaster.ui.Homepage.LocationPageMvpPresenter;
import in.co.sattamaster.ui.Homepage.LocationPageMvpView;
import in.co.sattamaster.ui.Homepage.LocationPojo;
import in.co.sattamaster.ui.autocomplete.Autocomplete;
import in.co.sattamaster.ui.autocomplete.AutocompleteCallback;
import in.co.sattamaster.ui.autocomplete.AutocompletePresenter;
import in.co.sattamaster.ui.autocomplete.LocationPresenter;
import in.co.sattamaster.ui.autocomplete.UserPresenter;
import in.co.sattamaster.ui.base.BaseActivity;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import in.co.sattamaster.ui.base.Constants;
import in.co.sattamaster.ui.base.MySharedPreferences;

public class ResultActivity extends BaseActivity implements LocationPageMvpView {
    private String USER_NAME;
    private String MODERATOR_NAME;
    private String MODERATOR_MOBILE;
    private String WALLET_BALANCE;

    String fromValue;
    String toValue;

    @BindView(R.id.search_location) EditText search_location;
    private Autocomplete userAutocomplete;

    @Inject
    LocationPageMvpPresenter<LocationPageMvpView> mPresenter;

    @BindView(R.id.result_progressbar) View progressFrame;
    
    @BindView(R.id.balance_amount_value) TextView balance_amount_value;
    @BindView(R.id.search_bid_button) Button search_bid_button;
    @BindView(R.id.user_name) TextView user_name;
    @BindView(R.id.from_text) TextView from_text;
    @BindView(R.id.to_Text) TextView to_Text;
    @BindView(R.id.moderator) TextView moderator;
    @BindView(R.id.date_picker_resultFrom) Button date_picker_resultFrom;
    @BindView(R.id.date_picker_resultTo) Button date_picker_resultTo;
    private String location_id;
    private boolean selectedModerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(ResultActivity.this);


        progressFrame.setVisibility(View.VISIBLE);

        search_bid_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (fromValue != null && toValue != null){
                    Intent intent = new Intent(ResultActivity.this, PastResultActivity.class);
                    intent.putExtra(Constants.FROM_TEXT, fromValue);
                    intent.putExtra(Constants.TO_TEXT, toValue);
                    intent.putExtra(Constants.LOCATION_ID, location_id);

                    startActivity(intent);
                }

            }
        });

        date_picker_resultFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerFromDialog();
            }
        });


        date_picker_resultTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerToDialog();
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


        mPresenter.getLocation(MySharedPreferences.getToken(preferences));


    }

    private void setupUserAutocomplete(List<LocationPojo> response) {
        // EditText edit = (EditText) findViewById(R.id.single);
        float elevation = 6f;
        Drawable backgroundDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.shadow, null);

        AutocompletePresenter<LocationPojo> presenter = new LocationPresenter(this, response);
        AutocompleteCallback<LocationPojo> callback = new AutocompleteCallback<LocationPojo>() {
            @Override
            public boolean onPopupItemClicked(Editable editable, LocationPojo item) {
                editable.clear();
                editable.append(item.getName());
                setModerator_id(item.getId());
                selectedModerator = true;
                return true;
            }

            public void onPopupVisibilityChanged(boolean shown) {
            }
        };

        userAutocomplete = Autocomplete.<LocationPojo>on(search_location)
                .with(elevation)
                .with(backgroundDrawable)
                .with(presenter)
                .with(callback)
                .build();
    }

    private void setModerator_id(String location_id) {
        this.location_id = location_id;
    }

    private void showDatePickerFromDialog() {
        Pico pico = new Pico(this, null, Type.CALENDAR);
        pico.setPicoListener(new PicoListener() {
            @Override
            public void result(Calendar calendar) {
                fromValue = Pico.formatDate(calendar);

                from_text.setText(fromValue);
          //      Pop.info(MainActivity.this, Pico.formatDate(calendar));
            //    Log.i("DatePicker", Pico.formatTime(calendar));
            }
        });
        pico.show();

    }

    private void showDatePickerToDialog() {
        Pico pico = new Pico(this, null, Type.CALENDAR);
        pico.setPicoListener(new PicoListener() {
            @Override
            public void result(Calendar calendar) {
                toValue = Pico.formatDate(calendar);

                to_Text.setText(toValue);


            }
        });
        pico.show();

    }


    @Override
    protected void setUp() {

    }


    @Override
    public void getLocationData(List<LocationPojo> response) {

        progressFrame.setVisibility(View.INVISIBLE);

        setupUserAutocomplete(response);


    }
}