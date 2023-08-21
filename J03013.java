
import java.math.BigInteger;
import java.util.Scanner;

public class J03013 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        while (t-- > 0) {
            String a = scan.next();
            String b = scan.next();
            String greater = a, lower = b;

            if (a.length() < b.length()) {
                greater = b; lower = a;
            }
            else if (a.length() == b.length()) {
                if (a.compareTo(b) < 0) {
                    greater = b; 
                    lower = a;
                }
            }
            
            BigInteger a1 = new BigInteger(greater);
            BigInteger b1 = new BigInteger(lower);
            String res = a1.subtract(b1).toString();

            while (res.length() < greater.length()) res = "0" + res;
            System.out.println(res);
        }
        scan.close();
    }
}