package com.reliableservices.venderapp.common;

import android.content.Context;
import android.content.SharedPreferences;

public class ShareUtils {

    /* Shared Preference file name*/
    private static final String REPLY_PREF = "USER_PRIF";

    private Context context;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    public ShareUtils(Context context){
        this.context = context;
    }

    /* Save a string into shared preferences */
    public void saveString(String key, String value){
        mSharedPreferences = context.getSharedPreferences(REPLY_PREF, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        mEditor.putString(key, value);
        mEditor.apply();
    }

    /* Save a int inot shared preferences */
    public void saveInt(String key, int value){
        mSharedPreferences = context.getSharedPreferences(REPLY_PREF, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        mEditor.putInt(key, value);
        mEditor.apply();
    }

    /* Get string from preferences*/
    public String getStringData(String key){
        mSharedPreferences = context.getSharedPreferences(REPLY_PREF, Context.MODE_PRIVATE);
        return mSharedPreferences.getString(key, "");
    }

    /* Get integer from preferences */
    public int getIntData(String key){
        mSharedPreferences = context.getSharedPreferences(REPLY_PREF, Context.MODE_PRIVATE);
        return mSharedPreferences.getInt(key, 0);
    }

    /* Clear the shared preferences file*/
    public void clear() {
        mSharedPreferences = context.getSharedPreferences(REPLY_PREF, Context.MODE_PRIVATE);
        mSharedPreferences.edit().clear().apply();

    }

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "welcome";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    public void setFirstTimeLaunch(boolean isFirstTime) {
        pref = context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor = pref.edit();
        editor.putBoolean(IS_FIRST_TIME_LAUNCH,isFirstTime);
        editor.apply();
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        pref = context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
}
