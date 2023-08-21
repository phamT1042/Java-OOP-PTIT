import java.math.BigInteger;
import java.util.Scanner;

public class J03033 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        while (t-- > 0) {
            String a = scan.next();
            String b = scan.next();
            BigInteger a1 = new BigInteger(a);
            BigInteger b1 = new BigInteger(b);
            System.out.println(a1.multiply(b1).divide(a1.gcd(b1)));
        }

        scan.close();
    }
}