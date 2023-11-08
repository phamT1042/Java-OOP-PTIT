import java.util.Scanner;
import java.util.Stack;

public class J08028 {
    public static long solve(long a[], int n) {
        Stack<Integer> st = new Stack<>();
        long res = 0;
        int i = 0;

        while (i < n) {
            if (st.empty() || a[i] >= a[st.peek()]) st.push(i++);
            else {
                int idx = st.pop();
                if (st.empty()) res = Math.max(res, i * a[idx]);
                else res = Math.max(res, a[idx] * (i - st.peek() - 1));
            }
        }

        while (!st.empty()) {
            int idx = st.pop();
            if (st.empty()) res = Math.max(res, i * a[idx]);
            else res = Math.max(res, a[idx] * (i - st.peek() - 1));
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        long a[] = new long[n];
        long b[] = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            b[i] = m - a[i];
        }

        System.out.println(Math.max(solve(a, n), solve(b, n)));

        sc.close();
    }
}