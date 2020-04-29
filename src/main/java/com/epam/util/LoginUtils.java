package com.epam.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginUtils {
    /**
     * Method compares email to regex
     *
     * @param email
     * @return boolean result of comparing
     */
    public static boolean checkEmail(String email) {
        Pattern pattern = Pattern.compile("^(.+)@(.+)\\.(\\w{2,5})$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    /**
     * Method compares name and surname to regex
     *
     * @param name
     * @param surname
     * @return boolean result of comparing
     */
    public static boolean checkName(String name, String surname) {
        Pattern pattern = Pattern.compile("^([A-Za-z]+)$");
        Matcher matcherName = pattern.matcher(name);
        Matcher matcherSurname = pattern.matcher(surname);
        return matcherName.find() && matcherSurname.find();
    }

    /**
     * Method compares password to regex
     *
     * @param password
     * @return boolean result of comparing
     */
    public static boolean checkPassword(String password) {
        Pattern pattern = Pattern.compile("^(.+)$");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

}