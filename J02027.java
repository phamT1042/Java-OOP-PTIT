import java.util.Arrays;
import java.util.Scanner;

public class J02027 {
    static int lower_bound(int a[], int l, int r, int val) {
        int res = r + 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (a[m] >= val) {
                res = m;
                r = m - 1;
            }
            else l = m + 1;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) a[i] = scan.nextInt();

            Arrays.sort(a);
            long res = 0;
            for (int i = 0; i < n; i++) {
                int j = lower_bound(a, i + 1, n - 1, a[i] + k);
                res += j - i - 1;
            }
            System.out.println(res);
        }
 
        scan.close();
    }
}