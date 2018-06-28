/*
 * 22. На плоскости задано N отрезков.
 * Найти точку пересечения двух отрезков,
 * имеющую минимальную абсциссу.
 * Использовать класс TreeMap
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * main clas for the task 22.
 */
public class Main {
    private static Map<Double, List<Point>> map = new TreeMap<>();
    private static Point point = new Point(5, 10);
    private static Point point1 = new Point(10, 7);
    private static Point point2 = new Point(3, 6);
    private static Point point3 = new Point(10, 13);
    private static Point point4 = new Point(1, 10);
    private static Point point5 = new Point(10, 5);
    private static Point point6 = new Point(3, 15);
    private static Point point7 = new Point(7, 1);
    private static Point point8 = new Point(25, 10);
    private static Point point9 = new Point(40, 30);
    private static Point point10 = new Point(30, 15);
    private static Point point11 = new Point(35, 50);

    /**
     * main method for the task 22.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(checkSegments(point, point1, point2, point3));
        System.out.println(checkSegments(point4, point5, point6, point7));
        System.out.println(checkSegments(point8, point9, point10, point11));
        System.out.println(map);
    }

    //The method that checks whether two segments intersect [p1, p2] and [p3, p4]
    private static boolean checkSegments(Point p1, Point p2, Point p3, Point p4) {
        List<Point> list = new ArrayList<>();
        List<Point> buff = new ArrayList<>();
//arrange the points in the correct order, p1.x <= p2.x
        if (p2.x < p1.x) {
            Point tmp = p1;
            p1 = p2;
            p2 = tmp;
        }
// p3.x <= p4.x
        if (p4.x < p3.x) {
            Point tmp = p3;
            p3 = p4;
            p4 = tmp;
        }
//verify the existence of a potential interval for the point of intersection of segments
        if (p2.x < p3.x) {
            return false; //the segments do not have a mutual abscissa
        }
//if both segments are vertical
        if ((p1.x - p2.x == 0) && (p3.x - p4.x == 0)) {
//if they lie on one X
            if (p1.x == p3.x) {
//check whether they intersect, i.e. do they have a common Y
//for this we take the negation from the case when they do not intersect
                if (!((Math.max(p1.y, p2.y) < Math.min(p3.y, p4.y)) ||
                        (Math.min(p1.y, p2.y) > Math.max(p3.y, p4.y)))) {
                    return true;
                }
            }
            return false;
        }
//find the coefficients of the equations containing the segments
//f1(x) = A1*x + b1 = y
//f2(x) = A2*x + b2 = y
//if the first segment is vertical
        if (p1.x - p2.x == 0) {
            //find Xa, Ya - points of intersection of two lines
            double Xa = p1.x;
            double A2 = (p3.y - p4.y) / (p3.x - p4.x);
            double b2 = p3.y - A2 * p3.x;
            double Ya = A2 * Xa + b2;
            if (p3.x <= Xa && p4.x >= Xa && Math.min(p1.y, p2.y) <= Ya &&
                    Math.max(p1.y, p2.y) >= Ya) {
                list.add(p1);
                list.add(p2);
                list.add(p3);
                list.add(p4);
                map.put(Xa, list);
                return true;
            }
            return false;
        }

        //if the second segment is vertical
        if (p3.x - p4.x == 0) {
            //find Xa, Ya - points of intersection of two lines
            double Xa = p3.x;
            System.out.println(Xa);
            double A1 = (p1.y - p2.y) / (p1.x - p2.x);
            double b1 = p1.y - A1 * p1.x;
            double Ya = A1 * Xa + b1;
            if (p1.x <= Xa && p2.x >= Xa && Math.min(p3.y, p4.y) <= Ya &&
                    Math.max(p3.y, p4.y) >= Ya) {
                list.add(p1);
                list.add(p2);
                list.add(p3);
                list.add(p4);
                map.put(Xa, list);
                return true;
            }
            return false;
        }

        //both segments are non-vertical
        double A1 = (p1.y - p2.y) / (p1.x - p2.x);
        double A2 = (p3.y - p4.y) / (p3.x - p4.x);
        double b1 = p1.y - A1 * p1.x;
        double b2 = p3.y - A2 * p3.x;
        if (A1 == A2) {
            return false; //segments are parallel
        }

        //Xa is the abscissa of the point of intersection of two straight lines
        double Xa = (b2 - b1) / (A1 - A2);

        if ((Xa < Math.max(p1.x, p3.x)) || (Xa > Math.min(p2.x, p4.x))) {
            return false; //the point Xa is outside the intersection of the projections of the segments on the X axis
        } else {
            list.add(p1);
            list.add(p2);
            list.add(p3);
            list.add(p4);
            map.put(Xa, list);
            return true;
        }
    }

}