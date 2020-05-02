package com.epam.util;

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
        return pattern.matcher(email).find();
    }

    /**
     * Method compares name and surname to regex
     *
     * @param name
     * @param surname
     * @return boolean result of comparing
     */
    public static boolean checkName(String name, String surname) {
        Pattern pattern = Pattern.compile("^[A-Z]([a-z]+)$");
        return pattern.matcher(name).find() && pattern.matcher(surname).find();
    }

    /**
     * Method compares password to regex
     *
     * @param password
     * @return boolean result of comparing
     */
    public static boolean checkPassword(String password) {
        Pattern pattern = Pattern.compile("^(.+)$");
        return pattern.matcher(password).find();
    }

}