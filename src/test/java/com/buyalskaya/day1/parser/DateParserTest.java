package com.buyalskaya.day1.parser;

import com.buyalskaya.day1.entity.DateYearMonth;
import com.buyalskaya.day1.exception.InputDataFormatException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DateParserTest {
    public static final String EXCEPTION_MESSAGE = "Data format is incorrect";
    DateParser dateParser;

    @BeforeClass
    public void setUp() {
        dateParser = new DateParser();
    }

    @Test
    public void testDateParserPositive() {
        try {
            DateYearMonth actual = dateParser.dateParser("01/01/2020");
            DateYearMonth expected = new DateYearMonth(2020, 1);
            assertEquals(actual, expected);
        } catch (InputDataFormatException ex) {
            fail(EXCEPTION_MESSAGE);
        }
    }

    @Test(expectedExceptions = InputDataFormatException.class)
    public void testDateParserNegative() throws InputDataFormatException {
        dateParser.dateParser("01/13/2020");
    }

    @Test
    public void testDateParserException() {
        assertThrows(InputDataFormatException.class, () -> dateParser.dateParser("01/2/-2020"));
    }
}
