package com.buyalskaya.day1.validator;

import com.buyalskaya.day1.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FigureValidatorTest {
    FigureValidator figureValidator = new FigureValidator();

    @Test
    public void testValidateAreaStringPositive() {
        boolean actual = figureValidator.validateArea("15.7");
        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateAreaStringNegative() {
        boolean actual = figureValidator.validateArea("zero");
        Assert.assertFalse(actual);
    }

    @Test
    public void testValidateAreaStringNull() {
        boolean actual = figureValidator.validateArea(null);
        Assert.assertFalse(actual);
    }

    @Test
    public void testValidateAreaDoublePositive() {
        boolean actual = figureValidator.validateArea(25.7);
        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateAreaDoubleNegative() {
        boolean actual = figureValidator.validateArea(0);
        Assert.assertFalse(actual);
    }

    @Test
    public void testValidatePointPositive() {
        Point point = new Point(1.5, -1.5);
        boolean actual = figureValidator.validatePoint(point);
        Assert.assertTrue(actual);
    }

    @Test
    public void testValidatePointNegative() {
        Point point = new Point(1.5, -25.5);
        boolean actual = figureValidator.validatePoint(point);
        Assert.assertFalse(actual);
    }

    @Test
    public void testValidateRadiusStringPositive() {
        boolean actual = figureValidator.validateRadius("1.5");
        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateRadiusStringNegative() {
        boolean actual = figureValidator.validateRadius("zero");
        Assert.assertFalse(actual);
    }

    @Test
    public void testValidateRadiusStringNull() {
        boolean actual = figureValidator.validateRadius(null);
        Assert.assertFalse(actual);
    }

    @Test
    public void testValidateRadiusDoublePositive() {
        boolean actual = figureValidator.validateRadius(5.7);
        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateRadiusDoubleNegative() {
        boolean actual = figureValidator.validateRadius(-1.5);
        Assert.assertFalse(actual);
    }

    @Test
    public void testValidateRangeStringPositive() {
        boolean actual = figureValidator.validateRange("1.5", "5.5");
        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateRangeStringNegative() {
        boolean actual = figureValidator.validateRange("17..7", "9.2");
        Assert.assertFalse(actual);
    }

    @Test
    public void testValidateRangeStringNull() {
        boolean actual = figureValidator.validateRange("1.1", null);
        Assert.assertFalse(actual);
    }

    @Test
    public void testValidateRangeDoublePositive() {
        boolean actual = figureValidator.validateRange(1.5, 5.5);
        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateRangeDoubleNegative() {
        boolean actual = figureValidator.validateRange(1.5, 0);
        Assert.assertFalse(actual);
    }
}
