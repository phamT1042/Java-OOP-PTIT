import java.util.Scanner;
import java.util.Stack;

public class J03017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Stack<Integer> st = new Stack<>();
            int n = s.length(), res = 0;
            
            for (int i = 0; i < n; ++i) {
                char kt = s.charAt(i);
                if (st.size() < 2) st.push(i);
                else {
                    int top1 = st.pop(); int top2 = st.pop();
                    if (s.charAt(top2) == '1' && s.charAt(top1) == '0' && kt == '0') continue;
                    st.push(top2);
                    st.push(top1);
                    st.push(i);
                }
            }
            
            if (st.empty()) res = s.length();
            else {
                st.push(n);
                int last = st.pop(), beforeLast = st.pop();
                res = Math.max(res, last - beforeLast - 1);
                last = beforeLast;
                while (!st.empty()) {
                    beforeLast = st.pop();
                    res = Math.max(res, last - beforeLast - 1);
                    last = beforeLast;
                    if (st.empty()) res = Math.max(res, beforeLast);
                }
            }
            
            System.out.println(res);
        }

        sc.close();
    }
}