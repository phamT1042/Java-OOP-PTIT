import java.util.Scanner;

public class J02022 {
    static int n;
    static int a[] = new int[10];
    static int vs[] = new int[10];

    public static void in() {
        for (int i = 1; i <= n; i++) System.out.print(a[i]);
        System.out.println();
    }

    public static void Try(int i) {
        for (int j = 1; j <= n; j++) {
            if (vs[j] == 0 && Math.abs(j - a[i - 1]) != 1) {
                a[i] = j;
                vs[j] = 1;
                if (i == n) in();
                else Try(i + 1);
                vs[j] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        while (t-- > 0) {
            n = scan.nextInt();
            a[0] = -1;
            Try(1);
        }
        
        scan.close();
    }
}