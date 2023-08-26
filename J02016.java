import java.util.Arrays;
import java.util.Scanner;

public class J02016 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            long e[] = new long[n];
            long x;
            for (int i = 0; i < n; i++) {
                x = scan.nextLong();
                e[i] = x * x;
            }
            Arrays.sort(e);

            byte check = 0;
            for (int c = n - 1; c >= 2; c--) {
                int a = 0, b = c - 1;
                while (a < b) {
                    if (e[a] + e[b] == e[c]) {
                        check = 1; break;
                    }
                    if (e[a] + e[b] > e[c]) b--;
                    else a++;
                }
                if (check == 1) break;
            }
            
            if (check == 1) System.out.println("YES");
            else System.out.println("NO");
        }
        
        scan.close();
    }
}