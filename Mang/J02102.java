import java.util.Arrays;
import java.util.Scanner;

public class J02102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int save[] = new int[n * n];
        for (int i = 0; i < n * n; i++) save[i] = sc.nextInt();
        Arrays.sort(save);

        int res[][] = new int[n + 1][n + 1];
        int lc = 1, lr = 1, rc = n, rr = n;
        int t = 0;
        while (lc <= rc && lr <= rr) {
            for (int i = lc; i <= rc; ++i) res[lr][i] = save[t++];
            lr++;
            for (int i = lr; i <= rr; ++i) res[i][rc] = save[t++];
            rc--;
            for (int i = rc; i >= lc; --i) res[rr][i] = save[t++];
            rr--;
            for (int i = rr; i >= lr; --i) res[i][lc] = save[t++];
            lc++; 
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) System.out.printf("%d ", res[i][j]);
            System.out.println();
        }

        sc.close();
    }
}