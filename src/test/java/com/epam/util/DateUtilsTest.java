package com.epam.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateUtilsTest {

    @Test()
    public void compareDateAndTimeFailTest() {
        assertThrows(DateTimeParseException.class, ()->
                DateUtils.compareDateAndTime(null, null));
    }
}
