package in.co.sattamaster.ui.Homepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.instacart.library.truetime.TrueTimeRx;

import java.util.Date;

import butterknife.BindView;
import in.co.sattamaster.R;
import in.co.sattamaster.data.DataManager;
import in.co.sattamaster.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import in.co.sattamaster.ui.base.MySharedPreferences;
import in.co.sattamaster.ui.login.LoginScreenActivity;
import in.co.sattamaster.ui.login.UserProfile;

public class MainActivity extends BaseActivity implements MainActivityMvpView{
    @Inject
    DataManager mDataManager;

    protected boolean isLoggedIn;

    @BindView(R.id.balance_amount_value) TextView balance_amount_value;
    @BindView(R.id.user_name) TextView user_name;
    @BindView(R.id.moderator) TextView moderator;
    View progressFrame;


    String balance_amount_value_String;
    String user_name_String;
    String moderator_String;
    GridAdapter gridAdapter;

    @Inject
    MainActivityMvpPresenter<MainActivityMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_launcher);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(MainActivity.this);

        progressFrame = (View) findViewById(R.id.main_progressbar);


        Intent intent = getIntent();

        isLoggedIn = intent.getBooleanExtra("isLoggedIn", false);

        if (!isLoggedIn){
            Intent intent02 = new Intent(MainActivity.this, LoginScreenActivity.class);
            startActivity(intent02);
        } else {
            try {
                progressFrame.setVisibility(View.VISIBLE);

                mPresenter.getUserProfile(preferences);
                // getGroupsJoined();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }




        GridView view = (GridView) findViewById(R.id.gridmain);


        getSupportActionBar().setTitle("Satta Master");

        gridAdapter = new GridAdapter(getBaseContext());

        view.setAdapter(gridAdapter);
        view.setFocusable(false);

    }

    @Override
    protected void setUp() {

    }

    @Override
    protected void onDestroy() {
        isLoggedIn = false;

        super.onDestroy();
    }


    @Override
    public void getUserProfile(UserObject response) {
        if (response.getUser().getId()!=null){
            // Todo add code to handle active user and jodi balance

            if (response.getUser().getProfile().getModerator().getProfile().isActive()){

                balance_amount_value.setText(response.getUser().getProfile().getCoinBalance());
                user_name.setText(response.getUser().getName());
                moderator.setText(String.valueOf(response.getUser().getProfile().getModerator().getName() + " ( " + response.getUser().getProfile().getModerator().getPhone() + " ) "));

                MySharedPreferences.registerCombinationLimit(preferences, String.valueOf(response.getUser().getProfile().getModerator().getProfile().getJodi_bid_max_length()));
                // setting local variable to be passed inside intent
                balance_amount_value_String = response.getUser().getProfile().getCoinBalance();
                user_name_String = response.getUser().getName();
                moderator_String = response.getUser().getProfile().getModerator().getName() + "@" + response.getUser().getProfile().getModerator().getPhone();


                gridAdapter.addAll(response);

            }



        }

        progressFrame.setVisibility(View.GONE);


    }
}
