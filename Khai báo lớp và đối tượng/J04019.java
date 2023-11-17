import java.util.Scanner;

class Point {
    private double x, y;
    public Point() {x = y = 0;}

    public double getX() {return x;}
    public double getY() {return y;}
    
    public static Point nextPoint(Scanner scan) {
        Point p = new Point();
        p.x = scan.nextDouble();
        p.y = scan.nextDouble();
        return p;
    }
}

class Triangle {
    private Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double diff(Point a, Point b) {
        return Math.sqrt((a.getX() - b.getX()) * (a.getX() - b.getX()) + (a.getY() - b.getY()) * (a.getY() - b.getY()));
    }

    public boolean valid() {
        double canh1 = diff(this.a, this.b);
        double canh2 = diff(this.b, this.c);
        double canh3 = diff(this.a, this.c);
        return (canh1 + canh2) > canh3 && (canh1 + canh3) > canh2 && (canh2 + canh3) > canh1; 
    }
    
    public String getPerimeter() {
        double canh1 = diff(this.a, this.b);
        double canh2 = diff(this.b, this.c);
        double canh3 = diff(this.a, this.c);
        return String.format("%.3f", canh1 + canh2 + canh3);
    }
}

public class J04019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
    }
}