import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J07076 {
    private static int swap(int a, int b) {
        return a;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MATRIX.in"));

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt(), s = sc.nextInt();
            int a[][] = new int[n][m];
            for (int i = 0; i < n; ++i) 
                for (int j = 0; j < m; ++j) a[i][j] = sc.nextInt();

            for (int i = 0; i < n - 1; ++i)
                for (int j = i + 1; j < n; ++j)
                    if (a[j][s - 1] < a[i][s - 1]) a[j][s - 1] = swap(a[i][s - 1], a[i][s - 1] = a[j][s - 1]);
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) System.out.printf("%d ", a[i][j]);
                System.out.println(); 
            }
        }

        sc.close();
    }
}
