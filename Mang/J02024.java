import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class J02024 {
    static Integer a[] = new Integer[16];
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
            Arrays.sort(a, 0, n, Collections.reverseOrder());
            Try(0);
        }

        sc.close();
    }
}