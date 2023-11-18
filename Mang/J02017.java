import java.util.Scanner;
import java.util.Stack;
public class J02017 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        Stack<Integer> st = new Stack<>();
        while (n-- > 0) {
            int x = scan.nextInt();
            if (st.empty()) st.push(x);
            else {
                if ((st.peek() + x) % 2 == 0) st.pop();
                else st.push(x);
            }
        }
        System.out.println(st.size());

        scan.close();
    }
}
