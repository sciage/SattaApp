package com.example.sattaapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    protected SharedPreferences preferences;
    String CONSTANT_PREF_FILE = "constant_prefs.xml";
    protected VoicemeApplication application;





    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        application = (VoicemeApplication) getApplication();

        preferences = getSharedPreferences(CONSTANT_PREF_FILE, Context.MODE_PRIVATE);


    }
}
