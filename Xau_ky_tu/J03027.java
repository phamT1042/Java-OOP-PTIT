import java.util.Scanner;
import java.util.Stack;

public class J03027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next();
        int n = s.length();
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < n; ++i) {
            if (st.empty()) st.push(s.charAt(i));
            else {
                if (st.peek() == s.charAt(i)) st.pop();
                else st.push(s.charAt(i));
            }
        }

        if (st.empty()) System.out.println("Empty String");
        else {
            String res = "";
            while (!st.isEmpty()) res = st.pop() + res;
            System.out.println(res);
        }
        
        sc.close();
    }
    
}