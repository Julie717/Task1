package com.buyalskaya.day1.service;

import com.buyalskaya.day1.exception.InputDataFormatException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArithmeticServiceTest {
    ArithmeticService arithmeticService = new ArithmeticService();

    @Test
    public void testLastDigitOfSquareNumberPositive() {
        int expected = 9;
        try {
            int actual = arithmeticService.lastDigitOfSquareNumber(97);
            assertEquals(actual, expected);
        } catch (InputDataFormatException ex) {
            fail();
        }
    }

    @Test(expectedExceptions = InputDataFormatException.class)
    public void testLastDigitOfSquareNumberException() throws InputDataFormatException {
        int actual = arithmeticService.lastDigitOfSquareNumber(50001);
    }

    @Test
    public void testIsEvenPositive() {
        try {
            boolean actual = arithmeticService.isEven(8);
            assertTrue(actual);
        } catch (InputDataFormatException ex) {
            fail();
        }
    }

    @Test
    public void testIsEvenNegative() {
        try {
            boolean actual = arithmeticService.isEven(97);
            assertFalse(actual);
        } catch (InputDataFormatException ex) {
            fail();
        }
    }

    @Test(expectedExceptions = InputDataFormatException.class)
    public void testIsEvenException() throws InputDataFormatException {
        boolean actual = arithmeticService.isEven(-50001);
    }

    @Test
    public void testIsEvenTwoNumbersPositive() {
        try {
            int[] arrayNumber = {1, 2, 3, 4};
            boolean actual = arithmeticService.isEvenTwoNumbers(arrayNumber);
            assertTrue(actual);
        } catch (InputDataFormatException ex) {
            fail();
        }
    }

    @Test
    public void testIsEvenTwoNumbersNegative() {
        try {
            int[] arrayNumber = {1, 2, 3, 1};
            boolean actual = arithmeticService.isEvenTwoNumbers(arrayNumber);
            assertFalse(actual);
        } catch (InputDataFormatException ex) {
            fail();
        }
    }

    @Test(expectedExceptions = InputDataFormatException.class)
    public void testIsEvenTwoNumbersException() throws InputDataFormatException {
        int[] arrayNumber = {1, 50412, 3, 1};
        boolean actual = arithmeticService.isEvenTwoNumbers(arrayNumber);
    }

    @Test
    public void testSumDividesPositive() {
        try {
            int actual = arithmeticService.sumDivides(4);
            int expected = 3;
            assertEquals(actual, expected);
        } catch (InputDataFormatException ex) {
            fail();
        }
    }

    @Test(expectedExceptions = InputDataFormatException.class)
    public void testSumDividesException() throws InputDataFormatException {
        int actual = arithmeticService.sumDivides(0);
    }

    @Test
    public void testIsPerfectNumberPositive() {
        try {
            boolean actual = arithmeticService.isPerfectNumber(28);
            assertTrue(actual);
        } catch (InputDataFormatException ex) {
            fail();
        }
    }

    @Test
    public void testIsPerfectNumberNegative() {
        try {
            boolean actual = arithmeticService.isPerfectNumber(87);
            assertFalse(actual);
        } catch (InputDataFormatException ex) {
            fail();
        }
    }
}
