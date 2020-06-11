package com.buyalskaya.day1.service;

import com.buyalskaya.day1.entity.Point;
import com.buyalskaya.day1.exception.InputDataFormatException;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;
import static java.lang.Math.*;

public class FunctionServiceTest {
    FunctionService functionService = new FunctionService();

    @Test
    public void testCustomFunction1GreaterThree() {
        try {
            double actual = functionService.customFunction1(3);
            double expected = 9;
            assertEquals(actual, expected);
        } catch (InputDataFormatException ex) {
            fail();
        }
    }

    @Test
    public void testCustomFunction1LessThree() {
        try {
            double actual = functionService.customFunction1(0);
            double expected = -1.0 / 6.0;
            assertEquals(actual, expected);
        } catch (InputDataFormatException ex) {
            fail();
        }
    }

    @Test(expectedExceptions = InputDataFormatException.class,
            expectedExceptionsMessageRegExp = "Division by zero")
    public void testCustomFunction1DivisionByZero() throws InputDataFormatException {
        double argument = cbrt(6);
        double actual = functionService.customFunction1(argument);
    }

    @Test
    public void testCalculateFunctionTablePositive() {
        double startSegment = toRadians(-80);
        double endSegment = toRadians(80);
        double step = toRadians(20);
        int size = (int) ((endSegment - startSegment) / step);
        Point point;
        double argument = startSegment;
        List<Point> expected = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            point = new Point(argument, tan(argument));
            expected.add(point);
            argument = argument + step;
        }
        try {
            List<Point> actual = functionService.calculateFunctionTable(startSegment, endSegment, step);
            assertEquals(actual, expected);
        } catch (InputDataFormatException ex) {
            fail();
        }
    }

    @Test(expectedExceptions = InputDataFormatException.class)
    public void testCalculateFunctionTableNegative() throws InputDataFormatException {
        double startSegment = toRadians(80);
        double endSegment = toRadians(-80);
        double step = toRadians(20);
        functionService.calculateFunctionTable(startSegment, endSegment, step);
    }
}
