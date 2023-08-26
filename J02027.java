import java.util.Arrays;
import java.util.Scanner;

public class J02027 {
    static int lower_bound(int a[], int l, int r, int val) {
        while (l + 1 < r) {
            int m = (l + r) / 2;
            if (a[m] >= val) r = m;
            else l = m;
        }
        return r;
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
            int res = 0;
            for (int i = 0; i < n - 1; i++) {
                int j = lower_bound(a, i, n, a[i] + k);
                j = j - i - 1;
                if (j >= 1) res += j; 
            }
            System.out.println(res);
        }
 
        scan.close();
    }
}