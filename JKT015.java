import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class JKT015 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        LinkedList<Character> res = new LinkedList<>();
        Stack<Character> save = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char sign = s.charAt(i);
            if (sign == '<') {
                if (res.size() > 0) save.push(res.removeLast());
            }
            else if (sign == '>') {
                if (save.size() > 0) res.addLast(save.pop());
            }
            else if (sign == '-') {
                if (res.size() > 0) res.removeLast();
            }
            else res.addLast(sign);
        }

        for (char x : res) System.out.print(x);
        while (!save.empty()) 
            System.out.print(save.pop());
        
        scan.close();
    }
}