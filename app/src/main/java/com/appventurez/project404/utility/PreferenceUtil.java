package com.appventurez.project404.utility;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;


public class PreferenceUtil {

    public static final String SHARED_PREF_NAME = "labbik";
    private final SharedPreferences mSpref;


    public PreferenceUtil(Context context) {
        mSpref = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void logoutUser(Context context) {
        SharedPreferences appInstallInfoSharedPref = context.getSharedPreferences(SHARED_PREF_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor appInstallInfoEditor = appInstallInfoSharedPref.edit();
        appInstallInfoEditor.clear();
        appInstallInfoEditor.commit();

//        context.deleteDatabase("webview.db");
//        context.deleteDatabase("webviewCache.db");
//
//        context.getSharedPreferences("com.pinterest.android.pdk.PREF_FILE_KEY", Context.MODE_PRIVATE).edit().clear()
//                .commit();


    }

    public static float getSharedPrefFloat(Context context, String key) {
        SharedPreferences userAcountPreference = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        return userAcountPreference.getFloat(key, 0);
    }

    public int getIntData(String key) {
        return mSpref.getInt(key, 0);
    }

    public void setFloatData(Context context, String key, float value) {
        SharedPreferences.Editor appInstallInfoEditor = mSpref.edit();
        appInstallInfoEditor.putFloat(key, value);
        appInstallInfoEditor.commit();
    }

    public void setIntData(String key, int value) {
        SharedPreferences.Editor appInstallInfoEditor = mSpref.edit();
        appInstallInfoEditor.putInt(key, value);
        appInstallInfoEditor.commit();
    }

    public void setStringData(String key, String value) {
        SharedPreferences.Editor appInstallInfoEditor = mSpref.edit();
        appInstallInfoEditor.putString(key, value);
        appInstallInfoEditor.apply();
    }

    public boolean getBoolean(String key) {
        return mSpref.getBoolean(key, false);
    }

    public String getStringData(String key) {
        return mSpref.getString(key, "");

    }

    public String getStringDataFilterCount(String key) {
        return mSpref.getString(key, "0");

    }
//    public String getTokenStringData(String key) {
//        String refreshedToken =mSpref.getString(key, "");
//        if(refreshedToken==null || refreshedToken.length()==0)
//            refreshedToken= FirebaseInstanceId.getInstance().getToken();
//        return refreshedToken;
//    }

    public void setBooleanData(String key, boolean value) {
        SharedPreferences.Editor appInstallInfoEditor = mSpref.edit();
        appInstallInfoEditor.putBoolean(key, value);
        appInstallInfoEditor.apply();
    }


//    public void saveArrayOfferList(String key,ArrayList<Offer> list){
//        SharedPreferences.Editor editor = mSpref.edit();
//        Gson gson = new Gson();
//        String json = gson.toJson(list);
//        editor.putString(key, json);
//        editor.apply();     // This line is IMPORTANT !!!
//    }
//
//    public ArrayList<Offer> getArrayListOffer(String key){
//        Gson gson = new Gson();
//        String json = mSpref.getString(key, null);
//        Type type = new TypeToken<ArrayList<Offer>>() {}.getType();
//        return gson.fromJson(json, type);
//    }

   // public void saveArrayOfferListResult(String key,ArrayList<ResponseOffer> list){
//        SharedPreferences.Editor editor = mSpref.edit();
//        Gson gson = new Gson();
//        String json = gson.toJson(list);
//        editor.putString(key, json);
//        editor.apply();     // This line is IMPORTANT !!!
//    }
//
//    public ArrayList<ResponseOffer> getArrayListOfferResult(String key){
//        Gson gson = new Gson();
//        String json = mSpref.getString(key, null);
//        Type type = new TypeToken<ArrayList<ResponseOffer>>() {}.getType();
//        return gson.fromJson(json, type);
//    }


    public void clear() {
        mSpref.edit().clear().apply();
    }
}
