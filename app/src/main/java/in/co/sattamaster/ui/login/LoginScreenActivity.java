package in.co.sattamaster.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import in.co.sattamaster.R;
import in.co.sattamaster.ui.Homepage.MainActivity;
import in.co.sattamaster.ui.base.BaseActivity;
import in.co.sattamaster.ui.base.MySharedPreferences;
import javax.inject.Inject;

import butterknife.ButterKnife;

public class LoginScreenActivity extends BaseActivity implements LoginScreenMvpView {
    private Button loginbutton;
    private Button registerbutton;
    private EditText username;
    private EditText password;


    @Inject
    LoginScreenMvpPresenter<LoginScreenMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        loginbutton = (Button) findViewById(R.id.loginbutton);
        password = (EditText) findViewById(R.id.password);
        username = (EditText) findViewById(R.id.username);
        registerbutton = (Button) findViewById(R.id.registerbutton);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(LoginScreenActivity.this);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (password.getText().toString().isEmpty() || username.getText().toString().isEmpty()){
                    Toast.makeText(LoginScreenActivity.this, "Please enter value", Toast.LENGTH_LONG);
                } else {
                  //  isLoggedIn = true;
                    MySharedPreferences.registerUserId(preferences, "1");

                    Intent intent = new Intent(LoginScreenActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                Intent intent = new Intent(LoginScreenActivity.this, MainActivity.class);
                MySharedPreferences.registerUserId(preferences, "1");
                intent.putExtra("isLoggedIn", true);
                startActivity(intent);
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

    @Override
    protected void setUp() {

    }
}
