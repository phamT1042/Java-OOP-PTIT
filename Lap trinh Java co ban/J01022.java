import java.util.Scanner;

public class J01022 {
    static long length[] = new long[95];

    public static byte Try(int n, long k) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (k <= length[n - 2]) return Try(n - 2, k);
        else return Try(n - 1, k - length[n - 2]);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        length[1] = length[2] = 1;
        for (int i = 3; i <= 92; i++) length[i] = length[i - 1] + length[i - 2];

        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            long k = scan.nextLong();
            System.out.println(Try(n, k));
        }

        scan.close();
    }    
}
