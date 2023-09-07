import java.util.Scanner;

class Rectange {
    private double width, height;
    private String color;
    
    public Rectange(){
        width = height = 1;
        color = "";
    }
    public Rectange(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public double findArea() {
        return width * height;
    }

    public double findPerimeter() {
        return (width + height) * 2;
    }

    public String toString() {
        double height = this.getHeight();
        double width = this.getWidth();
        if (height <= 0 || width <= 0) return "INVALID";
        if (height % 1 != 0 || width % 1 != 0) return "INVALID";
        String color_format = "";
        color_format += Character.toUpperCase(this.getColor().charAt(0));
        for (int i = 1; i < this.getColor().length(); i++) {
            color_format += Character.toLowerCase(this.getColor().charAt(i));
        }
        double area = this.findArea();
        double peri = this.findPerimeter();
        return (int)peri + " " + (int)area + " " + color_format;
    }
}
public class J04002 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double w = scan.nextDouble();
        double h = scan.nextDouble();
        String c = scan.next();
        System.out.println(new Rectange(w, h, c));

        scan.close();
    }
}