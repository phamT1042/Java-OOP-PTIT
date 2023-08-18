import java.util.Scanner;

public class J01021 {
    static final long MOD = 1000000007;
    public static long powMod(long a, long b) {
        long res = 1;
        while (b != 0) {
            if (b % 2 == 1) {
                res *= a;
                res %= MOD;
            }
            a *= a;
            a %= MOD;
            b /= 2;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        while (true) {
            long a = scan.nextLong();
            long b = scan.nextLong();
            if (a == 0 && b == 0) break;
            System.out.println(powMod(a, b));
        }

        scan.close();
    }
}
