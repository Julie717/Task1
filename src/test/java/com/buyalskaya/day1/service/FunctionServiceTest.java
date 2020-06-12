package com.buyalskaya.day1.service;

import com.buyalskaya.day1.entity.Point;
import com.buyalskaya.day1.exception.InputDataFormatException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;
import static java.lang.Math.*;

public class FunctionServiceTest {
    public static final String EXCEPTION_MESSAGE = "Data format is incorrect";
    FunctionService functionService;

    @BeforeClass
    public void setUp() {
        functionService = new FunctionService();
    }

    @Test
    public void testCustomFunction1GreaterThree() {
        try {
            double argument = 3;
            double actual = functionService.customFunction1(argument);
            double expected = 9;
            assertEquals(actual, expected);
        } catch (InputDataFormatException ex) {
            fail(EXCEPTION_MESSAGE);
        }
    }

    @Test
    public void testCustomFunction1LessThree() {
        try {
            double actual = functionService.customFunction1(0);
            double expected = -0.1667;
            assertEquals(actual, expected, 1E-4);
        } catch (InputDataFormatException ex) {
            fail(EXCEPTION_MESSAGE);
        }
    }

    @Test(expectedExceptions = InputDataFormatException.class,
            expectedExceptionsMessageRegExp = "Division by zero")
    public void testCustomFunction1DivisionByZero() throws InputDataFormatException {
        double argument = cbrt(6);
        functionService.customFunction1(argument);
    }

    @DataProvider(name = "dataForFunctionTable")
    public Object[][] dataForFunctionTable() {
        double startSegment = toRadians(-80);
        double endSegment = toRadians(80);
        double step = toRadians(20);
        int amountOfPoints = 9;
        double[][] expectedTable = {{-1.3963, -5.6713},
                {-1.0472, -1.7321},
                {-0.6981, -0.8391},
                {-0.3491, -0.364},
                {0.0, 0.0},
                {0.3491, 0.364},
                {0.6981, 0.8391},
                {1.0472, 1.7321},
                {1.3963, 5.6713}};
        Object[][] pointsActualExpected = new Point[amountOfPoints][2];
        try {
            List<Point> actualTable = functionService.calculateFunctionTable(startSegment, endSegment, step);
            for (int i = 0; i < amountOfPoints; i++) {
                pointsActualExpected[i][0] = actualTable.get(i);
                pointsActualExpected[i][1] = new Point(expectedTable[i][0], expectedTable[i][1]);
            }
        } catch (InputDataFormatException ex) {
            fail(EXCEPTION_MESSAGE);
        }
        return pointsActualExpected;
    }

    @Test(dataProvider = "dataForFunctionTable")
    public void testParamsFunctionTableX(Point actual, Point expected) {
        assertEquals(actual.getX(), expected.getX(), 1E-4);
    }

    @Test(dataProvider = "dataForFunctionTable")
    public void testParamsFunctionTableY(Point actual, Point expected) {
        assertEquals(actual.getY(), expected.getY(), 1E-4);
    }

    @Test(expectedExceptions = InputDataFormatException.class)
    public void testCalculateFunctionTableNegative() throws InputDataFormatException {
        double startSegment = toRadians(80);
        double endSegment = toRadians(-80);
        double step = toRadians(20);
        functionService.calculateFunctionTable(startSegment, endSegment, step);
    }
}
