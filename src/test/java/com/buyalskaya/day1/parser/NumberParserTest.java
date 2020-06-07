package com.buyalskaya.day1.parser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NumberParserTest {
    NumberParser numberParser = new NumberParser();

    @Test
    public void testIntegerParserPositive() {
        int actual = numberParser.integerParser("15");
        int expected = 15;
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void testIntegerParserNegative() {
        numberParser.integerParser("-1.5");
    }

    @Test
    public void testArrayIntegerParserPositive() {
        String[] arrayInteger = {"12", "1", "-1", "0"};
        int[] actual = numberParser.arrayIntegerParser(arrayInteger);
        int[] expected = {12, 1, -1, 0};
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void testArrayIntegerParserNegative() {
        String[] arrayInteger = {"1.2", "1", "-1", "0"};
        numberParser.arrayIntegerParser(arrayInteger);
    }

    @DataProvider(name = "dataForDoubleParser")
    public Object[][] dataForDoubleParser() {
        return new Object[][]{
                {"1.5", 1.5},
                {"1E-5", 1E-5},
                {"-17.8", -17.8}
        };
    }

    @Test(dataProvider = "dataForDoubleParser")
    public void testParamsDate(String number, double numberDouble) {
        double actual = numberParser.doubleParser(number);
        Assert.assertEquals(actual, numberDouble);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void testDoubleParserNegative() {
        numberParser.doubleParser("1.5.1");
    }
}
