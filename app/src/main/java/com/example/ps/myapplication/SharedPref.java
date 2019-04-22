package com.example.ps.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by LWQ on 2019-04-22.
 */
public class SharedPref {
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    static final String SP_NAME = "ps_xx";

    private static SharedPref instance;

    private SharedPref(Context context) {
        sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    private SharedPref getInstance(Context context) {

        if (instance == null) {
            instance = new SharedPref(context.getApplicationContext());
        }
        return instance;
    }


    public void putString(String key, String value) {
        editor.putString(key, value);
        editor.apply();

    }

    public String getString(String key, String defValue) {
        return sharedPreferences.getString(key, defValue);
    }

    public void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.apply();

    }

    public int getInt(String key, int defValue) {
        return sharedPreferences.getInt(key, defValue);
    }

    public void putLong(String key, long value) {
        editor.putLong(key, value);
        editor.apply();
    }

    public long getLong(String key, long defValue) {
        return sharedPreferences.getLong(key, defValue);
    }

    public void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBoolean(String key, boolean defValue) {
        return sharedPreferences.getBoolean(key, defValue);
    }

    public void clear() {
        editor.clear().apply();
    }


    public void remove(String key) {
        editor.remove(key);
        editor.apply();
    }

}
