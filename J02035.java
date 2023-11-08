import java.util.Scanner;

public class J02035 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            a[0] = sc.nextInt();
            if (n == 1) System.out.println(0);
            else {
                int res = 0;
                for (int i = 1; i < n; i++) {
                    a[i] = sc.nextInt();
                    if (a[i] < a[i - 1]) res = i;
                }
                System.out.println(res);
            }
        }

        sc.close();
    }
}
