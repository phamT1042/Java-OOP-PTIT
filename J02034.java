import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int a[] = new int[201];
        int mx = 0;
        while (n-- > 0) {
            int x = scan.nextInt();
            mx = Math.max(mx, x);
            a[x] = 1;
        }
        byte check = 1;
        for (int i = 1; i <= mx; i++)
            if (a[i] == 0) {
                check = 0;
                System.out.println(i);
            }
        if (check == 1) System.out.println("Excellent!");
        
        scan.close();
    }
}