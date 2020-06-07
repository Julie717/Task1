package com.buyalskaya.day1.service;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ArithmeticServiceTest {
    ArithmeticService arithmeticService = new ArithmeticService();

    @Test
    public void testLastDigitOfSquareNumberPositive() {
        int actual = arithmeticService.lastDigitOfSquareNumber(97);
        int expected = 9;
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void testLastDigitOfSquareNumberException() {
        arithmeticService.lastDigitOfSquareNumber(50001);
    }

    @Test
    public void testIsEvenPositive() {
        boolean actual = arithmeticService.isEven(8);
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsEvenNegative() {
        boolean actual = arithmeticService.isEven(97);
        Assert.assertFalse(actual);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void testIsEvenException() {
        arithmeticService.isEven(-50001);
    }

    @Test
    public void testIsEvenTwoNumbersPositive() {
        int[] arrayNumber = {1, 2, 3, 4};
        boolean actual = arithmeticService.isEvenTwoNumbers(arrayNumber);
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsEvenTwoNumbersNegative() {
        int[] arrayNumber = {1, 2, 3, 1};
        boolean actual = arithmeticService.isEvenTwoNumbers(arrayNumber);
        Assert.assertFalse(actual);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void testIsEvenTwoNumbersException() {
        int[] arrayNumber = {1, 50412, 3, 1};
        arithmeticService.isEvenTwoNumbers(arrayNumber);
    }

    @Test
    public void testSumDividesPositive() {
        int actual = arithmeticService.sumDivides(4);
        int expected = 3;
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void testSumDividesException() {
        arithmeticService.sumDivides(0);
    }

    @Test
    public void testIsPerfectNumberPositive() {
        boolean actual = arithmeticService.isPerfectNumber(28);
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsPerfectNumberNegative() {
        boolean actual = arithmeticService.isPerfectNumber(87);
        Assert.assertFalse(actual);
    }

}
