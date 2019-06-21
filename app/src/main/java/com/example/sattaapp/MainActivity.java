package com.example.sattaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_launcher);

        GridView view = (GridView) findViewById(R.id.gridmain);
        Button place_bid = (Button) findViewById(R.id.place_bid);


        getSupportActionBar().setTitle("Home Page");


        view.setAdapter(new GridAdapter(getBaseContext()));
    }
}
