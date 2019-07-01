package com.example.sattaapp.ui.Homepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sattaapp.ui.base.BaseActivity;
import com.example.sattaapp.ui.base.MySharedPreferences;
import com.example.sattaapp.R;

public class LoginScreenActivity extends BaseActivity {
    private Button loginbutton;
    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        loginbutton = (Button) findViewById(R.id.loginbutton);
        password = (EditText) findViewById(R.id.password);
        username = (EditText) findViewById(R.id.username);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (password.getText().toString().isEmpty() || username.getText().toString().isEmpty()){
                    Toast.makeText(LoginScreenActivity.this, "Please enter value", Toast.LENGTH_LONG);
                } else {
                  //  isLoggedIn = true;
                    MySharedPreferences.registerUserId(preferences, "1");
                    Intent intent = new Intent(LoginScreenActivity.this, LocationPageActivity.class);
                    startActivity(intent);
                }
                Intent intent = new Intent(LoginScreenActivity.this, LocationPageActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void setUp() {

    }
}
