import java.math.BigInteger;
import java.util.Scanner;

public class J01021 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        BigInteger mod = BigInteger.valueOf(1000000007);
        while (true) {
            long a = scan.nextLong();
            long b = scan.nextLong();
            if (a == 0 && b == 0) break;
            BigInteger Ba = BigInteger.valueOf(a);
            BigInteger Bb = BigInteger.valueOf(b);
            System.out.println(Ba.modPow(Bb, mod));
        }

        scan.close();
    }
}