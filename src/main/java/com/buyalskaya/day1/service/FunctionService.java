package com.buyalskaya.day1.service;

import com.buyalskaya.day1.entity.Point;
import com.buyalskaya.day1.validator.FigureValidator;
import com.buyalskaya.day1.validator.FractionValidator;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.tan;

public class FunctionService {
    public static final String EXCEPTION_CAPTION_INCORRECT_ARGUMENT = "This argument is incorrect";
    public static final String EXCEPTION_CAPTION_INCORRECT_VALUES = "These values are incorrect";
    public static final String EXCEPTION_DIVISION_BY_ZERO = "Division by zero";

    public double specialFunction1(double argument) {
        FractionValidator fractionValidation = new FractionValidator();
        if (fractionValidation.validateFraction(argument)) {
            double result = (argument >= 3) ? -pow(argument, 2) + 3 * argument + 9 : 1 / (pow(argument, 3) - 6);
            if (result == Double.POSITIVE_INFINITY) {
                throw new ArithmeticException(EXCEPTION_DIVISION_BY_ZERO);
            }
            return result;
        } else {
            throw new NumberFormatException(EXCEPTION_CAPTION_INCORRECT_ARGUMENT);
        }
    }

    private double specialFunction2(double x) {
        return tan(x);
    }

    public List<Point> calculateFunctionTable(double startSegment, double endSegment, double step) {
        FractionValidator fractionValidation = new FractionValidator();
        FigureValidator figureValidator = new FigureValidator();
        if (fractionValidation.validateFraction(startSegment) &&
                fractionValidation.validateFraction(endSegment) &&
                fractionValidation.validateFraction(step) &&
                figureValidator.validateRange(startSegment, endSegment)) {
            List<Point> functionTable = new ArrayList<>();
            Point point;
            for (double i = startSegment; i <= endSegment; i = i + step) {
                point = new Point(i, specialFunction2(i));
                functionTable.add(point);
            }
            return functionTable;
        } else {
            throw new NumberFormatException(EXCEPTION_CAPTION_INCORRECT_VALUES);
        }
    }
}
