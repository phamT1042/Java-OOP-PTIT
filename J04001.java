import java.util.Scanner;

class Point {
    private double x, y;
    
    public Point(){
        x = y = 0;
    }
    public Point (double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Point (Point p) {
        x = p.x; y = p.y;
    }

    public double getX() {return this.x;}
    public double getY() {return this.y;}

    public double distance(Point secondPoint) {
        return Math.sqrt(Math.pow(this.x - secondPoint.x, 2) + Math.pow(this.y - secondPoint.y, 2));
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public String toString() {
        return this.x + " " + this.y;
    }
}
public class J04001 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        while (t-- > 0) {
            double x1 = scan.nextDouble();
            double y1 = scan.nextDouble();
            double x2 = scan.nextDouble();
            double y2 = scan.nextDouble();
            System.out.printf("%.4f\n", new Point(x1, y1).distance(new Point(x2, y2)));
        }

        scan.close();
    }
}