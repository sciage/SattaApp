package com.example.sattaapp.ui.Withdraw;

import android.os.Bundle;
import android.view.View;

import com.example.sattaapp.R;
import com.example.sattaapp.ui.Homepage.BaseActivity;

public class WithdrawActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);

        toolbar.setNavigationIcon(R.drawable.ic_clear_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setTitle("Withdraw Balance");
    }
}
