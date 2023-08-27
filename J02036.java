import java.util.Scanner;

public class J02036 {
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) a[i] = scan.nextInt();

            System.out.print(a[0] + " ");
            for (int i = 1; i < n; i++)
                System.out.print((a[i] * a[i - 1]) / gcd(a[i], a[i - 1]) + " ");
            System.out.println(a[n - 1]);
        }

        scan.close();
    }
}