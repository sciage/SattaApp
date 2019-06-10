package com.example.sattaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CreateGroupTagActivity extends AppCompatActivity implements View.OnClickListener {
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
    TextView thirtyyfive;
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




    boolean boolean_group_interest_science;
    boolean boolean_group_interest_health;
    boolean boolean_group_interest_men_issues;
    boolean boolean_group_interest_teen;
    boolean boolean_group_interest_politics;
    boolean boolean_group_interest_celebrities;
    boolean boolean_group_interest_music;
    boolean boolean_group_interest_technology;
    boolean boolean_group_interest_fashion;
    boolean boolean_group_interest_business;
    boolean boolean_group_interest_school;
    boolean boolean_group_interest_art;
    boolean boolean_group_interest_photography;
    boolean boolean_group_interest_lgbt;
    boolean boolean_group_interest_relationship;
    boolean boolean_group_interest_sports;
    boolean boolean_group_interest_funny;
    boolean boolean_group_interest_confessions;
    boolean boolean_group_interest_family;
    boolean boolean_group_interest_work;
    boolean boolean_group_interest_faith;
    boolean boolean_group_interest_food;
    boolean boolean_group_interest_entertainment;
    boolean boolean_group_interest_personal;
    boolean boolean_group_interest_women_issues;
    boolean boolean_group_interest_sex;

    String selectedGroup = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group_tag);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);

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

                getSelectedButton();
                setGroup("1");
                boolean_group_interest_politics = true;
                //setGroupId
                one_number.setTextColor(getResources().getColor(R.color.white));
                one_number.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));
                break;

            case R.id.sixteen_number:

                getSelectedButton();
                setGroup("15");
                boolean_group_interest_personal = true;
                //setGroupId
                sixteen_number.setTextColor(getResources().getColor(R.color.white));
                sixteen_number.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.two_number:

                getSelectedButton();
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
                boolean_group_interest_family= true;
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

                getSelectedButton();
                setGroup("23");
                boolean_group_interest_health = true;
                //setGroupId
                twentyfour.setTextColor(getResources().getColor(R.color.white));
                twentyfour.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));

                break;
            case R.id.twentyfive:

                getSelectedButton();
                setGroup("24");
                boolean_group_interest_men_issues = true;
                //setGroupId
                twentyfive.setTextColor(getResources().getColor(R.color.white));
                twentyfive.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));

                break;
            case R.id.twentysix:

                getSelectedButton();
                setGroup("26");
                boolean_group_interest_teen = true;
                //setGroupId
                twentysix.setTextColor(getResources().getColor(R.color.white));
                twentysix.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));

                break;


        }
    }

    private void setGroup(String selectedGroup){
        this.selectedGroup = selectedGroup;
    }



    private void getSelectedButton(){
        if (boolean_group_interest_politics){
            boolean_group_interest_politics = false;
            one_number.setTextColor(getResources().getColor(R.color.black));
            one_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_celebrities){
            boolean_group_interest_celebrities = false;
            two_number.setTextColor(getResources().getColor(R.color.black));
            two_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_music){
            boolean_group_interest_music = false;
            fifteen_number.setTextColor(getResources().getColor(R.color.black));
            fifteen_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_technology){
            boolean_group_interest_technology = false;
            four_number.setTextColor(getResources().getColor(R.color.black));
            four_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_fashion){
            boolean_group_interest_fashion = false;
            number_five.setTextColor(getResources().getColor(R.color.black));
            number_five.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_business){

            boolean_group_interest_business = false;
            number_six.setTextColor(getResources().getColor(R.color.black));
            number_six.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_school){
            boolean_group_interest_school = false;
            number_seven.setTextColor(getResources().getColor(R.color.black));
            number_seven.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_art){
            boolean_group_interest_art = false;
            number_nine.setTextColor(getResources().getColor(R.color.black));
            number_nine.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_photography){
            boolean_group_interest_photography = false;
            twentythree.setTextColor(getResources().getColor(R.color.black));
            twentythree.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_lgbt){
            boolean_group_interest_lgbt = false;
            ten_number.setTextColor(getResources().getColor(R.color.black));
            ten_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_relationship){
            boolean_group_interest_relationship = false;
            eleven_number.setTextColor(getResources().getColor(R.color.black));
            eleven_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_sports){
            boolean_group_interest_sports = false;
            twelve_number.setTextColor(getResources().getColor(R.color.black));
            twelve_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_funny){
            boolean_group_interest_funny = false;
            thirteen_number.setTextColor(getResources().getColor(R.color.black));
            thirteen_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_confessions){
            boolean_group_interest_confessions = false;
            fourteen_number.setTextColor(getResources().getColor(R.color.black));
            fourteen_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_family){
            boolean_group_interest_family = false;
            eighteen_number.setTextColor(getResources().getColor(R.color.black));
            eighteen_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_work){
            boolean_group_interest_work = false;
            nineteen_number.setTextColor(getResources().getColor(R.color.black));
            nineteen_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_faith){
            boolean_group_interest_faith = false;
            twenty_number.setTextColor(getResources().getColor(R.color.black));
            twenty_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_food){
            boolean_group_interest_food=  false;
            twentyone_number.setTextColor(getResources().getColor(R.color.black));
            twentyone_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_entertainment){
            boolean_group_interest_entertainment = false;
            twentytwo.setTextColor(getResources().getColor(R.color.black));
            twentytwo.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_personal){
            boolean_group_interest_personal = false;
            sixteen_number.setTextColor(getResources().getColor(R.color.black));
            sixteen_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_women_issues){
            boolean_group_interest_women_issues = false;
            three_number.setTextColor(getResources().getColor(R.color.black));
            three_number.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_sex){
            boolean_group_interest_sex= false;
            seventeen_number.setTextColor(getResources().getColor(R.color.black));
            seventeen_number.setBackground(getResources().getDrawable(R.drawable.button_tag));

        }else if (boolean_group_interest_science){
            boolean_group_interest_science= false;
            number_eight.setTextColor(getResources().getColor(R.color.black));
            number_eight.setBackground(getResources().getDrawable(R.drawable.button_tag));
        }else if (boolean_group_interest_health){
            boolean_group_interest_health= false;
            twentyfour.setTextColor(getResources().getColor(R.color.black));
            twentyfour.setBackground(getResources().getDrawable(R.drawable.button_tag));
        }else if (boolean_group_interest_men_issues){
            boolean_group_interest_men_issues= false;
            twentyfive.setTextColor(getResources().getColor(R.color.black));
            twentyfive.setBackground(getResources().getDrawable(R.drawable.button_tag));
        }else if (boolean_group_interest_teen){
            boolean_group_interest_teen= false;
            twentysix.setTextColor(getResources().getColor(R.color.black));
            twentysix.setBackground(getResources().getDrawable(R.drawable.button_tag));
        }
    }
}
