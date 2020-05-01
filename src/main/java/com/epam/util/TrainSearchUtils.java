package com.epam.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainSearchUtils {
    /**
     * Method compares input route to regex
     *
     * @param from
     * @param to
     * @return boolean result of comparing
     */
    public static boolean checkRoute(String from, String to) {
        Pattern pattern = Pattern.compile("^([A-Za-z]+)$");
        return pattern.matcher(from).find() && pattern.matcher(to).find();
    }
}
