package com.buyalskaya.day1.comparator;

import com.buyalskaya.day1.entity.Point;
import com.buyalskaya.day1.service.FigureService;

import java.util.Comparator;

public class PointComparator implements Comparator<Point> {
    public static final Point CENTER = new Point(0, 0);

    @Override
    public int compare(Point point1, Point point2) {
        FigureService figureService = new FigureService();
        double distance1 = figureService.distanceBetweenPoints(point1, CENTER);
        double distance2 = figureService.distanceBetweenPoints(point2, CENTER);
        if (distance1 < distance2) {
            return -1;
        } else if (distance1 > distance2) {
            return 1;
        } else {
            return 0;
        }
    }
}
