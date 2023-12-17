import java.math.BigInteger;
import java.util.Scanner;

public class J03018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String n = sc.next();
            BigInteger b = new BigInteger(n);
            BigInteger four = BigInteger.valueOf(4);
            BigInteger zero = BigInteger.ZERO;
            
            System.out.println((b.mod(four).equals(zero)) ? 4 : 0);
        }

        sc.close();
    }
}
