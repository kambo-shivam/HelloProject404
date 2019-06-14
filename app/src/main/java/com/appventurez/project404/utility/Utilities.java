package com.appventurez.project404.utility;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.appventurez.project404.utility.constant.AppConstants;
import com.appventurez.project404.utility.session.SessionManager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Omi on 04-02-2018.
 */

public class Utilities {


    /**
     * Method to hide keyboard
     *
     * @param mContext Context of the calling class
     */
    public static void hideKeyboard(Context mContext) {
        try {
            InputMethodManager inputManager = (InputMethodManager) mContext
                    .getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(((Activity) mContext).getCurrentFocus().getWindowToken(), 0);
        } catch (Exception ignored) {
        }
    }
    /**
     * Method to Show keyboard
     *
     * @param mContext Context of the calling class
     */

    public static void showKeyboard(Context mContext) {

        try {
            InputMethodManager imm = (InputMethodManager)mContext
                    . getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);

        } catch (Exception ignored) {
        }
    }

    public static  void hideSoftKeyboardwithEdit(View view, Context mContext) {
        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            try {
                InputMethodManager inputManager = (InputMethodManager) mContext
                        .getSystemService(Activity.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(((Activity) mContext).getCurrentFocus().getWindowToken(), 0);
            } catch (Exception ignored) {
            }

        }

    }

    public static void clearUserDataOnLogout() {
        SessionManager.get().setLoggedIn(false);
        SessionManager.get().clear();
    }

    /**
     * Gets network state.
     *
     * @param context the context
     * @return the network state
     */
    public static boolean getNetworkState(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        @SuppressLint("MissingPermission") NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }

    public static String getUniqueId() {
        return UUID.randomUUID().toString();
    }

    public static boolean isValidList(List list) {
        return list != null && !list.isEmpty();
    }

    public static Map<String, Object> getBeanToMap(Object bean) {
        Map<String, Object> properties = new HashMap<>();
        for (Method method : bean.getClass().getDeclaredMethods()) {
            if (Modifier.isPublic(method.getModifiers())
                    && method.getParameterTypes().length == 0
                    && method.getReturnType() != void.class
                    && method.getName().matches("^(get|is).+")
                    ) {
                String name = method.getName().replaceAll("^(get|is)", "");
                name = Character.toLowerCase(name.charAt(0)) + (name.length() > 1 ? name.substring(1) : "");
                Object value = null;
                try {
                    value = method.invoke(bean);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                if (value != null)
                    properties.put(name, value);
            }
        }
        return properties;
    }

    public static String getShortMonthForInt(int num) {
        String month = "";
        DateFormatSymbols dfs = new DateFormatSymbols(Locale.ENGLISH);
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11) {
            month = months[num];
        }
        return month.substring(0,3).toUpperCase();
    }


    public static JSONArray remove(final int idx, final JSONArray from) {
        final List<JSONObject> objs = asList(from);
        objs.remove(idx);

        final JSONArray ja = new JSONArray();
        for (final JSONObject obj : objs) {
            ja.put(obj);
        }

        return ja;
    }

    public static List<JSONObject> asList(final JSONArray ja) {
        final int len = ja.length();
        final ArrayList<JSONObject> result = new ArrayList<JSONObject>(len);
        for (int i = 0; i < len; i++) {
            final JSONObject obj = ja.optJSONObject(i);
            if (obj != null) {
                result.add(obj);
            }
        }
        return result;
    }



    /**
     * This method is used to hide keyboard on clicking anywhere on the screen.
     *
     * @param view    parent view
     * @param context Context of the current activity.
     */
    public static void hideKeyboardOnClickingScreen(View view, final Context context) {
        //Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideKeyboard(context);
                    hideKeyboard(context, v);
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                hideKeyboardOnClickingScreen(innerView, context);
            }
        }
    }

    /**
     * Method to hide keyboard on view focus
     *
     * @param context    Context of the calling class
     * @param myEditText focussed view
     */
    public static void hideKeyboard(Context context, View myEditText) {
        hideKeyboard(context);
        try {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(myEditText.getWindowToken(), 0);
        } catch (Exception ignored) {
        }
    }

    public static long setDifference(String StartTime, String StartDate, String EndTime, String EndDate)
    {
        StartDate= DateTimeUtil.parseDateUtc(StartDate, AppConstants.SERVER_DATE_FORMAT,AppConstants.APP_DATE_TIME_YYYYMMDD);
        EndDate= DateTimeUtil.parseDateUtc(EndDate,AppConstants.SERVER_DATE_FORMAT,AppConstants.APP_DATE_TIME_YYYYMMDD);
        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        Date date = null;
        Date date1 = null;
        try {
            date = sdf4.parse(StartDate + StartTime);
            date1 = sdf4.parse(EndDate + EndTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String StartformattedTime = sdf4.format(date);
        String EndformattedTime = sdf4.format(date1);
        System.out.println("acddd"+StartformattedTime);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        Date st_Date = null;
        Date etDate = null;
        long milliseconds = 0;
        try {
            st_Date = f.parse(StartformattedTime);
            etDate = f.parse(EndformattedTime);
            //milliseconds = st_Date.getTime();
        } catch (ParseException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }


        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(st_Date);
        cal2.setTime(etDate);

        long starttime=cal1.getTime().getTime();
        long endtime=cal2.getTime().getTime();

        long difference=endtime - starttime;
        return difference;

    }



    public static long setDifferenceTime(String StartTime, String StartDate)
    {
        StartDate= DateTimeUtil.parseDateUtc(StartDate,AppConstants.SERVER_DATE_FORMAT,AppConstants.APP_DATE_TIME_YYYYMMDD);

        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        Date date = null;

        try {
            date = sdf4.parse(StartDate + StartTime);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        String StartformattedTime = sdf4.format(date);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        Date st_Date = null;

        long milliseconds = 0;
        try {
            st_Date = f.parse(StartformattedTime);

            //milliseconds = st_Date.getTime();
        } catch (ParseException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }


        Calendar cal1 = Calendar.getInstance();

        cal1.setTime(st_Date);

        Date todayDate = new Date();
        long starttime=cal1.getTime().getTime();


        long difference=todayDate.getTime() - starttime;
        return difference;

    }



    /*public static int getMargin(String time)
    {
        int value=0;
        List<TimeData> getList=DummyDataGenerator.getDummyData();

        for(int i=0;i<=getList.size();i++)
        {
            if(time.equals(getList.get(i).getTime()))
            {
                return getList.get(i).getValue();
            }
        }


        return value;

    }*/


    public static String removeZero(String str)
    {
        // Count leading zeros
        int i = 0;
        while (str.charAt(i) == '0')
            i++;

        // Convert str into StringBuffer as Strings
        // are immutable.
        StringBuffer sb = new StringBuffer(str);

        // The  StringBuffer replace function removes
        // i characters from given index (0 here)
        sb.replace(0, i, "");

        return sb.toString();  // return in String
    }

}
