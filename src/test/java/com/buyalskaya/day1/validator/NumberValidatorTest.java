package com.buyalskaya.day1.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumberValidatorTest {
    NumberValidator numberValidator = new NumberValidator();

    @Test
    public void testValidateNumberStringPositive() {
        boolean actual = numberValidator.validateNumber("15");
        assertTrue(actual);
    }

    @Test
    public void testValidateNumberStringNegative() {
        boolean actual = numberValidator.validateNumber("one");
        assertFalse(actual);
    }

    @Test
    public void testValidateNumberStringNull() {
        boolean actual = numberValidator.validateNumber((String) null);
        assertFalse(actual);
    }

    @Test
    public void testValidateNumberIntegerPositive() {
        boolean actual = numberValidator.validateNumber(25);
        assertTrue(actual);
    }

    @Test
    public void testValidateNumberIntegerNegative() {
        boolean actual = numberValidator.validateNumber(75000);
        assertFalse(actual);
    }

    @Test
    public void testValidatePositiveNumberPositive() {
        boolean actual = numberValidator.validatePositiveNumber(25);
        assertTrue(actual);
    }

    @Test
    public void testValidatePositiveNumberNegative() {
        boolean actual = numberValidator.validatePositiveNumber(-98);
        assertFalse(actual);
    }

    @Test
    public void testValidateNumberArrayStringPositive() {
        String[] arrayNumber = {"1", "2", "3", "4"};
        boolean actual = numberValidator.validateNumber(arrayNumber);
        assertTrue(actual);
    }

    @Test
    public void testValidateNumberArrayStringNegative() {
        String[] arrayNumber = {"1", "two", "3", "4"};
        boolean actual = numberValidator.validateNumber(arrayNumber);
        assertFalse(actual);
    }

    @Test
    public void testValidateNumberArrayStringNull() {
        String[] arrayNumber = {"1", "2", "3", null};
        boolean actual = numberValidator.validateNumber(arrayNumber);
        assertFalse(actual);
    }

    @Test
    public void testValidateNumberArrayIntegerPositive() {
        int[] arrayNumber = {1, 2, 3, 4};
        boolean actual = numberValidator.validateNumber(arrayNumber);
        assertTrue(actual);
    }

    @Test
    public void testValidateNumberArrayIntegerNegative() {
        int[] arrayNumber = {-75000, 2, 3, 4};
        boolean actual = numberValidator.validateNumber(arrayNumber);
        assertFalse(actual);
    }
}
