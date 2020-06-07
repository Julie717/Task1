package com.buyalskaya.day1.validator;

import com.buyalskaya.day1.entity.DateYearMonth;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DateValidatorTest {
    DateValidator dateValidator = new DateValidator();

    @DataProvider(name = "dataForDate")
    public Object[][] dataForDate() {
        return new Object[][]{
                {"01.01.2020", true},
                {"1.1.2020", true},
                {"08/07/2020", true},
                {"8/7/2020", true},
                {"32.02.2020", false},
                {"18.13.2020", false},
                {"45/7/1987", false},
                {"15/17/1987", false},
                {"01/01/-987", false},
        };
    }

    @Test(dataProvider = "dataForDate")
    public void testParamsDate(String date, boolean expected) {
        boolean actual = dateValidator.validateStringDate(date);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testValidateDatePositive() {
        DateYearMonth dateYearMonth = new DateYearMonth(2002, 8);
        boolean actual = dateValidator.validateYearMonth(dateYearMonth);
        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateDateIntegerNegative() {
        DateYearMonth dateYearMonth = new DateYearMonth(2002, 13);
        boolean actual = dateValidator.validateYearMonth(dateYearMonth);
        Assert.assertFalse(actual);
    }
}
