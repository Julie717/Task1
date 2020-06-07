package com.buyalskaya.day1.console;

import com.buyalskaya.day1.entity.Point;

import java.util.List;

public class FunctionPrint {

    public void printFunction(double argument, double function) {
        System.out.printf("f(%.2f) = %.2f\n", argument, function);
    }

    public void printTable(List<Point> functionTable) {
        for (Point point : functionTable) {
            System.out.printf("tg( %5.2f) = %5.2f\n", point.getX(), point.getY());
        }
    }
}
