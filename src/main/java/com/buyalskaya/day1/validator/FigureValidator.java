package com.buyalskaya.day1.validator;

import com.buyalskaya.day1.entity.Point;

public class FigureValidator {
    public static final double MIN_SIDE = 0.5;
    public static final double MAX_SIDE = 40;
    public static final double MIN_POINT_COORDINATE = -20;
    public static final double MAX_POINT_COORDINATE = 20;
    public static final double MIN_RADIUS = MIN_SIDE / 2;
    public static final double MAX_RADIUS = MAX_SIDE / 2;
    public static final double MIN_AREA = Math.pow(MIN_SIDE, 2);
    public static final double MAX_AREA = Math.pow(MAX_SIDE, 2);

    public boolean validateArea(String area) {
        return validateSize(area, MIN_AREA, MAX_AREA);
    }

    public boolean validateArea(double area) {
        return validateSize(area, MIN_AREA, MAX_AREA);
    }

    public boolean validatePoint(Point point) {
        return (validateSize(point.getX(), MIN_POINT_COORDINATE, MAX_POINT_COORDINATE) &&
                validateSize(point.getY(), MIN_POINT_COORDINATE, MAX_POINT_COORDINATE));
    }

    public boolean validateRadius(String radius) {
        return validateSize(radius, MIN_RADIUS, MAX_RADIUS);
    }

    public boolean validateRadius(double radius) {
        return validateSize(radius, MIN_RADIUS, MAX_RADIUS);
    }

    private boolean validateSize(String size, double minSize, double maxSize) {
        boolean validateSize = false;
        FractionValidator fractionValidation = new FractionValidator();
        boolean isNumberSize = fractionValidation.validateFraction(size);
        if (isNumberSize) {
            double sizeDouble = Double.parseDouble(size);
            validateSize = validateSize(sizeDouble, minSize, maxSize);
        }
        return validateSize;
    }

    private boolean validateSize(double size, double minSize, double maxSize) {
        return ((size >= minSize) && (size <= maxSize));
    }

    public boolean validateRange(String startRange, String endRange) {
        boolean validateRange = false;
        FractionValidator fractionValidation = new FractionValidator();
        boolean isNumberStartRange = fractionValidation.validateFraction(startRange);
        boolean isNumberEndRange = fractionValidation.validateFraction(endRange);
        if (isNumberStartRange && isNumberEndRange) {
            double startRangeDouble = Double.parseDouble(startRange);
            double endRangeDouble = Double.parseDouble(endRange);
            validateRange = validateRange(startRangeDouble, endRangeDouble);
        }
        return validateRange;
    }

    public boolean validateRange(double startRange, double endRange) {
        boolean validateRange = false;
        FractionValidator fractionValidation = new FractionValidator();
        boolean validateStartRange = fractionValidation.validateFraction(startRange);
        boolean validateEndRange = fractionValidation.validateFraction(endRange);
        if (validateStartRange && validateEndRange) {
            validateRange = startRange <= endRange;
        }
        return validateRange;
    }
}
