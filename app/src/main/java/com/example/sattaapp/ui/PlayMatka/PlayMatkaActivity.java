package com.example.sattaapp.ui.PlayMatka;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sattaapp.R;
import com.example.sattaapp.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayMatkaActivity extends BaseActivity implements PlayMatkaActivityMvpView {


    @Inject
    PlayMatkaActivityMvpPresenter<PlayMatkaActivityMvpView> mPresenter;

    @BindView(R.id.andar_00_edittext) EditText andar_00_edittext;
    @BindView(R.id.andar_01_edittext) EditText andar_01_edittext;
    @BindView(R.id.andar_02_edittext) EditText andar_02_edittext;
    @BindView(R.id.andar_03_edittext) EditText andar_03_edittext;
    @BindView(R.id.andar_04_edittext) EditText andar_04_edittext;
    @BindView(R.id.andar_05_edittext) EditText andar_05_edittext;
    @BindView(R.id.andar_06_edittext) EditText andar_06_edittext;
    @BindView(R.id.andar_07_edittext) EditText andar_07_edittext;
    @BindView(R.id.andar_08_edittext) EditText andar_08_edittext;
    @BindView(R.id.andar_09_edittext) EditText andar_09_edittext;

    private int andarValue = 0;
    private int andar_00 = 0;
    private int andar_01 = 0;
    private int andar_02 = 0;
    private int andar_03 = 0;
    private int andar_04 = 0;
    private int andar_05 = 0;
    private int andar_06 = 0;
    private int andar_07 = 0;
    private int andar_08 = 0;
    private int andar_09 = 0;

    @BindView(R.id.satta_heading_01_total_value) TextView satta_heading_01_total_value;






   // private View status_group_post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_play_matka);


        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(PlayMatkaActivity.this);


        andar_01_edittext.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "9999")});
        andar_02_edittext.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "9999")});
        andar_00_edittext.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "9999")});
        andar_03_edittext.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "9999")});
        andar_04_edittext.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "9999")});
        andar_05_edittext.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "9999")});
        andar_06_edittext.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "9999")});
        andar_07_edittext.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "9999")});
        andar_08_edittext.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "9999")});
        andar_09_edittext.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "9999")});

        TextWatcher textWatcher = new TextWatcher() {
            public void afterTextChanged(Editable s) {
                calculateResult();
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        };

        andar_00_edittext.addTextChangedListener(textWatcher);
        andar_01_edittext.addTextChangedListener(textWatcher);
        andar_02_edittext.addTextChangedListener(textWatcher);
        andar_03_edittext.addTextChangedListener(textWatcher);
        andar_04_edittext.addTextChangedListener(textWatcher);
        andar_05_edittext.addTextChangedListener(textWatcher);
        andar_06_edittext.addTextChangedListener(textWatcher);


    }



    // The function called to calculate and display the result of the multiplication
    private void calculateResult() throws NumberFormatException {
        // Gets the two EditText controls' Editable values
        Editable editableValue1 = andar_01_edittext.getText(),
                editableValue2 = andar_02_edittext.getText(),
                editableValue3 = andar_03_edittext.getText(),
                editableValue4 = andar_04_edittext.getText(),
                editableValue5 = andar_05_edittext.getText(),
                editableValue6 = andar_06_edittext.getText(),
                editableValue7 = andar_07_edittext.getText(),
                editableValue8 = andar_08_edittext.getText(),
                editableValue9 = andar_09_edittext.getText();

        // Initializes the double values and result
        int value1 = 0,
                value2 = 0, value3 = 0, value4 = 0, value5 = 0,value6 = 0, value7 = 0,value8 = 0, value9 = 0,
                result;

        // If the Editable values are not null, obtains their double values by parsing
        if (editableValue1 != null)
            value1 = Integer.parseInt(andar_01_edittext.getText().toString());

        if (editableValue2 != null)
            value2 = Integer.parseInt(andar_02_edittext.getText().toString());

        if (editableValue3 != null)
            value3 = Integer.parseInt(andar_03_edittext.getText().toString());

        if (editableValue4 != null)
            value4 = Integer.parseInt(andar_04_edittext.getText().toString());

        if (editableValue5 != null)
            value5 = Integer.parseInt(andar_05_edittext.getText().toString());

        if (editableValue6 != null)
            value6 = Integer.parseInt(andar_06_edittext.getText().toString());

        if (editableValue7 != null)
            value7 = Integer.parseInt(andar_07_edittext.getText().toString());

        if (editableValue8 != null)
            value8 = Integer.parseInt(andar_08_edittext.getText().toString());

        if (editableValue9 != null)
            value9 = Integer.parseInt(andar_09_edittext.getText().toString());

        // Calculates the result
        result = value1 + value2 + value3 + value4 + value5 + value6 + value7 + value8 + value9;

        // Displays the calculated result
        satta_heading_01_total_value.setText(String.valueOf(result));
    }
    private void clearEdittext(EditText editText){
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //You can identify which key pressed buy checking keyCode value with KeyEvent.KEYCODE_
                if(keyCode == KeyEvent.KEYCODE_DEL) {
                    //this is for backspace
                    editText.getText().clear();
                }
                return false;
            }
        });
    }

    @Override
    protected void setUp() {

    }
}
