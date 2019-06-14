package com.appventurez.project404.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import java.util.Locale;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static void setLocaleFa (Context context){
        Locale locale = new Locale("ar");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getApplicationContext().getResources().updateConfiguration(config, null);
    }

    public static void setLocaleEn (Context context){
        Locale locale = new Locale("hi");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getApplicationContext().getResources().updateConfiguration(config, null);
    }

}