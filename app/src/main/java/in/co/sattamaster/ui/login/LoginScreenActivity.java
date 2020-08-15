package in.co.sattamaster.ui.login;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import in.co.sattamaster.R;
import in.co.sattamaster.retrofit.NetworkClient;
import in.co.sattamaster.ui.Homepage.MainActivity;
import in.co.sattamaster.ui.base.BaseActivity;
import in.co.sattamaster.ui.base.MySharedPreferences;
import javax.inject.Inject;

import butterknife.ButterKnife;

public class LoginScreenActivity extends BaseActivity implements LoginScreenMvpView {
    @BindView(R.id.loginbutton) Button loginbutton;
    @BindView(R.id.registerbutton) Button registerbutton;
    @BindView(R.id.phone_number) EditText phoneNumber;
    @BindView(R.id.forgot_password) TextView forgot_password;
    @BindView(R.id.password) EditText password;
    @BindView(R.id.login_progressbar) View login_progressbar;

    @Inject
    LoginScreenMvpPresenter<LoginScreenMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(LoginScreenActivity.this);

        login_progressbar.setVisibility(View.GONE);

        NetworkClient.makeRetrofitNull();

        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getContactDialog();
            }
        });

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (password.getText().toString().isEmpty() || phoneNumber.getText().toString().isEmpty()){
                    Toast.makeText(LoginScreenActivity.this, "Please enter value", Toast.LENGTH_LONG).show();
                } else {
                  //  isLoggedIn = true;

                    login_progressbar.setVisibility(View.VISIBLE);
                    mPresenter.sendBidSet(createLogin(), preferences);


                }
            }
        });

        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreenActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getContactDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(LoginScreenActivity.this);
        alertDialogBuilder.setTitle("Please contact owner to change password");
        alertDialogBuilder.setMessage("owner email : ravigamerao@gmail.com");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setIcon(android.R.drawable.ic_dialog_alert);
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialogBuilder.show();
    }

    @Override
    protected void setUp() {

    }

    private JsonObject createLogin(){
        JsonObject loginObject = new JsonObject();
        try {
            loginObject.addProperty("phone", phoneNumber.getText().toString());
            loginObject.addProperty("password", password.getText().toString());

        } catch (JsonIOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return loginObject;
    }

    @Override
    public void getLoginResponse(LoginResponse response) {

        String token = response.getToken();

        Intent intent = new Intent(LoginScreenActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

        MySharedPreferences.registerUserId(preferences, response.getUser().getId().toString());
        MySharedPreferences.registerToken(preferences, response.getToken());
        intent.putExtra("isLoggedIn", true);
        startActivity(intent);

        login_progressbar.setVisibility(View.GONE);

    }

    @Override
    public void getLoginError(String response) {

        login_progressbar.setVisibility(View.GONE);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(LoginScreenActivity.this);
        alertDialogBuilder.setTitle("Invalid Login and Password");
        alertDialogBuilder.setMessage("If you forgot password then email us : ravigamerao@gmail.com");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialogBuilder.show();

    }
}
