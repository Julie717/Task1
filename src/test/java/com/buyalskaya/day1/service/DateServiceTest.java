package com.buyalskaya.day1.service;

import com.buyalskaya.day1.entity.DateYearMonth;
import com.buyalskaya.day1.exception.InputDataFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

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
        try {
            int actual = dateService.amountOfDaysInMonth(dateYearMonth);
            assertEquals(actual, expected);
        } catch (
                InputDataFormatException ex) {
            fail();
        }
    }

    @Test(expectedExceptions = InputDataFormatException.class)
    public void testDateServiceNegative() throws InputDataFormatException {
        DateYearMonth dateYearMonth = new DateYearMonth(1910, 13);
        dateService.amountOfDaysInMonth(dateYearMonth);
    }
}
