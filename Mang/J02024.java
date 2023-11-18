import java.util.Arrays;
import java.util.Scanner;

public class J02024 {
    static int a[] = new int[16];
    static int bit[] = new int[16];
    static int n;

    public static void res () {
        String s = "";
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (bit[i] == 1) {
                s += String.valueOf(a[i]) + " ";
                sum += a[i];
            }
        }
        if (sum % 2 == 1) System.out.println(s);
    }

    public static void Try (int i) {
        for (int j = 0; j <= 1; j++) {
            bit[i] = j;
            if (i == n - 1) res();
            else Try(i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Arrays.sort(a, 0, n);
            int l = 0, r = n - 1;
            while (l < r) {
                int tmp = a[r];
                a[r] = a[l];
                a[l] = tmp;
                l++; r--;
            }
            Try(0);
        }

        sc.close();
    }
}