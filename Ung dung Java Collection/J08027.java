import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class J08027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        Stack<Character> save = new Stack<>();

        LinkedList<Character> res = new LinkedList<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '-') {
                if (!res.isEmpty()) res.pollLast();
            }
            else if (s.charAt(i) == '<') {
                if (!res.isEmpty()) {
                    save.add(res.peekLast());
                    res.pollLast();
                }
            }
            else if (s.charAt(i) == '>') {
                if (!save.isEmpty()) res.add(save.pop());
            }
            else res.add(s.charAt(i));
        }

        while (!save.isEmpty()) res.add(save.pop());
        for (char x : res) System.out.print(x);

        sc.close();
    }
}