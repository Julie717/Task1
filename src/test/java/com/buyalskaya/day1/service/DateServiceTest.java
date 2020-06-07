package com.buyalskaya.day1.service;

import com.buyalskaya.day1.entity.DateYearMonth;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DateServiceTest {
    DateService dateService = new DateService();

    @DataProvider(name = "dataForDateService")
    public Object[][] dataForDateService() {
        DateYearMonth dateYearMonth1 = new DateYearMonth(2020, 2);
        DateYearMonth dateYearMonth2 = new DateYearMonth(2100, 2);
        DateYearMonth dateYearMonth3 = new DateYearMonth(2018, 4);

        return new Object[][]{
                {dateYearMonth1, 29},
                {dateYearMonth2, 28},
                {dateYearMonth3, 30}
        };
    }

    @Test(dataProvider = "dataForDateService")
    public void testParamsDateService(DateYearMonth dateYearMonth, int expected) {
        int actual = dateService.amountOfDaysInMonth(dateYearMonth);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void testDateServiceNegative() {
        DateYearMonth dateYearMonth = new DateYearMonth(1910, 13);
        dateService.amountOfDaysInMonth(dateYearMonth);
    }
}
