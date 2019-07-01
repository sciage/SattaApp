package com.example.sattaapp.ui.PlayMatka;

import android.os.Bundle;
import android.text.InputFilter;
import android.widget.EditText;

import com.example.sattaapp.R;
import com.example.sattaapp.ui.base.BaseActivity;

public class PlayMatkaActivity extends BaseActivity {
    private EditText andar_00_edittext;
    private EditText andar_01_edittext;
    private EditText andar_02_edittext;
    private EditText andar_03_edittext;
    private EditText andar_04_edittext;
    private EditText andar_05_edittext;
    private EditText andar_06_edittext;
    private EditText andar_07_edittext;
    private EditText andar_08_edittext;
    private EditText andar_09_edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_matka);

        andar_01_edittext = (EditText) findViewById(R.id.andar_01_edittext);
        andar_02_edittext = (EditText) findViewById(R.id.andar_02_edittext);
        andar_00_edittext = (EditText) findViewById(R.id.andar_00_edittext);
        andar_03_edittext = (EditText) findViewById(R.id.andar_03_edittext);
        andar_04_edittext = (EditText) findViewById(R.id.andar_04_edittext);
        andar_05_edittext = (EditText) findViewById(R.id.andar_05_edittext);
        andar_06_edittext = (EditText) findViewById(R.id.andar_06_edittext);
        andar_07_edittext = (EditText) findViewById(R.id.andar_07_edittext);
        andar_08_edittext = (EditText) findViewById(R.id.andar_08_edittext);
        andar_09_edittext = (EditText) findViewById(R.id.andar_09_edittext);

        andar_01_edittext.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "1000")});
        andar_02_edittext.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "1000")});
        andar_00_edittext.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "1000")});
        andar_03_edittext.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "1000")});
        andar_04_edittext.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "1000")});
        andar_05_edittext.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "1000")});
        andar_06_edittext.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "1000")});
        andar_07_edittext.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "1000")});
        andar_08_edittext.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "1000")});
        andar_09_edittext.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "1000")});

    }

    @Override
    protected void setUp() {

    }
}
