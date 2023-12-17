import java.util.Scanner;

public class J03028 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();

            String s1 = s.substring(0, n / 2);
            String s2 = s.substring(n / 2);

            int r1 = 0, r2 = 0;
            for (int i = 0; i < n / 2; ++i) {
                r1 += s1.charAt(i) - 'A';
                r2 += s2.charAt(i) - 'A';
            }

            for (int i = 0; i < n / 2; i++) 
                System.out.printf("%c", (s1.charAt(i) - 'A' + r1 + s2.charAt(i) - 'A' + r2) % 26 + 'A');
            System.out.println();
        }

        sc.close();
    }
}