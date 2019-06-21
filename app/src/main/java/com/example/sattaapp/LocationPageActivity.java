package com.example.sattaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

public class LocationPageActivity extends BaseActivity {
    Button place_bid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  if (!isLoggedIn){
            Intent intent = new Intent(LocationPageActivity.this, LoginScreenActivity.class);
            startActivity(intent);
        }

       */

        toolbar.setNavigationIcon(R.drawable.ic_clear_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setTitle("History");

        GridView view = (GridView) findViewById(R.id.grid);
        Button place_bid = (Button) findViewById(R.id.place_bid);

        place_bid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LocationPageActivity.this, CreateGroupTagActivity.class);
                startActivity(intent);
            }
        });
        view.setAdapter(new LocationGridAdapter(getBaseContext()));
    }
}
