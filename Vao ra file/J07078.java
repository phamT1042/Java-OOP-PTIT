import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J07078 {
    public static void solve(String text, String pattern) {
        String newStr = pattern + "$" + text;
        int n = newStr.length();

        int Z[] = new int[n];
        int l = 0, r = 0, k;
        for (int i = 1; i < n; ++i) {
            if (i > r) {
                l = r = i;
                while (r < n && newStr.charAt(r - l) == newStr.charAt(r)) r++;
                Z[i] = r - l;
                r--;
            }
            else {
                k = i - l;
                if (Z[k] < r - i + 1) Z[i] = Z[k];
                else {
                    l = i;
                    while (r < n && newStr.charAt(r - l) == newStr.charAt(r)) r++;
                    Z[i] = r - l;
                    r--;
                }
            }
        }

        for (int i = 0; i < n; ++i) 
            if (Z[i] == pattern.length()) System.out.printf("%d ", i - pattern.length());
        System.out.println();
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("STRING.in"));

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String text = sc.nextLine();
            String pattern = sc.nextLine();
            solve(text, pattern);
        }
 
        sc.close();
    }
}
