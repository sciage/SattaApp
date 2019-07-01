package com.example.sattaapp.ui;

import android.os.Bundle;
import android.view.View;

import com.example.sattaapp.R;
import com.example.sattaapp.ui.Homepage.BaseActivity;

public class SingleLocationPage extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_location_page);

        toolbar.setNavigationIcon(R.drawable.ic_clear_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setTitle("Edit Group");
    }
}
