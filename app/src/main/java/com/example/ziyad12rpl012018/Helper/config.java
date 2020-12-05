package com.example.ziyad12rpl012018.Helper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.ziyad12rpl012018.LoginActivity;

public class config {
    public static final String BASE_URL = "http://192.168.43.107/rentalsepeda/";
    public static final String TOAST_AN_ERROR = "ERROR GA ADA USER :)";

    private static final String API = "api/";
    public static final String BASE_URL_API = BASE_URL + API;

    public static final String UPLOAD_FOLDER = "uploads/";
    public static final String BASE_URL_UPLOADS = BASE_URL + UPLOAD_FOLDER;
    public static final String FIREBASE_URL = "https://dazzling-torch-6878.firebaseio.com/ABS/";

    public static final String TOAST_AN_EROR = "Mohon maaf, terjadi kendala jaringan / server";

    public static final String SHARED_PREF_NAME = "Rental Sepeda";
    public static final String LOGIN_NAME_SHARED_PREF = "NAME";
    public static final String LOGIN_ID_SHARED_PREF = "ID";
    public static final String LOGIN_ADDRESS_SHARED_PREF = "ADDRESS";
    public static final String LOGIN_CITY_SHARED_PREF = "CITY";
    public static final String LOGIN_ZIP_CODE_SHARED_PREF = "ZIP CODE";
    public static final String LOGIN_TOKEN_SHARED_PREF = "TOKEN";
    public static final String LOGIN_EMAIL_SHARED_PREF = "EMAIL";
    public static final String LOGIN_PHONE_SHARED_PREF = "PHONE";
    public static final String LOGIN_KTP= "KTP";
    public static final String LOGIN_GROUP_NAME_SHARED_PREF = "GROUP";
    public static final String LOGIN_GROUP_ID_SHARED_PREF = "GROUP_ID";
    public static final String LOGIN_STATUS_SHARED_PREF = "loggedin";
    public static final String LOGIN_AVATAR_SHARED_PREF = "AVATAR";
    public static final String LOGIN_EXTRA_01_SHARED_PREF = "EXTRA_01";
    public static final String LOGIN_EXTRA_02_SHARED_PREF = "EXTRA_02";
    public static final String LOGIN_EXTRA_03_SHARED_PREF = "EXTRA_03";
    public static final String LOGIN_EXTRA_04_SHARED_PREF = "EXTRA_04";
    public static final String LOGIN_EXTRA_05_SHARED_PREF = "EXTRA_05";


    public static final String RESPONSE_STATUS_FIELD = "status";
    public static final String RESPONSE_STATUS_VALUE_SUCCESS = "success";
    public static final String RESPONSE_STATUS_VALUE_ERROR = "ERROR";
    public static final String RESPONSE_MESSAGE_FIELD = "message";
    public static final String RESPONSE_PAYLOAD_FIELD = "payload";

    public static final String ERROR_NETWORK = "Periksa kembali jaringan Anda";


    public static final String RESPONSE_PAYLOAD_API_ACTION = "API_ACTION";
    public static final String RESPONSE_PAYLOAD_API_ACTION_LOGOUT = "LOGOUT";

    public static void forceLogout(Context context) {
        //Getting out shared preferences
        SharedPreferences preferences = context.getSharedPreferences(config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        //Getting editor
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(config.LOGIN_STATUS_SHARED_PREF, false);
        editor.putString(config.LOGIN_ID_SHARED_PREF, "");
        editor.putString(config.LOGIN_ADDRESS_SHARED_PREF, "");
        editor.putString(config.LOGIN_CITY_SHARED_PREF, "");
        editor.putString(config.LOGIN_ZIP_CODE_SHARED_PREF, "");
        editor.putString(config.LOGIN_NAME_SHARED_PREF, "");
        editor.putString(config.LOGIN_GROUP_NAME_SHARED_PREF, "");
        editor.putString(config.LOGIN_GROUP_ID_SHARED_PREF, "");
        editor.putString(config.LOGIN_TOKEN_SHARED_PREF, "");
        editor.putString(config.LOGIN_EMAIL_SHARED_PREF, "");
        editor.putString(config.LOGIN_PHONE_SHARED_PREF, "");
        editor.putString(config.LOGIN_AVATAR_SHARED_PREF, "");
        editor.putString(config.LOGIN_EXTRA_01_SHARED_PREF, "");
        editor.putString(config.LOGIN_EXTRA_02_SHARED_PREF, "");
        editor.putString(config.LOGIN_EXTRA_03_SHARED_PREF, "");
        editor.putString(config.LOGIN_EXTRA_04_SHARED_PREF, "");
        editor.putString(config.LOGIN_EXTRA_05_SHARED_PREF, "");

        //Saving the sharedpreferences
        editor.commit();

        Toast.makeText(context, "Anda telah logout dari aplikasi.\nUntuk mengakses beberapa fitur, Anda harus login terlebih dahulu", Toast.LENGTH_LONG).show();
        //Starting login activity
        Intent intent = new Intent(context.getApplicationContext(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
