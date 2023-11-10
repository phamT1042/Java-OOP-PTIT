import java.util.Scanner;

public class J02028 {
    private static Scanner sc = new Scanner(System.in);
    public static String check (int n, long k) {
        int check0 = 0;
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (a[i] == 0) check0 = 1;
        }
        if (check0 == 0 && k == 0) return "NO";

        int l = 0; long sum = 0;
        for (int r = 0; r < n; r++) {
            sum += a[r];
            while (sum > k) sum -= a[l++];
            if (sum == k) return "YES";
        }
        return "NO";
    }
    public static void main(String[] args) {
        
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            System.out.println(check(n, k));
        }

        sc.close();
    }
}
