import java.util.Scanner;
public class J02014 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            int a[] = new int[n];
            int pre[] = new int[n];

            a[0] = scan.nextInt();
            pre[0] = a[0];

            for (int i = 1; i < n; i++) {
                a[i] = scan.nextInt();
                pre[i] = pre[i - 1] + a[i];
            }

            int index = -1;
            for (int i = 1; i < n - 1; i++) {
                if (pre[i - 1] == pre[n - 1] - pre[i]) {
                    index = i + 1;
                    break;
                }
            }
            System.out.println(index);
        }
        scan.close();
    }
}
