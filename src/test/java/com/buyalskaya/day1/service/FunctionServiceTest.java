package com.buyalskaya.day1.service;

import com.buyalskaya.day1.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FunctionServiceTest {
    FunctionService functionService = new FunctionService();

    @Test
    public void testSpecialFunction1GreaterThree() {
        double actual = functionService.specialFunction1(3);
        double expected = 9;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSpecialFunction1LessThree() {
        double actual = functionService.specialFunction1(0);
        double expected = -1.0 / 6.0;
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testSpecialFunction1DivisionByZero() {
        double argument = Math.pow(6, 1.0 / 3.0);
        functionService.specialFunction1(argument);
    }

    @Test
    public void testCalculateFunctionTablePositive() {
        double startSegment = Math.toRadians(-80);
        double endSegment = Math.toRadians(80);
        double step = Math.toRadians(20);
        List<Point> actual = functionService.calculateFunctionTable(startSegment, endSegment, step);
        List<Point> expected = new ArrayList<>();
        int size = (int) ((endSegment - startSegment) / step);
        Point point;
        double argument = Math.toRadians(-80);
        for (int i = 0; i < size; i++) {
            point = new Point(argument, Math.tan(argument));
            expected.add(point);
            argument = argument + step;
        }
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void testCalculateFunctionTableNegative() {
        double startSegment = Math.toRadians(80);
        double endSegment = Math.toRadians(-80);
        double step = Math.toRadians(20);
        functionService.calculateFunctionTable(startSegment, endSegment, step);
    }
}
