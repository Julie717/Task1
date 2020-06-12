package com.buyalskaya.day1.service;

import com.buyalskaya.day1.entity.Point;
import com.buyalskaya.day1.exception.InputDataFormatException;
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

    public double customFunction1(double argument) throws InputDataFormatException {
        FractionValidator fractionValidation = new FractionValidator();
        if (fractionValidation.validateFraction(argument)) {
            double result = (argument >= 3) ? -pow(argument, 2) + 3 * argument + 9 : 1 / (pow(argument, 3) - 6);
            if (result == Double.POSITIVE_INFINITY) {
                throw new InputDataFormatException(EXCEPTION_DIVISION_BY_ZERO);
            }
            return result;
        } else {
            throw new InputDataFormatException(EXCEPTION_CAPTION_INCORRECT_ARGUMENT);
        }
    }

    private double customFunction2(double x) {
        return tan(x);
    }

    public List<Point> calculateFunctionTable(double startSegment, double endSegment, double step)
            throws InputDataFormatException {
        FractionValidator fractionValidation = new FractionValidator();
        FigureValidator figureValidator = new FigureValidator();
        if (fractionValidation.validateFraction(startSegment) &&
                fractionValidation.validateFraction(endSegment) &&
                fractionValidation.validateFraction(step) &&
                figureValidator.validateRange(startSegment, endSegment)) {
            List<Point> functionTable = new ArrayList<>();
            Point point;
            int size = (int) ((endSegment - startSegment) / step) + 1;// calculate points inside the range
            //(1 add because it needs to add a border point)
            double argument = startSegment;
            for (int i = 0; i < size; i++) {
                point = new Point(argument, customFunction2(argument));
                functionTable.add(point);
                argument += step;
            }
            return functionTable;
        } else {
            throw new InputDataFormatException(EXCEPTION_CAPTION_INCORRECT_VALUES);
        }
    }
}
