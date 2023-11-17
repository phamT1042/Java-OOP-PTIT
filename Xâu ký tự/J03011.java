import java.math.BigInteger;
import java.util.Scanner;

public class J03011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            System.out.println(new BigInteger(a).gcd(new BigInteger(b)));
        }

        sc.close();
    }
}