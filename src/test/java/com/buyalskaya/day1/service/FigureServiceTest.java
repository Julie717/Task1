package com.buyalskaya.day1.service;

import com.buyalskaya.day1.entity.Point;
import com.buyalskaya.day1.exception.InputDataFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FigureServiceTest {
    FigureService figureService = new FigureService();

    @Test
    public void testAreaSquareInscribedInCirclePositive() {
        try {
            double actual = figureService.areaSquareInscribedInCircle(25);
            double expected = 12.5;
            assertEquals(actual, expected);
        } catch (
                InputDataFormatException ex) {
            fail();
        }
    }

    @Test(expectedExceptions = InputDataFormatException.class)
    public void testAreaSquareInscribedInCircleNegative() throws InputDataFormatException {
        figureService.areaSquareInscribedInCircle(1601);
    }

    @Test
    public void testDistanceBetweenPointsPositive() {
        Point point1 = new Point(1, -1);
        Point point2 = new Point(1, 1);
        double actual = figureService.distanceBetweenPoints(point1, point2);
        double expected = 2.0;
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForPointNearestToCenter")
    public Object[][] dataForPointNearestToCenter() {
        Point point1 = new Point(1, -1);
        Point point2 = new Point(1, 1);
        Point point4 = new Point(1, 2);
        Point point5 = new Point(1, -2);
        return new Object[][]{
                {point1, point2, 0},
                {point1, point4, -1},
                {point5, point2, 1}
        };
    }

    @Test(dataProvider = "dataForPointNearestToCenter")
    public void testParamsPointNearestToCenter(Point point1, Point point2, int expected) {
        try {
            int actual = figureService.pointNearestToCenter(point1, point2);
            assertEquals(actual, expected);
        } catch (
                InputDataFormatException ex) {
            fail();
        }
    }

    @Test(expectedExceptions = InputDataFormatException.class)
    public void testPointNearestToCenterNegative() throws InputDataFormatException {
        Point point1 = new Point(1, -1);
        Point point2 = new Point(20.4, 1);
        figureService.pointNearestToCenter(point1, point2);
    }

    @Test
    public void testAreaCirclePositive() {
        try {
            double radius = 5;
            double actual = figureService.areaCircle(radius);
            double expected = 78.5398;
            assertEquals(actual, expected,1E-4);
        } catch (
                InputDataFormatException ex) {
            fail();
        }
    }

    @Test(expectedExceptions = InputDataFormatException.class)
    public void testAreaCircleNegative() throws InputDataFormatException {
        figureService.areaCircle(25);
    }

    @Test
    public void testCircumferencePositive() {
        try {
            double radius = 5;
            double actual = figureService.circumference(radius);
            double expected = 31.4159;
            assertEquals(actual, expected,1E-4);
        } catch (
                InputDataFormatException ex) {
            fail();
        }
    }

    @Test(expectedExceptions = InputDataFormatException.class)
    public void testCircumferenceNegative() throws InputDataFormatException {
        figureService.areaCircle(-1);
    }
}
