package com.buyalskaya.day1.console;

import com.buyalskaya.day1.entity.Point;

public class FigurePrint {

    public static final String CAPTION_AREA_SQUARE = "Area initial square = %.2f,  " +
            "area of a square inscribed in a circle that inscribed in the initial square = %.2f\n";
    public static final String CAPTION_CIRCUMFERENCE = "Circumference = 2 * PI * %.2f = %.2f\n";
    public static final String CAPTION_AREA_CIRCLE = "Area circle = PI * %.2f ^ 2 = %.2f\n";

    public void printAreaSquareInscribedInCircle(double initialAreaSquare,
                                                 double areaSquareInscribedInCircle) {
        System.out.printf(CAPTION_AREA_SQUARE, initialAreaSquare, areaSquareInscribedInCircle);
    }

    public void printPointNearestToCenter(Point point1, Point point2, int resultComparison) {
        String points = "{" + point1.toString() + " ; " + point2.toString() + "}";
        switch (resultComparison) {
            case -1:
                System.out.println("Nearest to the center point from " + points + " is " + point1.toString());
                break;
            case 0:
                System.out.println("Points " + points + " have the same distance to the center");
                break;
            case 1:
                System.out.println("Nearest to the center point from " + points + " is " + point2.toString());
                break;
        }
    }

    public void printCircumference(double radius, double circumference) {
        System.out.printf(CAPTION_CIRCUMFERENCE, radius, circumference);
    }

    public void printAreaCircle(double radius, double areaCircle) {
        System.out.printf(CAPTION_AREA_CIRCLE, radius, areaCircle);
    }
}
