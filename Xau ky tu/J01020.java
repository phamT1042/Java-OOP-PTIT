import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class J01020 {
    private static String solve(int n) {
        if (n == 0) return "Impossible";

        Set<Integer> check = new HashSet<>();
        int res = 0;
        while (check.size() < 10) {
            int tmp = n * (++res);
            while (tmp > 0) {
                check.add(tmp % 10);
                tmp /= 10;
            }
        }
        return String.valueOf(n * res);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(solve(n));
        }

        sc.close();
    }
}
