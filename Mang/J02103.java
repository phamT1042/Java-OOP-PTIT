import java.util.Scanner;

public class J02103 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        for (int T = 1; T <= t; T++) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int a[][] = new int[n][m];
            int b[][] = new int[m][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++) {
                    a[i][j] = scan.nextInt();
                    b[j][i] = a[i][j];
                }
            
            int c[][] = new int[n][n];
            System.out.printf("Test %d:\n", T);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                        c[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf(c[i][j] + " ");
                } 
                System.out.println();
            }
        }
        
        scan.close();
    }
}