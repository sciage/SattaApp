package in.co.sattamaster.ui.PlayMatka;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.co.sattamaster.R;
import in.co.sattamaster.dto.Bid;
import in.co.sattamaster.ui.Homepage.MainActivity;
import in.co.sattamaster.ui.Result.ResultActivity;
import in.co.sattamaster.ui.base.BaseActivity;
import in.co.sattamaster.ui.base.Constants;
import in.co.sattamaster.ui.base.MySharedPreferences;
import in.co.sattamaster.ui.login.LoginScreenActivity;
import timber.log.Timber;

public class PlayMatkaActivity extends BaseActivity implements PlayMatkaActivityMvpView, View.OnClickListener {


    @Inject
    PlayMatkaActivityMvpPresenter<PlayMatkaActivityMvpView> mPresenter;

    AlertDialog.Builder alertDialogBuilder;

    @BindView(R.id.andar_00_view)
    TextView andar_00_view;

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

    private List<Integer> joinComb;
    private JsonArray jodiBidding;

    @BindView(R.id.play_matkaloading) View play_matkaloading;


    @BindView(R.id.andar_00_edittext)
    EditText andar_00_edittext;
    @BindView(R.id.andar_01_edittext)
    EditText andar_01_edittext;
    @BindView(R.id.andar_02_edittext)
    EditText andar_02_edittext;
    @BindView(R.id.andar_03_edittext)
    EditText andar_03_edittext;
    @BindView(R.id.andar_04_edittext)
    EditText andar_04_edittext;
    @BindView(R.id.andar_05_edittext)
    EditText andar_05_edittext;
    @BindView(R.id.andar_06_edittext)
    EditText andar_06_edittext;
    @BindView(R.id.andar_07_edittext)
    EditText andar_07_edittext;
    @BindView(R.id.andar_08_edittext)
    EditText andar_08_edittext;
    @BindView(R.id.andar_09_edittext)
    EditText andar_09_edittext;

    @BindView(R.id.bahar_00_edittext)
    EditText bahar_00_edittext;
    @BindView(R.id.bahar_01_edittext)
    EditText bahar_01_edittext;
    @BindView(R.id.bahar_02_edittext)
    EditText bahar_02_edittext;
    @BindView(R.id.bahar_03_edittext)
    EditText bahar_03_edittext;
    @BindView(R.id.bahar_04_edittext)
    EditText bahar_04_edittext;
    @BindView(R.id.bahar_05_edittext)
    EditText bahar_05_edittext;
    @BindView(R.id.bahar_06_edittext)
    EditText bahar_06_edittext;
    @BindView(R.id.bahar_07_edittext)
    EditText bahar_07_edittext;
    @BindView(R.id.bahar_08_edittext)
    EditText bahar_08_edittext;
    @BindView(R.id.bahar_09_edittext)
    EditText bahar_09_edittext;

    @BindView(R.id.comb_00_edittext)
    TextView comb_00_edittext;
    @BindView(R.id.comb_01_edittext)
    TextView comb_01_edittext;
    @BindView(R.id.comb_02_edittext)
    TextView comb_02_edittext;
    @BindView(R.id.comb_03_edittext)
    TextView comb_03_edittext;
    @BindView(R.id.comb_04_edittext)
    TextView comb_04_edittext;
    @BindView(R.id.comb_05_edittext)
    TextView comb_05_edittext;
    @BindView(R.id.comb_06_edittext)
    TextView comb_06_edittext;
    @BindView(R.id.comb_07_edittext)
    TextView comb_07_edittext;
    @BindView(R.id.comb_08_edittext)
    TextView comb_08_edittext;
    @BindView(R.id.comb_09_edittext)
    TextView comb_09_edittext;

    @BindView(R.id.single_00_edittext)
    EditText single_00_edittext;
    @BindView(R.id.single_01_edittext)
    EditText single_01_edittext;
    @BindView(R.id.single_02_edittext)
    EditText single_02_edittext;
    @BindView(R.id.single_03_edittext)
    EditText single_03_edittext;
    @BindView(R.id.single_04_edittext)
    EditText single_04_edittext;
    @BindView(R.id.single_05_edittext)
    EditText single_05_edittext;
    @BindView(R.id.single_06_edittext)
    EditText single_06_edittext;
    @BindView(R.id.single_07_edittext)
    EditText single_07_edittext;
    @BindView(R.id.single_08_edittext)
    EditText single_08_edittext;
    @BindView(R.id.single_09_edittext)
    EditText single_09_edittext;

    @BindView(R.id.single_10_edittext)
    EditText single_10_edittext;
    @BindView(R.id.single_11_edittext)
    EditText single_11_edittext;
    @BindView(R.id.single_12_edittext)
    EditText single_12_edittext;
    @BindView(R.id.single_13_edittext)
    EditText single_13_edittext;
    @BindView(R.id.single_14_edittext)
    EditText single_14_edittext;
    @BindView(R.id.single_15_edittext)
    EditText single_15_edittext;
    @BindView(R.id.single_16_edittext)
    EditText single_16_edittext;
    @BindView(R.id.single_17_edittext)
    EditText single_17_edittext;
    @BindView(R.id.single_18_edittext)
    EditText single_18_edittext;
    @BindView(R.id.single_19_edittext)
    EditText single_19_edittext;

    @BindView(R.id.single_20_edittext)
    EditText single_20_edittext;
    @BindView(R.id.single_21_edittext)
    EditText single_21_edittext;
    @BindView(R.id.single_22_edittext)
    EditText single_22_edittext;
    @BindView(R.id.single_23_edittext)
    EditText single_23_edittext;
    @BindView(R.id.single_24_edittext)
    EditText single_24_edittext;
    @BindView(R.id.single_25_edittext)
    EditText single_25_edittext;
    @BindView(R.id.single_26_edittext)
    EditText single_26_edittext;
    @BindView(R.id.single_27_edittext)
    EditText single_27_edittext;
    @BindView(R.id.single_28_edittext)
    EditText single_28_edittext;
    @BindView(R.id.single_29_edittext)
    EditText single_29_edittext;

    @BindView(R.id.single_30_edittext)
    EditText single_30_edittext;
    @BindView(R.id.single_31_edittext)
    EditText single_31_edittext;
    @BindView(R.id.single_32_edittext)
    EditText single_32_edittext;
    @BindView(R.id.single_33_edittext)
    EditText single_33_edittext;
    @BindView(R.id.single_34_edittext)
    EditText single_34_edittext;
    @BindView(R.id.single_35_edittext)
    EditText single_35_edittext;
    @BindView(R.id.single_36_edittext)
    EditText single_36_edittext;
    @BindView(R.id.single_37_edittext)
    EditText single_37_edittext;
    @BindView(R.id.single_38_edittext)
    EditText single_38_edittext;
    @BindView(R.id.single_39_edittext)
    EditText single_39_edittext;


    @BindView(R.id.single_40_edittext)
    EditText single_40_edittext;
    @BindView(R.id.single_41_edittext)
    EditText single_41_edittext;
    @BindView(R.id.single_42_edittext)
    EditText single_42_edittext;
    @BindView(R.id.single_43_edittext)
    EditText single_43_edittext;
    @BindView(R.id.single_44_edittext)
    EditText single_44_edittext;
    @BindView(R.id.single_45_edittext)
    EditText single_45_edittext;
    @BindView(R.id.single_46_edittext)
    EditText single_46_edittext;
    @BindView(R.id.single_47_edittext)
    EditText single_47_edittext;
    @BindView(R.id.single_48_edittext)
    EditText single_48_edittext;
    @BindView(R.id.single_49_edittext)
    EditText single_49_edittext;

    @BindView(R.id.single_50_edittext)
    EditText single_50_edittext;
    @BindView(R.id.single_51_edittext)
    EditText single_51_edittext;
    @BindView(R.id.single_52_edittext)
    EditText single_52_edittext;
    @BindView(R.id.single_53_edittext)
    EditText single_53_edittext;
    @BindView(R.id.single_54_edittext)
    EditText single_54_edittext;
    @BindView(R.id.single_55_edittext)
    EditText single_55_edittext;
    @BindView(R.id.single_56_edittext)
    EditText single_56_edittext;
    @BindView(R.id.single_57_edittext)
    EditText single_57_edittext;
    @BindView(R.id.single_58_edittext)
    EditText single_58_edittext;
    @BindView(R.id.single_59_edittext)
    EditText single_59_edittext;


    @BindView(R.id.single_60_edittext)
    EditText single_60_edittext;
    @BindView(R.id.single_61_edittext)
    EditText single_61_edittext;
    @BindView(R.id.single_62_edittext)
    EditText single_62_edittext;
    @BindView(R.id.single_63_edittext)
    EditText single_63_edittext;
    @BindView(R.id.single_64_edittext)
    EditText single_64_edittext;
    @BindView(R.id.single_65_edittext)
    EditText single_65_edittext;
    @BindView(R.id.single_66_edittext)
    EditText single_66_edittext;
    @BindView(R.id.single_67_edittext)
    EditText single_67_edittext;
    @BindView(R.id.single_68_edittext)
    EditText single_68_edittext;
    @BindView(R.id.single_69_edittext)
    EditText single_69_edittext;

    @BindView(R.id.single_70_edittext)
    EditText single_70_edittext;
    @BindView(R.id.single_71_edittext)
    EditText single_71_edittext;
    @BindView(R.id.single_72_edittext)
    EditText single_72_edittext;
    @BindView(R.id.single_73_edittext)
    EditText single_73_edittext;
    @BindView(R.id.single_74_edittext)
    EditText single_74_edittext;
    @BindView(R.id.single_75_edittext)
    EditText single_75_edittext;
    @BindView(R.id.single_76_edittext)
    EditText single_76_edittext;
    @BindView(R.id.single_77_edittext)
    EditText single_77_edittext;
    @BindView(R.id.single_78_edittext)
    EditText single_78_edittext;
    @BindView(R.id.single_79_edittext)
    EditText single_79_edittext;

    @BindView(R.id.satta_heading_01_total_value)
    TextView satta_heading_01_total_value;
    @BindView(R.id.satta_heading_02_total_value)
    TextView satta_heading_02_total_value;
    @BindView(R.id.satta_heading_03_total_value)
    TextView satta_heading_03_total_value;
    @BindView(R.id.satta_heading_03_bid_value)
    TextView satta_heading_03_bid_value;
    @BindView(R.id.satta_heading_04_total_value)
    TextView satta_heading_04_total_value;
    @BindView(R.id.place_bid_button) Button place_bid_button;
    @BindView(R.id.balance_amount_value) TextView balance_amount_value;
    @BindView(R.id.user_name) TextView user_name;
    @BindView(R.id.moderator) TextView moderator;

    @BindView(R.id.satta_net_total_value)
    TextView satta_net_total_value;

    int totalAndar = 0;
    int totalBahar = 0;
    int totalComb = 0;
    int totalSingle = 0;
    String location_id;
    String combinationValue;

    LinkedHashMap<String, String> andar_hash_map;
    LinkedHashMap<String, String> bahar_hash_map;
    LinkedHashMap<String, String> single_hash_map;

    ArrayList<String> single_keys;
    ArrayList<String> single_values;
    String location_name;
    private String username;
    private String moderator_name;
    private String mobile;
    private String wallet;

    // private View status_group_post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_play_matka_testing);

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

        single_keys = new ArrayList<>();
        single_values = new ArrayList<>();

        play_matkaloading.setVisibility(View.INVISIBLE);

        Intent intent = getIntent();
        location_id = intent.getStringExtra(Constants.LOCATION); // seconnd person username random
        location_name = intent.getStringExtra(Constants.LOCATION_NAME);
        username = intent.getStringExtra(Constants.USER_NAME);
        moderator_name = intent.getStringExtra(Constants.MODERATOR_NAME);
        mobile = intent.getStringExtra(Constants.MODERATOR_MOBILE);
        wallet = intent.getStringExtra(Constants.WALLET_BALANCE);

        balance_amount_value.setText(wallet);
        user_name.setText(username);
        moderator.setText(String.valueOf(moderator_name + "( " + mobile + " )"));

        joinComb = new ArrayList<Integer>();
        jodiBidding = new JsonArray();

        andar_hash_map = new LinkedHashMap<String, String>();
        bahar_hash_map = new LinkedHashMap<String, String>();
        single_hash_map = new LinkedHashMap<String, String>();

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
        setFilter03(single_28_edittext);
        setFilter(single_29_edittext);

        setFilter03(single_30_edittext);
        setFilter(single_31_edittext);
        setFilter03(single_32_edittext);
        setFilter(single_33_edittext);
        setFilter03(single_34_edittext);
        setFilter(single_35_edittext);
        setFilter03(single_36_edittext);
        setFilter(single_37_edittext);
        setFilter03(single_38_edittext);
        setFilter(single_39_edittext);

        setFilter03(single_40_edittext);
        setFilter(single_41_edittext);
        setFilter03(single_42_edittext);
        setFilter(single_43_edittext);
        setFilter03(single_44_edittext);
        setFilter(single_45_edittext);
        setFilter03(single_46_edittext);
        setFilter(single_47_edittext);
        setFilter03(single_48_edittext);
        setFilter(single_49_edittext);

        setFilter03(single_50_edittext);
        setFilter(single_51_edittext);
        setFilter03(single_52_edittext);
        setFilter(single_53_edittext);
        setFilter03(single_54_edittext);
        setFilter(single_55_edittext);
        setFilter03(single_56_edittext);
        setFilter(single_57_edittext);
        setFilter03(single_58_edittext);
        setFilter(single_59_edittext);

        setFilter03(single_60_edittext);
        setFilter(single_61_edittext);
        setFilter03(single_62_edittext);
        setFilter(single_63_edittext);
        setFilter03(single_64_edittext);
        setFilter(single_65_edittext);
        setFilter03(single_66_edittext);
        setFilter(single_67_edittext);
        setFilter03(single_68_edittext);
        setFilter(single_69_edittext);
        setFilter03(single_70_edittext);
        setFilter(single_71_edittext);
        setFilter03(single_72_edittext);
        setFilter(single_73_edittext);
        setFilter03(single_74_edittext);
        setFilter(single_75_edittext);
        setFilter03(single_76_edittext);
        setFilter(single_77_edittext);
        setFilter03(single_78_edittext);
        setFilter(single_79_edittext);




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
        single_28_edittext.addTextChangedListener(textWatcher04);
        single_29_edittext.addTextChangedListener(textWatcher04);

        single_30_edittext.addTextChangedListener(textWatcher04);
        single_31_edittext.addTextChangedListener(textWatcher04);
        single_32_edittext.addTextChangedListener(textWatcher04);
        single_33_edittext.addTextChangedListener(textWatcher04);
        single_34_edittext.addTextChangedListener(textWatcher04);
        single_35_edittext.addTextChangedListener(textWatcher04);
        single_36_edittext.addTextChangedListener(textWatcher04);
        single_37_edittext.addTextChangedListener(textWatcher04);
        single_38_edittext.addTextChangedListener(textWatcher04);
        single_39_edittext.addTextChangedListener(textWatcher04);

        single_40_edittext.addTextChangedListener(textWatcher04);
        single_41_edittext.addTextChangedListener(textWatcher04);
        single_42_edittext.addTextChangedListener(textWatcher04);
        single_43_edittext.addTextChangedListener(textWatcher04);
        single_44_edittext.addTextChangedListener(textWatcher04);
        single_45_edittext.addTextChangedListener(textWatcher04);
        single_46_edittext.addTextChangedListener(textWatcher04);
        single_47_edittext.addTextChangedListener(textWatcher04);
        single_48_edittext.addTextChangedListener(textWatcher04);
        single_49_edittext.addTextChangedListener(textWatcher04);

        single_50_edittext.addTextChangedListener(textWatcher04);
        single_51_edittext.addTextChangedListener(textWatcher04);
        single_52_edittext.addTextChangedListener(textWatcher04);
        single_53_edittext.addTextChangedListener(textWatcher04);
        single_54_edittext.addTextChangedListener(textWatcher04);
        single_55_edittext.addTextChangedListener(textWatcher04);
        single_56_edittext.addTextChangedListener(textWatcher04);
        single_57_edittext.addTextChangedListener(textWatcher04);
        single_58_edittext.addTextChangedListener(textWatcher04);
        single_59_edittext.addTextChangedListener(textWatcher04);

        single_60_edittext.addTextChangedListener(textWatcher04);
        single_61_edittext.addTextChangedListener(textWatcher04);
        single_62_edittext.addTextChangedListener(textWatcher04);
        single_63_edittext.addTextChangedListener(textWatcher04);
        single_64_edittext.addTextChangedListener(textWatcher04);
        single_65_edittext.addTextChangedListener(textWatcher04);
        single_66_edittext.addTextChangedListener(textWatcher04);
        single_67_edittext.addTextChangedListener(textWatcher04);
        single_68_edittext.addTextChangedListener(textWatcher04);
        single_69_edittext.addTextChangedListener(textWatcher04);

        single_70_edittext.addTextChangedListener(textWatcher04);
        single_71_edittext.addTextChangedListener(textWatcher04);
        single_72_edittext.addTextChangedListener(textWatcher04);
        single_73_edittext.addTextChangedListener(textWatcher04);
        single_74_edittext.addTextChangedListener(textWatcher04);
        single_75_edittext.addTextChangedListener(textWatcher04);
        single_76_edittext.addTextChangedListener(textWatcher04);
        single_77_edittext.addTextChangedListener(textWatcher04);
        single_78_edittext.addTextChangedListener(textWatcher04);
        single_79_edittext.addTextChangedListener(textWatcher04);

        place_bid_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place_bid_button.setClickable(false);

                if (joinComb.size() > Integer.parseInt(MySharedPreferences.getCombinationLimit(preferences))){

                    alertDialogBuilder = new AlertDialog.Builder(PlayMatkaActivity.this);
                    alertDialogBuilder.setTitle("Combination Limit Exceeded");
                    alertDialogBuilder.setMessage("App Combination numbers = " + MySharedPreferences.getCombinationLimit(preferences) + " take bid kar saktey h");
                    alertDialogBuilder.setCancelable(true);
                    alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.dismiss();
                            place_bid_button.setClickable(true);

                        }
                    });
                    alertDialogBuilder.show();

                } else {
                    if (Integer.parseInt(wallet)< Integer.parseInt(satta_net_total_value.getText().toString())){
                        balanceInsufficient();
                        place_bid_button.setClickable(true);

                    } else {
                        play_matkaloading.setVisibility(View.VISIBLE);
                        try {
                            // writeJsonSimpleDemo();
                            mPresenter.sendBidSet(writeJsonSimpleDemo(), preferences);
                            place_bid_button.setClickable(false);
                        } catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }

                }

            }
        });


    }

    private void balanceInsufficient() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PlayMatkaActivity.this);
        alertDialogBuilder.setTitle("Balance Insufficient");
        alertDialogBuilder.setMessage("Your Balance = " + wallet + " Bid Amount = " + satta_net_total_value.getText().toString());
        alertDialogBuilder.setCancelable(true);
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialogBuilder.show();
    }


    public JsonObject writeJsonSimpleDemo() throws Exception {

        JsonObject object = new JsonObject();
        object.addProperty("user_id", MySharedPreferences.getUserId(preferences));
        object.addProperty("centre_id", location_id);

        JsonArray array = new JsonArray();

        JsonObject locationOne = getLocationObject("ANDAR"); // enter type of location key value
        JsonObject locationOneData = getAndarBidding();
        locationOne.add("data", locationOneData);

        JsonObject locationTwo = getLocationObject("BAHAR"); // enter type of location key value
        JsonObject locationTwoData = getBaharBidding();
        locationTwo.add("data", locationTwoData);

        JsonObject locationThree = getLocationObject("SINGLE"); // enter type of location key value
        findCalculation();
        JsonObject locationThreeData = getSingleBidding();
        locationThree.add("data", locationThreeData);

        JsonObject locationFour = getLocationObject("JODI"); // enter type of location key value
        JsonObject locationFourData = getJodiBidding();
        locationFour.add("data", locationFourData);

        array.add(locationOne);
        array.add(locationTwo);
        array.add(locationThree);
        array.add(locationFour);

        // first array top heading

        object.add("bids", array);


        return object;
    }

    private JsonObject getLocationObject(String Name) throws JsonIOException {

        JsonObject arrayElementOne = new JsonObject();
        arrayElementOne.addProperty("type", Name);

        return arrayElementOne;
    }

    private JsonObject getAndarBidding() throws JsonIOException {
        JsonObject arrayElementOneArrayElementOne = new JsonObject();

        for(int i=0; i<= 10; i++){
            if (andar_hash_map.containsKey(String.valueOf(i))){
                arrayElementOneArrayElementOne.addProperty(String.valueOf(i), andar_hash_map.get(String.valueOf(i)));
            }
        }

       // arrayElementOneArrayElementOne.put("1", 100);
       // arrayElementOneArrayElementOne.put("2", 100);

        return arrayElementOneArrayElementOne;
    }

    private JsonObject getBaharBidding() throws JsonIOException {

        JsonObject arrayElementOneArrayElementOne = new JsonObject();

        for(int i=0; i<= 10; i++){
            if (bahar_hash_map.containsKey(String.valueOf(i))){
                arrayElementOneArrayElementOne.addProperty(String.valueOf(i), bahar_hash_map.get(String.valueOf(i)));
            }
        }

        return arrayElementOneArrayElementOne;
    }

    private JsonObject getSingleBidding() throws JsonIOException {

        JsonObject arrayElementOneArrayElementOne = new JsonObject();

        for(int i=0; i< single_keys.size(); i++){
             arrayElementOneArrayElementOne.addProperty(single_keys.get(i), single_values.get(i));

            }

        return arrayElementOneArrayElementOne;
    }



    private JsonObject getJodiBidding() throws JsonIOException {
        JsonObject arrayElementOneArrayElementOne = new JsonObject();

        arrayElementOneArrayElementOne.add("numbers", jodiBidding);
        arrayElementOneArrayElementOne.addProperty("amount", combinationValue);

        return arrayElementOneArrayElementOne;
    }


    private void setFilter(EditText editText){
        editText.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "99999")});
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
        if (!editableValue0.isEmpty()){
            value0 = Integer.parseInt(andar_00_edittext.getText().toString());
            andar_hash_map.put("0", String.valueOf(value0));
        } else {
            if (andar_hash_map.containsKey("0")){
                andar_hash_map.remove("0");
            }
        }



        if (!editableValue1.isEmpty()){
            value1 = Integer.parseInt(andar_01_edittext.getText().toString());
            andar_hash_map.put("1", String.valueOf(value1));
        } else {
            if (andar_hash_map.containsKey("1")){
                andar_hash_map.remove("1");
            }
        }



        if (!editableValue2.isEmpty()){
            value2 = Integer.parseInt(andar_02_edittext.getText().toString());
            andar_hash_map.put("2", String.valueOf(value2));
        } else {
            if (andar_hash_map.containsKey("2")){
                andar_hash_map.remove("2");
            }
        }



        if (!editableValue3.isEmpty()){
            value3 = Integer.parseInt(andar_03_edittext.getText().toString());
            andar_hash_map.put("3", String.valueOf(value3));
        } else {
            if (andar_hash_map.containsKey("3")){
                andar_hash_map.remove("3");
            }
        }



        if (!editableValue4.isEmpty()){
            value4 = Integer.parseInt(andar_04_edittext.getText().toString());
            andar_hash_map.put("4", String.valueOf(value4));
        } else {
            if (andar_hash_map.containsKey("4")){
                andar_hash_map.remove("4");
            }
        }



        if (!editableValue5.isEmpty()){
            value5 = Integer.parseInt(andar_05_edittext.getText().toString());
            andar_hash_map.put("5", String.valueOf(value5));
        } else {
            if (andar_hash_map.containsKey("5")){
                andar_hash_map.remove("5");
            }
        }



        if (!editableValue6.isEmpty()){
            value6 = Integer.parseInt(andar_06_edittext.getText().toString());
            andar_hash_map.put("6", String.valueOf(value6));
        } else {
            if (andar_hash_map.containsKey("6")){
                andar_hash_map.remove("6");
            }
        }



        if (!editableValue7.isEmpty()){
            value7 = Integer.parseInt(andar_07_edittext.getText().toString());
            andar_hash_map.put("7", String.valueOf(value7));
        } else {
            if (andar_hash_map.containsKey("7")){
                andar_hash_map.remove("7");
            }
        }



        if (!editableValue8.isEmpty()){
            value8 = Integer.parseInt(andar_08_edittext.getText().toString());
            andar_hash_map.put("8", String.valueOf(value8));
        } else {
            if (andar_hash_map.containsKey("8")){
                andar_hash_map.remove("8");
            }
        }



        if (!editableValue9.isEmpty()){
            value9 = Integer.parseInt(andar_09_edittext.getText().toString());
            andar_hash_map.put("9", String.valueOf(value9));
        } else {
            if (andar_hash_map.containsKey("9")){
                andar_hash_map.remove("9");
            }
        }



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
        if (!editableValue0.isEmpty()){
            value0 = Integer.parseInt(bahar_00_edittext.getText().toString());
            bahar_hash_map.put("0", String.valueOf(value0));
        } else {
            if (bahar_hash_map.containsKey("0")){
                bahar_hash_map.remove("0");
            }
        }



        if (!editableValue1.isEmpty()){
            value1 = Integer.parseInt(bahar_01_edittext.getText().toString());
            bahar_hash_map.put("1", String.valueOf(value1));
        } else {
            if (bahar_hash_map.containsKey("1")){
                bahar_hash_map.remove("1");
            }
        }



        if (!editableValue2.isEmpty()){
            value2 = Integer.parseInt(bahar_02_edittext.getText().toString());
            bahar_hash_map.put("2", String.valueOf(value2));
        } else {
            if (bahar_hash_map.containsKey("2")){
                bahar_hash_map.remove("2");
            }
        }



        if (!editableValue3.isEmpty()){
            value3 = Integer.parseInt(bahar_03_edittext.getText().toString());
            bahar_hash_map.put("3", String.valueOf(value3));
        } else {
            if (bahar_hash_map.containsKey("3")){
                bahar_hash_map.remove("3");
            }
        }



        if (!editableValue4.isEmpty()){
            value4 = Integer.parseInt(bahar_04_edittext.getText().toString());
            bahar_hash_map.put("4", String.valueOf(value4));
        } else {
            if (bahar_hash_map.containsKey("4")){
                bahar_hash_map.remove("4");
            }
        }



        if (!editableValue5.isEmpty()){
            value5 = Integer.parseInt(bahar_05_edittext.getText().toString());
            bahar_hash_map.put("5", String.valueOf(value5));
        } else {
            if (bahar_hash_map.containsKey("5")){
                bahar_hash_map.remove("5");
            }
        }



        if (!editableValue6.isEmpty()){
            value6 = Integer.parseInt(bahar_06_edittext.getText().toString());
            bahar_hash_map.put("6", String.valueOf(value6));
        } else {
            if (bahar_hash_map.containsKey("6")){
                bahar_hash_map.remove("6");
            }
        }



        if (!editableValue7.isEmpty()){
            value7 = Integer.parseInt(bahar_07_edittext.getText().toString());
            bahar_hash_map.put("7", String.valueOf(value7));
        } else {
            if (bahar_hash_map.containsKey("7")){
                bahar_hash_map.remove("7");
            }
        }



        if (!editableValue8.isEmpty()){
            value8 = Integer.parseInt(bahar_08_edittext.getText().toString());
            bahar_hash_map.put("8", String.valueOf(value8));
        } else {
            if (bahar_hash_map.containsKey("8")){
                bahar_hash_map.remove("8");
            }
        }



        if (!editableValue9.isEmpty()){
            value9 = Integer.parseInt(bahar_09_edittext.getText().toString());
            bahar_hash_map.put("9", String.valueOf(value9));
        } else {
            if (bahar_hash_map.containsKey("9")){
                bahar_hash_map.remove("9");
            }
        }


        // Calculates the result
        result = value0 + value1 + value2 + value3 + value4 + value5 + value6 + value7 + value8 + value9;

        totalBahar = result;

        int finalResult = totalAndar + totalBahar + totalComb + totalSingle;

        satta_net_total_value.setText(String.valueOf(finalResult));



        // Displays the calculated result
        satta_heading_02_total_value.setText(String.valueOf(result));
    }

    private void calculateResult03() throws NumberFormatException {

        int value10 = 0, result, arraySize;

        if (!satta_heading_03_bid_value.getText().toString().isEmpty()){

            value10 = Integer.parseInt(satta_heading_03_bid_value.getText().toString());

            combinationValue = satta_heading_03_bid_value.getText().toString();


        }

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

    private void findCalculation(){
        // Gets the two EditText controls' Editable values
        String
                editableValue32 = single_32_edittext.getText().toString(),
                editableValue33 = single_33_edittext.getText().toString(),
                editableValue34 = single_34_edittext.getText().toString(),
                editableValue35 = single_35_edittext.getText().toString(),
                editableValue36 = single_36_edittext.getText().toString(),
                editableValue37 = single_37_edittext.getText().toString(),
                editableValue38 = single_38_edittext.getText().toString(),
                editableValue39 = single_39_edittext.getText().toString(),
                editableValue40 = single_40_edittext.getText().toString(),
                editableValue41 = single_41_edittext.getText().toString(),
                editableValue42 = single_42_edittext.getText().toString(),
                editableValue43 = single_43_edittext.getText().toString(),
                editableValue44 = single_44_edittext.getText().toString(),
                editableValue45 = single_45_edittext.getText().toString(),
                editableValue46 = single_46_edittext.getText().toString(),
                editableValue47 = single_47_edittext.getText().toString(),
                editableValue48 = single_48_edittext.getText().toString(),
                editableValue49 = single_49_edittext.getText().toString(),
                editableValue50 = single_50_edittext.getText().toString(),
                editableValue51 = single_51_edittext.getText().toString(),
                editableValue52 = single_52_edittext.getText().toString(),
                editableValue53 = single_53_edittext.getText().toString(),
                editableValue54 = single_54_edittext.getText().toString(),
                editableValue55 = single_55_edittext.getText().toString(),
                editableValue56 = single_56_edittext.getText().toString(),
                editableValue57 = single_57_edittext.getText().toString(),
                editableValue58 = single_58_edittext.getText().toString(),
                editableValue59 = single_59_edittext.getText().toString(),
                editableValue60 = single_60_edittext.getText().toString(),
                editableValue61 = single_61_edittext.getText().toString(),
                editableValue62 = single_62_edittext.getText().toString(),
                editableValue63 = single_63_edittext.getText().toString(),
                editableValue64 = single_64_edittext.getText().toString(),
                editableValue65 = single_65_edittext.getText().toString(),
                editableValue66 = single_66_edittext.getText().toString(),
                editableValue67 = single_67_edittext.getText().toString(),
                editableValue68 = single_68_edittext.getText().toString(),
                editableValue69 = single_69_edittext.getText().toString(),
                editableValue70 = single_70_edittext.getText().toString(),
                editableValue71 = single_71_edittext.getText().toString(),
                editableValue72 = single_72_edittext.getText().toString(),
                editableValue73 = single_73_edittext.getText().toString(),
                editableValue74 = single_74_edittext.getText().toString(),
                editableValue75 = single_75_edittext.getText().toString(),
                editableValue76 = single_76_edittext.getText().toString(),
                editableValue77 = single_77_edittext.getText().toString(),
                editableValue78 = single_78_edittext.getText().toString(),
                editableValue79 = single_79_edittext.getText().toString();


        if (!single_00_edittext.getText().toString().isEmpty()){
            AddToArrayList(single_00_edittext.getText().toString(), single_01_edittext.getText().toString());
        }


        if (!single_02_edittext.getText().toString().isEmpty()){
            AddToArrayList(single_02_edittext.getText().toString(), single_03_edittext.getText().toString());
        }

        if (!single_04_edittext.getText().toString().isEmpty()){
            AddToArrayList(single_04_edittext.getText().toString(), single_05_edittext.getText().toString());
        }


        if (!single_06_edittext.getText().toString().isEmpty()){
            AddToArrayList(single_06_edittext.getText().toString(), single_07_edittext.getText().toString());
        }

        if (!single_08_edittext.getText().toString().isEmpty()){
            AddToArrayList(single_08_edittext.getText().toString(), single_09_edittext.getText().toString());
        }

        if (!single_10_edittext.getText().toString().isEmpty()){
            AddToArrayList(single_10_edittext.getText().toString(), single_11_edittext.getText().toString());
        }

        if (!single_12_edittext.getText().toString().isEmpty()){
            AddToArrayList(single_12_edittext.getText().toString(), single_13_edittext.getText().toString());
        }

        if (!single_14_edittext.getText().toString().isEmpty()){
            AddToArrayList(single_14_edittext.getText().toString(), single_15_edittext.getText().toString());
        }

        if (!single_16_edittext.getText().toString().isEmpty()){
            AddToArrayList(single_16_edittext.getText().toString(), single_17_edittext.getText().toString());
        }

        if (!single_18_edittext.getText().toString().isEmpty()){
            AddToArrayList(single_18_edittext.getText().toString(), single_19_edittext.getText().toString());
        }



        if (!single_20_edittext.getText().toString().isEmpty()){
            AddToArrayList(single_20_edittext.getText().toString(), single_21_edittext.getText().toString());
        }

        if (!single_22_edittext.getText().toString().isEmpty() && !single_23_edittext.getText().toString().isEmpty()){
            AddToArrayList(single_22_edittext.getText().toString(), single_23_edittext.getText().toString());
        }

        if (!single_24_edittext.getText().toString().isEmpty() && !single_25_edittext.getText().toString().isEmpty()){
            AddToArrayList(single_24_edittext.getText().toString(), single_25_edittext.getText().toString());
        }

        if (!single_26_edittext.getText().toString().isEmpty() && !single_27_edittext.getText().toString().isEmpty()){
            AddToArrayList(single_26_edittext.getText().toString(), single_27_edittext.getText().toString());
        }

        if (!single_28_edittext.getText().toString().isEmpty() && !single_29_edittext.getText().toString().isEmpty()){
            AddToArrayList(single_28_edittext.getText().toString(), single_29_edittext.getText().toString());
        }


        if (!single_30_edittext.getText().toString().isEmpty() && !single_31_edittext.getText().toString().isEmpty()){
            AddToArrayList(single_30_edittext.getText().toString(), single_31_edittext.getText().toString());
        }


        if (!editableValue32.isEmpty() && !editableValue33.isEmpty()){
            AddToArrayList(single_32_edittext.getText().toString(), single_33_edittext.getText().toString());
        }

        if (!editableValue34.isEmpty() && !editableValue35.isEmpty()){
            AddToArrayList(single_34_edittext.getText().toString(), single_35_edittext.getText().toString());
        }

        if (!editableValue36.isEmpty() && !editableValue37.isEmpty()){
            AddToArrayList(single_36_edittext.getText().toString(), single_37_edittext.getText().toString());
        }

        if (!editableValue38.isEmpty() && !editableValue39.isEmpty()){
            AddToArrayList(single_38_edittext.getText().toString(), single_39_edittext.getText().toString());
        }



        if (!editableValue40.isEmpty() && !editableValue41.isEmpty()){
            AddToArrayList(single_40_edittext.getText().toString(), single_41_edittext.getText().toString());
        }


        if (!editableValue42.isEmpty() && !editableValue43.isEmpty()){
            AddToArrayList(single_42_edittext.getText().toString(), single_43_edittext.getText().toString());
        }

        if (!editableValue44.isEmpty() && !editableValue45.isEmpty()){
            AddToArrayList(single_44_edittext.getText().toString(), single_45_edittext.getText().toString());
        }

        if (!editableValue46.isEmpty() && !editableValue47.isEmpty()){
            AddToArrayList(single_46_edittext.getText().toString(), single_47_edittext.getText().toString());
        }

        if (!editableValue48.isEmpty() && !editableValue49.isEmpty()){
            AddToArrayList(single_48_edittext.getText().toString(), single_49_edittext.getText().toString());
        }



        if (!editableValue50.isEmpty() && !editableValue51.isEmpty()){
            AddToArrayList(single_50_edittext.getText().toString(), single_51_edittext.getText().toString());
        }


        if (!editableValue52.isEmpty() && !editableValue53.isEmpty()){
            AddToArrayList(single_52_edittext.getText().toString(), single_53_edittext.getText().toString());
        }


        if (!editableValue54.isEmpty() && !editableValue55.isEmpty()){
            AddToArrayList(single_54_edittext.getText().toString(), single_55_edittext.getText().toString());
        }


        if (!editableValue56.isEmpty() && !editableValue57.isEmpty()){
            AddToArrayList(single_56_edittext.getText().toString(), single_57_edittext.getText().toString());
        }

        if (!editableValue58.isEmpty() && !editableValue59.isEmpty()){
            AddToArrayList(single_58_edittext.getText().toString(), single_59_edittext.getText().toString());
        }



        if (!editableValue60.isEmpty() && !editableValue61.isEmpty()){
            AddToArrayList(single_60_edittext.getText().toString(), single_61_edittext.getText().toString());
        }


        if (!editableValue62.isEmpty() && !editableValue63.isEmpty()){
            AddToArrayList(single_62_edittext.getText().toString(), single_63_edittext.getText().toString());
        }



        if (!editableValue64.isEmpty() && !editableValue65.isEmpty()){
            AddToArrayList(single_64_edittext.getText().toString(), single_65_edittext.getText().toString());
        }



        if (!editableValue66.isEmpty() && !editableValue67.isEmpty()){
            AddToArrayList(single_66_edittext.getText().toString(), single_67_edittext.getText().toString());
        }

        if (!editableValue68.isEmpty() && !editableValue69.isEmpty()){
            AddToArrayList(single_68_edittext.getText().toString(), single_69_edittext.getText().toString());
        }





        if (!editableValue70.isEmpty() && !editableValue71.isEmpty()){
            AddToArrayList(single_70_edittext.getText().toString(), single_71_edittext.getText().toString());
        }


        if (!editableValue72.isEmpty() && !editableValue73.isEmpty()){
            AddToArrayList(single_72_edittext.getText().toString(), single_73_edittext.getText().toString());
        }



        if (!editableValue74.isEmpty() && !editableValue75.isEmpty()){
            AddToArrayList(single_74_edittext.getText().toString(), single_75_edittext.getText().toString());
        }

        if (!editableValue76.isEmpty() && !editableValue77.isEmpty()){
            AddToArrayList(single_76_edittext.getText().toString(), single_77_edittext.getText().toString());
        }

        if (!editableValue78.isEmpty() && !editableValue79.isEmpty()){
            AddToArrayList(single_78_edittext.getText().toString(), single_79_edittext.getText().toString());
        }

    }

    private void AddToArrayList(String key, String value){

        single_keys.add(key);
        single_values.add(value);
    }

    private void calculateResult04() throws NumberFormatException {

        // Gets the two EditText controls' Editable values
        String editableValue0 = single_00_edittext.getText().toString(),
                editableValue1 = single_01_edittext.getText().toString(),
                editableValue2 = single_02_edittext.getText().toString(),
                editableValue3 = single_03_edittext.getText().toString(),
                editableValue4 = single_04_edittext.getText().toString(),
                editableValue5 = single_05_edittext.getText().toString(),
                editableValue6 = single_06_edittext.getText().toString(),
                editableValue7 = single_07_edittext.getText().toString(),
                editableValue8 = single_08_edittext.getText().toString(),
                editableValue9 = single_09_edittext.getText().toString(),
                editableValue10 = single_10_edittext.getText().toString(),
                editableValue11 = single_11_edittext.getText().toString(),
                editableValue12 = single_12_edittext.getText().toString(),
                editableValue13 = single_13_edittext.getText().toString(),
                editableValue14 = single_14_edittext.getText().toString(),
                editableValue15 = single_15_edittext.getText().toString(),
                editableValue16 = single_16_edittext.getText().toString(),
                editableValue17 = single_17_edittext.getText().toString(),
                editableValue18 = single_18_edittext.getText().toString(),
                editableValue19 = single_19_edittext.getText().toString(),
                editableValue20 = single_20_edittext.getText().toString(),
                editableValue21 = single_21_edittext.getText().toString(),
                editableValue22 = single_22_edittext.getText().toString(),
                editableValue23 = single_23_edittext.getText().toString(),
                editableValue24 = single_24_edittext.getText().toString(),
                editableValue25 = single_25_edittext.getText().toString(),
                editableValue26 = single_26_edittext.getText().toString(),
                editableValue27 = single_27_edittext.getText().toString(),
                editableValue28 = single_28_edittext.getText().toString(),
                editableValue29 = single_29_edittext.getText().toString(),
                editableValue30 = single_30_edittext.getText().toString(),
                editableValue31 = single_31_edittext.getText().toString(),
                editableValue32 = single_32_edittext.getText().toString(),
                editableValue33 = single_33_edittext.getText().toString(),
                editableValue34 = single_34_edittext.getText().toString(),
                editableValue35 = single_35_edittext.getText().toString(),
                editableValue36 = single_36_edittext.getText().toString(),
                editableValue37 = single_37_edittext.getText().toString(),
                editableValue38 = single_38_edittext.getText().toString(),
                editableValue39 = single_39_edittext.getText().toString(),
                editableValue40 = single_40_edittext.getText().toString(),
                editableValue41 = single_41_edittext.getText().toString(),
                editableValue42 = single_42_edittext.getText().toString(),
                editableValue43 = single_43_edittext.getText().toString(),
                editableValue44 = single_44_edittext.getText().toString(),
                editableValue45 = single_45_edittext.getText().toString(),
                editableValue46 = single_46_edittext.getText().toString(),
                editableValue47 = single_47_edittext.getText().toString(),
                editableValue48 = single_48_edittext.getText().toString(),
                editableValue49 = single_49_edittext.getText().toString(),
                editableValue50 = single_50_edittext.getText().toString(),
                editableValue51 = single_51_edittext.getText().toString(),
                editableValue52 = single_52_edittext.getText().toString(),
                editableValue53 = single_53_edittext.getText().toString(),
                editableValue54 = single_54_edittext.getText().toString(),
                editableValue55 = single_55_edittext.getText().toString(),
                editableValue56 = single_56_edittext.getText().toString(),
                editableValue57 = single_57_edittext.getText().toString(),
                editableValue58 = single_58_edittext.getText().toString(),
                editableValue59 = single_59_edittext.getText().toString(),
                editableValue60 = single_60_edittext.getText().toString(),
                editableValue61 = single_61_edittext.getText().toString(),
                editableValue62 = single_62_edittext.getText().toString(),
                editableValue63 = single_63_edittext.getText().toString(),
                editableValue64 = single_64_edittext.getText().toString(),
                editableValue65 = single_65_edittext.getText().toString(),
                editableValue66 = single_66_edittext.getText().toString(),
                editableValue67 = single_67_edittext.getText().toString(),
                editableValue68 = single_68_edittext.getText().toString(),
                editableValue69 = single_69_edittext.getText().toString(),
                editableValue70 = single_70_edittext.getText().toString(),
                editableValue71 = single_71_edittext.getText().toString(),
                editableValue72 = single_72_edittext.getText().toString(),
                editableValue73 = single_73_edittext.getText().toString(),
                editableValue74 = single_74_edittext.getText().toString(),
                editableValue75 = single_75_edittext.getText().toString(),
                editableValue76 = single_76_edittext.getText().toString(),
                editableValue77 = single_77_edittext.getText().toString(),
                editableValue78 = single_78_edittext.getText().toString(),
                editableValue79 = single_79_edittext.getText().toString();



        // Initializes the double values and result
        int value0 = 0, value1 = 0, value2 = 0, value3 = 0, value4 = 0, value5 = 0, value6 = 0, value7 = 0, value8 = 0,
                value9 = 0, value10 = 0, value11 = 0, value12 = 0, value13 = 0, value14 = 0, value15 = 0, value16 = 0,
                value17 = 0, value18 = 0, value19 = 0, value20 = 0, value21 = 0, value22 = 0, value23 = 0, value24 = 0,
                value25 = 0, value26 = 0, value27 = 0, value28 = 0,
                value29 = 0,
                value30 = 0,
                value31 = 0,
                value32 = 0,
                value33 = 0,
                value34 = 0,
                value35 = 0,
                value36 = 0,
                value37 = 0,
                value38 = 0,
                value39 = 0,
                value40 = 0,
                value41 = 0,
                value42 = 0,
                value43 = 0,
                value44 = 0,
                value45 = 0,
                value46 = 0,
                value47 = 0,
                value48 = 0,
                value49 = 0,
                value50 = 0,
                value51 = 0,
                value52 = 0,
                value53 = 0,
                value54 = 0,
                value55 = 0,
                value56 = 0,
                value57 = 0,
                value58 = 0,
                value59 = 0,
                value60 = 0,
                value61 = 0,
                value62 = 0,
                value63 = 0,
                value64 = 0,
                value65 = 0,
                value66 = 0,
                value67 = 0,
                value68 = 0,
                value69 = 0,
                value70 = 0,
                value71 = 0,
                value72 = 0,
                value73 = 0,
                value74 = 0,
                value75 = 0,
                value76 = 0,
                value77 = 0,
                value78 = 0,
                value79 = 0,
                result;

        if (!editableValue0.isEmpty()) value0 = Integer.parseInt(single_00_edittext.getText().toString());
        if (!editableValue1.isEmpty()) value1 = Integer.parseInt(single_01_edittext.getText().toString());
        if (!editableValue2.isEmpty()) value2 = Integer.parseInt(single_02_edittext.getText().toString());
        if (!editableValue3.isEmpty()) value3 = Integer.parseInt(single_03_edittext.getText().toString());
        if (!editableValue4.isEmpty()) value4 = Integer.parseInt(single_04_edittext.getText().toString());
        if (!editableValue5.isEmpty()) value5 = Integer.parseInt(single_05_edittext.getText().toString());
        if (!editableValue6.isEmpty()) value6 = Integer.parseInt(single_06_edittext.getText().toString());
        if (!editableValue7.isEmpty()) value7 = Integer.parseInt(single_07_edittext.getText().toString());
        if (!editableValue8.isEmpty()) value8 = Integer.parseInt(single_08_edittext.getText().toString());
        if (!editableValue9.isEmpty()) value9 = Integer.parseInt(single_09_edittext.getText().toString());
        if (!editableValue10.isEmpty()) value10 = Integer.parseInt(single_10_edittext.getText().toString());
        if (!editableValue11.isEmpty()) value11 = Integer.parseInt(single_11_edittext.getText().toString());
        if (!editableValue12.isEmpty()) value12 = Integer.parseInt(single_12_edittext.getText().toString());
        if (!editableValue13.isEmpty()) value13 = Integer.parseInt(single_13_edittext.getText().toString());
        if (!editableValue14.isEmpty()) value14 = Integer.parseInt(single_14_edittext.getText().toString());
        if (!editableValue15.isEmpty()) value15 = Integer.parseInt(single_15_edittext.getText().toString());
        if (!editableValue16.isEmpty()) value16 = Integer.parseInt(single_16_edittext.getText().toString());
        if (!editableValue17.isEmpty()) value17 = Integer.parseInt(single_17_edittext.getText().toString());
        if (!editableValue18.isEmpty()) value18 = Integer.parseInt(single_18_edittext.getText().toString());
        if (!editableValue19.isEmpty()) value19 = Integer.parseInt(single_19_edittext.getText().toString());
        if (!editableValue20.isEmpty()) value20 = Integer.parseInt(single_20_edittext.getText().toString());
        if (!editableValue21.isEmpty()) value21 = Integer.parseInt(single_21_edittext.getText().toString());
        if (!editableValue22.isEmpty()) value22 = Integer.parseInt(single_22_edittext.getText().toString());
        if (!editableValue23.isEmpty()) value23 = Integer.parseInt(single_23_edittext.getText().toString());
        if (!editableValue24.isEmpty()) value24 = Integer.parseInt(single_24_edittext.getText().toString());
        if (!editableValue25.isEmpty()) value25 = Integer.parseInt(single_25_edittext.getText().toString());
        if (!editableValue26.isEmpty()) value26 = Integer.parseInt(single_26_edittext.getText().toString());
        if (!editableValue27.isEmpty()) value27 = Integer.parseInt(single_27_edittext.getText().toString());
        if (!editableValue28.isEmpty()) value28 = Integer.parseInt(single_28_edittext.getText().toString());
        if (!editableValue29.isEmpty()) value29 = Integer.parseInt(single_29_edittext.getText().toString());
        if (!editableValue30.isEmpty()) value30 = Integer.parseInt(single_30_edittext.getText().toString());
        if (!editableValue31.isEmpty()) value31 = Integer.parseInt(single_31_edittext.getText().toString());
        if (!editableValue32.isEmpty()) value32 = Integer.parseInt(single_32_edittext.getText().toString());
        if (!editableValue33.isEmpty()) value33 = Integer.parseInt(single_33_edittext.getText().toString());
        if (!editableValue34.isEmpty()) value34 = Integer.parseInt(single_34_edittext.getText().toString());
        if (!editableValue35.isEmpty()) value35 = Integer.parseInt(single_35_edittext.getText().toString());
        if (!editableValue36.isEmpty()) value36 = Integer.parseInt(single_36_edittext.getText().toString());
        if (!editableValue37.isEmpty()) value37 = Integer.parseInt(single_37_edittext.getText().toString());
        if (!editableValue38.isEmpty()) value38 = Integer.parseInt(single_38_edittext.getText().toString());
        if (!editableValue39.isEmpty()) value39 = Integer.parseInt(single_39_edittext.getText().toString());
        if (!editableValue40.isEmpty()) value40 = Integer.parseInt(single_40_edittext.getText().toString());
        if (!editableValue41.isEmpty()) value41 = Integer.parseInt(single_41_edittext.getText().toString());
        if (!editableValue42.isEmpty()) value42 = Integer.parseInt(single_42_edittext.getText().toString());
        if (!editableValue43.isEmpty()) value43 = Integer.parseInt(single_43_edittext.getText().toString());
        if (!editableValue44.isEmpty()) value44 = Integer.parseInt(single_44_edittext.getText().toString());
        if (!editableValue45.isEmpty()) value45 = Integer.parseInt(single_45_edittext.getText().toString());
        if (!editableValue46.isEmpty()) value46 = Integer.parseInt(single_46_edittext.getText().toString());
        if (!editableValue47.isEmpty()) value47 = Integer.parseInt(single_47_edittext.getText().toString());
        if (!editableValue48.isEmpty()) value48 = Integer.parseInt(single_48_edittext.getText().toString());
        if (!editableValue49.isEmpty()) value49 = Integer.parseInt(single_49_edittext.getText().toString());
        if (!editableValue50.isEmpty()) value50 = Integer.parseInt(single_50_edittext.getText().toString());
        if (!editableValue51.isEmpty()) value51 = Integer.parseInt(single_51_edittext.getText().toString());
        if (!editableValue52.isEmpty()) value52 = Integer.parseInt(single_52_edittext.getText().toString());
        if (!editableValue53.isEmpty()) value53 = Integer.parseInt(single_53_edittext.getText().toString());
        if (!editableValue54.isEmpty()) value54 = Integer.parseInt(single_54_edittext.getText().toString());
        if (!editableValue55.isEmpty()) value55 = Integer.parseInt(single_55_edittext.getText().toString());
        if (!editableValue56.isEmpty()) value56 = Integer.parseInt(single_56_edittext.getText().toString());
        if (!editableValue57.isEmpty()) value57 = Integer.parseInt(single_57_edittext.getText().toString());
        if (!editableValue58.isEmpty()) value58 = Integer.parseInt(single_58_edittext.getText().toString());
        if (!editableValue59.isEmpty()) value59 = Integer.parseInt(single_59_edittext.getText().toString());
        if (!editableValue60.isEmpty()) value60 = Integer.parseInt(single_60_edittext.getText().toString());
        if (!editableValue61.isEmpty()) value61 = Integer.parseInt(single_61_edittext.getText().toString());
        if (!editableValue62.isEmpty()) value62 = Integer.parseInt(single_62_edittext.getText().toString());
        if (!editableValue63.isEmpty()) value63 = Integer.parseInt(single_63_edittext.getText().toString());
        if (!editableValue64.isEmpty()) value64 = Integer.parseInt(single_64_edittext.getText().toString());
        if (!editableValue65.isEmpty()) value65 = Integer.parseInt(single_65_edittext.getText().toString());
        if (!editableValue66.isEmpty()) value66 = Integer.parseInt(single_66_edittext.getText().toString());
        if (!editableValue67.isEmpty()) value67 = Integer.parseInt(single_67_edittext.getText().toString());
        if (!editableValue68.isEmpty()) value68 = Integer.parseInt(single_68_edittext.getText().toString());
        if (!editableValue69.isEmpty()) value69 = Integer.parseInt(single_69_edittext.getText().toString());
        if (!editableValue70.isEmpty()) value70 = Integer.parseInt(single_70_edittext.getText().toString());
        if (!editableValue71.isEmpty()) value71 = Integer.parseInt(single_71_edittext.getText().toString());
        if (!editableValue72.isEmpty()) value72 = Integer.parseInt(single_72_edittext.getText().toString());
        if (!editableValue73.isEmpty()) value73 = Integer.parseInt(single_73_edittext.getText().toString());
        if (!editableValue74.isEmpty()) value74 = Integer.parseInt(single_74_edittext.getText().toString());
        if (!editableValue75.isEmpty()) value75 = Integer.parseInt(single_75_edittext.getText().toString());
        if (!editableValue76.isEmpty()) value76 = Integer.parseInt(single_76_edittext.getText().toString());
        if (!editableValue77.isEmpty()) value77 = Integer.parseInt(single_77_edittext.getText().toString());
        if (!editableValue78.isEmpty()) value78 = Integer.parseInt(single_78_edittext.getText().toString());
        if (!editableValue79.isEmpty()) value79 = Integer.parseInt(single_79_edittext.getText().toString());

        // If the Editable values are not null, obtains their double values by parsing

        // If the Editable values are not null, obtains their double values by parsing


        // Calculates the result
        result = value1 + value3 + value5 + value7 + value9 + value11 + value13 + value15 + value17 + value19 + value21 +
                value23 + value25 + value27 + value29 + value31 + value33 + value35 + value37 + value39 + value41 +
                value43 + value45 + value47 + value49 + value51 + value53 + value55
         + value57 + value59 + value61 + value63 + value65 + value67 + value69 + value71 + value73 + value75 +
                value77 + value79;

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

    private void addGroupTag(int selectedGroup){
        joinComb.add(selectedGroup);
        jodiBidding.add(selectedGroup);
    }

    private void removeGroupTag(int selectedGroup){
        Iterator itr = joinComb.iterator();
        while (itr.hasNext())
        {
            int x = (Integer)itr.next();
            if (x == selectedGroup)
                itr.remove();
        }

      //  joinComb.remove(new Integer(selectedGroup));

        jodiBidding = new JsonArray();

        for (int i=0;i<joinComb.size();i++){
            int one = joinComb.get(i);
            jodiBidding.add(one);
        }

       // new JsonArray()
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.comb_00_edittext:

                if (boolean_comb_00_edittext) {
                    removeGroupTag(0);
                    boolean_comb_00_edittext = false;
                    comb_00_edittext.setTextColor(getResources().getColor(R.color.black));
                    comb_00_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle));
                    calculateResult03();
                } else {
                boolean_comb_00_edittext = true;
                    //setGroupId
                    addGroupTag(0);
                    comb_00_edittext.setTextColor(getResources().getColor(R.color.md_blue_grey_700));
                    comb_00_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle_color));

                    calculateResult03();
                }
                break;

            case R.id.comb_01_edittext:

                if (boolean_comb_01_edittext) {
                    removeGroupTag(1);
                    boolean_comb_01_edittext = false;
                    comb_01_edittext.setTextColor(getResources().getColor(R.color.black));
                    comb_01_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle));
                    calculateResult03();
                } else {
                    boolean_comb_01_edittext = true;
                    //setGroupId
                    addGroupTag(1);
                    comb_01_edittext.setTextColor(getResources().getColor(R.color.md_blue_grey_700));
                    comb_01_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle_color));
                    calculateResult03();

                }
                break;
            case R.id.comb_02_edittext:

                if (boolean_comb_02_edittext) {
                    removeGroupTag(2);
                    boolean_comb_02_edittext = false;
                    comb_02_edittext.setTextColor(getResources().getColor(R.color.black));
                    comb_02_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle));
                    calculateResult03();
                } else {
                    boolean_comb_02_edittext = true;
                    //setGroupId
                    addGroupTag(2);
                    comb_02_edittext.setTextColor(getResources().getColor(R.color.md_blue_grey_700));
                    comb_02_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle_color));
                    calculateResult03();

                }
                break;
            case R.id.comb_03_edittext:

                if (boolean_comb_03_edittext) {
                    removeGroupTag(3);
                    boolean_comb_03_edittext = false;
                    comb_03_edittext.setTextColor(getResources().getColor(R.color.black));
                    comb_03_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle));
                    calculateResult03();
                } else {
                    boolean_comb_03_edittext = true;
                    //setGroupId
                    addGroupTag(3);
                    comb_03_edittext.setTextColor(getResources().getColor(R.color.md_blue_grey_700));
                    comb_03_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle_color));
                    calculateResult03();

                }
                break;
            case R.id.comb_04_edittext:

                if (boolean_comb_04_edittext) {
                    removeGroupTag(4);
                    boolean_comb_04_edittext = false;
                    comb_04_edittext.setTextColor(getResources().getColor(R.color.black));
                    comb_04_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle));
                    calculateResult03();
                } else {
                    boolean_comb_04_edittext = true;
                    //setGroupId
                    addGroupTag(4);
                    comb_04_edittext.setTextColor(getResources().getColor(R.color.md_blue_grey_700));
                    comb_04_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle_color));
                    calculateResult03();

                }
                break;
            case R.id.comb_05_edittext:

                if (boolean_comb_05_edittext) {
                    removeGroupTag(5);
                    boolean_comb_05_edittext = false;
                    comb_05_edittext.setTextColor(getResources().getColor(R.color.black));
                    comb_05_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle));
                    calculateResult03();
                } else {
                    boolean_comb_05_edittext = true;
                    //setGroupId
                    addGroupTag(5);
                    comb_05_edittext.setTextColor(getResources().getColor(R.color.md_blue_grey_700));
                    comb_05_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle_color));
                    calculateResult03();

                }
                break;
            case R.id.comb_06_edittext:

                if (boolean_comb_06_edittext) {
                    removeGroupTag(6);
                    boolean_comb_06_edittext = false;
                    comb_06_edittext.setTextColor(getResources().getColor(R.color.black));
                    comb_06_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle));
                    calculateResult03();
                } else {
                    boolean_comb_06_edittext = true;
                    //setGroupId
                    addGroupTag(6);
                    comb_06_edittext.setTextColor(getResources().getColor(R.color.md_blue_grey_700));
                    comb_06_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle_color));

                    calculateResult03();
                }
                break;
            case R.id.comb_07_edittext:

                if (boolean_comb_07_edittext) {
                    removeGroupTag(7);
                    boolean_comb_07_edittext = false;
                    comb_07_edittext.setTextColor(getResources().getColor(R.color.black));
                    comb_07_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle));
                    calculateResult03();
                } else {
                    boolean_comb_07_edittext = true;
                    //setGroupId
                    addGroupTag(7);
                    comb_07_edittext.setTextColor(getResources().getColor(R.color.md_blue_grey_700));
                    comb_07_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle_color));
                    calculateResult03();

                }
                break;
            case R.id.comb_08_edittext:

                if (boolean_comb_08_edittext) {
                    removeGroupTag(8);
                    boolean_comb_08_edittext = false;
                    comb_08_edittext.setTextColor(getResources().getColor(R.color.black));
                    comb_08_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle));
                    calculateResult03();
                } else {
                    boolean_comb_08_edittext = true;
                    //setGroupId
                    addGroupTag(8);
                    comb_08_edittext.setTextColor(getResources().getColor(R.color.md_blue_grey_700));
                    comb_08_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle_color));
                    calculateResult03();

                }
                break;
            case R.id.comb_09_edittext:

                if (boolean_comb_09_edittext) {
                    removeGroupTag(9);
                    boolean_comb_09_edittext = false;
                    comb_09_edittext.setTextColor(getResources().getColor(R.color.black));
                    comb_09_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle));
                    calculateResult03();
                } else {
                    boolean_comb_09_edittext = true;
                    //setGroupId
                    addGroupTag(9);
                    comb_09_edittext.setTextColor(getResources().getColor(R.color.md_blue_grey_700));
                    comb_09_edittext.setBackground(getResources().getDrawable(R.drawable.rectangle_color));
                    calculateResult03();

                }
                break;
        }
    }

    @Override
    public void receiveBidSetResult(Bid response) {

        play_matkaloading.setVisibility(View.GONE);

        if (response.getStatus()){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PlayMatkaActivity.this);
            alertDialogBuilder.setTitle("Success");
            alertDialogBuilder.setMessage("Successfully Placed Bid ");
            alertDialogBuilder.setCancelable(true);
            alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(PlayMatkaActivity.this, MainActivity.class);
                    intent.putExtra("isLoggedIn", true);
                    startActivity(intent);
                }
            });
            alertDialogBuilder.show();
           // Toast.makeText(PlayMatkaActivity.this, "Successfully Placed Bid", Toast.LENGTH_SHORT).show();
        } else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PlayMatkaActivity.this);
            alertDialogBuilder.setTitle("There is an error in placing bid");
            alertDialogBuilder.setMessage("Please contact your moderator: " + mobile);
            alertDialogBuilder.setCancelable(true);
            alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialogBuilder.show();
        }


        Timber.d(response.toString());
    }

    @Override
    public void biderror(String response) {
        play_matkaloading.setVisibility(View.GONE);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PlayMatkaActivity.this);
        alertDialogBuilder.setTitle("Error Occured");
        alertDialogBuilder.setMessage("Error name = " + response);
        alertDialogBuilder.setCancelable(true);
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialogBuilder.show();
    }
}

/*
  private JsonObject getLocationBidding() throws JSONException {

        JsonObject arrayElementOneArrayElementOne = new JsonObject();
        arrayElementOneArrayElementOne.put("1", 100);
        arrayElementOneArrayElementOne.put("2", 100);

        return arrayElementOneArrayElementOne;
    }
 */