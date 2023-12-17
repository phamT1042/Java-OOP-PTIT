import java.util.Scanner;
import java.util.Stack;

public class J08022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Stack<Integer> s = new Stack<>();
            int res[] = new int[n];
            int a[] = new int[n];

            for (int i = 0; i < n; ++i) {
                a[i] = sc.nextInt();
                while (!s.isEmpty() && a[i] > a[s.peek()]) 
                    res[s.pop()] = a[i];
                s.push(i);
            }
            while (!s.isEmpty()) res[s.pop()] = -1;

            for (int x : res) System.out.printf("%d ", x);
            System.out.println();
        }

        sc.close();
    }
} 