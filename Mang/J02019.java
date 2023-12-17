import java.util.Scanner;

public class J02019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(), b = sc.nextInt();

        int sieve[] = new int[b + 1];
        for (int i = 1; i * 2 <= b; ++i)
            for (int j = i * 2; j <= b; j += i) sieve[j] += i;

        int res = 0;
        for (int i = a; i <= b; i++)
            if (sieve[i] > i) res++;
        System.out.println(res);

        sc.close();
    }
}