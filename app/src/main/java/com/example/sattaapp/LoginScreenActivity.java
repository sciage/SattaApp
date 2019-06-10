package com.example.sattaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                    MySharedPreferences.registerUserId(preferences, "1");
                    Intent intent = new Intent(LoginScreenActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                Intent intent = new Intent(LoginScreenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
