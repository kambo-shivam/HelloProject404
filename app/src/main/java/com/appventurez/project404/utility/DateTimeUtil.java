package com.appventurez.project404.utility;

import com.appventurez.project404.utility.constant.AppConstants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateTimeUtil {

    private static final int SECOND_MILLIS = 1000;
    private static final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
    private static final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
    private static final int DAY_MILLIS = 24 * HOUR_MILLIS;

    public static String parseDateUtc(String date, String sourceFormat, String targetFormat) {
        try {
            if (date != null && !date.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat(sourceFormat, Locale.ENGLISH);
                Date strDate = sdf.parse(date);
                SimpleDateFormat sdf2 = new SimpleDateFormat(targetFormat.trim(), Locale.ENGLISH);
                sdf2.setTimeZone(TimeZone.getDefault());
                // return DateUtils.getRelativeTimeSpanString(strDate.getTime()).toString();
                return sdf2.format(strDate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String parse24HoursTo12Hour(String time) {
        try {
            if (time != null && !time.isEmpty()) {

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                SimpleDateFormat amPmFormat = new SimpleDateFormat("hh:mm aa");
                Date strDate = simpleDateFormat.parse(time);
                return amPmFormat.format(strDate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String parse12HoursTo24Hour(String time) {
        try {
            if (time != null && !time.isEmpty()) {

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm aa");
                SimpleDateFormat amPmFormat = new SimpleDateFormat("HH:mm:ss");
                Date strDate = simpleDateFormat.parse(time);
                return amPmFormat.format(strDate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }


    public static String getChangeDate(String currentdate, boolean isPrevious) {


        SimpleDateFormat sdf = new SimpleDateFormat(AppConstants.APP_DATE_TIME_FORMAT_1);
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(currentdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        System.out.println("Current time => " + c.getTime());

        if (isPrevious)
            c.add(Calendar.DATE, -1);
        else
            c.add(Calendar.DATE, 1);

        Date resultdate = new Date(c.getTimeInMillis());

        String dateInString = sdf.format(resultdate);

        System.out.println("String date:" + dateInString);

        return dateInString;


    }

    public static String getCureentdate(String currentdateFormat) {

        String dateInString = new SimpleDateFormat(currentdateFormat).format(new Date());
        System.out.println("String date:" + dateInString);
        return dateInString;
    }

    public static String getNextDayDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();

        SimpleDateFormat dateFormat = new SimpleDateFormat(AppConstants.APP_DATE_TIME_YYYYMMDD);
        String tomorrowAsString = dateFormat.format(tomorrow);

        System.out.println(tomorrowAsString);
        return tomorrowAsString;
    }


    public static boolean isCureentDate(String givenDate) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(AppConstants.APP_DATE_TIME_ddMMYY);

            System.out.println("givenDate====>" + givenDate);

            Date date1 = formatter.parse(givenDate);

            String currDtate = formatter.format(new Date());
            Date date2 = formatter.parse(currDtate);

            if (date1.compareTo(date2) == 0) {
                System.out.println(currDtate + "===>Equals");
                return true;
            } else {
                System.out.println(currDtate + "===>NotEqals");
            }

        } catch (ParseException e1) {
            e1.printStackTrace();
        }

        return false;
    }


    public static boolean isBeforeDate(String givenDate) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(AppConstants.APP_DATE_TIME_ddMMYY);

            System.out.println("givenDate====>" + givenDate);

            Date date1 = formatter.parse(givenDate);

            String currDtate = formatter.format(new Date());
            Date date2 = formatter.parse(currDtate);

            if (date1.compareTo(date2) < 0) {
                System.out.println(currDtate + "===>Before");
                return true;
            }/*else if(date1.compareTo(date2) == 0){
                return true;
            }*/ else {
                System.out.println(currDtate + "===>NotEqals");
            }

        } catch (ParseException e1) {
            e1.printStackTrace();
        }

        return false;
    }


}
