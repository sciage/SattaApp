package com.example.sattaapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public abstract class BaseActivity extends AppCompatActivity {
    protected SharedPreferences preferences;
    String CONSTANT_PREF_FILE = "constant_prefs.xml";
    protected VoicemeApplication application;
    protected Toolbar toolbar;


    boolean isLoggedIn = false;


    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        application = (VoicemeApplication) getApplication();

        preferences = getSharedPreferences(CONSTANT_PREF_FILE, Context.MODE_PRIVATE);

    }

    @Override
    public void setContentView(@LayoutRes int layoutResId) {
        super.setContentView(layoutResId);

        toolbar = (Toolbar) findViewById(R.id.include_toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }
}
