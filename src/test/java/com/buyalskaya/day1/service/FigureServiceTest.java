package com.buyalskaya.day1.service;

import com.buyalskaya.day1.entity.Point;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FigureServiceTest {
    FigureService figureService = new FigureService();

    @Test
    public void testAreaSquareInscribedInCirclePositive() {
        double actual = figureService.areaSquareInscribedInCircle(25);
        double expected = 25.0 / 2.0;
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void testAreaSquareInscribedInCircleNegative() {
        figureService.areaSquareInscribedInCircle(1601);
    }

    @Test
    public void testDistanceBetweenPointsPositive() {
        Point point1 = new Point(1, -1);
        Point point2 = new Point(1, 1);
        double actual = figureService.distanceBetweenPoints(point1, point2);
        double expected = 2.0;
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void testDistanceBetweenPointsNegative() {
        Point point1 = new Point(1, -1);
        Point point2 = new Point(1, -20.1);
        figureService.distanceBetweenPoints(point1, point2);
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
        int actual = figureService.pointNearestToCenter(point1, point2);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testAreaCirclePositive() {
        double radius = 5;
        double actual = figureService.areaCircle(radius);
        double expected = Math.PI * Math.pow(radius, 2);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void testAreaCircleNegative() {
        figureService.areaCircle(25);
    }

    @Test
    public void testCircumferencePositive() {
        double radius = 5;
        double actual = figureService.circumference(radius);
        double expected = 2 * Math.PI * radius;
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void testCircumferenceNegative() {
        figureService.areaCircle(-1);
    }
}
