package com.buyalskaya.day1.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeValidatorTest {
    TimeValidator timeValidator = new TimeValidator();

    @Test
    public void testValidateTimeStringPositive() {
        boolean actual = timeValidator.validateSecond("48500");
        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateTimeStringNegative() {
        boolean actual = timeValidator.validateSecond("-10");
        Assert.assertFalse(actual);
    }

    @Test
    public void testValidateTimeStringNull() {
        boolean actual = timeValidator.validateSecond((String) null);
        Assert.assertFalse(actual);
    }

    @Test
    public void testValidateTimeIntegerPositive() {
        boolean actual = timeValidator.validateSecond(875);
        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateTimeIntegerNegative() {
        boolean actual = timeValidator.validateSecond(-5);
        Assert.assertFalse(actual);
    }
}
