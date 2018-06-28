/**
 * helper class.
 */
public class Point {

    double x, y;

    /**
     * pulic constructor.
     * @param newX x
     * @param newY y
     */
    public Point(double newX, double newY) {
        x = newX;
        y = newY;
    }

    @Override
    public String toString() {
        return "Point{x=" + x + ", y=" + y + "}";
    }
}
