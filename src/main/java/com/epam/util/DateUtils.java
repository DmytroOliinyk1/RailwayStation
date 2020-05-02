package com.epam.util;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import com.epam.controller.user.LoginServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);

    /**
     * Method adds one month to current date
     *
     * @return object of type Date
     */
    public static Date currentDatePlusMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, 1);
        Date date = new Date();
        date.setTime(calendar.getTimeInMillis());
        LOGGER.info("Added one month to current date");
        return date;
    }

    /**
     * Method subtracts one day from current date
     *
     * @return object of type Date
     */
    public static Date currentDateMinusDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -1);
        Date date = new Date();
        date.setTime(calendar.getTimeInMillis());
        LOGGER.info("Subtract one day from current date");
        return date;
    }

    /**
     * Method compares input date and time to current date and time
     *
     * @param comparingDate
     * @param time
     * @return boolean result of comparing
     */
    public static boolean compareDateAndTime(java.sql.Date comparingDate, Time time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentTime = sdf.format(new Date());
        try {
            return LocalTime.now().isAfter(LocalTime.parse(String.valueOf(time))) &&
                    comparingDate.compareTo(sdf.parse(currentTime)) == 0;
        } catch (ParseException e) {
            LOGGER.error("ParseException: "+ e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
