import static java.lang.Math.*;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double distance(Point p1, Point p2){
        return sqrt(((p2.x - p1.x) *(p2.x - p1.x)) + ((p2.y - p1.y) *(p2.y - p1.y)));
    }

    public double distance(Point p1){
        return sqrt(((this.x - p1.x) *(this.x - p1.x)) + ((this.y - p1.y) *(this.y - p1.y)));
    }

    public static void main(String[] args) {
        Point p1 = new Point(3,-4);
        Point p2 = new Point(-6,5);
        System.out.println(distance(p1,p2));
        System.out.println(p1.distance(p2));
    }
}
