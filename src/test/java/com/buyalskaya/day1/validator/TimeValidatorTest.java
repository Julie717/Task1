package com.buyalskaya.day1.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TimeValidatorTest {
    TimeValidator timeValidator = new TimeValidator();

    @Test
    public void testValidateTimeStringPositive() {
        boolean actual = timeValidator.validateSecond("48500");
        assertTrue(actual);
    }

    @Test
    public void testValidateTimeStringNegative() {
        boolean actual = timeValidator.validateSecond("-10");
        assertFalse(actual);
    }

    @Test
    public void testValidateTimeStringNull() {
        boolean actual = timeValidator.validateSecond((String) null);
        assertFalse(actual);
    }

    @Test
    public void testValidateTimeIntegerPositive() {
        boolean actual = timeValidator.validateSecond(875);
        assertTrue(actual);
    }

    @Test
    public void testValidateTimeIntegerNegative() {
        boolean actual = timeValidator.validateSecond(-5);
        assertFalse(actual);
    }
}
