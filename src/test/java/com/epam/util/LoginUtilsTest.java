package com.epam.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginUtilsTest {
    @Test
    public void checkEmailTest() {
        String email = "example@email.com";
        assertTrue(LoginUtils.checkEmail(email));
    }

    @Test
    public void checkEmailFailTest() {
        String email = "@email.com";
        assertFalse(LoginUtils.checkEmail(email));
    }

    @Test
    public void checkPasswordTest() {
        String password = "1234";
        assertTrue(LoginUtils.checkPassword(password));
    }

    @Test
    public void checkPasswordFailTest() {
        String password = "";
        assertFalse(LoginUtils.checkPassword(password));
    }

    @Test
    public void checkNameTest() {
        String name = "Aa";
        String surname = "Aa";
        assertTrue(LoginUtils.checkName(name, surname));
    }

    @Test
    public void checkNameFailTest() {
        String name = "a1";
        String surname = "a2";
        assertFalse(LoginUtils.checkName(name, surname));
    }
}
