package com.appventurez.project404.utility.constant;


import android.os.Environment;

public class AppConstants {

    public static final String APP_NAME = "DrivingSchool";
    public static final String ROOT_DIR = Environment.getExternalStorageDirectory() + "/" + APP_NAME + "/";

    public static final String APP_ID_MOB = "ca-app-pub-5298711864309079~9723789772";


    public static final long SPLASH_DURATION = 5000;
    public static final int ZERO_STATUS_CODE = 0;
    public static final String RESOURCE_ERROR_TYPE = "type must be a resource";
    public static final String RESOURCE_ERROR_PARAMETER = "resource must be parameterized";
    public static final String SCREEN_NAME = "screen_name";
    public static final int MIN_USERNAME_RANGE = 2;
    public static final int MAX_USERNAME_RANGE = 64;
    public static final int MIN_PSWD_LENGTH = 8;


    /*DATE CONSTANTS*/
    public static final String APP_DATE_TIME_FORMAT_1 = "dd MMMM, yyyy (EEEE)";
    public static final String APP_DATE_TIME_FORMAT_2 = "MMMM dd, yyyy (EEEE)";

    public static final String DefaultBlankTimeFormat = "00:00:00";
    public static final String DefaultBlankDateFormat = "0000-00-00";

    public static final String APP_DATE_TIME_YYYYMMDD = "yyyy-MM-dd";

    public static final String APP_DATE_TIME_MMddyyyy = "MM/dd/yyyy";

    public static final String APP_DATE_TIME_ddMMYY = "dd/MM/yyyy";
    public static final String AppDecimalFormator = "%.2f";


    public static final String APP_DATE_TIME_ = "yyyy-MM-dd";//yyyy-MM-dd


    public static final String APP_DATE_TIME_FORMAT_22 = "MMMM yyyy";
    public static final String APP_DATE_TIME_FORMAT_4 = "hh:mm a";
    public static final String APP_DATE_TIME_FORMAT_5 = "dd/MM/yyyy";

    public static final String APP_DATE_TIME_FORMAT_6 = "MMM dd yyyy";
    public static final String APP_DATE_TIME_FORMAT_7 = "MMM";
    public static final String APP_DATE_TIME_FORMAT_8 = "dd";
    public static final String APP_DATE_TIME_FORMAT_9 = "yyyy";
    public static final String APP_DATE_TIME_FORMAT_10 = "MMM dd yyyy";
    public static final String DATE_FORMAT_SERVER = "yyyy-MM-dd'T'HH:mm:ss,'Z'";

    public static final String DATE_FORMAT_DST = "dd MMM yyyy hh:mm:ss a";
    public static final String SERVER_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSS"; //2019-05-01T00:00:00.000Z
    public static final String SERVER_DATE_FORMAT1 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String SERVER_DATE_FORMAT2 = "yyyy-MM-dd";
    public static final String ADDTOBACKSTACK = "addtobackstack";

    public static final String FCM_DEVICE_TOKEN = "deviceToken";

    public static final String LessionNum = "lessionNum";


    public static final String LISTCHECK = "list_";
    public static final String LIST_POS = "ListPos";
    public static final String ScheduledDate = "ScheduledDate";

    public static final String APP_ID = "app_id";

    public static final String APP_DIALOG_ID = "app_d";

    public static final String ISREMEMBER = "is_rem";

    public static final String USER_ID = "user_id";

    public static final String PASSWORD = "password";

    public static final String SCHOOL_NAME = "SchoolName";

    public static final String SCHOOL_ID = "SchoolId";

    public static final String OFFICE_NAME = "OfficeName";

    public static final String OFFICE_ID = "OfficeId";
    public static final String BASE_URL = "";

    public static boolean IS_UPDATE = false;

    public static boolean IS_PAYINSTALLMENT = false;


}
