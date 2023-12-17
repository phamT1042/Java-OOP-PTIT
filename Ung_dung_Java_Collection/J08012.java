import java.util.Scanner;

public class J08012 {
    static String check(int ke[], int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (ke[i] == n - 1) {
                if (cnt == 1) return "No";
                cnt++;
            }
            else if (ke[i] != 1) return "No";
        }
        return "Yes";
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int ke[] = new int[n + 1];
        for (int i = 0; i < n - 1; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            ke[x]++;
            ke[y]++;
        }
        System.out.println(check(ke, n));

        scan.close();
    }
}