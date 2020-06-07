package com.buyalskaya.day1.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FractionValidatorTest {
    FractionValidator fractionValidator = new FractionValidator();

    @Test
    public void testValidateFractionStringPositive() {
        boolean actual = fractionValidator.validateFraction("15.5");
        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateFractionStringExpPositive() {
        boolean actual = fractionValidator.validateFraction("1E-5");
        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateFractionStringNegative() {
        boolean actual = fractionValidator.validateFraction("point");
        Assert.assertFalse(actual);
    }

    @Test
    public void testValidateFractionStringNull() {
        boolean actual = fractionValidator.validateFraction((String) null);
        Assert.assertFalse(actual);
    }

    @Test
    public void testValidateFractionIntegerPositive() {
        boolean actual = fractionValidator.validateFraction(25.7);
        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateNumberIntegerNegative() {
        boolean actual = fractionValidator.validateFraction(75000);
        Assert.assertFalse(actual);
    }
}
