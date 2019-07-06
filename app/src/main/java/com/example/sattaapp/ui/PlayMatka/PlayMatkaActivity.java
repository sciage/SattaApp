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

    @BindView(R.id.bahar_00_edittext) EditText bahar_00_edittext;
    @BindView(R.id.bahar_01_edittext) EditText bahar_01_edittext;
    @BindView(R.id.bahar_02_edittext) EditText bahar_02_edittext;
    @BindView(R.id.bahar_03_edittext) EditText bahar_03_edittext;
    @BindView(R.id.bahar_04_edittext) EditText bahar_04_edittext;
    @BindView(R.id.bahar_05_edittext) EditText bahar_05_edittext;
    @BindView(R.id.bahar_06_edittext) EditText bahar_06_edittext;
    @BindView(R.id.bahar_07_edittext) EditText bahar_07_edittext;
    @BindView(R.id.bahar_08_edittext) EditText bahar_08_edittext;
    @BindView(R.id.bahar_09_edittext) EditText bahar_09_edittext;

    @BindView(R.id.comb_00_edittext) EditText comb_00_edittext;
    @BindView(R.id.comb_01_edittext) EditText comb_01_edittext;
    @BindView(R.id.comb_02_edittext) EditText comb_02_edittext;
    @BindView(R.id.comb_03_edittext) EditText comb_03_edittext;
    @BindView(R.id.comb_04_edittext) EditText comb_04_edittext;
    @BindView(R.id.comb_05_edittext) EditText comb_05_edittext;
    @BindView(R.id.comb_06_edittext) EditText comb_06_edittext;
    @BindView(R.id.comb_07_edittext) EditText comb_07_edittext;
    @BindView(R.id.comb_08_edittext) EditText comb_08_edittext;
    @BindView(R.id.comb_09_edittext) EditText comb_09_edittext;



    @BindView(R.id.satta_heading_01_total_value) TextView satta_heading_01_total_value;
    @BindView(R.id.satta_heading_02_total_value) TextView satta_heading_02_total_value;
    @BindView(R.id.satta_heading_03_total_value) TextView satta_heading_03_total_value;
    @BindView(R.id.satta_heading_03_bid_value) TextView satta_heading_03_bid_value;






   // private View status_group_post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_play_matka);


        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(PlayMatkaActivity.this);


        setFilter(andar_00_edittext);
        setFilter(andar_01_edittext);
        setFilter(andar_02_edittext);
        setFilter(andar_03_edittext);
        setFilter(andar_04_edittext);
        setFilter(andar_05_edittext);
        setFilter(andar_06_edittext);
        setFilter(andar_07_edittext);
        setFilter(andar_08_edittext);
        setFilter(andar_09_edittext);

        setFilter(bahar_00_edittext);
        setFilter(bahar_01_edittext);
        setFilter(bahar_02_edittext);
        setFilter(bahar_03_edittext);
        setFilter(bahar_04_edittext);
        setFilter(bahar_05_edittext);
        setFilter(bahar_06_edittext);
        setFilter(bahar_07_edittext);
        setFilter(bahar_08_edittext);
        setFilter(bahar_09_edittext);

        setFilter(comb_00_edittext);
        setFilter(comb_01_edittext);
        setFilter(comb_02_edittext);
        setFilter(comb_03_edittext);
        setFilter(comb_04_edittext);
        setFilter(comb_05_edittext);
        setFilter(comb_06_edittext);
        setFilter(comb_07_edittext);
        setFilter(comb_08_edittext);
        setFilter(comb_09_edittext);


        TextWatcher textWatcher = new TextWatcher() {
            public void afterTextChanged(Editable s) {

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){

                calculateResult();
            }
        };

        TextWatcher textWatcher02 = new TextWatcher() {
            public void afterTextChanged(Editable s) {

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){

                calculateResult02();
            }
        };

        TextWatcher textWatcher03 = new TextWatcher() {
            public void afterTextChanged(Editable s) {

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){

                calculateResult03();
            }
        };

        andar_00_edittext.addTextChangedListener(textWatcher);
        andar_01_edittext.addTextChangedListener(textWatcher);
        andar_02_edittext.addTextChangedListener(textWatcher);
        andar_03_edittext.addTextChangedListener(textWatcher);
        andar_04_edittext.addTextChangedListener(textWatcher);
        andar_05_edittext.addTextChangedListener(textWatcher);
        andar_06_edittext.addTextChangedListener(textWatcher);
        andar_07_edittext.addTextChangedListener(textWatcher);
        andar_08_edittext.addTextChangedListener(textWatcher);
        andar_09_edittext.addTextChangedListener(textWatcher);


        bahar_00_edittext.addTextChangedListener(textWatcher02);
        bahar_01_edittext.addTextChangedListener(textWatcher02);
        bahar_02_edittext.addTextChangedListener(textWatcher02);
        bahar_03_edittext.addTextChangedListener(textWatcher02);
        bahar_04_edittext.addTextChangedListener(textWatcher02);
        bahar_05_edittext.addTextChangedListener(textWatcher02);
        bahar_06_edittext.addTextChangedListener(textWatcher02);
        bahar_07_edittext.addTextChangedListener(textWatcher02);
        bahar_08_edittext.addTextChangedListener(textWatcher02);
        bahar_09_edittext.addTextChangedListener(textWatcher02);

        comb_00_edittext.addTextChangedListener(textWatcher03);
        comb_01_edittext.addTextChangedListener(textWatcher03);
        comb_02_edittext.addTextChangedListener(textWatcher03);
        comb_03_edittext.addTextChangedListener(textWatcher03);
        comb_04_edittext.addTextChangedListener(textWatcher03);
        comb_05_edittext.addTextChangedListener(textWatcher03);
        comb_06_edittext.addTextChangedListener(textWatcher03);
        comb_07_edittext.addTextChangedListener(textWatcher03);
        comb_08_edittext.addTextChangedListener(textWatcher03);
        comb_09_edittext.addTextChangedListener(textWatcher03);
        satta_heading_03_bid_value.addTextChangedListener(textWatcher03);





    }


    private void setFilter(EditText editText){
        editText.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "9999")});
    }


    // The function called to calculate and display the result of the multiplication
    private void calculateResult() throws NumberFormatException {

        // Gets the two EditText controls' Editable values
        String editableValue0 = andar_00_edittext.getText().toString(),
                editableValue1 = andar_01_edittext.getText().toString(),
                editableValue2 = andar_02_edittext.getText().toString(),
                editableValue3 = andar_03_edittext.getText().toString(),
                editableValue4 = andar_04_edittext.getText().toString(),
                editableValue5 = andar_05_edittext.getText().toString(),
                editableValue6 = andar_06_edittext.getText().toString(),
                editableValue7 = andar_07_edittext.getText().toString(),
                editableValue8 = andar_08_edittext.getText().toString(),
                editableValue9 = andar_09_edittext.getText().toString();

        // Initializes the double values and result
        int value0 = 0, value1 = 0,
                value2 = 0, value3 = 0, value4 = 0, value5 = 0,value6 = 0, value7 = 0,value8 = 0, value9 = 0,
                result;

        // If the Editable values are not null, obtains their double values by parsing
        if (!editableValue0.isEmpty())
            value0 = Integer.parseInt(andar_00_edittext.getText().toString());

        if (!editableValue1.isEmpty())
            value1 = Integer.parseInt(andar_01_edittext.getText().toString());

        if (!editableValue2.isEmpty())
            value2 = Integer.parseInt(andar_02_edittext.getText().toString());

        if (!editableValue3.isEmpty())
            value3 = Integer.parseInt(andar_03_edittext.getText().toString());

        if (!editableValue4.isEmpty())
            value4 = Integer.parseInt(andar_04_edittext.getText().toString());

        if (!editableValue5.isEmpty())
            value5 = Integer.parseInt(andar_05_edittext.getText().toString());

        if (!editableValue6.isEmpty())
            value6 = Integer.parseInt(andar_06_edittext.getText().toString());

        if (!editableValue7.isEmpty())
            value7 = Integer.parseInt(andar_07_edittext.getText().toString());

        if (!editableValue8.isEmpty())
            value8 = Integer.parseInt(andar_08_edittext.getText().toString());

        if (!editableValue9.isEmpty())
            value9 = Integer.parseInt(andar_09_edittext.getText().toString());

        // Calculates the result
        result = value0 + value1 + value2 + value3 + value4 + value5 + value6 + value7 + value8 + value9;

        // Displays the calculated result
        satta_heading_01_total_value.setText(String.valueOf(result));
    }

    private void calculateResult02() throws NumberFormatException {

        // Gets the two EditText controls' Editable values
        String editableValue0 = bahar_00_edittext.getText().toString(),
                editableValue1 = bahar_01_edittext.getText().toString(),
                editableValue2 = bahar_02_edittext.getText().toString(),
                editableValue3 = bahar_03_edittext.getText().toString(),
                editableValue4 = bahar_04_edittext.getText().toString(),
                editableValue5 = bahar_05_edittext.getText().toString(),
                editableValue6 = bahar_06_edittext.getText().toString(),
                editableValue7 = bahar_07_edittext.getText().toString(),
                editableValue8 = bahar_08_edittext.getText().toString(),
                editableValue9 = bahar_09_edittext.getText().toString();


        // Initializes the double values and result
        int value0 = 0, value1 = 0,
                value2 = 0, value3 = 0, value4 = 0, value5 = 0,value6 = 0, value7 = 0,value8 = 0, value9 = 0,
                result;

        // If the Editable values are not null, obtains their double values by parsing
        if (!editableValue0.isEmpty())
            value0 = Integer.parseInt(bahar_00_edittext.getText().toString());

        if (!editableValue1.isEmpty())
            value1 = Integer.parseInt(bahar_01_edittext.getText().toString());

        if (!editableValue2.isEmpty())
            value2 = Integer.parseInt(bahar_02_edittext.getText().toString());

        if (!editableValue3.isEmpty())
            value3 = Integer.parseInt(bahar_03_edittext.getText().toString());

        if (!editableValue4.isEmpty())
            value4 = Integer.parseInt(bahar_04_edittext.getText().toString());

        if (!editableValue5.isEmpty())
            value5 = Integer.parseInt(bahar_05_edittext.getText().toString());

        if (!editableValue6.isEmpty())
            value6 = Integer.parseInt(bahar_06_edittext.getText().toString());

        if (!editableValue7.isEmpty())
            value7 = Integer.parseInt(bahar_07_edittext.getText().toString());

        if (!editableValue8.isEmpty())
            value8 = Integer.parseInt(bahar_08_edittext.getText().toString());

        if (!editableValue9.isEmpty())
            value9 = Integer.parseInt(bahar_09_edittext.getText().toString());


        // Calculates the result
        result = value0 + value1 + value2 + value3 + value4 + value5 + value6 + value7 + value8 + value9;

        // Displays the calculated result
        satta_heading_02_total_value.setText(String.valueOf(result));
    }

    private void calculateResult03() throws NumberFormatException {

        // Gets the two EditText controls' Editable values
        String editableValue0 = comb_00_edittext.getText().toString(),
                editableValue1 = comb_01_edittext.getText().toString(),
                editableValue2 = comb_02_edittext.getText().toString(),
                editableValue3 = comb_03_edittext.getText().toString(),
                editableValue4 = comb_04_edittext.getText().toString(),
                editableValue5 = comb_05_edittext.getText().toString(),
                editableValue6 = comb_06_edittext.getText().toString(),
                editableValue7 = comb_07_edittext.getText().toString(),
                editableValue8 = comb_08_edittext.getText().toString(),
                editableValue9 = comb_09_edittext.getText().toString(),
                editableValueBid = satta_heading_03_bid_value.getText().toString();



        // Initializes the double values and result
        int value0 = 0, value1 = 0,
                value2 = 0, value3 = 0, value4 = 0, value5 = 0,value6 = 0, value7 = 0,value8 = 0, value9 = 0,
                value10 = 0,
                result;

        // If the Editable values are not null, obtains their double values by parsing
        if (!editableValue0.isEmpty())
            value0 = 1;

        if (!editableValue1.isEmpty())
            value1 = 1;

        if (!editableValue2.isEmpty())
            value2 = 1;

        if (!editableValue3.isEmpty())
            value3 = 1;

        if (!editableValue4.isEmpty())
            value4 = 1;

        if (!editableValue5.isEmpty())
            value5 = 1;

        if (!editableValue6.isEmpty())
            value6 = 1;

        if (!editableValue7.isEmpty())
            value7 = 1;

        if (!editableValue8.isEmpty())
            value8 = 1;

        if (!editableValue9.isEmpty())
            value9 = 1;

        if (!editableValueBid.isEmpty())
        value10 = Integer.parseInt(satta_heading_03_bid_value.getText().toString());


        // Calculates the result
        result = (value0 + value1 + value2 + value3 + value4 + value5 + value6 + value7 + value8 + value9) *
                (value0 + value1 + value2 + value3 + value4 + value5 + value6 + value7 + value8 + value9) * value10;

        // Displays the calculated result
        satta_heading_03_total_value.setText(String.valueOf(result));
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
