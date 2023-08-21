import java.util.Scanner;

public class a {
    static int n, k, cnt = 0;
    static int a[] = new int[10];

    public static void in() {
        cnt++;
        for (int i = 1; i <= k; i++) 
            System.out.printf(a[i] + " ");
        System.out.println();
    }

    public static void Try(int i) {
        for (int j = a[i - 1] + 1; j <= n; j++) {
            a[i] = j;
            if (i == k) in();
            else Try(i + 1);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        k = scan.nextInt();
        Try(1);
        System.out.printf("Tong cong co %d to hop", cnt);
        
        scan.close();
    }
}