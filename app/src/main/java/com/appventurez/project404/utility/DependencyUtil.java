package com.appventurez.project404.utility;


import com.appventurez.project404.AppExecutors;
import com.appventurez.project404.api.AppRetrofit;
import com.appventurez.project404.api.AppService;
import com.appventurez.project404.app.AppController;
//import com.appventurez.project404.db.AppDb;


public class DependencyUtil {
/*
    private static AppDb sAddDbInstance;
    private static AppService sAppServiceInstance;


    public static AppService getAppService() {
        if (sAppServiceInstance == null) {
            sAppServiceInstance = AppRetrofit.getInstance().getAppService();
        }
        return sAppServiceInstance;
    }


    public static AppDb getAppDb() {
        if (sAddDbInstance == null) {
            sAddDbInstance = Room.databaseBuilder(AppController.getInstance(), AppDb.class, AppDb.DATABASE_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return sAddDbInstance;
    }


    public static AppExecutors getAppExecuter() {
        return new AppExecutors();
    }*/
}
