import java.util.Scanner;

public class J01013 {
    static int sang[] = new int[2000001];
    public static void sangNT() {
        sang[0] = sang[1] = 1;
        for (int i = 2; i <= 1415; i++) {
            if (sang[i] == 0) {
                for (int j = i * i; j < 2000001; j += i) sang[j] = i;
            }
        }
        for (int i = 2; i < 2000001; i++)
            if (sang[i] == 0) sang[i] = i;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        sangNT();
        int t; t = scan.nextInt();
        long res = 0;
        while (t-- > 0) {
            int n = scan.nextInt();
           while (n > 1) {
                res += sang[n];
                n /= sang[n];
           }
        }
        System.out.println(res);

        scan.close();   
    }
}
