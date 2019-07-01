package com.example.sattaapp.ui.Homepage;

import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;

import com.example.sattaapp.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_launcher);

        GridView view = (GridView) findViewById(R.id.gridmain);
        Button place_bid = (Button) findViewById(R.id.place_bid);


        getSupportActionBar().setTitle("Satta Home Page");


        view.setAdapter(new GridAdapter(getBaseContext()));
        view.setFocusable(false);

    }
}
