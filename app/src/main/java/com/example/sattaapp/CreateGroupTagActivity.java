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

    TextView group_interest_politics;
    TextView group_interest_celebrities;
    TextView group_interest_music;
    TextView group_interest_technology;
    TextView group_interest_fashion;
    TextView group_interest_business;
    TextView group_interest_school;
    TextView group_interest_art;
    TextView group_interest_photography;
    TextView group_interest_lgbt;
    TextView group_interest_relationship;
    TextView group_interest_sports;
    TextView group_interest_funny;
    TextView group_interest_confessions;
    TextView group_interest_family;
    TextView group_interest_work;
    TextView group_interest_faith;
    TextView group_interest_food;
    TextView group_interest_entertainment;
    TextView group_interest_personal;
    TextView group_interest_women_issues;
    TextView group_interest_sex;
    TextView group_interest_science;
    TextView group_interest_health;
    TextView group_interest_men_issues;
    TextView group_interest_teen;

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

        group_interest_science = (TextView) findViewById(R.id.number_eight);
        group_interest_health = (TextView) findViewById(R.id.twentyfour);
        group_interest_men_issues = (TextView) findViewById(R.id.twentyfive);
        group_interest_teen = (TextView) findViewById(R.id.twentysix);

        group_interest_politics = (TextView) findViewById(R.id.one_number);
        group_interest_personal = (TextView) findViewById(R.id.sixteen_number);
        group_interest_celebrities = (TextView) findViewById(R.id.two_number);
        group_interest_music = (TextView) findViewById(R.id.fifteen_number);
        group_interest_technology = (TextView) findViewById(R.id.four_number);
        group_interest_fashion = (TextView) findViewById(R.id.number_five);
        group_interest_business = (TextView) findViewById(R.id.number_six);
        group_interest_school = (TextView) findViewById(R.id.number_seven);
        group_interest_art = (TextView) findViewById(R.id.number_nine);
        group_interest_photography = (TextView) findViewById(R.id.twentythree);
        group_interest_lgbt = (TextView) findViewById(R.id.ten_number);
        group_interest_relationship = (TextView) findViewById(R.id.eleven_number);
        group_interest_sports = (TextView) findViewById(R.id.twelve_number);
        group_interest_funny = (TextView) findViewById(R.id.thirteen_number);
        group_interest_confessions = (TextView) findViewById(R.id.fourteen_number);
        group_interest_family = (TextView) findViewById(R.id.eighteen_number);
        group_interest_work = (TextView) findViewById(R.id.nineteen_number);
        group_interest_faith = (TextView) findViewById(R.id.twenty_number);
        group_interest_food = (TextView) findViewById(R.id.twentyone_number);
        group_interest_women_issues = (TextView) findViewById(R.id.three_number);
        group_interest_entertainment = (TextView) findViewById(R.id.twentytwo);
        group_interest_sex = (TextView) findViewById(R.id.seventeen_number);

        create_new_group.setVisibility(View.INVISIBLE);


        group_interest_science.setOnClickListener(this);
        group_interest_health.setOnClickListener(this);
        group_interest_men_issues.setOnClickListener(this);
        group_interest_teen.setOnClickListener(this);
        group_interest_personal.setOnClickListener(this);
        group_interest_politics.setOnClickListener(this);
        group_interest_celebrities.setOnClickListener(this);
        group_interest_music.setOnClickListener(this);
        group_interest_technology.setOnClickListener(this);
        group_interest_fashion.setOnClickListener(this);
        group_interest_business.setOnClickListener(this);
        group_interest_school.setOnClickListener(this);
        group_interest_art.setOnClickListener(this);
        group_interest_photography.setOnClickListener(this);
        group_interest_lgbt.setOnClickListener(this);
        group_interest_relationship.setOnClickListener(this);
        group_interest_sports.setOnClickListener(this);
        group_interest_funny.setOnClickListener(this);
        group_interest_confessions.setOnClickListener(this);
        group_interest_family.setOnClickListener(this);
        group_interest_work.setOnClickListener(this);
        group_interest_faith.setOnClickListener(this);
        group_interest_food.setOnClickListener(this);
        group_interest_entertainment.setOnClickListener(this);
        group_interest_women_issues.setOnClickListener(this);
        group_interest_sex.setOnClickListener(this);

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
                group_interest_politics.setTextColor(getResources().getColor(R.color.white));
                group_interest_politics.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));
                break;

            case R.id.sixteen_number:

                getSelectedButton();
                setGroup("15");
                boolean_group_interest_personal = true;
                //setGroupId
                group_interest_personal.setTextColor(getResources().getColor(R.color.white));
                group_interest_personal.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.two_number:

                getSelectedButton();
                setGroup("2");
                boolean_group_interest_celebrities = true;
                //setGroupId
                group_interest_celebrities.setTextColor(getResources().getColor(R.color.white));
                group_interest_celebrities.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.fifteen_number:

                getSelectedButton();
                setGroup("3");
                boolean_group_interest_music = true;
                //setGroupId
                group_interest_music.setTextColor(getResources().getColor(R.color.white));
                group_interest_music.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.four_number:

                getSelectedButton();
                boolean_group_interest_technology = true;
                setGroup("4");
                //setGroupId
                group_interest_technology.setTextColor(getResources().getColor(R.color.white));
                group_interest_technology.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));
                group_interest_technology.setCompoundDrawablePadding(10);


                break;
            case R.id.number_five:

                getSelectedButton();
                boolean_group_interest_fashion = true;
                setGroup("5");
                //setGroupId
                group_interest_fashion.setTextColor(getResources().getColor(R.color.white));
                group_interest_fashion.setCompoundDrawablePadding(10);
                group_interest_fashion.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.number_six:

                getSelectedButton();
                setGroup("6");
                boolean_group_interest_business = true;
                //setGroupId
                group_interest_business.setTextColor(getResources().getColor(R.color.white));
                group_interest_business.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.number_seven:

                getSelectedButton();
                boolean_group_interest_school = true;
                setGroup("7");
                //setGroupId
                group_interest_school.setTextColor(getResources().getColor(R.color.white));
                group_interest_school.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.number_nine:

                setGroup("8");

                getSelectedButton();
                boolean_group_interest_art = true;
                //setGroupId
                group_interest_art.setTextColor(getResources().getColor(R.color.white));
                group_interest_art.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.twentythree:
                getSelectedButton();
                boolean_group_interest_photography = true;
                setGroup("9");
                //setGroupId
                group_interest_photography.setTextColor(getResources().getColor(R.color.white));
                group_interest_photography.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.ten_number:
                getSelectedButton();
                setGroup("10");
                boolean_group_interest_lgbt = true;
                //setGroupId
                group_interest_lgbt.setTextColor(getResources().getColor(R.color.white));
                group_interest_lgbt.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.eleven_number:
                getSelectedButton();
                setGroup("11");
                //setGroupId
                boolean_group_interest_relationship = true;
                group_interest_relationship.setTextColor(getResources().getColor(R.color.white));
                group_interest_relationship.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.twelve_number:
                getSelectedButton();
                //setGroupId
                setGroup("12");
                boolean_group_interest_sports = true;
                group_interest_sports.setTextColor(getResources().getColor(R.color.white));
                group_interest_sports.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));

                break;
            case R.id.thirteen_number:

                getSelectedButton();
                boolean_group_interest_funny = true;
                setGroup("13");
                //setGroupId
                group_interest_funny.setTextColor(getResources().getColor(R.color.white));
                group_interest_funny.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.fourteen_number:

                getSelectedButton();
                boolean_group_interest_confessions = true;
                setGroup("14");
                //setGroupId
                group_interest_confessions.setTextColor(getResources().getColor(R.color.white));
                group_interest_confessions.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.eighteen_number:

                getSelectedButton();
                setGroup("17");
                boolean_group_interest_family= true;
                //setGroupId
                group_interest_family.setTextColor(getResources().getColor(R.color.white));
                group_interest_family.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.nineteen_number:

                getSelectedButton();
                boolean_group_interest_work = true;
                setGroup("18");
                //setGroupId
                group_interest_work.setTextColor(getResources().getColor(R.color.white));
                group_interest_work.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.twenty_number:

                getSelectedButton();
                boolean_group_interest_faith = true;
                setGroup("19");
                //setGroupId
                group_interest_faith.setTextColor(getResources().getColor(R.color.white));
                group_interest_faith.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.twentyone_number:

                getSelectedButton();
                setGroup("20");
                boolean_group_interest_food = true;
                //setGroupId
                group_interest_food.setTextColor(getResources().getColor(R.color.white));
                group_interest_food.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.twentytwo:

                getSelectedButton();
                boolean_group_interest_entertainment = true;
                setGroup("21");
                //setGroupId
                group_interest_entertainment.setTextColor(getResources().getColor(R.color.white));
                group_interest_entertainment.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.seventeen_number:

                getSelectedButton();
                boolean_group_interest_sex = true;
                setGroup("16");
                //setGroupId
                group_interest_sex.setTextColor(getResources().getColor(R.color.white));
                group_interest_sex.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));


                break;
            case R.id.three_number:

                getSelectedButton();
                setGroup("22");
                boolean_group_interest_women_issues = true;
                //setGroupId
                group_interest_women_issues.setTextColor(getResources().getColor(R.color.white));
                group_interest_women_issues.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));

                break;

            case R.id.number_eight:

                getSelectedButton();
                setGroup("25");
                boolean_group_interest_science = true;
                //setGroupId
                group_interest_science.setTextColor(getResources().getColor(R.color.white));
                group_interest_science.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));

                break;
            case R.id.twentyfour:

                getSelectedButton();
                setGroup("23");
                boolean_group_interest_health = true;
                //setGroupId
                group_interest_health.setTextColor(getResources().getColor(R.color.white));
                group_interest_health.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));

                break;
            case R.id.twentyfive:

                getSelectedButton();
                setGroup("24");
                boolean_group_interest_men_issues = true;
                //setGroupId
                group_interest_men_issues.setTextColor(getResources().getColor(R.color.white));
                group_interest_men_issues.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));

                break;
            case R.id.twentysix:

                getSelectedButton();
                setGroup("26");
                boolean_group_interest_teen = true;
                //setGroupId
                group_interest_teen.setTextColor(getResources().getColor(R.color.white));
                group_interest_teen.setBackground(getResources().getDrawable(R.drawable.button_tag_selected));

                break;


        }
    }

    private void setGroup(String selectedGroup){
        this.selectedGroup = selectedGroup;
    }



    private void getSelectedButton(){
        if (boolean_group_interest_politics){
            boolean_group_interest_politics = false;
            group_interest_politics.setTextColor(getResources().getColor(R.color.black));
            group_interest_politics.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_celebrities){
            boolean_group_interest_celebrities = false;
            group_interest_celebrities.setTextColor(getResources().getColor(R.color.black));
            group_interest_celebrities.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_music){
            boolean_group_interest_music = false;
            group_interest_music.setTextColor(getResources().getColor(R.color.black));
            group_interest_music.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_technology){
            boolean_group_interest_technology = false;
            group_interest_technology.setTextColor(getResources().getColor(R.color.black));
            group_interest_technology.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_fashion){
            boolean_group_interest_fashion = false;
            group_interest_fashion.setTextColor(getResources().getColor(R.color.black));
            group_interest_fashion.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_business){

            boolean_group_interest_business = false;
            group_interest_business.setTextColor(getResources().getColor(R.color.black));
            group_interest_business.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_school){
            boolean_group_interest_school = false;
            group_interest_school.setTextColor(getResources().getColor(R.color.black));
            group_interest_school.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_art){
            boolean_group_interest_art = false;
            group_interest_art.setTextColor(getResources().getColor(R.color.black));
            group_interest_art.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_photography){
            boolean_group_interest_photography = false;
            group_interest_photography.setTextColor(getResources().getColor(R.color.black));
            group_interest_photography.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_lgbt){
            boolean_group_interest_lgbt = false;
            group_interest_lgbt.setTextColor(getResources().getColor(R.color.black));
            group_interest_lgbt.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_relationship){
            boolean_group_interest_relationship = false;
            group_interest_relationship.setTextColor(getResources().getColor(R.color.black));
            group_interest_relationship.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_sports){
            boolean_group_interest_sports = false;
            group_interest_sports.setTextColor(getResources().getColor(R.color.black));
            group_interest_sports.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_funny){
            boolean_group_interest_funny = false;
            group_interest_funny.setTextColor(getResources().getColor(R.color.black));
            group_interest_funny.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_confessions){
            boolean_group_interest_confessions = false;
            group_interest_confessions.setTextColor(getResources().getColor(R.color.black));
            group_interest_confessions.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_family){
            boolean_group_interest_family = false;
            group_interest_family.setTextColor(getResources().getColor(R.color.black));
            group_interest_family.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_work){
            boolean_group_interest_work = false;
            group_interest_work.setTextColor(getResources().getColor(R.color.black));
            group_interest_work.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_faith){
            boolean_group_interest_faith = false;
            group_interest_faith.setTextColor(getResources().getColor(R.color.black));
            group_interest_faith.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_food){
            boolean_group_interest_food=  false;
            group_interest_food.setTextColor(getResources().getColor(R.color.black));
            group_interest_food.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_entertainment){
            boolean_group_interest_entertainment = false;
            group_interest_entertainment.setTextColor(getResources().getColor(R.color.black));
            group_interest_entertainment.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_personal){
            boolean_group_interest_personal = false;
            group_interest_personal.setTextColor(getResources().getColor(R.color.black));
            group_interest_personal.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_women_issues){
            boolean_group_interest_women_issues = false;
            group_interest_women_issues.setTextColor(getResources().getColor(R.color.black));
            group_interest_women_issues.setBackground(getResources().getDrawable(R.drawable.button_tag));
        } else if (boolean_group_interest_sex){
            boolean_group_interest_sex= false;
            group_interest_sex.setTextColor(getResources().getColor(R.color.black));
            group_interest_sex.setBackground(getResources().getDrawable(R.drawable.button_tag));

        }else if (boolean_group_interest_science){
            boolean_group_interest_science= false;
            group_interest_science.setTextColor(getResources().getColor(R.color.black));
            group_interest_science.setBackground(getResources().getDrawable(R.drawable.button_tag));
        }else if (boolean_group_interest_health){
            boolean_group_interest_health= false;
            group_interest_health.setTextColor(getResources().getColor(R.color.black));
            group_interest_health.setBackground(getResources().getDrawable(R.drawable.button_tag));
        }else if (boolean_group_interest_men_issues){
            boolean_group_interest_men_issues= false;
            group_interest_men_issues.setTextColor(getResources().getColor(R.color.black));
            group_interest_men_issues.setBackground(getResources().getDrawable(R.drawable.button_tag));
        }else if (boolean_group_interest_teen){
            boolean_group_interest_teen= false;
            group_interest_teen.setTextColor(getResources().getColor(R.color.black));
            group_interest_teen.setBackground(getResources().getDrawable(R.drawable.button_tag));
        }
    }
}
