package com.buyalskaya.day1.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FractionValidatorTest {
    FractionValidator fractionValidator = new FractionValidator();

    @Test
    public void testValidateFractionStringPositive() {
        boolean actual = fractionValidator.validateFraction("15.5");
        assertTrue(actual);
    }

    @Test
    public void testValidateFractionStringExpPositive() {
        boolean actual = fractionValidator.validateFraction("1E-5");
        assertTrue(actual);
    }

    @Test
    public void testValidateFractionStringNegative() {
        boolean actual = fractionValidator.validateFraction("point");
        assertFalse(actual);
    }

    @Test
    public void testValidateFractionStringNull() {
        boolean actual = fractionValidator.validateFraction((String) null);
        assertFalse(actual);
    }

    @Test
    public void testValidateFractionIntegerPositive() {
        boolean actual = fractionValidator.validateFraction(25.7);
        assertTrue(actual);
    }

    @Test
    public void testValidateNumberIntegerNegative() {
        boolean actual = fractionValidator.validateFraction(75000);
        assertFalse(actual);
    }
}
