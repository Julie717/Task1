package com.buyalskaya.day1.service;

import com.buyalskaya.day1.entity.Time;
import com.buyalskaya.day1.exception.InputDataFormatException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TimeServiceTest {
    public static final String EXCEPTION_MESSAGE = "Data format is incorrect";
    TimeService timeService;

    @BeforeClass
    public void setUp() {
        timeService = new TimeService();
    }

    @Test
    public void testCalculateTimePositive() {
        try {
            Time actual = timeService.calculateTime(3675);
            Time expected = new Time(1, 1, 15);
            assertEquals(actual, expected);
        } catch (
                InputDataFormatException ex) {
            fail(EXCEPTION_MESSAGE);
        }
    }

    @Test(expectedExceptions = InputDataFormatException.class,
            expectedExceptionsMessageRegExp = "This time is incorrect")
    public void testCalculateTimeException() throws InputDataFormatException {
        timeService.calculateTime(-5);
    }
}
