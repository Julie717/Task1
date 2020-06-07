package com.buyalskaya.day1.service;

import com.buyalskaya.day1.entity.Time;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeServiceTest {
    TimeService timeService = new TimeService();

    @Test
    public void testCalculateTimePositive() {
        Time actual = timeService.calculateTime(3675);
        Time expected = new Time(1, 1, 15);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = NumberFormatException.class,
            expectedExceptionsMessageRegExp = "This time is incorrect")
    public void testCalculateTimeException() {
        timeService.calculateTime(-5);
    }

}
