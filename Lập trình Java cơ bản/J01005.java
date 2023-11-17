import java.util.Scanner;

//Tỉ số diện tích của hai tam giác đồng dạng thì bằng bình phương tỉ số đồng dạng
public class J01005 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        while (t-- > 0) {
            double n = scan.nextDouble();
            double h = scan.nextDouble();
            for (int i = 1; i < n; i++) 
                System.out.printf("%.6f ", h * Math.sqrt(i / n));
            System.out.println();
        }

        scan.close();
    }
}