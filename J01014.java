import java.util.Scanner;

public class J01014 {
    public static boolean check_prime (long n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) 
            if (n % i == 0) return false;
        return true;
    } 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        while (t-- > 0) {
            long n = scan.nextLong();
            long res = 0;
            for (long i = 1; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    if (check_prime(i)) res = Math.max(res, i);
                    if (check_prime(n / i)) {
                        res = n / i;
                        break;
                    }
                }
            }
            System.out.println(res);
        }

        scan.close();
    }
}
