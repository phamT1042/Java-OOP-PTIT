import java.util.Scanner;
import java.util.Stack;

public class J08020 {
    public static String check (String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == '(' || tmp == '[' || tmp == '{') st.push(tmp);
            else {
                if (st.empty()) return "NO";
                if (tmp == ')' && st.peek() != '(') return "NO";
                else if (tmp == ']' && st.peek() != '[') return "NO";
                else if (tmp == '}' && st.peek() != '{') return "NO";
                st.pop();
            }
        }
        return (st.empty() ? "YES" : "NO");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            System.out.println(check(s));
        }

        sc.close();
    }
}
