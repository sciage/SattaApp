package com.example.sattaapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.sattaapp.R;
import com.example.sattaapp.ui.Homepage.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class CreateGroupTagActivity extends BaseActivity implements View.OnClickListener {
    Button btnSubmit;
    String group_name;
    String group_description;
    String image_location;
    String image_url;
    boolean select_category = false;
    ProgressBar create_new_group;


    TextView one_number;
    TextView two_number;
    TextView three_number;
    TextView four_number;
    TextView number_five;
    TextView number_six;
    TextView number_seven;
    TextView number_eight;
    TextView number_nine;
    TextView ten_number;
    TextView eleven_number;
    TextView twelve_number;
    TextView thirteen_number;
    TextView fourteen_number;
    TextView fifteen_number;
    TextView sixteen_number;
    TextView seventeen_number;
    TextView eighteen_number;
    TextView nineteen_number;
    TextView twenty_number;
    TextView twentyone_number;
    TextView twentytwo;
    TextView twentythree;
    TextView twentyfour;
    TextView twentyfive;
    TextView twentysix;

    TextView twentyseven;
    TextView twentyeight;
    TextView twentynine;
    TextView thirty;
    TextView thirtyone;
    TextView thirtytwo;
    TextView thirtythree;
    TextView thirtyfour;
    TextView thirtyfive;
    TextView thirtysix;
    TextView thirtyseven;
    TextView thirtyeight;
    TextView thirtynine;
    TextView forty;
    TextView fortyone;
    TextView fortytwo;
    TextView fortythree;
    TextView fortyfour;
    TextView fortyfive;
    TextView fortysix;
    TextView fortyseven;
    TextView fortyeight;
    TextView fortynine;
    TextView fifty;
    TextView fiftyone;
    TextView fiftytwo;
    TextView fiftythree;
    TextView fiftyfour;
    TextView fiftyfive;
    TextView fiftysix;
    TextView fiftyseven;
    TextView fiftyeight;
    TextView fiftynine;
    TextView sixty;
    TextView sixtyone;
    TextView sixtytwo;
    TextView sixtythree;
    TextView sixtyfour;
    TextView sixtyfive;
    TextView sixtysix;
    TextView sixtyseven;
    TextView sixtyeight;
    TextView sixtynine;
    TextView seventy;
    TextView seventyone;
    TextView seventytwo;
    TextView seventythree;
    TextView seventyfour;
    TextView seventyfive;
    TextView seventysix;
    TextView seventyseven;
    TextView seventyeight;
    TextView seventynine;
    TextView eighty;
    TextView eightyone;
    TextView eightytwo;
    TextView eightythree;
    TextView eightyfour;
    TextView eightyfive;
    TextView eightysix;
    TextView eightyseven;
    TextView eightyeight;
    TextView eightynine;
    TextView ninety;
    TextView ninetyone;
    TextView ninetytwo;
    TextView ninetythree;
    TextView ninetyfour;
    TextView ninetyfive;
    TextView ninetysix;
    TextView ninetyseven;
    TextView ninetyeight;
    TextView ninetynine;


    boolean boolean_one_number;
    boolean boolean_two_number;
    boolean boolean_three_number;
    boolean boolean_four_number;
    boolean boolean_number_five;
    boolean boolean_number_six;
    boolean boolean_number_seven;
    boolean boolean_number_eight;
    boolean boolean_number_nine;
    boolean boolean_ten_number;
    boolean boolean_eleven_number;
    boolean boolean_twelve_number;
    boolean boolean_thirteen_number;
    boolean boolean_fourteen_number;
    boolean boolean_fifteen_number;
    boolean boolean_sixteen_number;
    boolean boolean_seventeen_number;
    boolean boolean_eighteen_number;
    boolean boolean_nineteen_number;
    boolean boolean_twenty_number;
    boolean boolean_twentyone_number;
    boolean boolean_twentytwo;
    boolean boolean_twentythree;
    boolean boolean_twentyfour;
    boolean boolean_twentyfive;
    boolean boolean_twentysix;

    boolean boolean_twentyeight;
    boolean boolean_twentynine;
    boolean boolean_thirty;
    boolean boolean_thirtyone;
    boolean boolean_thirtytwo;
    boolean boolean_thirtythree;
    boolean boolean_thirtyfour;
    boolean boolean_thirtyfive;
    boolean boolean_thirtysix;
    boolean boolean_thirtyseven;
    boolean boolean_thirtyeight;
    boolean boolean_thirtynine;
    boolean boolean_forty;
    boolean boolean_fortyone;
    boolean boolean_fortytwo;
    boolean boolean_fortythree;
    boolean boolean_fortyfour;
    boolean boolean_fortyfive;
    boolean boolean_fortysix;
    boolean boolean_fortyseven;
    boolean boolean_fortyeight;
    boolean boolean_fortynine;
    boolean boolean_fifty;
    boolean boolean_fiftyone;
    boolean boolean_fiftytwo;
    boolean boolean_fiftythree;
    boolean boolean_fiftyfour;
    boolean boolean_fiftyfive;
    boolean boolean_fiftysix;
    boolean boolean_fiftyseven;
    boolean boolean_fiftyeight;
    boolean boolean_fiftynine;
    boolean boolean_sixty;
    boolean boolean_sixtyone;
    boolean boolean_sixtytwo;
    boolean boolean_sixtythree;
    boolean boolean_sixtyfour;
    boolean boolean_sixtyfive;
    boolean boolean_sixtysix;
    boolean boolean_sixtyseven;
    boolean boolean_sixtyeight;
    boolean boolean_sixtynine;
    boolean boolean_seventy;
    boolean boolean_seventyone;
    boolean boolean_seventytwo;
    boolean boolean_seventythree;
    boolean boolean_seventyfour;
    boolean boolean_seventyfive;
    boolean boolean_seventysix;
    boolean boolean_seventyseven;
    boolean boolean_seventyeight;
    boolean boolean_seventynine;
    boolean boolean_eighty;
    boolean boolean_eightyone;
    boolean boolean_eightytwo;
    boolean boolean_eightythree;
    boolean boolean_eightyfour;
    boolean boolean_eightyfive;
    boolean boolean_eightysix;
    boolean boolean_eightyseven;
    boolean boolean_eightyeight;
    boolean boolean_eightynine;
    boolean boolean_ninety;
    boolean boolean_ninetyone;
    boolean boolean_ninetytwo;
    boolean boolean_ninetythree;
    boolean boolean_ninetyfour;
    boolean boolean_ninetyfive;
    boolean boolean_ninetysix;
    boolean boolean_ninetyseven;
    boolean boolean_ninetyeight;
    boolean boolean_ninetynine;


    boolean singleSelect = false;
    boolean harasSelect = false;


    String selectedGroup = null;

    private List<String> joinedGroupsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group_tag);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        joinedGroupsList = new ArrayList<>();


        Intent intent = getIntent();
        group_name = intent.getStringExtra("name");
        group_description = intent.getStringExtra("desc");
        image_location = intent.getStringExtra("locationPOJO");
        create_new_group = (ProgressBar) findViewById(R.id.create_new_group);

        number_eight = (TextView) findViewById(R.id.number_eight);
        twentyfour = (TextView) findViewById(R.id.twentyfour);
        twentyfive = (TextView) findViewById(R.id.twentyfive);
        twentysix = (TextView) findViewById(R.id.twentysix);

        one_number = (TextView) findViewById(R.id.one_number);
        sixteen_number = (TextView) findViewById(R.id.sixteen_number);
        two_number = (TextView) findViewById(R.id.two_number);
        fifteen_number = (TextView) findViewById(R.id.fifteen_number);
        four_number = (TextView) findViewById(R.id.four_number);
        number_five = (TextView) findViewById(R.id.number_five);
        number_six = (TextView) findViewById(R.id.number_six);
        number_seven = (TextView) findViewById(R.id.number_seven);
        number_nine = (TextView) findViewById(R.id.number_nine);
        twentythree = (TextView) findViewById(R.id.twentythree);
        ten_number = (TextView) findViewById(R.id.ten_number);
        eleven_number = (TextView) findViewById(R.id.eleven_number);
        twelve_number = (TextView) findViewById(R.id.twelve_number);
        thirteen_number = (TextView) findViewById(R.id.thirteen_number);
        fourteen_number = (TextView) findViewById(R.id.fourteen_number);
        eighteen_number = (TextView) findViewById(R.id.eighteen_number);
        nineteen_number = (TextView) findViewById(R.id.nineteen_number);
        twenty_number = (TextView) findViewById(R.id.twenty_number);
        twentyone_number = (TextView) findViewById(R.id.twentyone_number);
        three_number = (TextView) findViewById(R.id.three_number);
        twentytwo = (TextView) findViewById(R.id.twentytwo);
        seventeen_number = (TextView) findViewById(R.id.seventeen_number);
        twentyseven = (TextView) findViewById(R.id.twentyseven);
        twentyseven = (TextView) findViewById(R.id.twentyseven);

        twentyeight = (TextView) findViewById(R.id.twentyeight);
        twentynine = (TextView) findViewById(R.id.twentynine);
        thirty = (TextView) findViewById(R.id.thirty);
        thirtyone = (TextView) findViewById(R.id.thirtyone);
        thirtytwo = (TextView) findViewById(R.id.thirtytwo);
        thirtythree = (TextView) findViewById(R.id.thirtythree);
        thirtyfour = (TextView) findViewById(R.id.thirtyfour);
        thirtyfive = (TextView) findViewById(R.id.thirtyfive);
        thirtysix = (TextView) findViewById(R.id.thirtysix);
        thirtyseven = (TextView) findViewById(R.id.thirtyseven);
        thirtyeight = (TextView) findViewById(R.id.thirtyeight);
        thirtynine = (TextView) findViewById(R.id.thirtynine);
        forty = (TextView) findViewById(R.id.forty);
        fortyone = (TextView) findViewById(R.id.fortyone);
        fortytwo = (TextView) findViewById(R.id.fortytwo);
        fortythree = (TextView) findViewById(R.id.fortythree);
        fortyfour = (TextView) findViewById(R.id.fortyfour);
        fortyfive = (TextView) findViewById(R.id.fortyfive);
        fortysix = (TextView) findViewById(R.id.fortysix);
        fortyseven = (TextView) findViewById(R.id.fortyseven);
        fortyeight = (TextView) findViewById(R.id.fortyeight);
        fortynine = (TextView) findViewById(R.id.fortynine);
        fifty = (TextView) findViewById(R.id.fifty);
        fiftyone = (TextView) findViewById(R.id.fiftyone);
        fiftytwo = (TextView) findViewById(R.id.fiftytwo);
        fiftythree = (TextView) findViewById(R.id.fiftythree);
        fiftyfour = (TextView) findViewById(R.id.fiftyfour);
        fiftyfive = (TextView) findViewById(R.id.fiftyfive);
        fiftysix = (TextView) findViewById(R.id.fiftysix);
        fiftyseven = (TextView) findViewById(R.id.fiftyseven);
        fiftyeight = (TextView) findViewById(R.id.fiftyeight);
        fiftynine = (TextView) findViewById(R.id.fiftynine);
        sixty = (TextView) findViewById(R.id.sixty);
        sixtyone = (TextView) findViewById(R.id.sixtyone);
        sixtytwo = (TextView) findViewById(R.id.sixtytwo);
        sixtythree = (TextView) findViewById(R.id.sixtythree);
        sixtyfour = (TextView) findViewById(R.id.sixtyfour);
        sixtyfive = (TextView) findViewById(R.id.sixtyfive);
        sixtysix = (TextView) findViewById(R.id.sixtysix);
        sixtyseven = (TextView) findViewById(R.id.sixtyseven);
        sixtyeight = (TextView) findViewById(R.id.sixtyeight);
        sixtynine = (TextView) findViewById(R.id.sixtynine);
        seventy = (TextView) findViewById(R.id.seventy);
        seventyone = (TextView) findViewById(R.id.seventyone);
        seventytwo = (TextView) findViewById(R.id.seventytwo);
        seventythree = (TextView) findViewById(R.id.seventythree);
        seventyfour = (TextView) findViewById(R.id.seventyfour);
        seventyfive = (TextView) findViewById(R.id.seventyfive);
        seventysix = (TextView) findViewById(R.id.seventysix);
        seventyseven = (TextView) findViewById(R.id.seventyseven);
        seventyeight = (TextView) findViewById(R.id.seventyeight);
        seventynine = (TextView) findViewById(R.id.seventynine);
        eighty = (TextView) findViewById(R.id.eighty);
        eightyone = (TextView) findViewById(R.id.eightyone);
        eightytwo = (TextView) findViewById(R.id.eightytwo);
        eightythree = (TextView) findViewById(R.id.eightythree);
        eightyfour = (TextView) findViewById(R.id.eightyfour);
        eightyfive = (TextView) findViewById(R.id.eightyfive);
        eightysix = (TextView) findViewById(R.id.eightysix);
        eightyseven = (TextView) findViewById(R.id.eightyseven);
        eightyeight = (TextView) findViewById(R.id.eightyeight);
        eightynine = (TextView) findViewById(R.id.eightynine);
        ninety = (TextView) findViewById(R.id.ninety);
        ninetyone = (TextView) findViewById(R.id.ninetyone);
        ninetytwo = (TextView) findViewById(R.id.ninetytwo);
        ninetythree = (TextView) findViewById(R.id.ninetythree);
        ninetyfour = (TextView) findViewById(R.id.ninetyfour);
        ninetyfive = (TextView) findViewById(R.id.ninetyfive);
        ninetysix = (TextView) findViewById(R.id.ninetysix);
        ninetyseven = (TextView) findViewById(R.id.ninetyseven);
        ninetyeight = (TextView) findViewById(R.id.ninetyeight);
        ninetynine = (TextView) findViewById(R.id.ninetynine);


        create_new_group.setVisibility(View.INVISIBLE);


        number_eight.setOnClickListener(this);
        twentyfour.setOnClickListener(this);
        twentyfive.setOnClickListener(this);
        twentysix.setOnClickListener(this);
        sixteen_number.setOnClickListener(this);
        one_number.setOnClickListener(this);
        two_number.setOnClickListener(this);
        fifteen_number.setOnClickListener(this);
        four_number.setOnClickListener(this);
        number_five.setOnClickListener(this);
        number_six.setOnClickListener(this);
        number_seven.setOnClickListener(this);
        number_nine.setOnClickListener(this);
        twentythree.setOnClickListener(this);
        ten_number.setOnClickListener(this);
        eleven_number.setOnClickListener(this);
        twelve_number.setOnClickListener(this);
        thirteen_number.setOnClickListener(this);
        fourteen_number.setOnClickListener(this);
        eighteen_number.setOnClickListener(this);
        nineteen_number.setOnClickListener(this);
        twenty_number.setOnClickListener(this);
        twentyone_number.setOnClickListener(this);
        twentytwo.setOnClickListener(this);
        three_number.setOnClickListener(this);
        seventeen_number.setOnClickListener(this);

        twentyeight.setOnClickListener(this);
        twentynine.setOnClickListener(this);
        thirty.setOnClickListener(this);
        thirtyone.setOnClickListener(this);
        thirtytwo.setOnClickListener(this);
        thirtythree.setOnClickListener(this);
        thirtyfour.setOnClickListener(this);
        thirtyfive.setOnClickListener(this);
        thirtysix.setOnClickListener(this);
        thirtyseven.setOnClickListener(this);
        thirtyeight.setOnClickListener(this);
        thirtynine.setOnClickListener(this);
        forty.setOnClickListener(this);
        fortyone.setOnClickListener(this);
        fortytwo.setOnClickListener(this);
        fortythree.setOnClickListener(this);
        fortyfour.setOnClickListener(this);
        fortyfive.setOnClickListener(this);
        fortysix.setOnClickListener(this);
        fortyseven.setOnClickListener(this);
        fortyeight.setOnClickListener(this);
        fortynine.setOnClickListener(this);
        fifty.setOnClickListener(this);
        fiftyone.setOnClickListener(this);
        fiftytwo.setOnClickListener(this);
        fiftythree.setOnClickListener(this);
        fiftyfour.setOnClickListener(this);
        fiftyfive.setOnClickListener(this);
        fiftysix.setOnClickListener(this);
        fiftyseven.setOnClickListener(this);
        fiftyeight.setOnClickListener(this);
        fiftynine.setOnClickListener(this);
        sixty.setOnClickListener(this);
        sixtyone.setOnClickListener(this);
        sixtytwo.setOnClickListener(this);
        sixtythree.setOnClickListener(this);
        sixtyfour.setOnClickListener(this);
        sixtyfive.setOnClickListener(this);
        sixtysix.setOnClickListener(this);
        sixtyseven.setOnClickListener(this);
        sixtyeight.setOnClickListener(this);
        sixtynine.setOnClickListener(this);
        seventy.setOnClickListener(this);
        seventyone.setOnClickListener(this);
        seventytwo.setOnClickListener(this);
        seventythree.setOnClickListener(this);
        seventyfour.setOnClickListener(this);
        seventyfive.setOnClickListener(this);
        seventysix.setOnClickListener(this);
        seventyseven.setOnClickListener(this);
        seventyeight.setOnClickListener(this);
        seventynine.setOnClickListener(this);
        eighty.setOnClickListener(this);
        eightyone.setOnClickListener(this);
        eightytwo.setOnClickListener(this);
        eightythree.setOnClickListener(this);
        eightyfour.setOnClickListener(this);
        eightyfive.setOnClickListener(this);
        eightysix.setOnClickListener(this);
        eightyseven.setOnClickListener(this);
        eightyeight.setOnClickListener(this);
        eightynine.setOnClickListener(this);
        ninety.setOnClickListener(this);
        ninetyone.setOnClickListener(this);
        ninetytwo.setOnClickListener(this);
        ninetythree.setOnClickListener(this);
        ninetyfour.setOnClickListener(this);
        ninetyfive.setOnClickListener(this);
        ninetysix.setOnClickListener(this);
        ninetyseven.setOnClickListener(this);
        ninetyeight.setOnClickListener(this);
        ninetynine.setOnClickListener(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

           /*     try {
                    create_new_group.setVisibility(View.VISIBLE);
                    if (!image_location.equalsIgnoreCase("null")){
                        uploadFile(Uri.parse(image_location));
                    } else {
                        mPresenter.postNewCategoryOnline(selectedGroup, MySharedPreferences.getUserId(preferences), group_name,"","");
                        //  CreatedNewCategory();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } */
            }


        });

    }

    private float dpToPx(float dp) {
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.one_number:

                if(singleSelect){

                } else if(harasSelect) {

                } else {

                }

       /*         if (boolean_group_interest_politics){
                    removeGroupTag("1");
                    boolean_group_interest_politics = false;
                    group_interest_politics.setTextColor(getResources().getColor(R.color.black));
                    group_interest_politics.setBackground(getResources().getDrawable(R.drawable.button_tag_big));
                    group_interest_politics.setCompoundDrawablesWithIntrinsicBounds(R.drawable.onboarding_tags_politics, 0, 0, 0);
                } else {
                    boolean_group_interest_politics = true;
                    //setGroupId
                    addGroupTag("1");
                    group_interest_politics.setTextColor(getResources().getColor(R.color.white));
                    group_interest_politics.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));
                    group_interest_politics.setCompoundDrawablesWithIntrinsicBounds(R.drawable.onboarding_tags_politics_selected, 0, 0, 0);

                }


        */


          //      getSelectedButton();
                setGroup("1");
            //    boolean_group_interest_politics = true;
                //setGroupId
                one_number.setTextColor(getResources().getColor(R.color.white));
                one_number.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));
                break;

            case R.id.sixteen_number:

         //       getSelectedButton();
                setGroup("15");
         //       boolean_group_interest_personal = true;
                //setGroupId
                sixteen_number.setTextColor(getResources().getColor(R.color.white));
                sixteen_number.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.two_number:

      /*          getSelectedButton();
                setGroup("2");
                boolean_group_interest_celebrities = true;
                //setGroupId
                two_number.setTextColor(getResources().getColor(R.color.white));
                two_number.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.fifteen_number:

                getSelectedButton();
                setGroup("3");
                boolean_group_interest_music = true;
                //setGroupId
                fifteen_number.setTextColor(getResources().getColor(R.color.white));
                fifteen_number.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.four_number:

                getSelectedButton();
                boolean_group_interest_technology = true;
                setGroup("4");
                //setGroupId
                four_number.setTextColor(getResources().getColor(R.color.white));
                four_number.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));
                four_number.setCompoundDrawablePadding(10);


                break;
            case R.id.number_five:

                getSelectedButton();
                boolean_group_interest_fashion = true;
                setGroup("5");
                //setGroupId
                number_five.setTextColor(getResources().getColor(R.color.white));
                number_five.setCompoundDrawablePadding(10);
                number_five.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.number_six:

                getSelectedButton();
                setGroup("6");
                boolean_group_interest_business = true;
                //setGroupId
                number_six.setTextColor(getResources().getColor(R.color.white));
                number_six.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.number_seven:

                getSelectedButton();
                boolean_group_interest_school = true;
                setGroup("7");
                //setGroupId
                number_seven.setTextColor(getResources().getColor(R.color.white));
                number_seven.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.number_nine:

                setGroup("8");

                getSelectedButton();
                boolean_group_interest_art = true;
                //setGroupId
                number_nine.setTextColor(getResources().getColor(R.color.white));
                number_nine.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.twentythree:
                getSelectedButton();
                boolean_group_interest_photography = true;
                setGroup("9");
                //setGroupId
                twentythree.setTextColor(getResources().getColor(R.color.white));
                twentythree.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.ten_number:
                getSelectedButton();
                setGroup("10");
                boolean_group_interest_lgbt = true;
                //setGroupId
                ten_number.setTextColor(getResources().getColor(R.color.white));
                ten_number.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.eleven_number:
                getSelectedButton();
                setGroup("11");
                //setGroupId
                boolean_group_interest_relationship = true;
                eleven_number.setTextColor(getResources().getColor(R.color.white));
                eleven_number.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.twelve_number:
                getSelectedButton();
                //setGroupId
                setGroup("12");
                boolean_group_interest_sports = true;
                twelve_number.setTextColor(getResources().getColor(R.color.white));
                twelve_number.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));

                break;
            case R.id.thirteen_number:

                getSelectedButton();
                boolean_group_interest_funny = true;
                setGroup("13");
                //setGroupId
                thirteen_number.setTextColor(getResources().getColor(R.color.white));
                thirteen_number.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.fourteen_number:

                getSelectedButton();
                boolean_group_interest_confessions = true;
                setGroup("14");
                //setGroupId
                fourteen_number.setTextColor(getResources().getColor(R.color.white));
                fourteen_number.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.eighteen_number:

                getSelectedButton();
                setGroup("17");
                boolean_group_interest_family = true;
                //setGroupId
                eighteen_number.setTextColor(getResources().getColor(R.color.white));
                eighteen_number.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.nineteen_number:

                getSelectedButton();
                boolean_group_interest_work = true;
                setGroup("18");
                //setGroupId
                nineteen_number.setTextColor(getResources().getColor(R.color.white));
                nineteen_number.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.twenty_number:

                getSelectedButton();
                boolean_group_interest_faith = true;
                setGroup("19");
                //setGroupId
                twenty_number.setTextColor(getResources().getColor(R.color.white));
                twenty_number.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.twentyone_number:

                getSelectedButton();
                setGroup("20");
                boolean_group_interest_food = true;
                //setGroupId
                twentyone_number.setTextColor(getResources().getColor(R.color.white));
                twentyone_number.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.twentytwo:

                getSelectedButton();
                boolean_group_interest_entertainment = true;
                setGroup("21");
                //setGroupId
                twentytwo.setTextColor(getResources().getColor(R.color.white));
                twentytwo.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.seventeen_number:

                getSelectedButton();
                boolean_group_interest_sex = true;
                setGroup("16");
                //setGroupId
                seventeen_number.setTextColor(getResources().getColor(R.color.white));
                seventeen_number.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.three_number:

                getSelectedButton();
                setGroup("22");

                boolean_group_interest_women_issues = true;
                //setGroupId
                three_number.setTextColor(getResources().getColor(R.color.white));
                three_number.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));

                break;

            case R.id.number_eight:

                getSelectedButton();
                setGroup("25");
                boolean_group_interest_science = true;
                //setGroupId
                number_eight.setTextColor(getResources().getColor(R.color.white));
                number_eight.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));

                break;
            case R.id.twentyfour:

            //    getSelectedButton();
                setGroup("23");
                boolean_group_interest_health = true;
                //setGroupId
                twentyfour.setTextColor(getResources().getColor(R.color.white));
                twentyfour.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));

                break;
            case R.id.twentyfive:

              //  getSelectedButton();
                setGroup("24");
                boolean_group_interest_men_issues = true;
                //setGroupId
                twentyfive.setTextColor(getResources().getColor(R.color.white));
                twentyfive.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));

                break;
            case R.id.twentysix:

               // getSelectedButton();
                setGroup("26");
                boolean_group_interest_teen = true;
                //setGroupId
                twentysix.setTextColor(getResources().getColor(R.color.white));
                twentysix.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


       */
                break;




        }
    }

    private void setGroup(String selectedGroup) {
        this.selectedGroup = selectedGroup;
    }


    /* private void getSelectedButton() {
        if (boolean_group_interest_politics) {
            boolean_group_interest_politics = false;
            one_number.setTextColor(getResources().getColor(R.color.black));
            one_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_celebrities) {
            boolean_group_interest_celebrities = false;
            two_number.setTextColor(getResources().getColor(R.color.black));
            two_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_music) {
            boolean_group_interest_music = false;
            fifteen_number.setTextColor(getResources().getColor(R.color.black));
            fifteen_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_technology) {
            boolean_group_interest_technology = false;
            four_number.setTextColor(getResources().getColor(R.color.black));
            four_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_fashion) {
            boolean_group_interest_fashion = false;
            number_five.setTextColor(getResources().getColor(R.color.black));
            number_five.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_business) {

            boolean_group_interest_business = false;
            number_six.setTextColor(getResources().getColor(R.color.black));
            number_six.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_school) {
            boolean_group_interest_school = false;
            number_seven.setTextColor(getResources().getColor(R.color.black));
            number_seven.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_art) {
            boolean_group_interest_art = false;
            number_nine.setTextColor(getResources().getColor(R.color.black));
            number_nine.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_photography) {
            boolean_group_interest_photography = false;
            twentythree.setTextColor(getResources().getColor(R.color.black));
            twentythree.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_lgbt) {
            boolean_group_interest_lgbt = false;
            ten_number.setTextColor(getResources().getColor(R.color.black));
            ten_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_relationship) {
            boolean_group_interest_relationship = false;
            eleven_number.setTextColor(getResources().getColor(R.color.black));
            eleven_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_sports) {
            boolean_group_interest_sports = false;
            twelve_number.setTextColor(getResources().getColor(R.color.black));
            twelve_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_funny) {
            boolean_group_interest_funny = false;
            thirteen_number.setTextColor(getResources().getColor(R.color.black));
            thirteen_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_confessions) {
            boolean_group_interest_confessions = false;
            fourteen_number.setTextColor(getResources().getColor(R.color.black));
            fourteen_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_family) {
            boolean_group_interest_family = false;
            eighteen_number.setTextColor(getResources().getColor(R.color.black));
            eighteen_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_work) {
            boolean_group_interest_work = false;
            nineteen_number.setTextColor(getResources().getColor(R.color.black));
            nineteen_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_faith) {
            boolean_group_interest_faith = false;
            twenty_number.setTextColor(getResources().getColor(R.color.black));
            twenty_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_food) {
            boolean_group_interest_food = false;
            twentyone_number.setTextColor(getResources().getColor(R.color.black));
            twentyone_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_entertainment) {
            boolean_group_interest_entertainment = false;
            twentytwo.setTextColor(getResources().getColor(R.color.black));
            twentytwo.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_personal) {
            boolean_group_interest_personal = false;
            sixteen_number.setTextColor(getResources().getColor(R.color.black));
            sixteen_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_women_issues) {
            boolean_group_interest_women_issues = false;
            three_number.setTextColor(getResources().getColor(R.color.black));
            three_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_sex) {
            boolean_group_interest_sex = false;
            seventeen_number.setTextColor(getResources().getColor(R.color.black));
            seventeen_number.setBackground(getResources().getDrawable(R.drawable.button_tag));

        } else if (boolean_group_interest_science) {
            boolean_group_interest_science = false;
            number_eight.setTextColor(getResources().getColor(R.color.black));
            number_eight.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_health) {
            boolean_group_interest_health = false;
            twentyfour.setTextColor(getResources().getColor(R.color.black));
            twentyfour.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_men_issues) {
            boolean_group_interest_men_issues = false;
            twentyfive.setTextColor(getResources().getColor(R.color.black));
            twentyfive.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_teen) {
            boolean_group_interest_teen = false;
            twentysix.setTextColor(getResources().getColor(R.color.black));
            twentysix.setBackground(getResources().getDrawable(R.drawable.button_tag));
        }

    } */
}
