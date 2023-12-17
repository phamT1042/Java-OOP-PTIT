import java.util.Scanner;

public class J01025 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int xMin = scan.nextInt();
        int yMin = scan.nextInt();
        int xMax = xMin, yMax = yMin;
        for (int i = 0; i < 3; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            if (x > xMax) xMax = x;
            else if (x < xMin) xMin = x;
            if (y > yMax) yMax = y;
            else if (y < yMin) yMin = y;
        }
        int edge = Math.max(xMax - xMin, yMax - yMin);
        System.out.println(edge * edge);

        scan.close();
    }
}