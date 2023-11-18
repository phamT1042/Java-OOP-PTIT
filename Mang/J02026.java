import java.util.Arrays;
import java.util.Scanner;

public class J02026 {
    static int a[] = new int[16];
    static int bit[] = new int[16];
    static int n, k;

    public static void res () {
        int pre = a[bit[1] - 1];
        String s = String.valueOf(pre) + " ";
        for (int i = 2; i <= k; ++i) {
            if (a[bit[i] - 1] < pre) return;
            pre = a[bit[i] - 1];
            s += String.valueOf(pre) + " ";
        }
        System.out.println(s);
    }

    public static void Try (int i) {
        for (int j = bit[i - 1] + 1; j <= n - k + i; j++) {
            bit[i] = j;
            if (i == k) res();
            else Try(i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            k = sc.nextInt();
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Arrays.sort(a, 0, n);
            Try(1);
        }

        sc.close();
    }
}