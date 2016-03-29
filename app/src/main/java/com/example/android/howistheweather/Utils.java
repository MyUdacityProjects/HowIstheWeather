package com.example.android.howistheweather;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;

public class Utils {

    private static SharedPreferences getSharedPreference(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static String getPincode(Context context) {
        SharedPreferences sharedPreferences = getSharedPreference(context);
        String defaultPincode = context.getResources().getString(R.string.pref_loc_default);
        return sharedPreferences.getString(context.getString(R.string.pref_loc_key), defaultPincode);
    }

    public static String getUnits(Context context) {
        SharedPreferences sharedPreferences = getSharedPreference(context);
        String defaultUnit = context.getResources().getString(R.string.pref_unit_default);
        return sharedPreferences.getString(context.getString(R.string.pref_unit_key), defaultUnit);
    }

    public static Uri getGeoLocation(Context context) {
        return Uri.parse("geo:0,0?q=" + getPincode(context));
    }
}
