import java.util.Scanner;

public class J02019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sieve[] = new int[1000001];
        for (int i = 1; i <= 500000; ++i)
            for (int j = i * 2; j <= 1000000; j += i) sieve[j] += i;

        int a = sc.nextInt(), b = sc.nextInt();
        int res = 0;
        for (int i = a; i <= b; i++)
            if (sieve[i] > i) res++;
        System.out.println(res);

        sc.close();
    }
}
