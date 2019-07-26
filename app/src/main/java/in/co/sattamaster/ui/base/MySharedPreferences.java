package in.co.sattamaster.ui.base;

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

    public static String getUserId(SharedPreferences sharedPreferences) {
        return MySharedPreferences.getValueFromSharedPreferences(sharedPreferences, AMAZON_USER_ID);
    }

}
