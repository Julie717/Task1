package com.buyalskaya.day1.parser;

import com.buyalskaya.day1.exception.InputDataFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumberParserTest {
    NumberParser numberParser = new NumberParser();

    @Test
    public void testIntegerParserPositive() {
        try {
            int actual = numberParser.integerParser("15");
            int expected = 15;
            assertEquals(actual, expected);
        } catch (
                InputDataFormatException ex) {
            fail();
        }
    }

    @Test(expectedExceptions = InputDataFormatException.class)
    public void testIntegerParserNegative() throws InputDataFormatException {
        numberParser.integerParser("-1.5");
    }

    @Test
    public void testArrayIntegerParserPositive() {
        try {
            String[] arrayInteger = {"12", "1", "-1", "0"};
            int[] actual = numberParser.arrayIntegerParser(arrayInteger);
            int[] expected = {12, 1, -1, 0};
            assertEquals(actual, expected);
        } catch (
                InputDataFormatException ex) {
            fail();
        }
    }

    @Test(expectedExceptions = InputDataFormatException.class)
    public void testArrayIntegerParserNegative() throws InputDataFormatException {
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
        try {
            double actual = numberParser.doubleParser(number);
            assertEquals(actual, numberDouble);
        } catch (
                InputDataFormatException ex) {
            fail();
        }
    }

    @Test(expectedExceptions = InputDataFormatException.class)
    public void testDoubleParserNegative() throws InputDataFormatException {
        numberParser.doubleParser("1.5.1");
    }
}
