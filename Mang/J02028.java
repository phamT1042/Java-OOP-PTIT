import java.util.Scanner;

public class J02028 {
    private static Scanner sc = new Scanner(System.in);
    public static String check (int n, long k) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) 
            a[i] = sc.nextInt();

        int l = 0; long sum = 0;
        for (int r = 0; r < n; r++) {
            sum += a[r];
            while (l < r && sum > k) sum -= a[l++];
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