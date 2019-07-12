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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayMatkaActivity extends BaseActivity implements PlayMatkaActivityMvpView, View.OnClickListener {


    @Inject
    PlayMatkaActivityMvpPresenter<PlayMatkaActivityMvpView> mPresenter;

    @BindView(R.id.andar_00_view) TextView andar_00_view;

    boolean boolean_comb_00_edittext;
    boolean boolean_comb_01_edittext;
    boolean boolean_comb_02_edittext;
    boolean boolean_comb_03_edittext;
    boolean boolean_comb_04_edittext;
    boolean boolean_comb_05_edittext;
    boolean boolean_comb_06_edittext;
    boolean boolean_comb_07_edittext;
    boolean boolean_comb_08_edittext;
    boolean boolean_comb_09_edittext;

    private List<String> joinComb;



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

    @BindView(R.id.comb_00_edittext) TextView comb_00_edittext;
    @BindView(R.id.comb_01_edittext) TextView comb_01_edittext;
    @BindView(R.id.comb_02_edittext) TextView comb_02_edittext;
    @BindView(R.id.comb_03_edittext) TextView comb_03_edittext;
    @BindView(R.id.comb_04_edittext) TextView comb_04_edittext;
    @BindView(R.id.comb_05_edittext) TextView comb_05_edittext;
    @BindView(R.id.comb_06_edittext) TextView comb_06_edittext;
    @BindView(R.id.comb_07_edittext) TextView comb_07_edittext;
    @BindView(R.id.comb_08_edittext) TextView comb_08_edittext;
    @BindView(R.id.comb_09_edittext) TextView comb_09_edittext;

    @BindView(R.id.single_00_edittext) EditText single_00_edittext;
    @BindView(R.id.single_01_edittext) EditText single_01_edittext;
    @BindView(R.id.single_02_edittext) EditText single_02_edittext;
    @BindView(R.id.single_03_edittext) EditText single_03_edittext;
    @BindView(R.id.single_04_edittext) EditText single_04_edittext;
    @BindView(R.id.single_05_edittext) EditText single_05_edittext;
    @BindView(R.id.single_06_edittext) EditText single_06_edittext;
    @BindView(R.id.single_07_edittext) EditText single_07_edittext;
    @BindView(R.id.single_08_edittext) EditText single_08_edittext;
    @BindView(R.id.single_09_edittext) EditText single_09_edittext;

    @BindView(R.id.single_10_edittext) EditText single_10_edittext;
    @BindView(R.id.single_11_edittext) EditText single_11_edittext;
    @BindView(R.id.single_12_edittext) EditText single_12_edittext;
    @BindView(R.id.single_13_edittext) EditText single_13_edittext;
    @BindView(R.id.single_14_edittext) EditText single_14_edittext;
    @BindView(R.id.single_15_edittext) EditText single_15_edittext;
    @BindView(R.id.single_16_edittext) EditText single_16_edittext;
    @BindView(R.id.single_17_edittext) EditText single_17_edittext;
    @BindView(R.id.single_18_edittext) EditText single_18_edittext;
    @BindView(R.id.single_19_edittext) EditText single_19_edittext;

    @BindView(R.id.single_20_edittext) EditText single_20_edittext;
    @BindView(R.id.single_21_edittext) EditText single_21_edittext;
    @BindView(R.id.single_22_edittext) EditText single_22_edittext;
    @BindView(R.id.single_23_edittext) EditText single_23_edittext;
    @BindView(R.id.single_24_edittext) EditText single_24_edittext;
    @BindView(R.id.single_25_edittext) EditText single_25_edittext;
    @BindView(R.id.single_26_edittext) EditText single_26_edittext;
    @BindView(R.id.single_27_edittext) EditText single_27_edittext;






    @BindView(R.id.satta_heading_01_total_value) TextView satta_heading_01_total_value;
    @BindView(R.id.satta_heading_02_total_value) TextView satta_heading_02_total_value;
    @BindView(R.id.satta_heading_03_total_value) TextView satta_heading_03_total_value;
    @BindView(R.id.satta_heading_03_bid_value) TextView satta_heading_03_bid_value;
    @BindView(R.id.satta_heading_04_total_value) TextView satta_heading_04_total_value;

    @BindView(R.id.satta_net_total_value) TextView satta_net_total_value;

    int totalAndar = 0;
    int totalBahar = 0;
    int totalComb = 0;
    int totalSingle = 0;






   // private View status_group_post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_play_matka);

        toolbar.setNavigationIcon(R.drawable.ic_clear_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setTitle("Play Satta Matka");


        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(PlayMatkaActivity.this);


        joinComb = new ArrayList<>();

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

   /*     setFilter02(comb_00_edittext);
        setFilter02(comb_01_edittext);
        setFilter02(comb_02_edittext);
        setFilter02(comb_03_edittext);
        setFilter02(comb_04_edittext);
        setFilter02(comb_05_edittext);
        setFilter02(comb_06_edittext);
        setFilter02(comb_07_edittext);
        setFilter02(comb_08_edittext);
        setFilter02(comb_09_edittext); */

        setFilter03(single_00_edittext);
        setFilter(single_01_edittext);
        setFilter03(single_02_edittext);
        setFilter(single_03_edittext);
        setFilter03(single_04_edittext);
        setFilter(single_05_edittext);
        setFilter03(single_06_edittext);
        setFilter(single_07_edittext);
        setFilter03(single_08_edittext);
        setFilter(single_09_edittext);

        setFilter03(single_10_edittext);
        setFilter(single_11_edittext);
        setFilter03(single_12_edittext);
        setFilter(single_13_edittext);
        setFilter03(single_14_edittext);
        setFilter(single_15_edittext);
        setFilter03(single_16_edittext);
        setFilter(single_17_edittext);
        setFilter03(single_18_edittext);
        setFilter(single_19_edittext);

        setFilter03(single_20_edittext);
        setFilter(single_21_edittext);
        setFilter03(single_22_edittext);
        setFilter(single_23_edittext);
        setFilter03(single_24_edittext);
        setFilter(single_25_edittext);
        setFilter03(single_26_edittext);
        setFilter(single_27_edittext);



        comb_00_edittext.setOnClickListener(this);
        comb_01_edittext.setOnClickListener(this);
        comb_02_edittext.setOnClickListener(this);
        comb_03_edittext.setOnClickListener(this);
        comb_04_edittext.setOnClickListener(this);
        comb_05_edittext.setOnClickListener(this);
        comb_06_edittext.setOnClickListener(this);
        comb_07_edittext.setOnClickListener(this);
        comb_08_edittext.setOnClickListener(this);
        comb_09_edittext.setOnClickListener(this);

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

        TextWatcher textWatcher04 = new TextWatcher() {
            public void afterTextChanged(Editable s) {

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){

                calculateResult04();
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

        single_00_edittext.addTextChangedListener(textWatcher04);
        single_01_edittext.addTextChangedListener(textWatcher04);
        single_02_edittext.addTextChangedListener(textWatcher04);
        single_03_edittext.addTextChangedListener(textWatcher04);
        single_04_edittext.addTextChangedListener(textWatcher04);
        single_05_edittext.addTextChangedListener(textWatcher04);
        single_06_edittext.addTextChangedListener(textWatcher04);
        single_07_edittext.addTextChangedListener(textWatcher04);
        single_08_edittext.addTextChangedListener(textWatcher04);
        single_09_edittext.addTextChangedListener(textWatcher04);


        single_10_edittext.addTextChangedListener(textWatcher04);
        single_11_edittext.addTextChangedListener(textWatcher04);
        single_12_edittext.addTextChangedListener(textWatcher04);
        single_13_edittext.addTextChangedListener(textWatcher04);
        single_14_edittext.addTextChangedListener(textWatcher04);
        single_15_edittext.addTextChangedListener(textWatcher04);
        single_16_edittext.addTextChangedListener(textWatcher04);
        single_17_edittext.addTextChangedListener(textWatcher04);
        single_18_edittext.addTextChangedListener(textWatcher04);
        single_19_edittext.addTextChangedListener(textWatcher04);

        single_20_edittext.addTextChangedListener(textWatcher04);
        single_21_edittext.addTextChangedListener(textWatcher04);
        single_22_edittext.addTextChangedListener(textWatcher04);
        single_23_edittext.addTextChangedListener(textWatcher04);
        single_24_edittext.addTextChangedListener(textWatcher04);
        single_25_edittext.addTextChangedListener(textWatcher04);
        single_26_edittext.addTextChangedListener(textWatcher04);
        single_27_edittext.addTextChangedListener(textWatcher04);





    }


    private void setFilter(EditText editText){
        editText.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "9999")});
    }

  /*  private void setFilter02(TextView editText){
        editText.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "9")});
    } */

    private void setFilter03(EditText editText){
        editText.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "99")});
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


        totalAndar = result;

        int finalResult = totalAndar + totalBahar + totalComb + totalSingle;

        satta_net_total_value.setText(String.valueOf(finalResult));



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

        totalBahar = result;

        int finalResult = totalAndar + totalBahar + totalComb + totalSingle;

        satta_net_total_value.setText(String.valueOf(finalResult));



        // Displays the calculated result
        satta_heading_02_total_value.setText(String.valueOf(result));
    }

    private void calculateResult03() throws NumberFormatException {

        // Gets the two EditText controls' Editable values
       /* String editableValue0 = comb_00_edittext.getText().toString(),
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

*/
        int value10 = 0, result, arraySize;

        if (!satta_heading_03_bid_value.getText().toString().isEmpty())
        value10 = Integer.parseInt(satta_heading_03_bid_value.getText().toString());

        arraySize = joinComb.size() * joinComb.size() * value10;

        // Calculates the result
      /*  result = (value0 + value1 + value2 + value3 + value4 + value5 + value6 + value7 + value8 + value9) *
                (value0 + value1 + value2 + value3 + value4 + value5 + value6 + value7 + value8 + value9) * value10; */


        // Displays the calculated result
        satta_heading_03_total_value.setText(String.valueOf(arraySize));

        totalComb = arraySize;

        int finalResult = totalAndar + totalBahar + totalComb + totalSingle;

        satta_net_total_value.setText(String.valueOf(finalResult));



    }

    private void calculateResult04() throws NumberFormatException {

        // Gets the two EditText controls' Editable values
        String
                editableValue1 = single_01_edittext.getText().toString(),

                editableValue3 = single_03_edittext.getText().toString(),

                editableValue5 = single_05_edittext.getText().toString(),

                editableValue7 = single_07_edittext.getText().toString(),

                editableValue9 = single_09_edittext.getText().toString(),

                editableValue11 = single_11_edittext.getText().toString(),

                editableValue13 = single_13_edittext.getText().toString(),

                editableValue15 = single_15_edittext.getText().toString(),

                editableValue17 = single_17_edittext.getText().toString(),

                editableValue19 = single_19_edittext.getText().toString(),

                editableValue21 = single_21_edittext.getText().toString(),

                editableValue23 = single_23_edittext.getText().toString(),

                editableValue25 = single_25_edittext.getText().toString(),

                editableValue27 = single_27_edittext.getText().toString();



        // Initializes the double values and result
        int value1 = 0, value3 = 0, value5 = 0, value7 = 0, value9 = 0, value11 = 0, value13 = 0, value15 = 0,  value17 = 0,  value19 = 0,
                  value21 = 0, value23 = 0, value25 = 0,  value27 = 0,
                result;

        // If the Editable values are not null, obtains their double values by parsing

        if (!editableValue1.isEmpty())
            value1 = Integer.parseInt(single_01_edittext.getText().toString());

        if (!editableValue3.isEmpty())
            value3 = Integer.parseInt(single_03_edittext.getText().toString());

        if (!editableValue5.isEmpty())
            value5 = Integer.parseInt(single_05_edittext.getText().toString());

        if (!editableValue7.isEmpty())
            value7 = Integer.parseInt(single_07_edittext.getText().toString());

        if (!editableValue9.isEmpty())
            value9 = Integer.parseInt(single_09_edittext.getText().toString());

        if (!editableValue11.isEmpty())
            value11 = Integer.parseInt(single_11_edittext.getText().toString());

        if (!editableValue13.isEmpty())
            value13 = Integer.parseInt(single_13_edittext.getText().toString());

        if (!editableValue15.isEmpty())
            value15 = Integer.parseInt(single_15_edittext.getText().toString());

        if (!editableValue17.isEmpty())
            value17 = Integer.parseInt(single_17_edittext.getText().toString());

        if (!editableValue19.isEmpty())
            value19 = Integer.parseInt(single_19_edittext.getText().toString());

        if (!editableValue21.isEmpty())
            value21 = Integer.parseInt(single_21_edittext.getText().toString());

        if (!editableValue23.isEmpty())
            value23 = Integer.parseInt(single_23_edittext.getText().toString());

        if (!editableValue25.isEmpty())
            value25 = Integer.parseInt(single_25_edittext.getText().toString());

        if (!editableValue27.isEmpty())
            value27 = Integer.parseInt(single_27_edittext.getText().toString());



        // Calculates the result
        result = value1 + value3 + value5 + value7 + value9 + value11 + value13 + value15 + value17 + value19 + value21 + value23 + value25 + value27;

        // Displays the calculated result
        satta_heading_04_total_value.setText(String.valueOf(result));

        totalSingle = result;

        int finalResult = totalAndar + totalBahar + totalComb + totalSingle;

        satta_net_total_value.setText(String.valueOf(finalResult));


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

    private void addGroupTag(String selectedGroup){
        joinComb.add(selectedGroup);
    }

    private void removeGroupTag(String selectedGroup){
        joinComb.remove(selectedGroup);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.comb_00_edittext:

                if (boolean_comb_00_edittext) {
                    removeGroupTag("0");
                    boolean_comb_00_edittext = false;
                    comb_00_edittext.setTextColor(getResources().getColor(R.color.black));
                    comb_00_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle));
                    calculateResult03();
                } else {
                    boolean_comb_00_edittext = true;
                    //setGroupId
                    addGroupTag("0");
                    comb_00_edittext.setTextColor(getResources().getColor(R.color.md_blue_grey_700));
                    comb_00_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle_color));

                    calculateResult03();
                }
                break;

            case R.id.comb_01_edittext:

                if (boolean_comb_01_edittext) {
                    removeGroupTag("1");
                    boolean_comb_01_edittext = false;
                    comb_01_edittext.setTextColor(getResources().getColor(R.color.black));
                    comb_01_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle));
                    calculateResult03();
                } else {
                    boolean_comb_01_edittext = true;
                    //setGroupId
                    addGroupTag("1");
                    comb_01_edittext.setTextColor(getResources().getColor(R.color.md_blue_grey_700));
                    comb_01_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle_color));
                    calculateResult03();

                }
                break;
            case R.id.comb_02_edittext:

                if (boolean_comb_02_edittext) {
                    removeGroupTag("2");
                    boolean_comb_02_edittext = false;
                    comb_02_edittext.setTextColor(getResources().getColor(R.color.black));
                    comb_02_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle));
                    calculateResult03();
                } else {
                    boolean_comb_02_edittext = true;
                    //setGroupId
                    addGroupTag("2");
                    comb_02_edittext.setTextColor(getResources().getColor(R.color.md_blue_grey_700));
                    comb_02_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle_color));
                    calculateResult03();

                }
                break;
            case R.id.comb_03_edittext:

                if (boolean_comb_03_edittext) {
                    removeGroupTag("3");
                    boolean_comb_03_edittext = false;
                    comb_03_edittext.setTextColor(getResources().getColor(R.color.black));
                    comb_03_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle));
                    calculateResult03();
                } else {
                    boolean_comb_03_edittext = true;
                    //setGroupId
                    addGroupTag("3");
                    comb_03_edittext.setTextColor(getResources().getColor(R.color.md_blue_grey_700));
                    comb_03_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle_color));
                    calculateResult03();

                }
                break;
            case R.id.comb_04_edittext:

                if (boolean_comb_04_edittext) {
                    removeGroupTag("4");
                    boolean_comb_04_edittext = false;
                    comb_04_edittext.setTextColor(getResources().getColor(R.color.black));
                    comb_04_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle));
                    calculateResult03();
                } else {
                    boolean_comb_04_edittext = true;
                    //setGroupId
                    addGroupTag("4");
                    comb_04_edittext.setTextColor(getResources().getColor(R.color.md_blue_grey_700));
                    comb_04_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle_color));
                    calculateResult03();

                }
                break;
            case R.id.comb_05_edittext:

                if (boolean_comb_05_edittext) {
                    removeGroupTag("5");
                    boolean_comb_05_edittext = false;
                    comb_05_edittext.setTextColor(getResources().getColor(R.color.black));
                    comb_05_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle));
                    calculateResult03();
                } else {
                    boolean_comb_05_edittext = true;
                    //setGroupId
                    addGroupTag("5");
                    comb_05_edittext.setTextColor(getResources().getColor(R.color.md_blue_grey_700));
                    comb_05_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle_color));
                    calculateResult03();

                }
                break;
            case R.id.comb_06_edittext:

                if (boolean_comb_06_edittext) {
                    removeGroupTag("6");
                    boolean_comb_06_edittext = false;
                    comb_06_edittext.setTextColor(getResources().getColor(R.color.black));
                    comb_06_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle));
                    calculateResult03();
                } else {
                    boolean_comb_06_edittext = true;
                    //setGroupId
                    addGroupTag("6");
                    comb_06_edittext.setTextColor(getResources().getColor(R.color.md_blue_grey_700));
                    comb_06_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle_color));

                    calculateResult03();
                }
                break;
            case R.id.comb_07_edittext:

                if (boolean_comb_07_edittext) {
                    removeGroupTag("7");
                    boolean_comb_07_edittext = false;
                    comb_07_edittext.setTextColor(getResources().getColor(R.color.black));
                    comb_07_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle));
                    calculateResult03();
                } else {
                    boolean_comb_07_edittext = true;
                    //setGroupId
                    addGroupTag("7");
                    comb_07_edittext.setTextColor(getResources().getColor(R.color.md_blue_grey_700));
                    comb_07_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle_color));
                    calculateResult03();

                }
                break;
            case R.id.comb_08_edittext:

                if (boolean_comb_08_edittext) {
                    removeGroupTag("8");
                    boolean_comb_08_edittext = false;
                    comb_08_edittext.setTextColor(getResources().getColor(R.color.black));
                    comb_08_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle));
                    calculateResult03();
                } else {
                    boolean_comb_08_edittext = true;
                    //setGroupId
                    addGroupTag("8");
                    comb_08_edittext.setTextColor(getResources().getColor(R.color.md_blue_grey_700));
                    comb_08_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle_color));
                    calculateResult03();

                }
                break;
            case R.id.comb_09_edittext:

                if (boolean_comb_09_edittext) {
                    removeGroupTag("9");
                    boolean_comb_09_edittext = false;
                    comb_09_edittext.setTextColor(getResources().getColor(R.color.black));
                    comb_09_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle));
                    calculateResult03();
                } else {
                    boolean_comb_09_edittext = true;
                    //setGroupId
                    addGroupTag("9");
                    comb_09_edittext.setTextColor(getResources().getColor(R.color.md_blue_grey_700));
                    comb_09_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle_color));
                    calculateResult03();

                }
                break;
        }
    }
}
