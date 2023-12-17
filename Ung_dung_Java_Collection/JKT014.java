import java.util.Scanner;
import java.util.Stack;

public class JKT014 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) a[i] = scan.nextInt();

            int res[] = new int[n]; 
            for (int i = 0; i < n; i++) res[i] = 1;

            Stack<Integer> st = new Stack<>();
            st.push(0);
            for (int i = 1; i < n; i++) {
                while (a[i] >= a[st.peek()]) {
                    res[i] += res[st.pop()];
                    if (st.empty()) break;
                }
                st.push(i);
            }

            for (int x : res) System.out.print(x + " ");
            System.out.println();
        }
        scan.close();
    }
}