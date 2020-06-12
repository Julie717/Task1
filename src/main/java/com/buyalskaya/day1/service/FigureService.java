package com.buyalskaya.day1.service;

import com.buyalskaya.day1.comparator.PointComparator;
import com.buyalskaya.day1.entity.Point;
import com.buyalskaya.day1.exception.InputDataFormatException;
import com.buyalskaya.day1.validator.FigureValidator;

import static java.lang.Math.*;

public class FigureService {
    public static final String EXCEPTION_CAPTION_INCORRECT_AREA = "This area is incorrect";
    public static final String EXCEPTION_CAPTION_INCORRECT_POINT = "These points are incorrect";
    public static final String EXCEPTION_CAPTION_INCORRECT_RADIUS = "This radius is incorrect";

    public double areaSquareInscribedInCircle(double areaInitialSquare) throws InputDataFormatException {
        FigureValidator figureValidation = new FigureValidator();
        if (figureValidation.validateArea(areaInitialSquare)) {
            double sideInitialSquare = sqrt(areaInitialSquare);
            double diagonalSquareInscribedInCircle = sideInitialSquare;
            return squareAreaThroughDiagonal(diagonalSquareInscribedInCircle);
        } else {
            throw new InputDataFormatException(EXCEPTION_CAPTION_INCORRECT_AREA);
        }
    }

    private double squareAreaThroughDiagonal(double diagonalSquare) {
        return pow(diagonalSquare, 2) / 2;
    }

    public double distanceBetweenPoints(Point point1, Point point2) {
        return hypot(point1.getX() - point2.getX(), point1.getY() - point2.getY());
    }

    public int pointNearestToCenter(Point point1, Point point2) throws InputDataFormatException {
        FigureValidator figureValidation = new FigureValidator();
        if (figureValidation.validatePoint(point1) &&
                figureValidation.validatePoint(point2)) {
            PointComparator pointComparator = new PointComparator();
            int pointNearestToCenter = pointComparator.compare(point1, point2);
            return pointNearestToCenter; // -1 - point1, 1 - point2, 0 - the same
        } else {
            throw new InputDataFormatException(EXCEPTION_CAPTION_INCORRECT_POINT);
        }
    }

    public double areaCircle(double radius) throws InputDataFormatException {
        FigureValidator figureValidation = new FigureValidator();
        if (figureValidation.validateRadius(radius)) {
            return PI * pow(radius, 2);
        } else {
            throw new InputDataFormatException(EXCEPTION_CAPTION_INCORRECT_RADIUS);
        }
    }

    public double circumference(double radius) throws InputDataFormatException {
        FigureValidator figureValidation = new FigureValidator();
        if (figureValidation.validateRadius(radius)) {
            return 2 * PI * radius;
        } else {
            throw new InputDataFormatException(EXCEPTION_CAPTION_INCORRECT_RADIUS);
        }
    }
}
