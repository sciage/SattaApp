package com.example.sattaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

public class MainActivity extends BaseActivity {
    Button place_bid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (MySharedPreferences.getUserId(preferences) == null){
            Intent intent = new Intent(MainActivity.this, LoginScreenActivity.class);
            startActivity(intent);
        }
        GridView view = (GridView) findViewById(R.id.grid);
        Button place_bid = (Button) findViewById(R.id.place_bid);

        place_bid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateGroupTagActivity.class);
                startActivity(intent);
            }
        });
        view.setAdapter(new GridAdapter(getBaseContext()));
    }
}
