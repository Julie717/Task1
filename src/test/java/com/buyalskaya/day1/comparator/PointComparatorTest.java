package com.buyalskaya.day1.comparator;

import com.buyalskaya.day1.entity.Point;
import com.buyalskaya.day1.validator.TimeValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PointComparatorTest {
    PointComparator pointComparator;

    @BeforeClass
    public void setUp() {
        pointComparator = new PointComparator();
    }

    @DataProvider(name = "dataForPointComparator")
    public Object[][] dataForPointComparator() {
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

    @Test(dataProvider = "dataForPointComparator")
    public void testParamsPointComparator(Point point1, Point point2, int expected) {
        int actual = pointComparator.compare(point1, point2);
        assertEquals(actual, expected);
    }
}
