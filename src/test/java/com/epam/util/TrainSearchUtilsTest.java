package com.epam.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrainSearchUtilsTest {
    @Test
    public void checkRouteTest() {
        String from = "Kiyv";
        String to = "Sumy";

        assertTrue(TrainSearchUtils.checkRoute(from, to));
    }

    @Test
    public void checkRouteFailTest() {
        String from = "kiyv1";
        String to = "sumy";

        assertFalse(TrainSearchUtils.checkRoute(from, to));
    }
}
