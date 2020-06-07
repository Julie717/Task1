package com.buyalskaya.day1.parser;

import com.buyalskaya.day1.entity.DateYearMonth;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DateParserTest {
    DateParser dateParser = new DateParser();

    @Test
    public void testDateParserPositive() {
        DateYearMonth actual = dateParser.dateParser("01/01/2020");
        DateYearMonth expected = new DateYearMonth(2020, 1);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void testDateParserNegative() {
        dateParser.dateParser("01/13/2020");
    }
}
