package com.example.sattaapp.ui.PlayMatka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.widget.EditText;
import android.widget.GridView;

import com.example.sattaapp.R;
import com.example.sattaapp.ui.Homepage.BaseActivity;

public class PlayMatkaActivity extends BaseActivity {
    private EditText andar_01_edittext;
    private EditText andar_02_edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_matka);

        andar_01_edittext = (EditText) findViewById(R.id.andar_01_edittext);
        andar_02_edittext = (EditText) findViewById(R.id.andar_02_edittext);
        andar_01_edittext.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "999")});
        andar_02_edittext.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "999")});

    }
}
