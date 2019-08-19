package in.co.sattamaster.ui.Withdraw;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import in.co.sattamaster.R;
import in.co.sattamaster.ui.Homepage.MainActivity;
import in.co.sattamaster.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import in.co.sattamaster.ui.base.Constants;
import in.co.sattamaster.ui.base.MySharedPreferences;
import in.co.sattamaster.ui.login.LoginScreenActivity;
import in.co.sattamaster.ui.login.RegisterActivity;

public class WithdrawActivity extends BaseActivity implements WithdrawMvpView {

    @Inject
    WithdrawMvpPresenter<WithdrawMvpView> mPresenter;

    @BindView(R.id.withdraw_button) Button withdraw_button;
    @BindView(R.id.withdraw_amount) EditText withdraw_amount;
    @BindView(R.id.withdraw_progressbar) View progressFrame;


    private String USER_NAME;
    private String MODERATOR_NAME;
    private String MODERATOR_MOBILE;
    private String WALLET_BALANCE;

    @BindView(R.id.balance_amount_value) TextView balance_amount_value;
    @BindView(R.id.user_name) TextView user_name;
    @BindView(R.id.moderator) TextView moderator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(WithdrawActivity.this);


        toolbar.setNavigationIcon(R.drawable.ic_clear_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setTitle("Withdraw Balance");

        Intent intent = getIntent();
        USER_NAME = intent.getStringExtra(Constants.USER_NAME);
        MODERATOR_NAME = intent.getStringExtra(Constants.MODERATOR_NAME);
        MODERATOR_MOBILE = intent.getStringExtra(Constants.MODERATOR_MOBILE);
        WALLET_BALANCE = intent.getStringExtra(Constants.WALLET_BALANCE);

        balance_amount_value.setText(WALLET_BALANCE);
        user_name.setText(USER_NAME);
        moderator.setText(MODERATOR_NAME + " ( " + MODERATOR_MOBILE + " ) ");

        progressFrame.setVisibility(View.GONE);
        withdraw_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressFrame.setVisibility(View.VISIBLE);

                try{
                    mPresenter.sendBidSet(withdrawAmount(), MySharedPreferences.getToken(preferences));
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    private JSONObject withdrawAmount(){
        JSONObject balance = new JSONObject();
        try {
            balance.put("player_id", MySharedPreferences.getUserId(preferences));
            balance.put("amount", withdraw_amount.getText().toString());

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return balance;
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void withdrawResponse(WithdrawResponseTop response) {

        progressFrame.setVisibility(View.GONE);

        if (response.getStatus()){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(WithdrawActivity.this);
            alertDialogBuilder.setTitle("WithDraw Successful");
            alertDialogBuilder.setMessage("Admin will call you back in 24 hours");
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setIcon(android.R.drawable.ic_dialog_alert);
            alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                    Intent intent = new Intent(WithdrawActivity.this, MainActivity.class);
                    intent.putExtra("isLoggedIn", true);
                    startActivity(intent);
                }
            });
            alertDialogBuilder.show();

        }
    }
}
