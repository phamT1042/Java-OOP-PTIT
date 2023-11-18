import java.util.Scanner;
public class J02008 {
    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int t = scan.nextInt();
        while (t-- > 0) {
            long n = scan.nextLong();
            if (n == 1) System.out.println(1);
            else {
                long res = 2;
                for (int i = 3; i <= n; i++) 
                    res = res * i / gcd(res, i);
                System.out.println(res);
            }
        }
        scan.close();
    }
}
