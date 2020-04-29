package com.epam.util;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static Date currentDatePlusMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, 1);
        Date date = new Date();
        date.setTime(calendar.getTimeInMillis());
        return date;
    }

    public static Date currentDateMinusDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -1);
        Date date = new Date();
        date.setTime(calendar.getTimeInMillis());
        return date;
    }

    public static boolean compareDateAndTime(java.sql.Date comparingDate, Time time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentTime = sdf.format(new Date());
        try {
            return LocalTime.now().isAfter(LocalTime.parse( String.valueOf(time) )) &&
                    comparingDate.compareTo(sdf.parse(currentTime)) == 0;
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
