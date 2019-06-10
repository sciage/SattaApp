package com.example.sattaapp;

import android.content.SharedPreferences;


/**
 * Created by harish on 1/2/2017.
 */

public class MySharedPreferences {

    private static final String AMAZON_USER_ID = "AMAZON_USER_ID";

    public static void wipe(SharedPreferences sharedPreferences) {
        MySharedPreferences.storeValueInSharedPreferences(sharedPreferences, AMAZON_USER_ID, null);
    }

    protected static void storeValueInSharedPreferences(SharedPreferences sharedPreferences, String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    protected static void storeValueInSharedPreferences2(SharedPreferences sharedPreferences, String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    protected static String getValueFromSharedPreferences(SharedPreferences sharedPreferences, String key) {
        return sharedPreferences.getString(key, null);
    }

    public static void registerUserId(SharedPreferences sharedPreferences, String userId) {
        MySharedPreferences.storeValueInSharedPreferences2(sharedPreferences, AMAZON_USER_ID, userId);
    }

    public static void registerFirebaseToken(SharedPreferences sharedPreferences, String userId) {
        MySharedPreferences.storeValueInSharedPreferences2(sharedPreferences, Constants.FIREBASETOKEN, userId);
    }


    public static void registerFacebook(SharedPreferences sharedPreferences, String userId) {
        MySharedPreferences.storeValueInSharedPreferences2(sharedPreferences, Constants.FACEBOOK_ID, userId);
    }

    public static void registerSecretToken(SharedPreferences sharedPreferences, String secretToken) {
        MySharedPreferences.storeValueInSharedPreferences2(sharedPreferences, Constants.SECRET_TOKEN, secretToken);
    }


    public static void RegisterBelow18(SharedPreferences sharedPreferences, String username) {
        MySharedPreferences.storeValueInSharedPreferences(sharedPreferences, Constants.BELOW18, username);
    }

    public static String getBelow18(SharedPreferences sharedPreferences) {
        return MySharedPreferences.getValueFromSharedPreferences(sharedPreferences, Constants.BELOW18);
    }

    public static String getFireBaseToken(SharedPreferences sharedPreferences) {
        return MySharedPreferences.getValueFromSharedPreferences(sharedPreferences, Constants.FIREBASETOKEN);
    }

    public static String getFacebook(SharedPreferences sharedPreferences) {
        return MySharedPreferences.getValueFromSharedPreferences(sharedPreferences, Constants.FACEBOOK_ID);
    }

    public static String getImageUrl(SharedPreferences sharedPreferences) {
        return MySharedPreferences.getValueFromSharedPreferences(sharedPreferences, Constants.IMAGE_URL);
    }

    public static String getUserId(SharedPreferences sharedPreferences) {
        return MySharedPreferences.getValueFromSharedPreferences(sharedPreferences, AMAZON_USER_ID);
    }

    public static String getSecretToken(SharedPreferences sharedPreferences) {
        return MySharedPreferences.getValueFromSharedPreferences(sharedPreferences, Constants.SECRET_TOKEN);
    }




}
